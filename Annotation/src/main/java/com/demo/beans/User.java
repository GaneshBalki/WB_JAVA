package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserGanesh12345")

public class User {
@Id
@Column(name="ID")
private int id;
@Column(name="USERNAME")
private String name;
@Column(name="PASSWORD")
private String password;
@Embedded
@Column(name="CityAddress")
private Address add;
public User() {
	super();
}
public User(int id, String name, String password,Address addr) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.add=addr;
}
public Address getAdd() {
	return add;
}
public void setAdd(Address add) {
	this.add = add;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", password=" + password + ", add=" + add + "]";
}

}
