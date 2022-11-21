package com.gnt.projectEdit.service;

import java.sql.Connection;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.project.vo.CampaignVo;
import com.gnt.project.vo.DonationVo;
import com.gnt.project.vo.FundingVo;
import com.gnt.project.vo.RegistVo;
import com.gnt.projectEdit.repository.ProjectEditDao;

public class ProjectEditService {
	
	private final ProjectEditDao dao = new ProjectEditDao();
	
	//기부프로젝트 수정
	public int donationEdit(RegistVo rvo, DonationVo dvo) {
		int result = 0;
		int regist = 0;
		int project = 0;
		int subdelete = 0;
		int subproject = 0;
		
		Connection conn = getConnection();
		
		regist = dao.registEdit(conn, rvo);
		
		if(regist == 1) {
			project = dao.donationEdit(conn, dvo, rvo);
			
			//집행 기존 데이터 삭제
			if(project == 1) {
				subdelete = dao.donationExecuteDelete(conn, dvo);
				
				//집행테이블 삽입
				if(subdelete >= 1) {
					for(int i = 0; i < dvo.getDonaExecategory().length; i++) {
						subproject = dao.donationExecuteInsert(conn, dvo, i);
						if(subproject == 0) {break;}
					}
				}
			}
		}
		
		int num = regist + project + subproject;
		if(num == 3) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	//펀딩프로젝트 수정
	public int fundingEdit(RegistVo rvo, FundingVo fvo) {
		int result = 0;
		int regist = 0;
		int project = 0;
		int subdelete = 0;
		int subproject = 0;
		
		Connection conn = getConnection();
		
		regist = dao.registEdit(conn, rvo);
		
		if(regist == 1) {
			project = dao.fundingEdit(conn, fvo, rvo);
			
			//리워드 기존 데이터 삭제
			if(project == 1) {
				subdelete = dao.fundingRewardDelete(conn, fvo);
				
				//리워드테이블 삽입
				if(subdelete >= 1) {
					for(int i = 0; i < fvo.getName().length; i++) {
						subproject = dao.fundingRewardInsert(conn, fvo, i);
						if(subproject == 0) {break;}
					}
				}
			}
		}
		
		int num = regist + project + subproject;
		if(num == 3) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	//캠페인프로젝트 수정
	public int campaignEdit(RegistVo rvo, CampaignVo cvo) {
		int result = 0;
		int regist = 0;
		int project = 0;
		
		Connection conn = getConnection();
		
		regist = dao.registEdit(conn, rvo);
		
		if(regist == 1) {
			project = dao.campaignEdit(conn, cvo, rvo);
		}
		
		int num = regist + project;
		if(num == 2) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
