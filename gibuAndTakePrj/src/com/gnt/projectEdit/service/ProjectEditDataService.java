package com.gnt.projectEdit.service;

import static com.gnt.common.JDBCTemplate.close;
import static com.gnt.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.gnt.project.vo.CampaignVo;
import com.gnt.project.vo.DonationVo;
import com.gnt.project.vo.FundingVo;
import com.gnt.projectEdit.repository.ProjectEditDataDao;

public class ProjectEditDataService {
	
	private final ProjectEditDataDao dao = new ProjectEditDataDao();
	
	//기부수정페이지 데이터
	public DonationVo getDonationEdit(int regNo, int mNo) {
		
		DonationVo resultVo = null;
		Connection conn = getConnection();
		
		//등록, 기부테이블에서 가져오기
		resultVo = dao.getDonation(conn, regNo, mNo);
		
		//집행테이블에서 가져오기
		if (resultVo != null) {
			resultVo = dao.getDonationExecute(conn, resultVo);
		}
		
		close(conn);
		
		return resultVo;
	}

	//펀딩수정페이지 데이터
	public FundingVo getFundingEdit(int regNo, int mNo) {
		
		FundingVo resultVo = null;
		Connection conn = getConnection();
		
		//등록, 펀딩테이블에서 가져오기
		resultVo = dao.getFunding(conn, regNo, mNo);
		
		//리워드테이블에서 가져오기
		if (resultVo != null) {
			resultVo = dao.getFundingReward(conn, resultVo);
		}
		
		close(conn);
		
		return resultVo;
	}

	//펀딩수정페이지 데이터
	public CampaignVo getCampaignEdit(int regNo, int mNo) {
		
		CampaignVo resultVo = null;
		Connection conn = getConnection();
		
		//등록, 캠페인테이블에서 가져오기
		resultVo = dao.getCampaign(conn, regNo, mNo);
		
		close(conn);
		
		return resultVo;
	}
}
