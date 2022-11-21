package com.gnt.review.service;

import static com.gnt.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.UUID;

import com.gnt.review.repository.UploadImgDao;
import com.gnt.review.vo.ReviewImgVo;
import com.gnt.review.vo.ReviewVo;

public class UploadImgService {

	public String createChangeName(String originName) {
		int dotIdx = originName.lastIndexOf(".");
		String ext = originName.substring(dotIdx);
		
		long now = System.currentTimeMillis();
		String random = UUID.randomUUID().toString();
		random = random.substring(0,8);
		String changeName = "KH_"+now+"_"+random+ext; 
		
		return changeName;
	}
	
	
	public int UploadImg(ReviewImgVo vo) {
		int result = 0;
		Connection conn = null;
		
		conn = getConnection();
		result = new UploadImgDao().UploadImg(conn, vo);
		
		
		if(result==1) {
			
			commit(conn);
		}else {
			rollback(conn);
		}
		
	
		close(conn);
		
		
		return result;
	}


	public int InsertReview(ReviewVo reviewVo, ReviewImgVo imgVo,String regNo,String category) {
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		Connection conn = null;
		
		conn = getConnection();
		result1 = new UploadImgDao().InsertReview(conn, reviewVo);
		result2 = new UploadImgDao().UploadImg(conn, imgVo);
		result3 = new UploadImgDao().InsertRevReg(conn, reviewVo, regNo, category);
		
		if(result1*result2*result3==1) {
			
			commit(conn);
		}else {
			rollback(conn);
		}
		
	
		close(conn);
		
		
		return result1*result2*result3;
	}

}
