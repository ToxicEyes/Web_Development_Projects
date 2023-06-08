package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.entity.Doctor;
import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class DoctorDAO {
	private Connection conn;

	public DoctorDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean registerDoctor(Doctor d)throws ServletException, SQLException {
		boolean f = false;
		
			String insert_query = "INSERT INTO doctor(fullname,dob,qualification,specialist,email,mobNo,password) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(insert_query);
			pst.setString(1, d.getFullname());
			pst.setString(2, d.getDob());
			pst.setString(3, d.getQualification());
			pst.setString(4, d.getSpecialist());
			pst.setString(5, d.getEmail());
			pst.setString(6, d.getMobNo());
			pst.setString(7, d.getPassword());
			
			int icount = pst.executeUpdate();
			
			if(icount == 1) {
				f = true;
			}
		
		
		return f;
	}
	
	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		
		try {
			String select_query = "SELECT * FROM doctor ORDER BY id desc";
			PreparedStatement pst = conn.prepareStatement(select_query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setPassword(rs.getString(7));
				list.add(d);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Doctor login(String email,String password) {
		Doctor d = null;
		try {
			String select_query = "SELECT * FROM doctor WHERE email = ? AND password = ?";
			PreparedStatement pst = conn.prepareStatement(select_query);
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1)); 
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setPassword(rs.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public Doctor getDoctorById(int id) {

		Doctor d = null;
		try {

			String select_query = "select * from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(select_query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public int countDoctor() {
		int count = 0;
		
		try {
			String select_query = "SELECT * FROM doctor";
			PreparedStatement pst = conn.prepareStatement(select_query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				count++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int countAppointment() {
		int count = 0;
		
		try {
			String select_query = "SELECT * FROM appointment";
			PreparedStatement pst = conn.prepareStatement(select_query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				count++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int countUser() {
		int count = 0;
		
		try {
			String select_query = "SELECT * FROM user_details1";
			PreparedStatement pst = conn.prepareStatement(select_query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				count++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int countSpecialist() {
		int count = 0;
		
		try {
			String select_query = "SELECT * FROM specialist";
			PreparedStatement pst = conn.prepareStatement(select_query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				count++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
