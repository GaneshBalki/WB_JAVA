package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.LoginData;
import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;

@WebServlet("/adminregistration")
public class AdminRegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AdminService ads=new AdminServiceImpl();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		
		int status=ads.registerAdmin(new LoginData(username,password,role));
		
		if(status>0) {
			out.println("<h2 style='color:green'>Registration Done !!!</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("admin_login.html");
			rd.include(request, response);
		}
		else {
			out.println("<h2 style='color:red'>X UserName Already Exists</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("AdminRegistration.html");
			rd.include(request, response);
		}
	
		
	}

}
