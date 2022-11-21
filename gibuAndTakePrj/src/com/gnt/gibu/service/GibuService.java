package com.gnt.gibu.service;

import java.sql.Connection;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.ReplyVo;
import com.gnt.gibu.repository.GibuDao;
import com.gnt.gibu.vo.GibuVo;

public class GibuService {
	
	private final GibuDao dao = new GibuDao();

	//목록 조회
	public List<GibuVo> selectList(int type) {
		
		Connection conn = null;
		List<GibuVo> voList = null;
		
	
		conn = getConnection();
		//DAO 호출	
			voList = dao.selectList(conn, type);
			close(conn);
		return voList;
	}

	//게시글 총 개수 구하기
	public int getListCount(int type) {
		Connection conn = null;
		int result = 0;
		conn = getConnection();
		//DAO 호출
			result = dao.getListCount(conn, type);
			close(conn);
		return result;
	}
	//만료된 목록 조회
	public List<GibuVo> selectDoneList(int type) {
		Connection conn = null;
		List<GibuVo> voList = null;
		
		conn = getConnection();
		//DAO 호출	
			voList = dao.selectDoneList(conn, type);
			close(conn);
		return voList;
	}
	//만료된 게시글 총 개수 구하기
	public int getListDoneCount(int type) {
		Connection conn = null;
		int result = 0;
		conn = getConnection();
		//DAO 호출
			result = dao.getListDoneCount(conn, type);
			close(conn);
		return result;
	}

	public GibuVo selectDetail(int type, int num) {
		Connection conn = null;
		GibuVo vo = null;
		
		conn = getConnection();
		//DAO 호출	
			vo = dao.selectDetail(conn, type, num);
			close(conn);
		return vo;
	}

	public List<ReplyVo> selectReply(int type, int num) {
		Connection conn = null;
		List<ReplyVo> volist = null;
		
		conn = getConnection();
		//DAO 호출	
			volist = dao.selectReply(conn, type, num);
			close(conn);
		return volist;
	}

	public int insertReply(GibuVo vo) {
		Connection conn = null;
		int result = 0;
		conn = getConnection();
		//DAO 호출	
			result = dao.insertReply(conn, vo);
			close(conn);
		return result;
	}

	public ReplyVo GibuEdit(String num) {
		Connection conn = null;
		ReplyVo vo = null;
		
		conn = getConnection();
		//DAO 호출	
			vo = dao.GibuEdit(conn, num);
			close(conn);
		return vo;
	}

	public int Edit(ReplyVo vo) {
		//데이터 검사
		if(vo.getRepcontent().length()<1) {
			return -1;
		}
		Connection conn = null;

		conn = getConnection();
		//DAO 호출	
		int	result = dao.Edit(conn, vo);
			close(conn);
		return result;
	}

	public int GibuReplyDel(String num) {
		Connection conn = null;
		int result = 0;
		
		conn = getConnection();
		//DAO 호출	
			result = dao.GibuReplyDel(conn, num);
			close(conn);
		return result;
	}

	public GibuVo selectDetail(int num) {
		Connection conn = null;
		GibuVo vo = null;
		
		conn = getConnection();
		//DAO 호출	
			vo = dao.selectDetail(conn, num);
			close(conn);
		return vo;
	}

	public int donateMoney(int num, int mno, int addmoney) {
		Connection conn = null;

		conn = getConnection();
		//DAO 호출	
		int	result = dao.donateMoney(conn, num, mno, addmoney);
			close(conn);
		return result;
	}

}
