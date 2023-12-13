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

import com.exam.bean.User;
import com.exam.dao.NewUserDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//System.out.println("Connection is "+con);
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
		response.setContentType("text/html");
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user=new User(username, password); 
        NewUserDAO nudao=new NewUserDAO();
        boolean answer=nudao.loginUser(con, user);
        
        if (answer==true) 
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            User loggedUser=nudao.getUserByUsername(con, username);           
    		session.setAttribute("FirstName", loggedUser.getFirstname());
    		session.setAttribute("LastName", loggedUser.getLastname());
    		
            response.setContentType("text/html");
            response.sendRedirect("home.jsp");
        } 
        else 
        {
            request.setAttribute("error", "Invalid username or password");
            response.setContentType("text/html");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
