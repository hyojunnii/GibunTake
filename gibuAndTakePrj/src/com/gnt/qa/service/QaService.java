package com.gnt.qa.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.PageVo;
import com.gnt.qa.repository.QaDao;
import com.gnt.qa.vo.QaVo;

public class QaService {

//	public ArrayList<QaVo> selectList(PageVo pageVo) {
//		Connection conn = null;
//		ArrayList<QaVo> voList = null;
//		
//		conn = getConnection();
//		voList = new QaDao().selectList(conn, pageVo);
//		
//		close(conn);
//		
//		return voList;
//	}
//
//	public int getCount() {
//		Connection conn = null;
//		int result = 0;
//		
//		try {
//			conn = getConnection();
//			result = new QaDao().getCount(conn);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(conn);
//		}
//		
//		return result;
//	}

}
