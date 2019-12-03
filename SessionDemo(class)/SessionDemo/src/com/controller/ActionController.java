package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Student;
import com.dao.StudentDao;

@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("register"))
		{
			Student s=new Student();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(request.getParameter("mobile"));
			s.setPass(request.getParameter("pass"));
			
			StudentDao.registerStudent(s);
			response.sendRedirect("login.jsp");
		}
		else if(action.equalsIgnoreCase("login"))
		{
			Student s=new Student();
			s.setEmail(request.getParameter("email"));
			s.setPass(request.getParameter("pass"));
			String email=request.getParameter("email");
			String pass=request.getParameter("pass");
			Student student=StudentDao.checkLogin(s);
			if(email.equalsIgnoreCase("") || pass.equalsIgnoreCase(""))
			{
				out.println("Your User Name Or Password Is Missing");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
			else if(student==null)
			{
				out.println("Your User Name Or Password Is Incorrect");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("student", student);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		}
	}

}
