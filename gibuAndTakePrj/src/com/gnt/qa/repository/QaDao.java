package com.gnt.qa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.PageVo;
import com.gnt.qa.vo.QaVo;

public class QaDao {

//	public ArrayList<QaVo> selectList(Connection conn, PageVo pageVo) {
//		
//		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , RM.* FROM ( SELECT Q.QA_NO,  Q.QA_NAME , Q.QA_CONTENT, Q.QA_DATE FROM QA Q WHERE QA_DEL = 'N' ORDER BY Q.QA_NO DESC ) RM ) WHERE RNUM BETWEEN ? AND ?";
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ArrayList<QaVo> list = new ArrayList<QaVo>();
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
//			int end = start + pageVo.getBoardLimit() - 1;
//			
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String no = rs.getString("QA_NO");
//				String name = rs.getString("QA_NAME");
//				String content = rs.getString("QA_CONTENT");
//				String date = rs.getString("QA_DATE");
//				
//				QaVo vo = new QaVo();
//				vo.setNo(no);
//				vo.setName(name);
//				vo.setContent(content);
//				vo.setDate(date);
//				
//				list.add(vo);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//			close(rs);
//		}
//		return list;
//	}
//
//	public int getCount(Connection conn) {
//		
//		String sql = "SELECT COUNT(QA_NO) AS COUNT FROM QA WHERE QA_DEL = 'N'";
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int count = 0;
//		
//		try {
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				count = rs.getInt("COUNT");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//			close(rs);
//		}
//		
//		return count;
//	}

}
