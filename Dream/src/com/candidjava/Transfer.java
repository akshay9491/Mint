package com.candidjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/transfer")
public class Transfer extends HttpServlet
{
	private static final long serialVersionUID=1L;
	 int balance1,balance2;
	 String credcheck1=null,credcheck2=null;
	 
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
	  
		
		  String aadhar=req.getParameter("aadhar"); 
		  String acc=req.getParameter("accountnum");
		  String benefitaad=req.getParameter("benefitaad");
		  String benefitacc=req.getParameter("benefitacc");
		  Integer amount=Integer.parseInt(req.getParameter("amount"));
		  
		 
		  
		 
	  PrintWriter out=res.getWriter();
	  Connection conn=null;
		Statement st1=null,st2=null,st3=null,st4=null;
		ResultSet rs1=null,rs2=null,cred1=null,cred2=null;
		
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
	conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			
			st1=conn.createStatement();
			st2=conn.createStatement();
			st3=conn.createStatement();
			st4=conn.createStatement();
			
		
			
			String qry1="select Count(*) from (select * from customer where Aadhar='"+aadhar+"' and Acc='"+acc+"' union select * from agent where Aadhar='"+aadhar+"' and Acc='"+acc+"') as a;";
			cred1=st1.executeQuery(qry1);
			cred1.absolute(1);
			

			String qry2="select Count(*) from (select * from customer where Aadhar='"+benefitaad+"' and Acc='"+benefitacc+"' union select * from agent where Aadhar='"+benefitaad+"' and Acc='"+benefitacc+"') as a;";
			cred2=st2.executeQuery(qry2);
			cred2.absolute(1);

			credcheck1=cred1.getString(1);
			credcheck2=cred2.getString(1);
			
			
			
			
			if(credcheck1.equals("1") && credcheck2.equals("1")) {
				
					String qry3="select * from customer Where Aadhar='"+aadhar+"' and Acc='"+acc+"' union select * from agent where  Aadhar='"+aadhar+"' and Acc='"+acc+"' ";
					rs1=st3.executeQuery(qry3);
					rs1.absolute(1);
					balance1=Integer.parseInt(rs1.getString(3));
					
					if(balance1>=amount) {
							balance1=balance1-amount;
							String qry4="update customer set Amount='"+balance1+"' where Aadhar='"+aadhar+"' and Acc='"+acc+"'";
							String qry44="update agent set Amount='"+balance1+"' where Aadhar='"+aadhar+"' and Acc='"+acc+"'";
							
							st3.addBatch(qry4);
							st3.addBatch(qry44);
							st3.executeBatch();
							
							
							String qry5="select * from customer Where Aadhar='"+benefitaad+"' and Acc='"+benefitacc+"' union select * from agent where  Aadhar='"+benefitaad+"' and Acc='"+benefitacc+"' ";
							rs2=st4.executeQuery(qry5);
							rs2.absolute(1);
							balance2=Integer.parseInt(rs2.getString(3));
				
							balance2=balance2+amount;
							String qry6="update customer set Amount='"+balance2+"' where Aadhar='"+benefitaad+"' and Acc='"+benefitacc+"'";
							String qry66="update agent set Amount='"+balance2+"' where Aadhar='"+benefitaad+"' and Acc='"+benefitacc+"'";
									
							st4.addBatch(qry6);
							st4.addBatch(qry66);
							st4.executeBatch();
				
							out.print("<h3>Successfully Transferred");
										}
					else {out.print("<h3>Insufficient balance</h3>");}
			
						}
			else {
				out.print("<h3>Wrong credentials</h3>");
			}
			
			
			
		}

		catch(Exception e){
			
			out.print("Error:"+e.getMessage());
	} 
	  
  }
  
}