package com.candidjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deposit")
public class Depoist extends HttpServlet
{
	private static final long serialVersionUID=1L;
	int cbalance,abalance;
	String credcheck=null;
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
	      String agentaad="123";
	      String agentacc="123";
		
		  String aadhar=req.getParameter("aadhar"); 
		  String acc=req.getParameter("accountnum");
		  Integer amount=Integer.parseInt(req.getParameter("amount"));
		  
		 
	  PrintWriter out=res.getWriter();
	  Connection conn=null;
		Statement st1=null,st2=null,st3=null;
		ResultSet rs1=null,rs2=null,cred=null;
		
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
	conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			
			st1=conn.createStatement();
			st2=conn.createStatement();
			st3=conn.createStatement();
			
			String qry1="select COUNT(*) from customer Where Aadhar='"+aadhar+"' and Acc='"+acc+"'";
			cred=st2.executeQuery(qry1);
			cred.absolute(1);
			credcheck=cred.getString(1);
			
			if(credcheck.equals("1")) {
			
				String qry2="select * from customer Where Aadhar='"+aadhar+"' and Acc='"+acc+"' ";
				rs1=st1.executeQuery(qry2);
				rs1.next();
				cbalance=Integer.parseInt(rs1.getString(3));
			
				
					cbalance=cbalance+amount;
					String qry3="update customer set Amount='"+cbalance+"' where Aadhar='"+aadhar+"' and Acc='"+acc+"'";
					st1.executeUpdate(qry3);
			
					out.println("<h3>Successful deposit to customer</h3><br>");
					
					String qry4="select * from agent Where Aadhar='"+agentaad+"' and Acc='"+agentacc+"' ";
					rs2=st3.executeQuery(qry4);
					rs2.next();
					
					abalance=Integer.parseInt(rs2.getString(3));
					abalance=abalance-amount;
					String qry5="update agent set Amount='"+abalance+"' where Aadhar='"+agentaad+"' and Acc='"+agentacc+"'";
					st3.executeUpdate(qry5);
					out.print("<h3>Successful withdrawal from agent</h3>");
				
				
			
			}
			else {
					out.print("Wrong credentials");
				}
				
		}

		catch(Exception e){
			out.print("Error:"+e.getMessage());
	} 
	  
  }
  
}