package com.gnt.breakdown.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gnt.breakdown.vo.BreakdownVo;
import com.gnt.member.vo.MemberVo;

import static com.gnt.common.JDBCTemplate.*;

public class BreakdownDao {

	public ArrayList<BreakdownVo> showList(Connection conn, MemberVo m) {
		
		PreparedStatement payPstmt = null;
		PreparedStatement corpPstmt = null;
		ResultSet payRs = null;
		ResultSet corpRs = null;
		
		ArrayList<BreakdownVo> list = new ArrayList<BreakdownVo>();
		BreakdownVo vo = null;
		
		String paySql = "SELECT M.M_ID, R.REG_NAME, D.D_CLASS, P.P_NO, P_NAME, PL_DATE, PL_MONEY FROM PAYLIST PL JOIN PAY P ON P.P_NO = PL.P_NO JOIN MEMBER M ON M.M_NO = P.M_NO JOIN REGIST R ON R.REG_NO = PL.REG_NO JOIN DONATION D ON D.REG_NO = R.REG_NO WHERE R.REG_CLASS = '기부' AND P.M_NO = ? ORDER BY P.P_NO DESC";
		String corpSql = "SELECT R.REG_NO, M.M_NO, M.M_NAME, M.M_ADD, M.M_REGNUM FROM REGIST R JOIN MEMBER M ON M.M_NO = R.M_NO JOIN PAYLIST PL ON PL.REG_NO = R.REG_NO JOIN PAY P ON P.P_NO = PL.P_NO WHERE P.P_NO = ?";
		
		try {
			
			payPstmt = conn.prepareStatement(paySql);
			payPstmt.setInt(1, m.getNo());
			
			payRs = payPstmt.executeQuery();
			
			while(payRs.next()) {
				
				String regName = payRs.getString("REG_NAME");
				String payNo = payRs.getString("P_NO");
				String payName = payRs.getString("P_NAME");
				String payMoney = payRs.getString("PL_MONEY");
				String payDate = payRs.getString("PL_DATE");
				String donaClass = payRs.getString("D_CLASS");
				
				corpPstmt = conn.prepareStatement(corpSql);
				corpPstmt.setNString(1, payNo);
				
				corpRs = corpPstmt.executeQuery();
				
				while(corpRs.next()) {
					String corpName = corpRs.getString("M_NAME");
					String corpRegNum = corpRs.getString("M_REGNUM");
					String corpAdd = corpRs.getString("M_ADD");
					
					vo = new BreakdownVo();
					vo.setMemberId(m.getId());
					vo.setMemberName(m.getName());
					vo.setRegName(regName);
					vo.setPayNo(payNo);
					vo.setPayName(payName);
					vo.setPayMoney(payMoney);
					vo.setPayDate(payDate);
					
					vo.setCorpName(corpName);
					vo.setCorpRegNum(corpRegNum);
					vo.setCorpAdd(corpAdd);
					vo.setCorpClass(donaClass);
					
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(payPstmt);
			close(corpPstmt);
			close(payRs);
			close(corpRs);
			
		}
		System.out.println(list);
		return list;
	}

	public BreakdownVo printList(Connection conn, String payNo, MemberVo m) {
		PreparedStatement payPstmt = null;
		PreparedStatement corpPstmt = null;
		ResultSet payRs = null;
		ResultSet corpRs = null;
		
		BreakdownVo vo = null;
		
		String paySql = "SELECT M.M_ID, R.REG_NAME, P.P_NO, P_NAME, PL_DATE, PL_MONEY FROM PAYLIST PL JOIN PAY P ON P.P_NO = PL.P_NO JOIN MEMBER M ON M.M_NO = P.M_NO JOIN REGIST R ON R.REG_NO = PL.REG_NO WHERE R.REG_CLASS = '기부' AND P.P_NO = ?";
		String corpSql = "SELECT R.REG_NO, M.M_NO, M.M_NAME, M.M_ADD, M.M_REGNUM FROM REGIST R JOIN MEMBER M ON M.M_NO = R.M_NO JOIN PAYLIST PL ON PL.REG_NO = R.REG_NO JOIN PAY P ON P.P_NO = PL.P_NO WHERE P.P_NO = ?";
		
		try {
			
			payPstmt = conn.prepareStatement(paySql);
			payPstmt.setString(1, payNo);
			
			payRs = payPstmt.executeQuery();
			
			if(payRs.next()) {
				
				String regName = payRs.getString("REG_NAME");
				String payName = payRs.getString("P_NAME");
				String payMoney = payRs.getString("PL_MONEY");
				String payDate = payRs.getString("PL_DATE");
				
				corpPstmt = conn.prepareStatement(corpSql);
				corpPstmt.setNString(1, payNo);
				
				corpRs = corpPstmt.executeQuery();
				
				if(corpRs.next()) {
					String corpName = corpRs.getString("M_NAME");
					String corpRegNum = corpRs.getString("M_REGNUM");
					String corpAdd = corpRs.getString("M_ADD");
					
					vo = new BreakdownVo();
					vo.setMemberId(m.getId());
					vo.setMemberName(m.getName());
					vo.setMemberRegNum(m.getRegnum());
					vo.setMemberAdd(m.getAddr());
					vo.setRegName(regName);
					vo.setPayNo(payNo);
					vo.setPayName(payName);
					vo.setPayMoney(payMoney);
					vo.setPayDate(payDate);
					
					vo.setCorpName(corpName);
					vo.setCorpRegNum(corpRegNum);
					vo.setCorpAdd(corpAdd);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(payPstmt);
			close(corpPstmt);
			close(payRs);
			close(corpRs);
		}
		System.out.println(vo);
		return vo;
	}
	
}
