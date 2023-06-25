package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;

@WebServlet("/deleteemp")
public class DeleteEmp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AdminService ads=new AdminServiceImpl();
		
		int empno=Integer.parseInt(request.getParameter("empno"));
		int status=ads.deleteEmp(empno);
		if(status>0) {
			out.println("<h2 style='color:green'>Employee Removed !!!</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("adminDash.html");
			rd.include(request, response);
		}
		else {
			out.println("<h2 style='color:red'>Invalid Employee Number XX</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("adminDash.html");
			rd.include(request, response);
		}
	}


}
