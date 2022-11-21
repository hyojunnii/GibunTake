package com.gnt.projectEdit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.project.vo.CampaignVo;
import com.gnt.project.vo.DonationVo;
import com.gnt.project.vo.FundingVo;

public class ProjectEditDataDao {

	//기부 수정페이지 데이터
	//등록, 기부테이블
	public DonationVo getDonation(Connection conn, int regNo, int mNo) {
		//나중에 PASS = 'Y'
		String sql = "SELECT R.REG_NO REGNO , R.REG_NAME TITLE , R.REG_CONTENT CONTENT , R.REG_FDATE FDATE , D.D_NO DNO , D.D_CLASS CATEGORY , D.D_GMONEY GMONEY , D.D_SDATE SDATE , D.D_EDATE EDATE , D.D_PERSON PERSON FROM REGIST R JOIN DONATION D ON R.REG_NO = D.REG_NO WHERE R.REG_NO = ? AND R.M_NO = ? AND R.REG_CLASS = '기부' AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DonationVo resultVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, regNo);
			pstmt.setInt(2, mNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String fDate = rs.getString("FDATE");
				String sDate = rs.getString("SDATE");
				String eDate = rs.getString("EDATE");
				fDate = fDate.substring(0, 10);
				sDate = sDate.substring(0, 10);
				eDate = eDate.substring(0, 10);
				
				resultVo = new DonationVo();
				resultVo.setRegNo(rs.getInt("REGNO"));
				resultVo.setTitle(rs.getString("TITLE"));
				resultVo.setContent(rs.getString("CONTENT"));
				resultVo.setfDate(fDate);
				resultVo.setdNo(rs.getInt("DNO"));
				resultVo.setDonaCategory(rs.getString("CATEGORY"));
				resultVo.setgMoney(rs.getString("GMONEY"));
				resultVo.setExeSDate(sDate);
				resultVo.setExeEDate(eDate);
				resultVo.setPerson(rs.getString("PERSON"));
			}
			
		} catch (SQLException e) {
			System.out.println("등록,기부테이블 가져오기 실패");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return resultVo;
	}
	
	//집행테이블
	public DonationVo getDonationExecute(Connection conn, DonationVo resultVo) {
		String sql = "SELECT E_NO, E_CTG, E_CONTENT, E_MONEY FROM EXECUTE WHERE D_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resultVo.getdNo());
			
			rs = pstmt.executeQuery();
			
			List<String> ecategory = new ArrayList<>();
			List<String> eContent = new ArrayList<>();
			List<String> eMoney = new ArrayList<>();
			
			while(rs.next()) {
				String category = rs.getString("E_CTG");
				String content = rs.getString("E_CONTENT");
				String money = rs.getString("E_MONEY");
				
				ecategory.add(category);
				eContent.add(content);
				eMoney.add(money);
			}
			
			if(!ecategory.isEmpty()) {
				String[] execategory = ecategory.toArray(new String[0]);
				String[] exeContent = eContent.toArray(new String[0]);
				String[] exeMoney = eMoney.toArray(new String[0]);
				
				resultVo.setDonaExecategory(execategory);
				resultVo.setDonaExecontent(exeContent);
				resultVo.setMoney(exeMoney);
			} else {
				resultVo = null;
			}
			
		} catch (SQLException e) {
			System.out.println("집행테이블 가져오기 실패");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return resultVo;
	}

	//펀딩 수정페이지 데이터
	//등록, 펀딩테이블
	public FundingVo getFunding(Connection conn, int regNo, int mNo) {
		//나중에 PASS = 'Y'
		String sql = "SELECT R.REG_NO REGNO , R.REG_NAME TITLE , R.REG_CONTENT CONTENT , R.REG_FDATE FDATE , F.F_NO FNO , F.F_CLASS CATEGORY , F.F_GMONEY GMONEY FROM REGIST R JOIN FUNDING F ON R.REG_NO = F.REG_NO WHERE R.REG_NO = ? AND R.M_NO = ? AND R.REG_CLASS = '펀딩' AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FundingVo resultVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, regNo);
			pstmt.setInt(2, mNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String fDate = rs.getString("FDATE");
				fDate = fDate.substring(0, 10);
				
				resultVo = new FundingVo();
				resultVo.setRegNo(rs.getInt("REGNO"));
				resultVo.setTitle(rs.getString("TITLE"));
				resultVo.setContent(rs.getString("CONTENT"));
				resultVo.setfDate(fDate);
				resultVo.setfNo(rs.getInt("FNO"));
				resultVo.setFundCategory(rs.getString("CATEGORY"));
				resultVo.setgMoney(rs.getString("GMONEY"));
			}
		} catch (SQLException e) {
			System.out.println("등록,펀딩테이블 가져오기 실패");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return resultVo;
	}

	//리워드테이블
	public FundingVo getFundingReward(Connection conn, FundingVo resultVo) {
		String sql = "SELECT REW_NO, REW_NAME, REW_MONEY, REW_COUNT FROM REWARD WHERE F_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resultVo.getfNo());
			
			rs = pstmt.executeQuery();
			
			List<String> rname = new ArrayList<>();
			List<String> rmoney = new ArrayList<>();
			List<String> rcount = new ArrayList<>();
			
			while(rs.next()) {
				String name = rs.getString("REW_NAME");
				String money = rs.getString("REW_MONEY");
				String count = rs.getString("REW_COUNT");
				
				rname.add(name);
				rmoney.add(money);
				rcount.add(count);
			}
			
			if(!rname.isEmpty()) {
				String[] rewName = rname.toArray(new String[0]);
				String[] rewMoney = rmoney.toArray(new String[0]);
				String[] rewCount = rcount.toArray(new String[0]);
				
				resultVo.setName(rewName);
				resultVo.setMoney(rewMoney);
				resultVo.setCount(rewCount);
			} else {
				resultVo = null;
			}
		} catch (SQLException e) {
			System.out.println("리워드 테이블 가져오기 실패");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return resultVo;
	}

	//캠페인 수정페이지 데이터
	//등록, 캠페인테이블
	public CampaignVo getCampaign(Connection conn, int regNo, int mNo) {
		//나중에 PASS = 'Y'
			String sql = "SELECT R.REG_NO REGNO , R.REG_NAME TITLE , R.REG_CONTENT CONTENT , R.REG_FDATE FDATE , C.CAM_NO CAMNO , C.CAM_GPEOPLE GPEOPLE FROM REGIST R JOIN CAMPAIGN C ON R.REG_NO = C.REG_NO WHERE R.REG_NO = ? AND R.M_NO = ? AND R.REG_CLASS = '캠페인' AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y'";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			CampaignVo resultVo = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, regNo);
				pstmt.setInt(2, mNo);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String fDate = rs.getString("FDATE");
					fDate = fDate.substring(0, 10);
					
					resultVo = new CampaignVo();
					resultVo.setRegNo(rs.getInt("REGNO"));
					resultVo.setTitle(rs.getString("TITLE"));
					resultVo.setContent(rs.getString("CONTENT"));
					resultVo.setfDate(fDate);
					resultVo.setCamNo(rs.getInt("CAMNO"));
					resultVo.setgPeople(rs.getString("GPEOPLE"));
				}
			} catch (SQLException e) {
				System.out.println("등록, 캠페인테이블 가져오기 실패");
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			return resultVo;
	}

}
