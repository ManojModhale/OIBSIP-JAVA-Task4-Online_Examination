<%@ page import="com.exam.bean.Quiz" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exam Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
        }

        h1 {
            color: #333;
        }

        p {
            margin-bottom: 20px;
            color: #333;
            margin-left: 500px;
            word-spacing: 4px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h4 {
            color: #333;
            margin-bottom: 15px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
            padding: 10px;
            border: none;
            border-radius: 4px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        a {
            color: #007bff;
            text-decoration: none;
            margin-left: 10px;
        }
        a:hover {
			background-color: aqua;
		}
    </style>
</head>
<body>
    <h1 align="center">Exam Result</h1>

    <%-- Retrieve Quiz object from the session --%>
    <% Quiz quiz = (Quiz) session.getAttribute("examination"); %>

    <%-- Display the user's score --%>
    <p><u><%= session.getAttribute("Subject") %> Subject Exam Marks are <b><%= quiz.getUserScore() %></b> out of <%= quiz.getQuestions().size() %></u></p>

    <form action="home.jsp">
        <h4>If You Want to Continue With Exam for Another Subject</h4>
        <input type="submit" value="Attempt Exam Again" />
        <br><br><br>
        <a href="LogoutServlet">Logout</a>
    </form>
</body>
</html>
