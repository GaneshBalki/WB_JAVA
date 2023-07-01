package com.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	@Value("23")
 private int pid;
	@Value("Ganesh")
 private String pname;
	@Value("130.33")
 private float price;
	@Value("13")
 private int qty;
    @Autowired
 private Warehouse whouse;
 public Product() {
	super();
}
public Product(int pid, String pname, float price, int qty, Warehouse whouse) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.qty = qty;
	this.whouse = whouse;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public Warehouse getWhouse() {
	return whouse;
}
public void setWhouse(Warehouse whouse) {
	this.whouse = whouse;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", whouse=" + whouse
			+ "]";
}
 
 
}
