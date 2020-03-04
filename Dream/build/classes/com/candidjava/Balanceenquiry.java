package com.candidjava;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class Balanceenquiry extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
PrintWriter out = response.getWriter();        

              String aadhar_number1=request.getParameter("Customer_Aadhar_Number"); 
              //String account_no2=request.getParameter("Customer_Account_Number"); 
              

              try{

                     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mint","root","root");               

                     PreparedStatement ps=con.prepareStatement("select * from balance where aadhar_number=?");

                     ps.setString(1,aadhar_number1);
                    // ps.setString(2,account_no2);  
                    
ResultSet rs=ps.executeQuery();                
while(rs.next())
{
	out.print("Balance is"+""+rs.getString(3));
}

 

              }
              catch (Exception e2)

                {

                    e2.printStackTrace();

                }

 

              finally{out.close();

                }

       }
} 