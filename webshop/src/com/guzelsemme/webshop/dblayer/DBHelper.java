package com.guzelsemme.webshop.dblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.guzelsemme.webshop.entities.User;

public class DBHelper {
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",	"postgres", "admyn");
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<User> getUserList(){
		List<User> userList = new ArrayList();
		cn = getConnection();
		
		try {
			String query = "select * from finances_user";
			st = cn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				long userId = rs.getLong("user_id");
				String first_name = rs.getString("first_name");
				userList.add(new User(userId,first_name));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
				rs.close();	
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return userList;
	}
	
}
