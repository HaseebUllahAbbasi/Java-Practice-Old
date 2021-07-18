<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"   %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Sample_18</title>
    <style>
    body
    {
    	  	background-color:blue;
  			color: white;
    }
    #text_area
    {
    	      	background-color:black;
    		color: green;
 		 font-weight: 1000;
    }
    #green
    {
    			      	background-color:green;
    			      	color:black;
    
    }
    .btn
    {
    	color:yellow;
    		      	background-color:brown;
    	 font-weight: 1000;
    }
    table *
    {
    color:black;
    }
    
      .center {
        text-align: center;
      }
      th
      {
      	background-color:red;
      }
      td
      {
      	background-color:wheat;
      }
      .center {
  margin-left: auto;
  margin-right: auto;
}
      
    </style>
  </head>
  <body>
    <jsp:include page="Header.html" />
    <jsp:include page="Desc.html" />
    <form action="Index.jsp">
    <div class="center">
      <textarea id="text_area" rows="20" cols="100" name="query" >  <% String q =  request.getParameter("query");
				if(q!=null) out.print(q.trim());
      		%>  </textarea>
    </div>
    <div class="center">
      <input class="btn" onclick="Execute()" value="Execute Command" type="submit">
      <button class="btn" onclick="Clear()">Reset Form</button>
    </div>
    </form>
    
    <div class="center">All Execution Will Appear below this Site</div>
    <hr />
    <h3 class="center">Database Results :</h3>
    <div id="results">
    	<% 
    	try
    	{
    		if(q==null)
    		{
    			return;
    		}
    		Class.forName("com.mysql.jdbc.Driver"); 
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3","root","");
            Statement  statement = connection.createStatement();
            System.out.println("statement is created");
             statement.execute(q);
            ResultSet resultSet;
            resultSet = statement.getResultSet();
            System.out.println("the resutlt is got ");
            System.out.println(resultSet);
            if(resultSet==null && q.contains("insert"))
            {
            	out.print("<table class='center'>");
            	out.print("<th id='green'>" + " Data Is Inserted "+  "</th>");
            	out.print("</table>");
                        	return;
            }
            if(resultSet==null && q.contains("update"))
            {
            	out.print("<table class='center'>");
            	out.print("<th id='green'>" + " Data Is Updated "+  "</th>");
            	out.print("</table>");
                        	return;
            }
            
            ResultSetMetaData resultSetMataData  = resultSet.getMetaData();
            
            int columns = resultSetMataData.getColumnCount();
            Object newObject[] = new Object[columns];
            
            if(columns==1)
            {
            	out.print("<table class='center'>");
            	newObject[0] = resultSetMataData.getColumnName(1);
            	out.print("<th id='green'>"+newObject[0] + "</th>");

            	out.print("</table>");
            	return;
            }
            
            
            out.println("<table class='center'>");
            out.println("<tr>");
            for(int i=0; i<columns;i++)
            {
            	newObject[i] = resultSetMataData.getColumnName(i+1);
            	out.print("<th>"+newObject[i] + "</th>");        
            }            
            out.println("</tr>");
            while(resultSet.next())
            {
            	out.println("<tr>");
            	for(int i=1; i<=columns;i++)
                {
            		String data = resultSet.getString(i);
                	out.print("<td>"+data+ "</td>");        
                }
            	out.println("</tr>");
            }
            out.println("</table>");
            resultSet.close();
            
            statement.close();
            connection.close();
            
            
        } catch (SQLException ex) 
    	{
        	out.print("<table class='center'>");
        	out.print("<th>" +  ex.getMessage() +"</th>");

        	out.print("</table>");
    	}
    		
    	%>
    </div>
  </body>
  <script>
    function Execute() 
    {
    	
      alert(document.getElementById("text_area").value + " is Executed ");
    }
    function Clear() {
      document.getElementById("text_area").value = "";
      alert("Command is Cleared");
    }
  </script>
</html>
