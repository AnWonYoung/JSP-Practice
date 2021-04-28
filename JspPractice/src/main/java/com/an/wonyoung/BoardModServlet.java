package com.an.wonyoung;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		request.setAttribute("data", Database.list.get(Integer.parseInt(no)));
		
		String jsp = "/WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		int intNo = Integer.parseInt(no);
		BoardField b = Database.list.get(intNo);
		b.setTitle(title);
		b.setCtnt(contents);
		
		response.sendRedirect("/detail?no=" + no);
	}

}
