package com.jas.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SampleApp {
	private static final Logger log = Logger.getLogger( SampleApp.class.getName() );
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement createTableStmt = null;
		Statement deleteStmt = null;
		Statement insertStmt = null;
		Statement selectStmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/postgres";
			conn = DriverManager.getConnection(url); 
			log.log(Level.INFO, "Get connection");
			
			String createTableSql = "create table product(productId int not null"
					+ ", productName varchar(255))";
			createTableStmt = conn.createStatement();
			log.log(Level.INFO, "Create create table statement");
			boolean ex = false;
			try {
				ex = createTableStmt.execute(createTableSql);
				if (ex) log.log(Level.INFO, "Execute create table statement");
			} catch (Exception e) {
				if (!ex) log.log(Level.INFO, e.getMessage());
			}
			
			String deleteSql = "delete from product";
			deleteStmt = conn.createStatement();
			log.log(Level.INFO, "Create delete statement");
			deleteStmt.execute(deleteSql);
			log.log(Level.INFO, "Execute delete");
			
			String insertSql = "insert into product values(1, 'Bicycle')";
			insertStmt = conn.createStatement();
			log.log(Level.INFO, "Create insert statement");
			insertStmt.execute(insertSql);
			log.log(Level.INFO, "Execute insert");
			
			String selectSql = "select productId, productName from product";
			selectStmt = conn.createStatement();
			log.log(Level.INFO, "Create select statement");
			rs = selectStmt.executeQuery(selectSql);
			log.log(Level.INFO, "Execute select");
			
			while (rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				
				System.out.println("productId=" + productId + ", productName=" + productName);
			}
		} catch (Exception e) {
			try {
				if (rs != null) rs.close();
				if (selectStmt != null) selectStmt.close();
				if (insertStmt != null) insertStmt.close();
				if (createTableStmt != null) createTableStmt.close();
				if (conn != null) conn.close();
			} catch (Exception sqlEx) {
				sqlEx.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
