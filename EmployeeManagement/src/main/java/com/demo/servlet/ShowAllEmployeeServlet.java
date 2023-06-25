package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Employee;
import com.demo.beans.LoginData;
import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;

@WebServlet("/showallemployees")
public class ShowAllEmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AdminService ads=new AdminServiceImpl();
		List<Employee> elist=new ArrayList<>();
		elist=ads.getAllEmp();
//		HttpSession session = request.getSession();
//		LoginData user=(LoginData) session.getAttribute("admin");
//		
		
		RequestDispatcher rd=request.getRequestDispatcher("allEmp.html");
		rd.include(request, response);
		out.println("<tbody>");		
		for(Employee emp:elist) {
			out.println("<tr>\r\n"
					+ "        <td>"+emp.getEmpno()+"</td>\r\n"
					+ "        <td>"+emp.getEname()+"</td>\r\n"
					+ "        <td>"+emp.getJob()+"</td>\r\n"
					+ "        <td>"+emp.getHiredate()+"</td>\r\n"
					+ "        <td>"+emp.getSal()+"</td>\r\n"
					+ "        <td>"+emp.getDeptno()+"</td>\r\n"
					
					+"          <td><a href='editemp?empno="+emp.getEmpno()+"'>Edit</a></td>\r\n"
					+"          <td><a href='deleteemp?empno="+emp.getEmpno()+"'>X</a></td>\r\n"
					+ "      </tr>");
		}
		out.println("</tbody>\r\n"
				+ "  </table>\r\n"
				+"<a href='adminDash.html'>Back</a>"
				+ "</body>\r\n"
				+ "</html>");
	}

}
