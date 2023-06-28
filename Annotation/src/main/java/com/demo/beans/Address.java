package com.demo.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
private int cid;
private String city;
public Address() {
	super();
}
public Address(int cid, String city) {
	super();
	this.cid = cid;
	this.city = city;
}
public int getId() {
	return cid;
}
public void setId(int cid) {
	this.cid = cid;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "Address [id=" + cid + ", city=" + city + "]";
}

}
