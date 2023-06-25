package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.beans.LoginData;

public interface LoginDao {

	LoginData validateAdmin(String username, String password);

	List<Employee> getAllEmp();

	Employee getEmpById(int empno);

	int addNewEmp(Employee emp);

	int registerAdmin(LoginData loginData);

	int resetPassword(LoginData loginData);

	int updateEmp(Employee emp);

	int deleteEmp(int empno);

}
