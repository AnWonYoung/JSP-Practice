package an.won.young;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardMethod {
	public static List<BoardField> selBoardList() {
		List<BoardField> data = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT iboard, title, b_date FROM t_board2 ORDER BY iboard ASC ";
		
		try {
			con = DBconnection.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardField b = new BoardField();
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String b_date = rs.getString("b_date");
				
				b.setIboard(iboard);
				b.setTitle(title);
				b.setB_date(b_date);
				
				data.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnection.close(con, ps, rs);
		}
		
		return data;
	}
	
	public static int insertBoard(BoardField data) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board2 (title, content) VALUES(?,?) ";
		
		try {
			con = DBconnection.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, data.getTitle());
			ps.setString(2, data.getContent());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnection.close(con, ps);
		}
		
		return 0;
	}
	
	public static BoardField selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM t_board2 WHERE iboard = ? ";
		
		try {
			con = DBconnection.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,iboard);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			BoardField b = new BoardField();
			String title = rs.getString("title");
			String content = rs.getString("content");
			String b_data = rs.getString("b_date");
			
			b.setIboard(iboard);
			b.setTitle(title);
			b.setContent(content);
			b.setB_date(b_data);
			
			return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBconnection.close(con, ps, rs);
		}
		return null;
	}
	
	public static int delBoard(BoardField iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board2 WHERE iboard = ?";
		
		try {
			con = DBconnection.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard.getIboard());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnection.close(con, ps);
		}
		return 0;
	}
	
	public static int modBoard(BoardField data) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE t_board2 SET title = ?, content = ? WHERE iboard = ? ";
		
		try {
			con = DBconnection.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, data.getTitle());
			ps.setString(2, data.getContent());
			ps.setInt(3, data.getIboard());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnection.close(con, ps);
		}
		
		return 0;
	}
}
