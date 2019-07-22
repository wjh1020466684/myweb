package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baidu.ueditor.ActionEnter;
public class EditAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EditAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    request.setCharacterEncoding( "utf-8" );
		response.setHeader("Content-Type" , "text/html");
		String rootPath="D:\\phpfind\\WWW\\myweb";
		/*String rootPath = getServletContext().getRealPath( "D:\\phpfind\\WWW\\uedit" );*/
		System.out.println("rootPath="+rootPath);
		
		PrintWriter out = response.getWriter();
		out.write( new ActionEnter( request, rootPath ).exec() );
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
