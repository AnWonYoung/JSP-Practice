package an.won.young;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardField> data = BoardMethod.selBoardList();
		request.setAttribute("data", data);
		
		String jsp = "/WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
