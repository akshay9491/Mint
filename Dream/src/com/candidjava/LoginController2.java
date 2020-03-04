package com.candidjava;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginController2 extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 PrintWriter pw = response.getWriter();  
           String connectionURL = "jdbc:mysql://localhost:3306/mint";
           Connection connection;  
           try{  
             String aadhar_number =request.getParameter("Customer Aadhar Number"); 
             String customer_account_no =request.getParameter("Customer Account Number"); 
             String beneficiary_account_no= request.getParameter("Beneficiary Account Number");
             String amount=request.getParameter("Amount To Transfer");  
             String Securitypin= request.getParameter("securitypin");  
             
 
             connection = (Connection) DriverManager.getConnection(connectionURL, "root", "root");  
             PreparedStatement pst = ((java.sql.Connection) connection).prepareStatement("Insert into transfer values('"+aadhar_number+"','"+customer_account_no+"','"+beneficiary_account_no+"','"+amount+"','"+Securitypin+"')");

             int i = pst.executeUpdate();  
             if(i!=0){  
               pw.println("<br>Record has been inserted");  
                  
          
             }  
             else{  
               pw.println("failed to insert the data");  
              }  
           }  
           catch (Exception e){  
             pw.println(e);  
           }  
         }  
        
   }

