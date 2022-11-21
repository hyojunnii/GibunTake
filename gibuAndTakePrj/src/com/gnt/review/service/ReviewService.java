package com.gnt.review.service;

import static com.gnt.common.JDBCTemplate.close;
import static com.gnt.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gnt.review.repository.ReviewDao;
import com.gnt.review.vo.ReviewDetailVo;
import com.gnt.review.vo.ReviewPageVo;
import com.gnt.review.vo.ReviewVo;

public class ReviewService {
	
	private final ReviewDao dao = new ReviewDao();
	
	public int getCount(int category) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.getCount(conn, category);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		return result;
	}
	
	public List<ReviewVo> selectList(ReviewPageVo pageVo) {
		List<ReviewVo> result = null;
		Connection conn = null;
		
		conn = getConnection();
		result = dao.selectList(conn, pageVo);
	
		close(conn);
			
		return result;
	}

	public ReviewDetailVo selectReviewOne1(String revNo) {
		ReviewDetailVo result = null;
		Connection conn = null;
		
		conn = getConnection();
		result = dao.selectReviewOne1(conn, revNo);
		
		close(conn);
			
		return result;
	}
	
	public ReviewDetailVo selectReviewOne2(String revNo) {
		ReviewDetailVo result = null;
		Connection conn = null;
		
		conn = getConnection();
		result = dao.selectReviewOne2(conn, revNo);
		
		close(conn);
			
		return result;
	}
	
	public ReviewDetailVo selectReviewOne3(String revNo) {
		ReviewDetailVo result = null;
		Connection conn = null;
		
		conn = getConnection();
		result = dao.selectReviewOne3(conn, revNo);
		
		close(conn);
			
		return result;
	}
}
	
