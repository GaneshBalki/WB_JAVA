package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Employee;
import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;

@WebServlet("/editemp")
public class UpdateEmp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int empno = Integer.parseInt(request.getParameter("empno"));
		AdminService ads = new AdminServiceImpl();
		Employee emp = ads.getEmpById(empno);

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n"
				+ "  <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/AddEmp.css\">\r\n" + "</head>\r\n"
				+ "<body>\r\n" + "<div class='container'>\r\n" 
				+ "<form action='updatemp' method='post'>");
		out.println("<label for='empno'>Employee Number:</label>"
				+ "    <input type='text' id='empno' name='empno' value='" + emp.getEmpno() + "' readonly required><br>");
		out.println("<label for='ename'>Employee Name:</label>"
				+ "    <input type='text' id='ename' name='ename' value='" + emp.getEname() + "' required><br>");
		out.println("<label for='job'>Job:</label>\r\n" + "    <input type='text' id='job' name='job' value='"
				+ emp.getJob() + "' required><br>");
		out.println("    <label for='hiredate'>Hire Date:</label>\r\n"
				+ "    <input type='date' id='hiredate' name='hiredate' value='" + emp.getHiredate()
				+ "' required><br>");
		out.println("   <label for='sal'>Salary:</label>\r\n" + "    <input type='number' id='sal' name='sal' value='"
				+ emp.getSal() + "' required><br>");
		out.println("   <label for='deptno'>Employee's Department Number:</label>\r\n"
				+ "    <input type='text' id='deptno' name='deptno' value='" + emp.getDeptno() + "' required><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println(" </form>\r\n"
				+ "  </div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		

	}

}
