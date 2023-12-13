package com.exam.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.bean.Question;
import com.exam.bean.Quiz;

/**
 * Servlet implementation class ExamServlet
 */
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con;
    ServletContext ctx;
	public void init(ServletConfig config) throws ServletException 
	{
		// TODO Auto-generated method stub
		ctx=config.getServletContext();
		con=(Connection) ctx.getAttribute("DB_Con");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		String SubjectName = (request.getParameter("subject"));
		
		if(SubjectName.equals("C"))
		{
			ArrayList<Question> questions = getC();
			Quiz quiz = new Quiz(questions);
			session.setAttribute("Subject", SubjectName);
			session.setAttribute("examination", quiz);
		}
		else if(SubjectName.equals("SQL"))
		{
			ArrayList<Question> questions = getSQL();
			Quiz quiz = new Quiz(questions);
			session.setAttribute("Subject", SubjectName);
			session.setAttribute("examination", quiz);
		}
		else if(SubjectName.equals("RWD"))
		{
			ArrayList<Question> questions = getRWD();
			Quiz quiz = new Quiz(questions);
			session.setAttribute("Subject", SubjectName);
			session.setAttribute("examination", quiz);
		}
		else
		{
			ArrayList<Question> questions = getJava();
			Quiz quiz = new Quiz(questions);
			session.setAttribute("Subject", SubjectName);
			session.setAttribute("examination", quiz);
		}   

        
        RequestDispatcher dispatcher=request.getRequestDispatcher("exam.jsp");
		dispatcher.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
 private ArrayList<Question> getC() 
{
		 	ArrayList<Question> questions = new ArrayList<>();
		 	
questions.add(new Question("What does 'C' stand for in C programming?",
                    new String[]{"Computer", "Common", "Central", "Circuit"},
 2));

questions.add(new Question("Which of the following is the correct way to declare a variable in C?",
                    new String[]{"variable x;", "int x;", "x = 5;", "declare x as int;"},
 1));

questions.add(new Question("What is the purpose of the 'printf' function in C?",
                    new String[]{"Read input from the user", "Print output to the console", "Perform mathematical calculations", "Allocate memory for variables"},
1));

questions.add(new Question("In C, what is the result of the expression 5 / 2?",
                    new String[]{"2.5", "2", "2.0", "2.25"},
1));

questions.add(new Question("Which of the following is a valid comment in C?",
                    new String[]{"// This is a comment", "# This is a comment", "/* This is a comment */", "-- This is a comment"},
2));

questions.add(new Question("What is the purpose of the 'return' statement in a C function?",
                    new String[]{"To print output", "To exit the program", "To return a value from the function", "To declare a variable"},
 2));

questions.add(new Question("What is the primary purpose of the #include directive in C?",
                    new String[]{"Defines a macro", "Declares a function", "Includes a header file", "Allocates memory"},
 2));

questions.add(new Question("What is the correct syntax for a 'for' loop in C?",
                    new String[]{"for (int i = 0; i < 10; i++)", "for i = 1 to 10", "loop (int i = 0; i < 10; i++)", "for (i = 0; i < 10; i++)"},
 0));

questions.add(new Question("What is the purpose of the scanf function in C?",
                    new String[]{"Prints formatted text to the console.", "Reads input from the console", "Allocates memory for variables", "Performs mathematical calculations"},
1));

questions.add(new Question("What does the void keyword indicate in a function declaration in C?",
                    new String[]{"function returns an integer", "function has no parameters", "function returns no value", "function accepts any data type"},
 2));
       
	        return questions;
}
		 
private ArrayList<Question> getSQL() 
{
		 	ArrayList<Question> questions = new ArrayList<>();
		 	
questions.add(new Question("What does SQL stand for?",
                    new String[]{"Structured Language", "Structured Logic", "Structured Query Language", "Simple Query Language"},
2));

questions.add(new Question("Which SQL keyword is used to retrieve data from a database?",
                    new String[]{"SELECT", "FETCH", "RETRIEVE", "GET"},
 0));

questions.add(new Question("Which SQL clause is used to filter the results of a query?",
                    new String[]{"FILTER BY", "RESTRICT", "WHERE", "LIMIT"},
 2));

questions.add(new Question("In SQL, which data type would you use for a column containing numeric values with decimal points?",
                    new String[]{"INTEGER", "FLOAT", "DECIMAL", "VARCHAR"},
 2));

questions.add(new Question("What is the purpose of the SQL GROUP BY clause?",
                    new String[]{"To sort the result set in ascending order", "To group rows based on a column's values", "To limit the number of rows returned", "To join tables"},
 1));

questions.add(new Question("Which SQL statement is used to modify data in a database?",
                    new String[]{"ALTER", "UPDATE", "INSERT", "MODIFY"},
 1));

questions.add(new Question("In SQL, what is the purpose of the JOIN clause?",
                    new String[]{"To create a new table", "To filter results based on a condition", "To combine rows from two or more tables", "To rename a table"},
 2));

questions.add(new Question("What does the SQL acronym ACID stand for in the context of database transactions?",
                    new String[]{"Atomicity, Consistency, Isolation, Durability", "All Columns In Data", "Access Control In Databases", "Associative Control of Internal Data"},
0));

questions.add(new Question("Which SQL function is used to find the total number of rows in a table?",
                    new String[]{"COUNT", "SUM", "TOTAL", "ROWS"},
0));

questions.add(new Question("In SQL, what is the purpose of the HAVING clause?",
                    new String[]{"To filter rows based on a condition", "To sort the result set", "To limit the number of rows returned", "To filter results of aggregate functions"},
3));

		 	
	        return questions;
}
	 

private ArrayList<Question> getRWD()
{
		ArrayList<Question> questions = new ArrayList<>();
	
questions.add(new Question("What does HTML stand for?",
            new String[]{"Hyperlink and Text Markup Language", "Hyper Text Markup Language", "High-Level Text Markup Language", "Hyper Transfer Markup Language"},
 1));

questions.add(new Question("Which HTML tag is used to define an unordered list?",
            new String[]{"<ol>", "<li>", "<ul>", "<dl>"},
 2));

questions.add(new Question("In CSS, what property is used to set the background color of an element?",
            new String[]{"background-color", "color", "background", "bgcolor"},
0));

questions.add(new Question("What is the correct way to link an external JavaScript file in an HTML document?",
            new String[]{"<script href='script.js'>", "<script name='script.js'>", "<link rel='javascript' href='script.js'>", "<script src='script.js'></script>"},
 3));

questions.add(new Question("Which HTML tag is used to define a table?",
            new String[]{"<table>", "<tr>", "<td>", "<th>"},
 0));

questions.add(new Question("In CSS, what is the 'box model' used for?",
            new String[]{"Positioning elements", "Styling tables", "Defining page structure", "Calculating space around an element"},
3));

questions.add(new Question("What does CSS stand for?",
            new String[]{"Computer Style Sheet", "Creative Style Sheet", "Cascading Style Sheet", "Colorful Style Sheet"},
2));

questions.add(new Question("Which JavaScript function is used to select an HTML element by its id?",
            new String[]{"getElementById()", "selectElementById()", "getElementsByClassName()", "querySelector()"},
 0));

questions.add(new Question("What is the default value of the 'position' property in CSS?",
        new String[]{"relative", "absolute", "static", "fixed"},
2));

questions.add(new Question("Which HTML tag is used to include external CSS code?",
            new String[]{"<style>", "<link>", "<css>", "<script>"},
 1));
		return questions;

}



	 
private ArrayList<Question> getJava()
{
		 ArrayList<Question> questions=new ArrayList<>();
		 
questions.add(new Question("Which of the following is the correct way to declare a variable in Java?", 
                 new String[]{"int x;", "variable x;", "x = int;", "declare x as int;"}, 0));

questions.add(new Question("What is the purpose of the 'static' keyword in Java?", 
                 new String[]{"To declare a variable", "To define a constant", "To indicate that a method belongs to the class and not an instance", "To specify the return type of a method"}, 2));

questions.add(new Question("Which data type is used to represent decimal numbers in Java?", 
                 new String[]{"int", "float", "double", "char"},  2));

questions.add(new Question("What is the main difference between '==' and '.equals()' in Java when comparing objects?", 
                 new String[]{"They are used interchangeably", "'.equals()' is used for primitive types, '==' is used for objects", "'.equals()' compares the content of objects, '==' compares the references", "'.equals()' is a syntax error"}, 
 2));

questions.add(new Question("Which keyword is used to implement multiple inheritances in Java?", 
                 new String[]{"extends", "implements", "interface", "abstract"}, 
 2));

questions.add(new Question("In Java, which exception is thrown when an array index is out of bounds?", 
                 new String[]{"ArrayIndexOutOfBoundsException", "IndexOutOfBoundsException", "ArrayOutOfBoundsException", "OutOfBoundsError"}, 
0));

questions.add(new Question("What is the purpose of the 'super' keyword in Java?", 
                 new String[]{"To call the superclass constructor", "To access the superclass's fields and methods", "To declare a superclass", "To override a superclass method"}, 
  1));

questions.add(new Question("Which Java collection class is synchronized by default?", 
                 new String[]{"ArrayList", "LinkedList", "HashMap", "Vector"}, 
3));

questions.add(new Question("What is the purpose of the 'finally' block in a try-catch-finally statement?", 
                 new String[]{"To catch exceptions", "To execute code regardless of whether an exception is thrown or not", "To handle checked exceptions", "To indicate the end of the try-catch block"}, 
 1));

questions.add(new Question("Which of the following is true about Java's garbage collection?", 
                 new String[]{"It explicitly deallocates memory", "It automatically frees memory occupied by objects that are no longer in use", "It is required to be called explicitly by the programmer", "It only works for primitive data types"}, 
 1));
			return questions;

}
	 
	 
	 
}
