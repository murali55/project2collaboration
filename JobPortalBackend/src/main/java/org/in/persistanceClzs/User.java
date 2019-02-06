package org.in.persistanceClzs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User 
{
@Id
private String email;
@Column(nullable=false)
private String password;
@Column(nullable=false)
private String role;
private String fristName;
private String lastName;
@Column(unique=true)
private String phoneNbr;
@Column(name="online_status")
private boolean online;
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
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getFristName() {
	return fristName;
}
public void setFristName(String fristName) {
	this.fristName = fristName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhoneNbr() {
	return phoneNbr;
}
public void setPhoneNbr(String phoneNbr) {
	this.phoneNbr = phoneNbr;
}
public boolean isOnline() {
	return online;
}
public void setOnline(boolean online) {
	this.online = online;
}
	
}
