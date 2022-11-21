package com.gnt.review.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gnt.review.vo.ReviewImgVo;
import com.gnt.review.vo.ReviewVo;
import com.gnt.common.JDBCTemplate;

public class UploadImgDao {

	
	public int UploadImg(Connection conn, ReviewImgVo vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			
			//sql 준비
			String sql = "INSERT INTO REVIMG(RVI_NO, REV_NO, URL) VALUES(SEQ_REVIMG_RVI_NO.nextval,?,?)";
			//sql 객체에 담기
			pstmt = conn.prepareStatement(sql);
			
			//미완성 sql 완성
			pstmt.setString(1, vo.getRevNo());
			pstmt.setString(2, vo.getUrl());
			
			
			
			
			//sql 실행 실행 결과 받기
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//다쓴 자원 정리하기
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
		
	}

	public int InsertReview(Connection conn, ReviewVo vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			
			//sql 준비
			String sql = "INSERT INTO REVIEW(REV_NO, M_NO, REV_NAME, REV_CONTENT, REV_CLASS) VALUES(?,?,?,?,?)";
			//sql 객체에 담기
			pstmt = conn.prepareStatement(sql);
			
			//미완성 sql 완성
			pstmt.setString(1, vo.getRevNo());
			pstmt.setString(2, vo.getmNo());
			pstmt.setString(3, vo.getRevName());
			pstmt.setString(4, vo.getRevContent());
			pstmt.setString(5, vo.getRevClass());
			
			
			
			
			//sql 실행 실행 결과 받기
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//다쓴 자원 정리하기
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int InsertRevReg(Connection conn, ReviewVo reviewVo, String regNo, String category) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			
			//sql 준비
			String sql = "INSERT INTO REVIEWREGIST(RR_NO, REV_NO, REG_NO, RR_CLASS) VALUES(SEQ_REVIEWREGIST_RR_NO.NEXTVAL,?,?,?)";
			//sql 객체에 담기
			pstmt = conn.prepareStatement(sql);
			
			//미완성 sql 완성
			pstmt.setString(1, reviewVo.getRevNo());
			pstmt.setString(2, regNo);
			pstmt.setString(3, category);
			
			
			
			
			//sql 실행 실행 결과 받기
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//다쓴 자원 정리하기
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
