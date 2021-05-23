package an.won.young.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import an.won.young.utils.DBUtils;

public class BoardDAO {
	
	public static List<BoardVO> selBoardList(BoardVO param) {
		// 						    <<추가된 점>>
		// BoardVO 필드를 받아서 search(찾기), sidx, page(페이징 처리) 구현하기
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select A.iboard, A.title, A.regdt, B.unm "
					  + " from t_board3 A left join "
					  + " t_user3 B on A.iuser = B.iuser "
					  + " where title like ? "
					  + " order by A.iboard DESC "
					  + " limit ?, ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "%" + param.getSearch() + "%");
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getPage());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {		// 한 줄이 나올 때만 if문
				BoardVO vo = new BoardVO();
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	
	}
	
	public static int getAllPage(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select ceil(count(*) / ?) as cnt from t_board3"
					+ " where title like ? ";
		
		int result = 0;
		
		try {
			con = DBUtils.getCon();
			ps= con.prepareStatement(sql);
			
			ps.setInt(1, param.getPage());
			ps.setString(2, "%" + param.getSearch() + "%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;
	}
	
}
