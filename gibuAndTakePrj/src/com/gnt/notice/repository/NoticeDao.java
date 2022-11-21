package com.gnt.notice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.PageVo;
import com.gnt.managercategory.vo.CategoryVo;
import com.gnt.notice.vo.NoticeVo;

public class NoticeDao {

	public ArrayList<NoticeVo> selectList(Connection conn, PageVo pageVo) {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , RM.* FROM ( SELECT N.N_NO,  N.N_TITLE , N.N_CONTENT, MN.MN_NICK AS N_WRITER , N.N_CNT , N.N_DATE FROM Notice N JOIN Manager MN ON N.N_WRITER = MN.MN_NO  WHERE N.STATUS = 'N' ORDER BY N.N_NO DESC ) RM ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("N_NO");
				String title = rs.getString("N_TITLE");
				String content = rs.getString("N_CONTENT");
				String writer = rs.getString("N_WRITER");
				String cnt = rs.getString("N_CNT");
				String date = rs.getString("N_DATE");
				
				NoticeVo vo = new NoticeVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.setDate(date);
				
				list.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

	public int writeNotice(Connection conn, NoticeVo vo) {
		
		String sql = "INSERT INTO NOTICE (N_NO, N_CATE ,N_TITLE ,N_CONTENT ,N_WRITER ) VALUES ( SEQ_NOTICE_NO.NEXTVAL ,?, ? , ? , ?)";
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

	public List<CategoryVo> selectCategoryList(Connection conn) {
		
		String sql = "SELECT CATEGORY_NO ,CATEGORY_NAME FROM M_CATEGORY";
		
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

	public int increaseNotice(Connection conn, String num) {
		
		String sql ="UPDATE Notice SET N_CNT = N_CNT+1 WHERE N_NO = ? AND STATUS = 'N'";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public NoticeVo selectNum(Connection conn, String num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVo vo = null;
		
		String sql = "SELECT N.N_NO ,N.N_TITLE , N.N_CONTENT , N.N_CNT , N.N_DATE, N.N_MOD, N.STATUS ,MN.MN_NICK AS N_WRITER FROM Notice N JOIN Manager MN ON N.N_WRITER = MN.MN_NO WHERE N.STATUS = 'N' AND N.N_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("N_NO");
				String title = rs.getString("N_TITLE");
				String content = rs.getString("N_CONTENT");
				String writer = rs.getString("N_WRITER");
				String cnt = rs.getString("N_CNT");
				String date = rs.getString("N_DATE");
				String mod = rs.getString("N_MOD");
				String status = rs.getString("STATUS");
				
				vo = new NoticeVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.setDate(date);
				vo.setMod(mod);
				vo.setStatus(status);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}

	public int getCount(Connection conn) {

				String sql = "SELECT COUNT(N_NO) AS COUNT FROM Notice WHERE STATUS = 'N' AND N_WRITER = 1";
				
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

	public int delete(Connection conn, String num) {
		
		String sql = "DELETE Notice WHERE N_NO = ?";
		
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

	//공지사항 수정
	public int modify(Connection conn, NoticeVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "UPDATE Notice SET N_TITLE = ? , N_CONTENT = ? WHERE N_NO = ?";
			
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
