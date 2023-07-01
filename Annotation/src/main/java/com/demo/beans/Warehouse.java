package com.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Warehouse {
	@Value("12")
private int wid;
	@Value("swarg")
private String wname;
	@Value("233")
private int rackno;
public Warehouse() {
	super();
}
public Warehouse(int wid, String wname, int rackno) {
	super();
	this.wid = wid;
	this.wname = wname;
	this.rackno = rackno;
}
public int getWid() {
	return wid;
}
public void setWid(int wid) {
	this.wid = wid;
}
public String getWname() {
	return wname;
}
public void setWname(String wname) {
	this.wname = wname;
}
public int getRackno() {
	return rackno;
}
public void setRackno(int rackno) {
	this.rackno = rackno;
}
@Override
public String toString() {
	return "Warehouse [wid=" + wid + ", wname=" + wname + ", rackno=" + rackno + "]";
}


}
