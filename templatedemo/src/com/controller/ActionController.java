package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.controlbean;
import com.dao.controldao;

@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			controlbean c = new controlbean();
			c.setUsername(request.getParameter("username"));
			c.setEmail(request.getParameter("email"));
			c.setMobile(request.getParameter("mobile"));
			c.setPassword(request.getParameter("password"));

			controldao.register(c);
			System.out.println("Data inserted!");
			response.sendRedirect("index.html");
		}
		if (action.equalsIgnoreCase("login")) {
			controlbean c = new controlbean();
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			controlbean control = controldao.register(c);
			if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
				out.println("your username and password is missing");
				request.getRequestDispatcher("index.html");
			} else if (control == null) {

				out.println("Your User Name Or Password Is Incorrect");
				request.getRequestDispatcher("index.html").include(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("control", control);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
		if(action.equalsIgnoreCase("reset")) {
			
			System.out.println("reset button clicked");
			
			
			controlbean c1 = new controlbean();
			
			String oldpass = request.getParameter("password");
			/*String newpass = request.getParameter("newpass");
			String cnfpass = request.getParameter("cnfpass");*/
			String email1 = request.getParameter("email");
			
			c1.setEmail(request.getParameter("email"));
			c1.setPassword(request.getParameter("password"));
			
			
			
			if(email1.equals("")||email1.equals(null)||oldpass.equals("")) {
				
				out.println("All Fields are mandetory");
				request.getRequestDispatcher("resetPass.html").include(request, response);
			}
			
			else {
				
				controldao.resetpass(c1);
				response.sendRedirect("home.jsp");
			}
		}

		}

	}
}
