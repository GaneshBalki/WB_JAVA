package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;
import com.demo.beans.LoginData;
import com.mysql.cj.protocol.Resultset;

public class LoginDaoImpl implements LoginDao {

	private static Connection conn;
	private static PreparedStatement getAdmin, getAllEmp, getEmpById, addNewEmp, registerAdmin,checkUsername,updatePass,updateEmp,deleteEmp;
	static {
		conn = DBUtil.getMyConnection();
		try {
			getAdmin = conn.prepareStatement("select * from admin_login where uname=? and password=?;");
			getAllEmp = conn.prepareStatement("select * from emp_p;");
			getEmpById = conn.prepareStatement("select * from emp_p where empno=?;");
			addNewEmp = conn.prepareStatement("insert into emp_p value(?,?,?,?,?,?);");
			registerAdmin = conn.prepareStatement("insert into admin_login values(?,?,?);");
			checkUsername = conn.prepareStatement("select * from admin_login where uname=?;");
			updatePass = conn.prepareStatement("update admin_login set password=? where uname=?;");
			updateEmp=conn.prepareStatement("update emp_p set ename=?,job=?,hiredate=?,sal=?,dept=? where empno=?;");
			deleteEmp=conn.prepareStatement("delete from emp_p where empno=?;");
			
			

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public LoginData validateAdmin(String username, String password) {
		LoginData ld = null;
		try {
			getAdmin.setString(1, username);
			getAdmin.setString(2, password);
			ResultSet rs = getAdmin.executeQuery();
			while (rs.next()) {
				ld = new LoginData(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			return ld;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> elist = new ArrayList<>();
		try {
			ResultSet rs = getAllEmp.executeQuery();
			while (rs.next()) {
				// (int empno, String ename, String job, LocalDate hiredate, int sal)
				LocalDate ldt = LocalDate.now();
				elist.add(
						new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), ldt, rs.getInt(5), rs.getInt(6)));
			}
			return elist;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Employee getEmpById(int empno) {
		Employee emp = null;
		try {
			getEmpById.setInt(1, empno);
			ResultSet rs = getEmpById.executeQuery();
			while (rs.next()) {
				LocalDate ldt = LocalDate.now();
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), ldt, rs.getInt(5), rs.getInt(6));
			}
			return emp;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int addNewEmp(Employee emp) {
		try {

			addNewEmp.setInt(1, emp.getEmpno());
			addNewEmp.setString(2, emp.getEname());
			addNewEmp.setString(3, emp.getJob());
			java.sql.Date date = java.sql.Date.valueOf(emp.getHiredate());
			addNewEmp.setDate(4, date);
			addNewEmp.setInt(5, emp.getSal());
			addNewEmp.setInt(6, emp.getDeptno());
			int status = addNewEmp.executeUpdate();
			return status;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int registerAdmin(LoginData loginData) {
		try {
			registerAdmin.setString(1, loginData.getUname());
			registerAdmin.setString(2, loginData.getPass());
			registerAdmin.setString(3, loginData.getRole());
			int status = registerAdmin.executeUpdate();
			return status;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int resetPassword(LoginData loginData) {
		try {
			checkUsername.setString(1, loginData.getUname());
			ResultSet rs = checkUsername.executeQuery();
			while(rs.next()) {
				if(loginData.getUname().equals(rs.getString(1))) {
					updatePass.setString(1,  loginData.getPass());
					updatePass.setString(2,  loginData.getUname());
					return updatePass.executeUpdate();
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmp(Employee emp) {
		//update emp_p set ename=?,job=?,hiredate=?,sal=?,dept=? where empno=?;
		try {
			java.sql.Date date = java.sql.Date.valueOf(emp.getHiredate());
			
			updateEmp.setString(1, emp.getEname());
			updateEmp.setString(2, emp.getJob());
			updateEmp.setDate(3, date);
			updateEmp.setInt(4, emp.getSal());
			updateEmp.setInt(5, emp.getDeptno());
			updateEmp.setInt(6, emp.getEmpno());
			int status=updateEmp.executeUpdate();
			return status;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmp(int empno) {
		try {
			deleteEmp.setInt(1, empno);
			int status=deleteEmp.executeUpdate();
			return status;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return 0;
	}

}
