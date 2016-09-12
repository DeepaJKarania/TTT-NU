package com.shoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {

   @Id	
    int supId;
   @Column
	String supName;
   @Column
	String supAddress;
   
   
	
	
	public Supplier() {
	super();
	// TODO Auto-generated constructor stub
}
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSupAddress() {
		return supAddress;
	}
	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}
	
	
	
	
}
