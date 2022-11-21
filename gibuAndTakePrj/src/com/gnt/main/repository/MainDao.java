package com.gnt.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import com.gnt.common.JDBCTemplate;
import com.gnt.main.vo.TodayStoryVo;

public class MainDao {
	
	private final DecimalFormat dc = new DecimalFormat("###,###,###,###");

	//오늘의 참여현황 - 기부
	public TodayStoryVo todayDonationStory(Connection conn, String today) {
		
		String sql = "SELECT COUNT(*) AS DPEOPLE, SUM(PL_MONEY) AS DMONEY FROM PAYLIST P JOIN REGIST R ON P.REG_NO = R.REG_NO WHERE P.PL_DATE LIKE ? || '%' AND R.REG_CLASS = '기부'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TodayStoryVo todayVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, today);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				double people = rs.getDouble("DPEOPLE");
				double money = rs.getDouble("DMONEY");
				
				String dPeople = dc.format(people);
				String dMoney = dc.format(money);
				
				todayVo = new TodayStoryVo();
				todayVo.setdPeople(dPeople);
				todayVo.setdMoney(dMoney);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return todayVo;
	}
	
	//오늘의 참여현황 - 펀딩
	public TodayStoryVo todayFundingStory(Connection conn, String today, TodayStoryVo todayVo) {
		
		String sql = "SELECT COUNT(*) AS FPEOPLE, SUM(PL_MONEY) AS FMONEY FROM PAYLIST P JOIN REGIST R ON P.REG_NO = R.REG_NO WHERE P.PL_DATE LIKE ? || '%' AND R.REG_CLASS = '펀딩'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, today);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				double people = rs.getDouble("FPEOPLE");
				double money = rs.getDouble("FMONEY");
				
				String fPeople = dc.format(people);
				String fMoney = dc.format(money);
				
				todayVo.setfPeople(fPeople);
				todayVo.setfMoney(fMoney);
			} else {
				todayVo = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return todayVo;
	}

}
