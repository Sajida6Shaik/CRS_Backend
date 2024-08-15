package com.springboot.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String emailId;
	@Column(unique=true)
	private String username;
	private String password;
	private String role;
	private String mobile;
	private int age;
	private String city;
	private String area;
	
	
	
	public User(String emailId, String username, String password, String role, String mobile, int age, String city,
			String area) {
		super();
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.age = age;
		this.city = city;
		this.area = area;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	//generate getters and setters
	public User(int id, String emailId, String username, String password, String role) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public User(String emailId, String username, String password, String role) {
		super();
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public User(String emailId, String username, String password, String role, String mobile) {
		super();
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", username=" + username + ", password=" + password
				+ ", role=" + role + "]";
	}
	


}
