package com.demo.UserData.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.UserData.dao.UserDao;
import com.demo.UserData.model.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findUser(String cityinput) {
		List<User> ulist=userDao.findByCity(cityinput);
		
		return ulist;
	}

	@Override
	public void addUser(User u) {
		userDao.save(u);
		
	}

	@Override
	public void deleteUser(int id) {
		Optional<User> u= userDao.findById(id);
		userDao.delete(u.get());
		
	}

	@Override
	public User getById(int id) {
		
		return userDao.findById(id).get();
	}

	@Override
	public void modify(User u) {
		userDao.save(u);
		
	}
}
