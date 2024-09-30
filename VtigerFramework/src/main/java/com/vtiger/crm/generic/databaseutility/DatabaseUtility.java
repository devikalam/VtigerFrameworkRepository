
package com.vtiger.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	public void getDBconnection(String url, String username, String password) throws Throwable {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {}
	}
	
	public void getDBconnection() throws Throwable {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql:106.51.90.215/projects","root@%","root");
		}catch(Exception e) {}
	}
	

	public void closeDBconnection() throws Throwable {
		try {
			conn.close();
		}catch(Exception e) {
			
		}
	}

	public ResultSet exceuteSelectQuery(String query) throws Throwable {
		ResultSet result=null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
		}catch (Exception e) {
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);
		}catch (Exception e) {
		}
		return result;
	}

}
