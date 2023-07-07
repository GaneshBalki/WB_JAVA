package com.demo.UserData.service;

import java.util.List;

import com.demo.UserData.model.User;

public interface UserService {

	List<User> findUser(String cityinput);

	void addUser(User u);

	void deleteUser(int id);

	User getById(int id);

	void modify(User u);

}
