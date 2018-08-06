package com.s3s.finalProject.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.s3s.finalProject.JDBCConnection.ConnectionFactory;
import com.s3s.finalProject.entity.Orders;
import com.s3s.finalProject.entity.Users;
import com.s3s.finalProject.service.OrderService;
import com.s3s.finalProject.service.UserService;

@Controller
public class UserController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;
	// Check if email and username already exists in Db. If not create a new user.

	@PostMapping("/signup")
	public String customerSignup(@ModelAttribute Users user, Model model) {
		if (userService.checkCustomerExists(user.getUsername(), user.getEmail())) {

			if (userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists", true);
			}

			if (userService.checkUsernameExists(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}

			return "signup";
		} else {
			userService.save(user);
			return "/index";
		}
	}

	// Login Validation

	@PostMapping("/index")
	public String verifyLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {

		Users user = userService.login(username, password);
		if (user == null) {
			return "index";
		}
		session.setAttribute("username", username);
		System.out.println(username);
		return "welcome";
	}

	@GetMapping("/welcome")
	public String welcomePage() {
		return "welcome";
	}

	@GetMapping("/order")
	public String orderPage() {
		return "order";
	}

	@PostMapping("/order")
	public String nextOrder(@ModelAttribute("order") Orders order, HttpSession session) throws ParseException {
		String userNm = (String) session.getAttribute("username");
		Users user = userService.findByUsername(userNm);
		order.setUser(user);

		orderService.save(order);

		return "order";
	}

	@GetMapping(value = "/welcome", params = "action=order")
	public String order() {
		return "order";
	}

// This mapping is used for viewing orders
	// Data is retrieved manually.
	@Autowired
	private HttpSession session;

	@GetMapping(value = "/welcome", params = "action=viewOrders")
	public String viewOrders(Model model) {
		
		// capturing username attribute from login session.
		String userNm = (String) session.getAttribute("username");
		// retrieving user object using username.
		Users user = userService.findByUsername(userNm);
		// retrieving userId using user object.
		Long usrId = user.getUserId();

		//Manually connecting to MySQL using JDBC
		try {
			// establishing connection using ConnectionFactory class.
			Connection con = ConnectionFactory.getConnection();
			// creating Statement object.
			Statement stmt = con.createStatement();
			// executing statement object using SQL query.
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders WHERE user_id=" + usrId);
			
			// Creating list object to store result set.
			List Order = new ArrayList<>();
			// Extract data from the result set.
			while (rs.next()) {
				Long orderId = rs.getLong("order_id");
				String orderItem = rs.getString("order_item");
				double pricePerUnit = rs.getDouble("price_per_unit");
				int quantity = rs.getInt("quantity");
				// Adding data from result set to list object.
				Order.add(new Orders(orderItem, quantity, pricePerUnit));
			}
			model.addAttribute("Order", Order);
			// closing the database connection.
			con.close();
			return "viewOrders";

		} catch (Exception e) {
			return e.toString();
		}

	}
}
