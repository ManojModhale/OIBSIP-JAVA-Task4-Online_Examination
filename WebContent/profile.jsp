<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.exam.bean.User" %>
<html>
<head>
    <title>User Profile</title>
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

        p.success {
            color: green;
        }

        p.error {
            color: red;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
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
    <h2 align="center">User Profile</h2>

    <%-- Display success message if available --%>
    <% if (request.getAttribute("successMessage") != null) { %>
        <p class="success"><%= request.getAttribute("successMessage") %></p>
    <% } %>

    <%-- Display error message if available --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
        <p class="error"><%= request.getAttribute("errorMessage") %></p>
    <% } %>

    <form action="ProfileServlet" method="post">
        <% User user = (User) session.getAttribute("User"); %>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="<%= user.getUsername() %>" readonly><br>

        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required><br>

        <input type="submit" value="Update Profile">
    </form>

    <%-- Redirect to home.jsp in 5 seconds after success message --%>
    <% if (request.getAttribute("successMessage") != null) { %>
        <% response.setHeader("Refresh", "5;url=home.jsp"); %>
    <% } %>
</body>
</html>
