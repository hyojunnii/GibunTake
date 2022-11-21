package com.gnt.funding.service;

import static com.gnt.common.JDBCTemplate.close;
import static com.gnt.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gnt.common.ReplyVo;
import com.gnt.funding.repository.FundingDao;
import com.gnt.funding.vo.FundingVo;
import com.gnt.gibu.vo.GibuVo;


public class FundingService {

	private final FundingDao dao = new FundingDao();
	
	public List<FundingVo> selectList(int type) {
		
		Connection conn = null;
		List<FundingVo> voList = null;
		
		conn = getConnection();
		//DAO 호출	
			voList = dao.selectList(conn, type);
			close(conn);
		return voList;
	}

	public int getListCount(int type) {
		Connection conn = null;
		int result = 0;
		conn = getConnection();
		//DAO 호출
			result = dao.getListCount(conn, type);
			close(conn);
		return result;
	}

	public List<FundingVo> selectDoneList(int type) {
		Connection conn = null;
		List<FundingVo> voList = null;
		
		conn = getConnection();
		//DAO 호출	
			voList = dao.selectDoneList(conn, type);
			close(conn);
		return voList;
	}

	public int getListDoneCount(int type) {
		Connection conn = null;
		int result = 0;
		conn = getConnection();
		//DAO 호출
			result = dao.getListDoneCount(conn, type);
			close(conn);
		return result;
	}

	public FundingVo selectDetail(int type, int num) {
		Connection conn = null;
		FundingVo vo = null;

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

	public int insertReply(FundingVo vo) {
		Connection conn = null;
		int result = 0;
		conn = getConnection();
		//DAO 호출	
			result = dao.insertReply(conn, vo);
			close(conn);
		return result;
	}

	public int FundingReplyDel(String num) {
		Connection conn = null;
		int result = 0;
		
		conn = getConnection();
		//DAO 호출	
			result = dao.FundingReplyDel(conn, num);
			close(conn);
		return result;
	}

	public FundingVo selectDetail(int num) {
		Connection conn = null;
		FundingVo vo = null;
		conn = getConnection();
		//DAO 호출	
			vo = dao.selectDetail(conn, num);
			close(conn);
		return vo;
	}

	public int rewardMoney(int num, int mno, int addmoney) {
		Connection conn = null;

		conn = getConnection();
		//DAO 호출	
		int	result = dao.rewardMoney(conn, num, mno, addmoney);
		close(conn);
	return result;
	}

	

}
