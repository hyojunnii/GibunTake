package com.gnt.review.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.gnt.common.JDBCTemplate.*;

public class CreateReviewDao {

	public String getCreateReviewNo(Connection conn) {
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			//sql 준비
			String sql = "SELECT SEQ_REVIEW_REV_NO.NEXTVAL FROM DUAL";
			//sql 객체에 담기
			pstmt = conn.prepareStatement(sql);
			
			//미완성 sql 완성
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("NEXTVAL");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//다쓴 자원 정리하기
			close(pstmt);
		}
		
		return result;
	}
	

}
