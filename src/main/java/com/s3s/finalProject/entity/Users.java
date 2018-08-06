package com.s3s.finalProject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name= "userId", nullable= false, updatable= false)
	private Long userId;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String phone;
	
	@Column(name= "email", nullable= false, unique= true)
	private String email;
	
	@Column(name= "username", nullable= false, unique= true)
	private String username;
	
	@Column(name= "password", nullable= false)
	private String password;
	
	@OneToMany(mappedBy= "user", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Orders> ordersList;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", phone=" + phone + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
	

}
