package com.gnt.stmt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.corp.vo.corpVo;
import com.gnt.member.vo.MemberVo;
import com.gnt.stmt.vo.ExeVo;
import com.gnt.stmt.vo.StmtVo;

public class StmtDao {

	//처음에 기부 명세서 리스트에서 기부 가져오기
	public ArrayList<StmtVo> showList(Connection conn, corpVo loginCorp) {
		
		String sql = "SELECT D.REG_NO, D_NO, REG_NAME, D_CLASS, D_GMONEY, D_PMONEY, D_SDATE, D_EDATE, D_PERSON FROM DONATION D JOIN REGIST R ON R.REG_NO = D.REG_NO JOIN MEMBER M ON M.M_NO = R.M_NO WHERE R.M_NO = 2 ORDER BY D_NO ASC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StmtVo> list = new ArrayList<StmtVo>();
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, loginCorp.getNo());

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String regNo = rs.getString("REG_NO");
				String donaNo = rs.getString("D_NO");
				String regName = rs.getString("REG_NAME");
				String donaClass = rs.getString("D_CLASS");
				String donaGmoney = rs.getString("D_GMONEY");
				String donaPmoney = rs.getString("D_PMONEY");
				String donaSdate = rs.getString("D_SDATE");
				String donaEdate = rs.getString("D_EDATE");
				String donaPerson = rs.getString("D_PERSON");
				
				StmtVo vo = new StmtVo();
				vo.setMemberNo(loginCorp.getNo());
				vo.setRegNo(regNo);
				vo.setDonaNo(donaNo);
				vo.setRegName(regName);
				vo.setDonaClass(donaClass);
				vo.setDonaGmoney(donaGmoney);
				vo.setDonaPmoney(donaPmoney);
				vo.setDonaSdate(donaSdate);
				vo.setDonaEdate(donaEdate);
				vo.setDonaPerson(donaPerson);

				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		System.out.println("기부 list ::: " + list);
		
		return list;
	}

	public StmtVo showStmt(Connection conn, String donaNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StmtVo vo = null;
		
		String sql = "SELECT D.REG_NO, D_NO, REG_NAME, D_CLASS, D_GMONEY, D_PMONEY, D_SDATE, D_EDATE, D_PERSON FROM DONATION D JOIN REGIST R ON R.REG_NO = D.REG_NO JOIN MEMBER M ON M.M_NO = R.M_NO WHERE D_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, donaNo);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String regName = rs.getString("REG_NAME");
				String donaClass = rs.getString("D_CLASS");
				String donaGmoney = rs.getString("D_GMONEY");
				String donaPmoney = rs.getString("D_PMONEY");
				String donaSdate = rs.getString("D_SDATE");
				String donaEdate = rs.getString("D_EDATE");
				String donaPerson = rs.getString("D_PERSON");
				
				vo = new StmtVo();
				vo.setDonaNo(donaNo);
				vo.setRegName(regName);
				vo.setDonaClass(donaClass);
				vo.setDonaGmoney(donaGmoney);
				vo.setDonaPmoney(donaPmoney);
				vo.setDonaSdate(donaSdate);
				vo.setDonaEdate(donaEdate);
				vo.setDonaPerson(donaPerson);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}
	
	//사업 내용 출력
	public ArrayList<ExeVo> showExe(Connection conn, String donaNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ExeVo> list = new ArrayList<ExeVo>();

		String sql = "SELECT E_NO, E_CTG, E_CONTENT, E_MONEY FROM EXECUTE E JOIN DONATION D ON D.D_NO = E.D_NO JOIN REGIST R ON R.REG_NO = D.REG_NO JOIN MEMBER M ON M.M_NO = R.M_NO WHERE D.D_NO = ? ORDER BY E_NO ASC";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, donaNo);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String exeNo = rs.getString("E_NO");
				String exeCtg = rs.getString("E_CTG");
				String exeCnt = rs.getString("E_CONTENT");
				String exeMoney = rs.getString("E_MONEY");
				
				ExeVo vo = new ExeVo();
				vo.setDonaNo(donaNo);
				vo.setExeNo(exeNo);
				vo.setExeCtg(exeCtg);
				vo.setExeCnt(exeCnt);
				vo.setExeMoney(exeMoney);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int insert(ExeVo vo, corpVo c, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO EXECUTE ( E_NO, D_NO, E_CTG, E_CONTENT, E_MONEY ) VALUES ( SEQ_EXECUTE_E_NO.NEXTVAL, ?, ?, ?, ? )";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(vo.getDonaNo()));
			pstmt.setString(2, vo.getExeCtg());
			pstmt.setString(3, vo.getExeCnt());
			pstmt.setString(4, vo.getExeMoney());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ExeVo> showExeTest(Connection conn, ArrayList<StmtVo> donaResult) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ExeVo> testList = new ArrayList<ExeVo>();

		String sql = "SELECT E_NO, E_CTG, E_CONTENT, E_MONEY FROM EXECUTE E JOIN DONATION D ON D.D_NO = E.D_NO JOIN REGIST R ON R.REG_NO = D.REG_NO JOIN MEMBER M ON M.M_NO = R.M_NO WHERE D.D_NO = ? ORDER BY E_NO ASC";
		try {
			for(int i = 0 ; i < donaResult.size(); ++i) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, donaResult.get(i).getDonaNo());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					String exeNo = rs.getString("E_NO");
					String exeCtg = rs.getString("E_CTG");
					String exeCnt = rs.getString("E_CONTENT");
					String exeMoney = rs.getString("E_MONEY");

					ExeVo vo = new ExeVo();
					vo.setDonaNo(donaResult.get(i).getDonaNo());
					vo.setExeNo(exeNo);
					vo.setExeCtg(exeCtg);
					vo.setExeCnt(exeCnt);
					vo.setExeMoney(exeMoney);
					
					testList.add(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			close(rs);
			close(pstmt);
		}
		return testList;
	}

}
