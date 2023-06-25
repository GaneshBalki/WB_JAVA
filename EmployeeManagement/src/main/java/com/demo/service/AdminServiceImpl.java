package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.beans.LoginData;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class AdminServiceImpl implements AdminService{
	
	LoginDao lDao=new LoginDaoImpl();
	

//	public AdminServiceImpl() {
//		super();
//		this.lDao = new LoginDaoImpl();
//	}


	@Override
	public LoginData validateAdmin(String username, String password) {
		
		return lDao.validateAdmin(username,password);
	}


	@Override
	public List<Employee> getAllEmp() {
		
		return lDao.getAllEmp();
	}


	@Override
	public Employee getEmpById(int empno) {
		
		return lDao.getEmpById(empno);
	}


	@Override
	public int addNewEmp(Employee emp) {
		
		return lDao.addNewEmp(emp);
	}


	@Override
	public int registerAdmin(LoginData loginData) {
		
		return lDao.registerAdmin(loginData);
	}


	@Override
	public int resetPassword(LoginData loginData) {
		
		return lDao.resetPassword(loginData);
	}


	@Override
	public int updateEmp(Employee emp) {
		
		return lDao.updateEmp(emp);
	}


	@Override
	public int deleteEmp(int empno) {
		
		return lDao.deleteEmp(empno);
	}

}
