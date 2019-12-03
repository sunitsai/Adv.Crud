package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.bean.StudentBean;
import com.google.gson.Gson;

@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String WebURL = "http://localhost:8080/RestServer/";
	ClientConfig clientconfig = null;
	Client client = null;
	WebTarget target = null;
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Do Process Method Called");
		clientconfig=new ClientConfig();
		client=ClientBuilder.newClient(clientconfig);
		target=client.target(WebURL).path("rest");
		
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert"))
		{
			System.out.println("Insert button Clicked");
			StudentBean s=new StudentBean();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			
			String student=gson.toJson(s);
			
			Response rs=target.path("student").path("insert").request().post(Entity.json(student));
			String result=rs.readEntity(String.class);
			System.out.println(result);
			
		}

	}
}
