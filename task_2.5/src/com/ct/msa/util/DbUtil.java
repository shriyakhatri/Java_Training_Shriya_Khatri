package com.ct.msa.util;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class DbUtil {
		public static Connection con = null;
		private static FileInputStream fis = null;
		
		public static Connection getDBConnection() {
			
				try {
					fis = new FileInputStream("db.properties");
					Properties prop = new Properties();
					prop.load(fis);
					con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
			        System.out.println(prop.getProperty("url"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					//throw new Exception(e.getMessage());
				}
				
				catch (IOException e) {
					// TODO Auto-generated catch block
					//throw new Exception(e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//throw new Exception(e.getMessage());
				}
			return con;
		}
	}

	
