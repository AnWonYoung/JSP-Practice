package an.won.young.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import an.won.young.user.UserVO;

// int형으로 바꿔주는 메소드
// open jsp 메소드
// 세션에서 loginUser 가져오는 메소드

public class MyUtils {
	// 형변환 메소드
	public static int parseStringToInt(String val) {
		try {
		return Integer.parseInt(val);
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static int getParamInt(String key, HttpServletRequest req) {
		String val = req.getParameter(key);
		int intVal = MyUtils.parseStringToInt(val);
		
		return intVal;
	}
	// jsp파일을 여는 메소드
	public static void openJSP(String title, String page, HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		req.setAttribute(Const.PAGE, page);
		req.setAttribute(Const.TITLE, title);
		
		String jsp = "/WEB-INF/view/template.jsp"; // template.jsp안에 다른 jsp파일을 불러서 뿌림 --> template.jsp 주소만 설정해도 됨
		req.getRequestDispatcher(jsp).forward(req, res);
	}
	
	public static UserVO getLoginUser(HttpServletRequest req) {
		if(req == null) {return null;}
		HttpSession hs = req.getSession();
		return (UserVO)hs.getAttribute("userLogin");
	}
	
	public static int getLoginUserPK(HttpServletRequest req) {
		if(req == null) {return 0;}
		return getLoginUser(req).getIuser();
	}
	
}
