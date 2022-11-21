package com.gnt.notice.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.PageVo;
import com.gnt.managercategory.vo.CategoryVo;
import com.gnt.notice.repository.NoticeDao;
import com.gnt.notice.vo.NoticeVo;

public class NoticeService {

	public ArrayList<NoticeVo> selectList(PageVo pageVo) {
		Connection conn = null;
		ArrayList<NoticeVo> voList = null;
		
		
			conn = getConnection();
			voList = new NoticeDao().selectList(conn, pageVo);
		
			close(conn);
		
		return voList;
	}

	
	public int writeNotice(NoticeVo vo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = new NoticeDao().writeNotice(conn, vo);
			
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

	public List<CategoryVo> selectCategoryList() {
		Connection conn = getConnection();
		List<CategoryVo> list = new NoticeDao().selectCategoryList(conn);
		close(conn);
		return list;
	}

	public int increaseNotice(String num) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			//DAO 호출
			result = new NoticeDao().increaseNotice(conn, num);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}

	public NoticeVo selectNum(String num) {
		Connection conn = null;
		NoticeVo vo = null;
		
		try {
			conn = getConnection();
			vo = new NoticeDao().selectNum(conn, num);
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
			
			result = new NoticeDao().getCount(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}
	
	

	//공지사항 삭제
	public int delete(String num) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = new NoticeDao().delete(conn, num);
			
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

	//공지사항 수정
	public int modify(NoticeVo vo) {
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
			result = new NoticeDao().modify(conn, vo);
			
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

}
