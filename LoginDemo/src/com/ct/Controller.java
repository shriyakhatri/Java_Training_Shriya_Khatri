package com.ct;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      PrintWriter out = response.getWriter();

		
		String un = request.getParameter("username");
        String pw = request.getParameter("password");
        if ((un.equals("admin")) && (pw.equals("admin"))) {

            HttpSession session = request.getSession(true); 
            session.setAttribute("user", un);
            session.setAttribute("pwd", pw);
            response.sendRedirect("main.jsp");

}
        else
        {
            out.println("<font color=red>Either user name or password is wrong.</font>");

            response.sendRedirect("login.jsp");

        	
        }
}
}