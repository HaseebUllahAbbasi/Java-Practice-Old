package com.dot.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;  

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Step 1: set content type
		response.setContentType("text/html");
		
		// Step 2: get the printwriter
		PrintWriter out = response.getWriter();
		
		// Step 3: generate the HTML content
		out.println("<html><body>");
		
		

		try
		{

			Class.forName("com.mysql.jdbc.Driver"); 

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_1","root","");
	        Statement  statement = connection.createStatement();
	        System.out.println("statement is created");
	        statement.execute("select * from do2072372_users ");
	        ResultSet resultSet;
	        resultSet = statement.getResultSet();		
	        int checked  =  0;
	        while(resultSet.next())
            {
	        	if(resultSet.getString("userName").equals(request.getParameter("userName")))
	        	{
	        		if(resultSet.getString("password").equals(request.getParameter("password")))
	        		{
	        			out.println("User Has Successfully logined");
	        			checked++;
	        			return;
	        			
	        		}
	        	}
	        	
                
            }
            resultSet.close();
            
            statement.close();
            connection.close();

    		out.println("</body></html>");
			
    		if(checked==0)
        	{
        		out.println("Wrong Password");
        		out.println("<html>\r\n" + 
        				"<head>\r\n" + 
        				"</head>\r\n" + 
        				"<body>\r\n" + 
        				"<form action=\"login\" method=\"GET\">\r\n" + 
        				"	User Name : <input type=\"text\" name=\"userName\" required> \r\n" + 
        				"	\r\n" + 
        				"	<br><br>\r\n" + 
        				"	\r\n" + 
        				"	Password <input type=\"password\" name=\"password\" required>\r\n" + 
        				"	<br>\r\n" + 
        				"	<br>\r\n" + 
        				"\r\n" + 
        				"	<input type=\"submit\" value=\"Login\">\r\n" + 
        				"		\r\n" + 
        				"</form>\r\n" + 
        				"\r\n" + 
        				"\r\n" + 
        				"\r\n" + 
        				"</body></html>");
        	}
    		
    		
        		
		}
		catch(Exception ex)
		{
			out.println(ex.toString());
			
		}
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
