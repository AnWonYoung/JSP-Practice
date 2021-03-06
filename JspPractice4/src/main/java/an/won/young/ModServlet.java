package an.won.young;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		BoardField b = BoardMethod.selBoard(intIboard);
		request.setAttribute("data", b);
		
		String jsp = "/WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int intIboard = Integer.parseInt(iboard);
		
		BoardField b = new BoardField();
		b.setIboard(intIboard);
		b.setTitle(title);
		b.setContent(content);
		
		BoardMethod.modBoard(b);
		
		response.sendRedirect("/detail?iboard=" + iboard);
	}

}
