/**
 * JDBCExample.java :
 * Copyright (c) 2002 Zeta Interactive.
 * #8-2-120/113,Plot No:99,Road No :2 ,Sanali Info Park,Ground Floor of B & C Block,
 * Banjara Hills, Hyderabad,T.S, 500 034, India.
 * All rights reserved.
 * This software is the confidential and proprietary information of Zeta Interactive
 * Systems India Pvt.Ltd.,"Confidential Information").  
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Zeta Interactive.
 * 
 **/


package com.rudra.aks.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @Author	    : chalapathi.bavisetti
 * @Created On  : Nov 2, 2016 6:07:40 PM
 * @Version	    : 1.7
 * @Description : "JDBCExample" is used for
 * 
 **/

public class JDBCExample {
	 public static void main(String[] argv) {

			System.out.println("-------- MySQL JDBC Connection Testing ------------");

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your MySQL JDBC Driver?");
				e.printStackTrace();
				return;
			}

			System.out.println("MySQL JDBC Driver Registered!");
			Connection connection = null;
			String urlTable = "TAB_1434_URLS";
			String createUrlTableQuery = "create table " + urlTable
					+ "(urlid bigint primary key,type char,encodeurl char,url longtext,tagnames longtext)";
			try {
				connection = DriverManager
				.getConnection("jdbc:mysql://10.98.8.100:3306/qacust3?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8",
						"qacust3", "leo$123");

			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
			}

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
				try {
					connection.createStatement().executeUpdate(createUrlTableQuery);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Failed to make connection!");
			}
		  }
}
