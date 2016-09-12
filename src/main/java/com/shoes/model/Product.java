package com.shoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

@Id
@GeneratedValue
@Column(name="Product_Id")
int itemID;

	@Column(name="Product_Name")
	String itemName;
	@Column(name="PRO_Description")
	String description;
	@Column(name="Quantity")
	int qty;
	
	@Column(name="Price")
	double price;
	
@Column(name="image")	
String image;

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	int categoryId,supplierId;

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	}
