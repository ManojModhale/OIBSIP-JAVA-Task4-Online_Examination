<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
        }

        h2 {
            color: #333;
        }

        p {
            margin-bottom: 20px;
            margin-left: 600px;
            width: 10%;
            padding: 3px;
        }
		
		p:hover{
		 background-color: aqua;
		}
		
        h3 {
            color: #333;
            margin-top: 20px;
        }

        form {
            max-width: 300px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
		/*
        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
        }*/
		/*
        input {
            width: 95%;  Adjusted width 
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }*/
		/*
        input[type="radio"] {
            margin-right: 5px;
            vertical-align: middle;
        }*/

        input[type="submit"] {
        width: 95%; 
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h2 align="center">Welcome to the Online Examination System!</h2>
    
    <h3 align="center">Hello, <%= session.getAttribute("FirstName") %>  <%= session.getAttribute("LastName") %> !</h3>
    
    <%-- Display error message if available --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
        <h4 align="center" style="color: red;"><%= request.getAttribute("errorMessage") %></h4>
    <% } %>
    <br>
    
    <!-- Profile Update Link -->
    <p><a href="ProfileServlet">Update Profile</a></p>
    
    <form action="ExamServlet" method="post">
        <h4>Select one Subject to Start Exam:</h4>
        <label for="c"><input type="radio" id="c" name="subject" value="C"> C</label><br>
        <label for="sql"><input type="radio" id="sql" name="subject" value="SQL"> SQL</label><br>
        <label for="rwd"><input type="radio" id="rwd" name="subject" value="RWD"> RWD</label><br>
        <label for="java"><input type="radio" id="java" name="subject" value="Java"> JAVA</label>
        <br><br>
        <input type="submit" value="Start Exam">
    </form>
    
    <br><br>
    <!-- Logout Link -->
    <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout">
    </form>

</body>
</html>
