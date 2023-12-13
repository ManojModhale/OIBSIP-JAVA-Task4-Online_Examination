package com.exam.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		NewUserDAO nudao=new NewUserDAO();
		User user=nudao.getUserByUsername(con, username);
		
		session.setAttribute("User", user);
		//System.out.println(session.getAttribute("User"));
		
		request.getRequestDispatcher("profile.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		NewUserDAO nudao=new NewUserDAO();
		User user = nudao.getUserByUsername(con,username);
		user.setPassword(request.getParameter("newPassword"));
		
		if(nudao.updateProfile(con, user))
		{
			request.setAttribute("successMessage", "Profile updated successfully");
        } 
		else 
		{
            // Set an error message in the request attribute
            request.setAttribute("errorMessage", "Failed to update profile");
        }
		
		user=nudao.getUserByUsername(con, username);
		session.setAttribute("currentUser", user);
		//System.out.println("Current User is  : "+session.getAttribute("currentUser"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);
	}

}
