package com.gnt.review.service;

import static com.gnt.common.JDBCTemplate.close;
import static com.gnt.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.gnt.review.repository.ReviewDao;
import com.gnt.review.repository.UploadImgDao;
import com.gnt.review.vo.ReviewDetailVo;
import com.gnt.review.vo.ReviewImgVo;
import com.gnt.review.vo.ReviewVo;

public class UpdateReviewService {

	public int updateReview(ReviewVo reviewVo, ReviewImgVo imgVo, String regNo) {
		int result1 = 0;
		int result2 = 0;
		Connection conn = null;
		
		conn = getConnection();
		result1 = new ReviewDao().updateReviewOne(conn, reviewVo, regNo);
		if(imgVo!=null) {
			result2 = new UploadImgDao().UploadImg(conn, imgVo);
		}
		
		if(imgVo==null) {
			result2 = 1;
		}
		close(conn);
			
		return result1*result2;
	}

}
