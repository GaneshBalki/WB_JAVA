package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.LoginData;
import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		AdminService ads = new AdminServiceImpl();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginData ld = ads.validateAdmin(username,password);
		
		if(ld==null) {
			out.println("<h4><span id='s1'>X</span> Invalid Username or Password</h4>");
			RequestDispatcher rd = request.getRequestDispatcher("admin_login.html");
			rd.include(request, response);
		}
		else {
			HttpSession session = request.getSession();
			if(session.isNew()) {
				session.setAttribute("admin", ld);
			}
			RequestDispatcher rd1 = request.getRequestDispatcher("adminDash.html");
			rd1.forward(request, response);
			
		}
	}

}
