package an.won.young.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import an.won.young.utils.MyUtils;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("리스트", "board/list", request, response);
		
		String search = request.getParameter("serach");
		if(search == null) {search = "";}
		
		int page = MyUtils.getParamInt("page", request);
		if(page == 0) {page = 1;}
		
		int recordNum = 5;
		int sIdx = (page - 1) * recordNum;
		
		BoardVO param = new BoardVO();
		param.setSearch(search); // getAllPage에서 필요
		param.setPage(page);
		param.setsIdx(sIdx);
		
		request.setAttribute("totalPage", BoardDAO.getAllPage(param));
		request.setAttribute("list", BoardDAO.selBoardList(param));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
