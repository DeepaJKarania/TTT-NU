package com.shoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserCredential {
	@Id
	@GeneratedValue
	int userId;
	@Column
	String custName;
	@Column
	String pass;
	@Column
	String role;
	@Column
	Boolean enabled;
	
	public UserCredential() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public String getCustName() {
		return custName;
	}





	public void setCustName(String custName) {
		this.custName = custName;
	}





	public int getUserId() {
		return userId;
	}





	public void setUserId(int userId) {
		this.userId = userId;
	}





	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
	

}
