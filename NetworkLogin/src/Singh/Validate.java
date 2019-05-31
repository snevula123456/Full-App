package Singh;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Validate {
	
	 public static boolean checkUser(String email,String password) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/network","root","root"); 
         PreparedStatement ps =(PreparedStatement) conn.prepareStatement
                             ("select * from developers where email=? and password=?");
         ps.setString(1, email);
         ps.setString(2, password);
         ResultSet rs =(ResultSet) ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   

}
