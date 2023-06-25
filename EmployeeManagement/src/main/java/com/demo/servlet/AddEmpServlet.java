package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Employee;
import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;


@WebServlet("/addnewemp")
public class AddEmpServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AdminService ads=new AdminServiceImpl();
		
		int empno=Integer.parseInt(request.getParameter("empno"));
		String ename=request.getParameter("ename");
		String job=request.getParameter("job");
		LocalDate hiredate=LocalDate.parse(request.getParameter("hiredate"),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int sal=Integer.parseInt(request.getParameter("sal"));
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		Employee emp=new Employee(empno,ename,job,hiredate,sal,deptno);
		
		int status=ads.addNewEmp(emp);
		if(status>0) {
			out.println("<h3>Employee Added.....</h3>");
		}else {
			out.println("<h3>failed.....</h3>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("adminDash.html");
		rd.include(request, response);
		
	}

}
