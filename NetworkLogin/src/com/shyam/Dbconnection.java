package com.shyam;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Dbconnection {
public static void main(String[] args) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Network","root","root"); 
			
			if(conn!=null){
				System.out.println("Database connected");
			}
			
//			Statement stmt = (Statement) conn.createStatement();
//			
//			ResultSet re = (ResultSet) stmt.executeQuery("insert into emp values(2,'prem',20)");
			
			/*while(re.next()){
				System.out.println(re.getInt(1)+" "+ re.getString(2)+ " "+ re.getInt(3));
				
			}
			System.out.println("query is affted");
			conn.close();
		*/	
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	

}
