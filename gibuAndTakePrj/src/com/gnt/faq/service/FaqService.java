package com.gnt.faq.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.PageVo;
import com.gnt.faq.repository.FaqDao;
import com.gnt.faq.vo.CategoryVo;
import com.gnt.faq.vo.FaqVo;

public class FaqService {

	private final FaqDao dao = new FaqDao();
	
	public ArrayList<FaqVo> selectList(PageVo pageVo) {
		Connection conn = null;
		ArrayList<FaqVo> vo = null;
		
		try {
			conn = getConnection();
			
			vo = dao.selectList(conn, pageVo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return vo;
	}

	public int getCount() {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = dao.getCount(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}

	public List<CategoryVo> selectCategoryList() {
		Connection conn = getConnection();
		List<CategoryVo> list = dao.selectCategoryList(conn);
		close(conn);
		return list;
	}

	public int writeFaq(FaqVo vo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.writeFaq(conn, vo);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}catch(Exception e) {
			rollback(conn);
		}finally {
			close(conn);
		}
		
		return result;
	}

	

	public FaqVo selectNum(String num) {
		Connection conn = null;
		FaqVo vo = null;
		
		try {
			conn = getConnection();
			vo = dao.selectNum(conn, num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return vo;
	}

	public int modify(FaqVo vo) {
		if(vo.getTitle().length() < 1) {
			return -1;
		}
		
		if(vo.getContent().length() < 1) {
			return -2;
		}
		
		Connection conn = null;
		int result = 0;
		
		conn = getConnection();
		
		try {
			result = dao.modify(conn, vo);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(conn);
		}
		
		return result;
	}
	
	public int delete(String num) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = dao.delete(conn, num);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}catch(Exception e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}

}
