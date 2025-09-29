package com.online.shopping.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private int userId;

	 @Column(name = "user_nm", nullable = false)
	 private String name;

	 @Column(name = "user_email", nullable = false, unique = true)
	 private String email;

	 @Column(name = "user_pass", nullable = false)
	 private String password;
	 
	 @Column(name = "status", nullable = false)
	 private String status;

	 public int getUserId() {
		 return userId;
	 }

	 public void setUserId(int userId) {
		 this.userId = userId;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public String getStatus() {
		 return status;
	 }

	 public void setStatus(String status) {
		 this.status = status;
	 }

	 public User(int userId, String name, String email, String password, String status) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
	 }

	 public User() {
		super();
		// TODO Auto-generated constructor stub
	 }

}
