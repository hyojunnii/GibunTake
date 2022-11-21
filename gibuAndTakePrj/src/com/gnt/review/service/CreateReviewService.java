package com.gnt.review.service;

import static com.gnt.common.JDBCTemplate.*;


import java.sql.Connection;

import com.gnt.review.repository.CreateReviewDao;
import com.gnt.review.repository.UploadImgDao;

public class CreateReviewService {

	public String getCreateReviewNo() {
		String result = null;
		Connection conn = null;
		
		conn = getConnection();
		result = new CreateReviewDao().getCreateReviewNo(conn);
	
		close(conn);
		
		return result;
	}

}
