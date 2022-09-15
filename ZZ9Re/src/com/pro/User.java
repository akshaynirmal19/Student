package com.pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		
		String name = req.getParameter("user_name");
		String department = req.getParameter("department");
		String email = req.getParameter("email");
		String num = req.getParameter("num");
		String adds = req.getParameter("adds");
		
	
		
		
		
		
		
		out.println("<h1>Name: "+name+"</h1>" );
		out.println("<h1>Department: "+department+"</h1>" );
		out.println("<h1>Email: "+email+"</h1>" );
		out.println("<h1>Mobile: "+num+"</h1>" );
		out.println("<h1>Address: "+adds+"</h1>" );
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","NIRMAL@131572");
			
			String q = "insert into student123(name,department,email,num,adds) values(?,?,?,?,?)";
			
            PreparedStatement ps= conn.prepareStatement(q);
            
            ps.setString(1, name);
            ps.setString(2, department);
            ps.setString(3, email);
            ps.setString(4, num);
            ps.setString(5, adds);
			
		ps.executeUpdate();
		
		
		
		
			
			out.println("Done.........");
			
		}catch(Exception e){
			
			e.printStackTrace();
			out.println("error.........");
			
		}
		
		
		
		
		
		
	}
	
	

}
