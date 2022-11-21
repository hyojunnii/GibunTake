package com.gnt.campaignproof.service;

import com.gnt.campaignproof.repository.CampaignProofDao;
import com.gnt.campaignproof.vo.CampaignProofVo;
import static com.gnt.common.JDBCTemplate.*;

import java.sql.Connection;

public class CampaignProofService {
	
	private final CampaignProofDao dao = new CampaignProofDao();

	//캠페인 인증
	public int insertProof(CampaignProofVo proofVo, String changeName) {
		if(changeName.length() < 1) {
			System.out.println("사진 입력 안함");
			return -3;
		}
		
		int result = 0;
		int proof = 0;
		int proofImg = 0;
		
		Connection conn = getConnection();
		
		proof = dao.insertProof(conn, proofVo);
		
		if(proof == 1) {
			proofImg = dao.insertProofImg(conn, proofVo, changeName);
		}
		
		if(proofImg == 1) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	//캠페인 인증 삭제
	public int proofDelete(int cpNo) {
		Connection conn = getConnection();
		int result = 0;
		
		result = dao.proofDelete(conn, cpNo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	//캠페인 인증 신고
	public int proofBan(int cpNo) {
		Connection conn = getConnection();
		int result = 0;
		
		result = dao.proofBan(conn, cpNo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
