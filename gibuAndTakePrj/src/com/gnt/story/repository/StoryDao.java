package com.gnt.story.repository;

import static com.gnt.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gnt.review.vo.ReviewVo;
import com.gnt.story.vo.StoryVo;

public class StoryDao {

	public StoryVo returnTotal(Connection conn, StoryVo result) {
			
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//sql객체에 담기 및 완성
			String sql = "SELECT (SELECT SUM(D_PPEOPLE) FROM DONATION) DONATIONCNT, (SELECT SUM(D_PMONEY) FROM DONATION) DONATIONMONEY, (SELECT SUM(F_PPEOPLE) FROM FUNDING) FUNDINGCNT, (SELECT SUM(F_PMONEY) FROM FUNDING) FUNDINGMONEY, (SELECT SUM(CAM_PPEOPLE) FROM CAMPAIGN) CAMPAIGNCNT FROM DUAL";
			pstmt = conn.prepareStatement(sql);
			
			//sql실행
			rs = pstmt.executeQuery();
			//결과반환//resultSet->자바객체(NoticeVo)
			if(rs.next()) {
				
				
				result.setTotalDonateMoney(rs.getString("DONATIONMONEY"));
				result.setTotalDonateCnt(rs.getString("DONATIONCNT"));
				result.setTotalFundingMoney(rs.getString("FUNDINGMONEY"));
				result.setTotalFundingCnt(rs.getString("FUNDINGCNT"));
				result.setTotalCampaignCnt(rs.getString("CAMPAIGNCNT"));
				
				int donationMoney = Integer.parseInt(rs.getString("DONATIONMONEY"));
				int fundingMoney = Integer.parseInt(rs.getString("FUNDINGMONEY"));
				result.setTotalMoney(Integer.toString(donationMoney+fundingMoney));
				
				int donationCnt = Integer.parseInt(rs.getString("DONATIONCNT"));
				int fundingCnt = Integer.parseInt(rs.getString("FUNDINGCNT"));
				int campaignCnt = Integer.parseInt(rs.getString("CAMPAIGNCNT"));
				result.setTotalCnt(Integer.toString(donationCnt+fundingCnt+campaignCnt));
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return result;
		
	}

	public List<ReviewVo> selectList(Connection conn) {
List<ReviewVo> result = new ArrayList<ReviewVo>();
		
		String sql = "SELECT * FROM (SELECT ROWNUM ROWNO, T.* FROM (SELECT REV.REV_NO, REV.M_NO, M.M_NICK M_NICK, REV.REV_NAME, REV.REV_CONTENT, REV.REV_CLASS, REV.REV_MOD, REV.REV_CNT FROM REVIEW REV JOIN MEMBER M ON REV.M_NO = M.M_NO WHERE REV.REV_CLASS = ? ORDER BY REV.REV_NO DESC) T) WHERE ROWNO BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//sql객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 1);
			pstmt.setInt(3, 3);
			
			
			//sql실행
			rs = pstmt.executeQuery();
			//결과반환//resultSet->자바객체(NoticeVo)
			while(rs.next()) {
				ReviewVo vo = new ReviewVo();
				
				String no = rs.getString("REV_NO");
				String mNo = rs.getString("M_NICK");
				String revName = rs.getString("REV_NAME");
				String revContent = rs.getString("REV_CONTENT");
				String revClass = rs.getString("REV_CLASS");
				String revMod = rs.getString("REV_MOD");
				String revCnt = rs.getString("REV_CNT");
				String revImg = selectImg(conn, vo);
				
				
				vo.setRevNo(no);
				vo.setmNo(mNo);
				vo.setRevName(revName);
				vo.setRevContent(revContent);
				vo.setRevClass(revClass);
				vo.setRevMod(revMod);
				vo.setRevCnt(revCnt);
				vo.setRevImg(revImg);
				
				
				result.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}
	
	public String selectImg(Connection conn, ReviewVo vo) {
		String result = null;
		
		String sql = "SELECT RVI_NO, REV_NO, URL FROM REVIMG WHERE REV_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//sql객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRevNo());
			
			//sql실행
			rs = pstmt.executeQuery();
			//결과반환//resultSet->자바객체(NoticeVo)
			if(rs.next()) {
				result = rs.getString("URL");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return result;
	}



}
