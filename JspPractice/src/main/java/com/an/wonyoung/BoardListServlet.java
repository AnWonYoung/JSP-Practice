package com.an.wonyoung;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", Database.list); // 값을 set해주기, 어디서 어떤 값을 해줄 건지 생각
		
		String jsp = "WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(jsp).forward(request, response); // set, get 유의하기
	}


}
