package com.Vtiger.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	public void getConnection(String url,String username,String password) throws SQLException {
		try{
			Driver driverref= new Driver();
	        DriverManager.registerDriver(driverref);
		     conn = DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
		}
	}
	
	public void getConnection() throws SQLException {
		try{
			Driver driverref= new Driver();
	        DriverManager.registerDriver(driverref);
		     conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		} catch(Exception e) {
		}
	}
	
	public void closeConnection() throws SQLException {
		try {
		conn.close();
		}catch(Exception e) {
			
		}
		
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet res=null;
		try {
		Statement stat = conn.createStatement();
		 res = stat.executeQuery(query);
		}catch(Exception e) {
			
		}
		return res;
		
	}
	
	public int executeNonSelectQuery(String query) throws SQLException {
		int res=0;
		try {
		Statement stat = conn.createStatement();
		 res = stat.executeUpdate(query);
		}catch(Exception e) {
			
		}
		return res;
	}
	

}
