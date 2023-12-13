<%@ page import="com.exam.bean.Quiz" %>
<%@ page import="com.exam.bean.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exam Page</title>
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

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        h3 {
            color: red;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }

        input[type="radio"] {
            margin-right: 5px;
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
    </style>
</head>
<body>
    <h1 align="center">Exam Page</h1>

    <%-- Display error message if available --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
        <h3 align="center"><%= request.getAttribute("errorMessage") %></h3>
    <% } %>
    <br>

    <form action="SubmitServlet" method="post">
        <%-- Retrieve Quiz object from the session --%>
        <% Quiz quiz = (Quiz) session.getAttribute("examination"); %>

        <%-- Display the current question --%>
        <h2><%= quiz.getCurrentQuestion().getQuestionText() %></h2>

        <%-- Display options for the current question --%>
        <% String[] options = quiz.getCurrentQuestion().getOptions(); %>
        <ul>
            <% for (int i = 0; i < options.length; i++) { %>
                <li>
                    <input type="radio" name="answer" value="<%= i %>" />
                    <%= options[i] %>
                </li>
            <% } %>
        </ul>

        <%-- Display navigation buttons --%>
        <% if (quiz.hasNextQuestion()) { %>
            <input type="submit" value="Next Question" />
        <% } else { %>
            <input type="submit" value="Submit Exam" />
        <% } %>
    </form>
</body>
</html>
