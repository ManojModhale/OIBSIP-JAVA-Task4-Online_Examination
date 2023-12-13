package com.exam.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.bean.Quiz;

/**
 * Servlet implementation class SubmitServlet
 */
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
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
		  HttpSession session = request.getSession();
	      Quiz quiz = (Quiz) session.getAttribute("examination");
	      
	      int selectedAnswer = Integer.parseInt(request.getParameter("answer"));
	      System.out.println("selected option : "+selectedAnswer);
	        // Check if the selected answer is correct and update the user's score
	        if (quiz.getCurrentQuestion().isCorrect(selectedAnswer)) 
	        {
	            quiz.incrementUserScore();
	        }

	        // Move to the next question or end the quiz if there are no more questions
	        quiz.nextQuestion();

	        // Store the updated Quiz object in the session
	        session.setAttribute("examination", quiz);

	        // Redirect back to the exam.jsp for the next question or result.jsp if the quiz is completed
	        if (quiz.hasNextQuestion()) {
	            response.sendRedirect("exam.jsp");
	        } else {
	            response.sendRedirect("result.jsp");
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
