package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.beans.LoginData;

public interface AdminService {

	LoginData validateAdmin(String username, String password);

	List<Employee> getAllEmp();

	Employee getEmpById(int empno);

	int addNewEmp(Employee emp);

	int registerAdmin(LoginData loginData);

	int resetPassword(LoginData loginData);

	int updateEmp(Employee emp);

	int deleteEmp(int empno);

}
