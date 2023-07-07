package com.demo.UserData.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.UserData.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	@Query(value="select * from registereduser where city=:cityinput",nativeQuery = true)
	List<User> findByCity(String cityinput);

}
