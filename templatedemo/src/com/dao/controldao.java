package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.controlbean;
import com.util.controlutil;

public class controldao {
	public static controlbean register(controlbean c) {

		System.out.println("register method called!");
		try {
			Connection conn = controlutil.createConnection();
			String sql = "insert into login(username,email,mobile,password) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getUsername());
			pst.setString(2, c.getEmail());
			pst.setString(3, c.getMobile());
			pst.setString(4, c.getPassword());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public static controlbean login(controlbean c) {

		controlbean conbean = null;
		try {
			Connection conn = controlutil.createConnection();
			String sql = "select * from login where email=? and password=?";

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, c.getEmail());
			pst.setString(2, c.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				conbean = new controlbean();
				conbean.setId(rs.getInt("id"));
				conbean.setUsername(rs.getString("username"));
				conbean.setEmail(rs.getString("email"));
				conbean.setMobile(rs.getString("mobile"));
				conbean.setPassword(rs.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;

	}
	
	public static void resetpass(controlbean conbean) {
			
		System.out.println("Reset Method called!");
		
		try {
			Connection conn = controlutil.createConnection();
			String sql = "update login set email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,conbean.getEmail());
			pst.setString(2, conbean.getPassword());
			pst.executeUpdate();
			System.out.println("Password Sccessfully Updated");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
