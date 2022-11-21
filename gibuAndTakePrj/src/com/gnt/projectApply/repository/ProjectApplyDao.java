package com.gnt.projectApply.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.project.vo.CampaignVo;
import com.gnt.project.vo.DonationVo;
import com.gnt.project.vo.FundingVo;
import com.gnt.project.vo.RegistVo;

public class ProjectApplyDao {

	//등록테이블에 삽입 (공통)
	public int registApply(Connection conn, RegistVo rvo) {
		String sql = "INSERT INTO Regist(REG_NO , M_NO , REG_CLASS , REG_NAME , REG_CONTENT , REG_FDATE) VALUES (SEQ_REGIST_REG_NO.NEXTVAL, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getmNo()); 
			pstmt.setString(2, rvo.getCategory()); 
			pstmt.setString(3, rvo.getTitle()); 
			pstmt.setString(4, rvo.getContent());
			pstmt.setString(5, rvo.getfDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//등록이미지 삽입 (공통)
	public int imageApply(Connection conn, String savePath) {
		String sql = "INSERT INTO RegImg(RI_NO, REG_NO, URL) VALUES(SEQ_REGIMG_RI_NO.NEXTVAL, SEQ_REGIST_REG_NO.CURRVAL, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, savePath); 
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//기부테이블에 삽입
	public int donationApply(Connection conn, DonationVo dvo) {
		String sql = "INSERT INTO Donation(D_NO , REG_NO , D_CLASS , D_GMONEY , D_SDATE , D_EDATE , D_PERSON) VALUES (SEQ_DONATION_D_NO.NEXTVAL, SEQ_REGIST_REG_NO.CURRVAL, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dvo.getDonaCategory());
			pstmt.setString(2, dvo.getgMoney());
			pstmt.setString(3, dvo.getExeSDate());
			pstmt.setString(4, dvo.getExeEDate());
			pstmt.setString(5, dvo.getPerson());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//사업집행테이블에 삽입
	public int donationExecuteApply(Connection conn, DonationVo dvo, int i) {
	
		String sql = "INSERT INTO Execute(E_NO , D_NO , E_CTG , E_CONTENT , E_MONEY) VALUES (SEQ_EXECUTE_E_NO.NEXTVAL, SEQ_DONATION_D_NO.CURRVAL, ?, ?, ?)";
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dvo.getDonaExecategory()[i]);
			pstmt.setString(2, dvo.getDonaExecontent()[i]);
			pstmt.setString(3, dvo.getMoney()[i]);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//펀딩테이블에 삽입
	public int fundingApply(Connection conn, FundingVo fvo) {
		
		String sql = "INSERT INTO Funding(F_NO , REG_NO , F_CLASS , F_GMONEY) VALUES (SEQ_FUNDING_F_NO.NEXTVAL, SEQ_REGIST_REG_NO.CURRVAL, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fvo.getFundCategory());
			pstmt.setString(2, fvo.getgMoney());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//펀딩리워드테이블에 삽입
	public int fundingRewardApply(Connection conn, FundingVo fvo, int i) {
		
		String sql = "INSERT INTO Reward(REW_NO , F_NO , REW_NAME , REW_MONEY , REW_COUNT) VALUES (SEQ_REWARD_REW_NO.NEXTVAL, SEQ_FUNDING_F_NO.CURRVAL, ?, ?, ?)";
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fvo.getName()[i]);
			pstmt.setString(2, fvo.getMoney()[i]);
			pstmt.setString(3, fvo.getCount()[i]);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//캠페인테이블에 삽입
	public int campaignApply(Connection conn, CampaignVo cvo) {
		
		String sql = "INSERT INTO Campaign (CAM_NO , REG_NO , CAM_GPEOPLE) VALUES (SEQ_CAMPAIGN_CAM_NO.NEXTVAL, SEQ_REGIST_REG_NO.CURRVAL, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getgPeople());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
