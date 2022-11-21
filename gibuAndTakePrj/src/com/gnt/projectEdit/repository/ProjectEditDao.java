package com.gnt.projectEdit.repository;

import static com.gnt.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gnt.project.vo.CampaignVo;
import com.gnt.project.vo.DonationVo;
import com.gnt.project.vo.FundingVo;
import com.gnt.project.vo.RegistVo;

public class ProjectEditDao {

	//등록테이블 수정 (공통)
	public int registEdit(Connection conn, RegistVo rvo) {
		String sql = "UPDATE REGIST SET REG_CONTENT = ?, REG_FDATE = ?, REG_MOD = SYSDATE WHERE REG_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getContent());
			pstmt.setString(2, rvo.getfDate());
			pstmt.setInt(3, rvo.getRegNo()); 
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//기부테이블 수정
	public int donationEdit(Connection conn, DonationVo dvo, RegistVo rvo) {
		String sql = "UPDATE DONATION SET D_SDATE = ?, D_EDATE = ?, D_PERSON = ? WHERE REG_NO = ? AND D_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dvo.getExeSDate());
			pstmt.setString(2, dvo.getExeEDate());
			pstmt.setString(3, dvo.getPerson());
			pstmt.setInt(4, rvo.getRegNo());
			pstmt.setInt(5, dvo.getdNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//집행테이블 기존 데이터 삭제
	public int donationExecuteDelete(Connection conn, DonationVo dvo) {
		String sql = "DELETE FROM EXECUTE WHERE D_NO = ?";
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dvo.getdNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//집행테이블 삽입
	public int donationExecuteInsert(Connection conn, DonationVo dvo, int i) {
		String sql = "INSERT INTO Execute(E_NO , D_NO , E_CTG , E_CONTENT , E_MONEY) VALUES (SEQ_EXECUTE_E_NO.NEXTVAL, ?, ?, ?, ?)";
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dvo.getdNo());
			pstmt.setString(2, dvo.getDonaExecategory()[i]);
			pstmt.setString(3, dvo.getDonaExecontent()[i]);
			pstmt.setString(4, dvo.getMoney()[i]);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//펀딩테이블 수정
	public int fundingEdit(Connection conn, FundingVo fvo, RegistVo rvo) {
		String sql = "UPDATE FUNDING SET F_GMONEY = ? WHERE REG_NO = ? AND F_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fvo.getgMoney());
			pstmt.setInt(2, rvo.getRegNo());
			pstmt.setInt(3, fvo.getfNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//리워드테이블 기존 데이터 삭제
	public int fundingRewardDelete(Connection conn, FundingVo fvo) {
		String sql = "DELETE FROM REWARD WHERE F_NO = ?";
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, fvo.getfNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//리워드테이블 삽입
	public int fundingRewardInsert(Connection conn, FundingVo fvo, int i) {
		String sql = "INSERT INTO REWARD(REW_NO , F_NO , REW_NAME , REW_MONEY, REW_COUNT) VALUES (SEQ_REWARD_REW_NO.NEXTVAL, ?, ?, ?, ?)";
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, fvo.getfNo());
			pstmt.setString(2, fvo.getName()[i]);
			pstmt.setString(3, fvo.getMoney()[i]);
			pstmt.setString(4, fvo.getCount()[i]);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//캠페인테이블 수정
	public int campaignEdit(Connection conn, CampaignVo cvo, RegistVo rvo) {
		String sql = "UPDATE CAMPAIGN SET CAM_GPEOPLE = ? WHERE REG_NO = ? AND CAM_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getgPeople());
			pstmt.setInt(2, rvo.getRegNo());
			pstmt.setInt(3, cvo.getCamNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


}
