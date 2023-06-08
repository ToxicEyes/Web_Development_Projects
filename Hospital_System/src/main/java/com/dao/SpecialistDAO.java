package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specialist;

public class SpecialistDAO {
	
	private Connection conn;

	public SpecialistDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean  addSpecialist(String specName) throws Exception{
		boolean f = false;
		String insert_query = "INSERT INTO specialist VALUES(?)";
		PreparedStatement pst = conn.prepareStatement(insert_query);
		pst.setString(1, specName);
		int icount = pst.executeUpdate();
		
		if(icount == 1) {
			f = true;
		}
		return f;
	}
	
	public List<Specialist> getAllSpecialist() {
		
		List<Specialist> list = new ArrayList<Specialist>();
		Specialist s = null;
		try {
			String select_query = "select * from specialist";
			PreparedStatement pst = conn.prepareStatement(select_query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				s = new Specialist();
				s.setId(rs.getInt(1));
				s.setSpName(rs.getString(2));
				list.add(s);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
