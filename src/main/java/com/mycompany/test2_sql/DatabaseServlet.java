/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test2_sql;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Babak
 */
@WebServlet(name = "DatabaseServlet", urlPatterns = {"/DatabaseServlet"})
public class DatabaseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        
        String DB_URL = "jdbc:mysql://localhost:3306/Customer";

        //  Database credentials
        String USER = "root";
        String PASS = "";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Query Result";
        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";
        out.println(docType
                + "<html>\n"
                + "<head><title>" + title + "</title></head>\n"
                + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + title + "</h1>\n");
        try {

            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             /*
            Query for creating  Custumer table:
            CREATE TABLE Customer
            (
            FirstName varchar(200),
            SureName  Varchar(200),
            HasPurchased bool,
            Gender Enum("male, female, other", "male"),
            Age Int
            );
            
            */
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT  firstname, surename, age, IF(haspurchased<>0, 'TRUE','FALSE') haspurchased, gender FROM Customer";
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {

                int age = result.getInt("age");
                String first = result.getString("firstname");
                String last = result.getString("surename");
                String haspurchased = result.getString("haspurchased");
                String gender = result.getString("gender");

                //Display values
                out.println("-----------------------" + "<br>");
                out.println(" Age: " + age + "<br>");
                out.println(" First: " + first + "<br>");
                out.println(" Last: " + last + "<br>");
                out.println(" HasPurchased: " + haspurchased + "<br>");
                out.println(" Gender:" + gender +"<br>");
            }
            out.println("</body></html>");
                
             
             result.close();
            stmt.close();
           String sql2;
            //SELECT ONLY MINIMUM AGE VALUE
             sql2 = "SELECT * from Customer   where age=(select MIN(age)from Customer)";
           Statement stmt2 = conn.createStatement();
            ResultSet res = stmt2.executeQuery(sql2);
            
            
               
             while (res.next()) {

                int age = res.getInt("age");
                String first = res.getString("firstname");
                String last = res.getString("surename");
                String haspurchased = res.getString("haspurchased");
                String gender = res.getString("gender");

                //Display values
                out.println("-----------------------MINIMUM AGE-------------------------" + "<br>");
                out.println(" Age: " + age + "<br>");
                out.println(" First: " + first + "<br>");
                out.println(" Last: " + last + "<br>");
                out.println(" HasPurchased: " + haspurchased + "<br>");
                out.println(" Gender:" + gender +"<br>");
            }
            out.println("</body></html>");
            // close all the alive connections
            res.close();
            stmt2.close();
            result.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
          
            se.printStackTrace();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
         

        
    }

}
