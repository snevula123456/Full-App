package Singh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class ShyamKing
 */
public class ShyamKing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShyamKing() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		String fullname = request.getParameter("fname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String number = request.getParameter("number");
		
		/*writer.println(fullname);
		writer.println(email);
		writer.println(password);
		writer.println(number);
		writer.println("Welcome to Shyam King");*/
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			int id = 0;
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/network","root","root"); 
			
			java.sql.PreparedStatement ps = conn.prepareStatement("select max(id) from developers");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			if(rs.next()){
				id = rs.getInt(1);
				id++;
				
				PreparedStatement pf =(PreparedStatement) conn.prepareStatement(  
						"insert into developers values(?,?,?,?,?)");  
						  
						pf.setInt(1,id);
						pf.setString(2,fullname);  
						pf.setString(3,email);  
						pf.setString(4,password);  
						pf.setString(5,number);  
					
						 int i = pf.executeUpdate();
						 
						 if(i>0){
							response.sendRedirect("./pages/developers.html");
						 }
						 else{
							 response.sendRedirect("index.html");
						 }
				
			}
			
					
//			if(conn!=null){
//				System.out.println("Database connected");
//			}
//			
//			Statement stmt = (Statement) conn.createStatement();
//			
//			ResultSet re = (ResultSet) stmt.executeQuery("insert into emp values(2,'prem',20)");
//			
//			/*while(re.next()){
//				System.out.println(re.getInt(1)+" "+ re.getString(2)+ " "+ re.getInt(3));
//				
//			}
			System.out.println("query is affted");
			conn.close();
//		*/	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
