package com.gnt.faq.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.PageVo;
import com.gnt.faq.vo.CategoryVo;
import com.gnt.faq.vo.FaqVo;

public class FaqDao {

	public ArrayList<FaqVo> selectList(Connection conn, PageVo pageVo) {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , RM.* FROM ( SELECT F.FAQ_NO,  F.FAQ_TITLE , F.FAQ_CONTENT, MN.MN_NICK AS FAQ_WRITER , F.FAQ_DATE FROM FAQ F JOIN Manager MN ON F.FAQ_WRITER = MN.MN_NO  WHERE STATUS = 'N' ORDER BY F.FAQ_NO DESC ) RM ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FaqVo> list = new ArrayList<FaqVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("FAQ_NO");
				String title = rs.getString("FAQ_TITLE");
				String content = rs.getString("FAQ_CONTENT");
				String writer = rs.getString("FAQ_WRITER");
				String date = rs.getString("FAQ_DATE");
				
				FaqVo vo = new FaqVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setDate(date);
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
		
	}

	public int getCount(Connection conn) {
		String sql = "SELECT COUNT(FAQ_NO) AS COUNT FROM FAQ WHERE STATUS = 'N' AND FAQ_WRITER = 1";
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return count;
	}

	public List<CategoryVo> selectCategoryList(Connection conn) {
		String sql = "SELECT CATEGORY_NO ,CATEGORY_NAME FROM FAQ_CATEGORY";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new CategoryVo(
						rs.getString("CATEGORY_NO")
						  , rs.getString("CATEGORY_NAME")
							));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

	public int writeFaq(Connection conn, FaqVo vo) {
		
		String sql = "INSERT INTO FAQ (FAQ_NO, FAQ_CATE ,FAQ_TITLE ,FAQ_CONTENT , FAQ_WRITER ) VALUES ( SEQ_FAQ_NO.NEXTVAL ,?, ? , ? , ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCate());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getWriter());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int delete(Connection conn, String num) {
		String sql = "DELETE FAQ WHERE FAQ_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public FaqVo selectNum(Connection conn, String num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FaqVo vo = null;
		
		String sql = "SELECT F.FAQ_NO ,F.FAQ_TITLE , F.FAQ_CONTENT , F.FAQ_DATE, F.STATUS ,MN.MN_NICK AS FAQ_WRITER FROM FAQ F JOIN Manager MN ON F.FAQ_WRITER = MN.MN_NO WHERE STATUS = 'N' AND F.FAQ_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("FAQ_NO");
				String title = rs.getString("FAQ_TITLE");
				String content = rs.getString("FAQ_CONTENT");
				String writer = rs.getString("FAQ_WRITER");
				String date = rs.getString("FAQ_DATE");
				
				vo = new FaqVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setDate(date);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}

	public int modify(Connection conn, FaqVo vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "UPDATE FAQ SET FAQ_TITLE = ? , FAQ_CONTENT = ? WHERE FAQ_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
