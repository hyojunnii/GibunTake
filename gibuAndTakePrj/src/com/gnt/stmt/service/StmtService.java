package com.gnt.stmt.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.corp.vo.corpVo;
import com.gnt.member.vo.MemberVo;
import com.gnt.stmt.repository.StmtDao;
import com.gnt.stmt.vo.ExeVo;
import com.gnt.stmt.vo.StmtVo;

//import com.gnt.corpStmt.controller.StmtVo;


public class StmtService {
	
	private final StmtDao dao = new StmtDao();

	public ArrayList<StmtVo> showDona(corpVo loginCorp) {
		Connection conn = null;
		ArrayList<StmtVo> voList = null;
	
		conn = getConnection();
		voList = new StmtDao().showList(conn, loginCorp); 
		
		return voList;
	}

	public ArrayList<ExeVo> showExe(String donaNo) {
		Connection conn = null;
		ArrayList<ExeVo> exeList = null;
		
		try {
			conn = getConnection();
			exeList = new StmtDao().showExe(conn, donaNo); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
				
		return exeList;
	}

	public StmtVo showReDona(String donaNo) {
		
		Connection conn = null;
		StmtVo vo = null;
		
		try {
			conn = getConnection();
			vo = new StmtDao().showStmt(conn, donaNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return vo;
	}
	
	public int insert(ExeVo vo, corpVo c) {
		if(vo.getExeCnt() == null || vo.getExeMoney() == null) {
			System.out.println("데이터를 채워주세요.");
			return -1;
		}
		
		Connection conn = null;
		int result = 0;
		ExeVo insertVo = null;
		
		try {
			conn = getConnection();
			result = new StmtDao().insert(vo, c, conn);
			
			if(result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(conn);
		}
		return result;
	}

	public ArrayList<ExeVo> showExeTest(ArrayList<StmtVo> donaResult) {

		Connection conn = null;
		ArrayList<ExeVo> testList = null;
		
		try {
			conn = getConnection();
			testList = new StmtDao().showExeTest(conn, donaResult);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return testList;
	}
}
