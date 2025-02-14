package com.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.google.gson.Gson;

@Path("student1")
public class RestService {

	Gson gson = new Gson();
	StudentDao sdao = new StudentDao();
	
	@Path("insert")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public String  insertStudent(String studentbean) {
		
		StudentBean s = gson.fromJson(studentbean, StudentBean.class);
		int result = sdao.doinsert(s);
		if(result>0) {
			return "Data Inserted Successfully";
		}
		else {
			return "Data Insertion Failed";
		}
		
		
	}
}
