package com.an.wonyoung;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del1")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard); 
		
		BoardVO vo = new BoardVO();
		vo.setIboard(intIboard);	// 객체 생성 후 값 set,
		BoardDAO.delBoard(vo);		// delBoard 안에 담아서 호출
		
		response.sendRedirect("/list1");
	}

}
