package com.shoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

@Id
int catId;
@Column
String catName;
@Column
String catDescription;

	
	
	public Category() {
	super();
	// TODO Auto-generated constructor stub
}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatDescription() {
		return catDescription;
	}
	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
	
	
	
}
