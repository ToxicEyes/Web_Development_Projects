package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;
public class AppointmentDAO {

	private Connection conn;

	public AppointmentDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addAppointment(Appointment ap) {
		boolean f = false;
		try {
			String insert_query = "insert into appointment(userid, fullname, gender, age, appointDate, email, phoneNo, diseases, docid, address, status) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(insert_query);
			pst.setInt(1, ap.getUserid());
			pst.setString(2, ap.getFullname());
			pst.setString(3, ap.getGender());
			pst.setString(4, ap.getAge());
			pst.setString(5, ap.getAppointDate());
			pst.setString(6, ap.getEmail());
			pst.setString(7, ap.getPhoneNo());
			pst.setString(8, ap.getDiseases());
			pst.setInt(9, ap.getDocid());
			pst.setString(10, ap.getAddress());
			pst.setString(11,ap.getStatus());
			int icount = pst.executeUpdate();
			if(icount == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Appointment> getAllAppointmentByLoginUser(int userid) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		
		try {
			String select_query = "SELECT * FROM appointment WHERE userid = ?";
			PreparedStatement pst = conn.prepareStatement(select_query);
			pst.setInt(1, userid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppointDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhoneNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDocid(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Appointment> getAllAppointmentByDoctor(int docid) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		
		try {
			String select_query = "SELECT * FROM appointment WHERE docid = ?";
			PreparedStatement pst = conn.prepareStatement(select_query);
			pst.setInt(1, docid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppointDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhoneNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDocid(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public Appointment getAppointmentById(int id) {
		Appointment ap = null;
		
		try {
			String select_query = "SELECT * FROM appointment WHERE id = ?";
			PreparedStatement pst = conn.prepareStatement(select_query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppointDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhoneNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDocid(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ap;
	}
	
	public boolean updateCommentStatus(int id, int docid,String comment) {
		boolean f = false;
		try {
			
			String update_query = "UPDATE appointment set status = ? WHERE id = ? AND docid = ?";
			PreparedStatement pst = conn.prepareStatement(update_query);
			pst.setString(1, comment);
			pst.setInt(2, id);
			pst.setInt(3, docid);
			
			int ucount = pst.executeUpdate();
			if(ucount == 1) {
				f = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	public List<Appointment> getAllAppointment() {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		
		try {
			String select_query = "SELECT * FROM appointment order by id desc";
			PreparedStatement pst = conn.prepareStatement(select_query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppointDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhoneNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDocid(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
