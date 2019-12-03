package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Student;
import com.util.StudentUtil;

public class StudentDao {

	public static void registerStudent(Student s)
	{
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="insert into student(fname,lname,email,mobile,pass) values(?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getMobile());
			pst.setString(5, s.getPass());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Student checkLogin(Student s)
	{
		Student student=null;
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="select * from student where email=? and pass=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPass());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				student=new Student();
				student.setId(rs.getInt("id"));
				student.setFname(rs.getString("fname"));
				student.setLname(rs.getString("lname"));
				student.setEmail(rs.getString("email"));
				student.setMobile(rs.getString("mobile"));
				student.setPass(rs.getString("pass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
