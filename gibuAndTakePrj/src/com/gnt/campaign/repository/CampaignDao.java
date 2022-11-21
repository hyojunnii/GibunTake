package com.gnt.campaign.repository;

import static com.gnt.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gnt.campaign.vo.CampaignProofVo;
import com.gnt.campaign.vo.CampaignVo;
import com.gnt.common.ReplyVo;
import com.gnt.funding.vo.FundingVo;
import com.gnt.gibu.vo.GibuVo;

public class CampaignDao {

	public List<CampaignVo> selectList(Connection conn) {

		// sql 준비
				String sql = "SELECT *  FROM CAMPAIGN C JOIN REGIST R ON C.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO  AND R.REG_CLASS = '캠페인' AND R.REG_FIN = 'N' ORDER BY C.CAM_NO DESC";

				PreparedStatement pstmt = null;
				List<CampaignVo> list = new ArrayList<CampaignVo>();
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {

						// 테스트
						String camno = rs.getString("CAM_NO");
						String regno = rs.getString("REG_NO");
						int camgpeople = rs.getInt("CAM_GPEOPLE");
						int camppeople = rs.getInt("CAM_PPEOPLE");
						
						String regclass = rs.getString("REG_CLASS");
						String regname = rs.getString("REG_NAME");
						String regcontent = rs.getString("REG_CONTENT");
						String regsdate = rs.getString("REG_SDATE");
						String regfdate = rs.getString("REG_FDATE");
						String regpass = rs.getString("REG_PASS");
						String regfin = rs.getString("REG_FIN");
						String regdel = rs.getString("REG_DEL");
						String regmod = rs.getString("REG_MOD");
						int regcnt = rs.getInt("REG_CNT");
						String mno = rs.getString("M_NO");
						String mnick = rs.getString("M_NICK");
						String imgsrc = rs.getString("URL");
						double per = (double) camppeople / (double) camgpeople * 100;
						// 수정완료 퍼센트 구하기
						String moneyper = null;
						if(camppeople == 0) {
							moneyper = "0";
						}else {
							moneyper = String.format("%.1f", per);
						}
						

						CampaignVo vo = new CampaignVo();

						vo.setCamno(camno);
						vo.setRegno(regno);
						vo.setCamgpeople(camgpeople);
						vo.setCamppeople(camppeople);
					
						vo.setRegclass(regclass);
						vo.setRegname(regname);
						vo.setRegcontent(regcontent);
						vo.setRegsdate(regsdate);
						vo.setRegfdate(regfdate);
						vo.setRegpass(regpass);
						vo.setRegfin(regfin);
						vo.setRegdel(regdel);
						vo.setRegmod(regmod);
						vo.setRegcnt(regcnt);
						vo.setMno(mno);
						vo.setMnick(mnick);
						vo.setImgsrc(imgsrc);
						vo.setMoneypercent(moneyper);
						list.add(vo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rs);
				}
				return list;
		
		
		
		
		
	}

	public int getListCount(Connection conn) {
		int listcount = 0;
		// sql 준비
		String sql = "SELECT COUNT(*) FROM CAMPAIGN C JOIN REGIST R ON C.REG_NO = R.REG_NO AND R.REG_FIN = 'N'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listcount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listcount;
	}

	public List<CampaignVo> selectbanner(Connection conn) {

		// sql 준비
		String sql = "SELECT *  FROM CAMPAIGN C JOIN REGIST R ON C.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO  AND R.REG_CLASS = '캠페인' AND R.REG_FIN = 'N' AND ROWNUM<=5 ORDER BY REG_CNT DESC";

		PreparedStatement pstmt = null;
		List<CampaignVo> list = new ArrayList<CampaignVo>();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				// 테스트
				String camno = rs.getString("CAM_NO");
				String regno = rs.getString("REG_NO");
				int camgpeople = rs.getInt("CAM_GPEOPLE");
				int camppeople = rs.getInt("CAM_PPEOPLE");
				
				String regclass = rs.getString("REG_CLASS");
				String regname = rs.getString("REG_NAME");
				String regcontent = rs.getString("REG_CONTENT");
				String regsdate = rs.getString("REG_SDATE");
				String regfdate = rs.getString("REG_FDATE");
				String regpass = rs.getString("REG_PASS");
				String regfin = rs.getString("REG_FIN");
				String regdel = rs.getString("REG_DEL");
				String regmod = rs.getString("REG_MOD");
				int regcnt = rs.getInt("REG_CNT");
				String mno = rs.getString("M_NO");
				String mnick = rs.getString("M_NICK");
				String imgsrc = rs.getString("URL");
				double per = (double) camppeople / (double) camgpeople * 100;
				// 수정완료 퍼센트 구하기
				String moneyper = null;
				if(camppeople == 0) {
					moneyper = "0";
				}else {
					moneyper = String.format("%.1f", per);
				}
				

				CampaignVo vo = new CampaignVo();

				vo.setCamno(camno);
				vo.setRegno(regno);
				vo.setCamgpeople(camgpeople);
				vo.setCamppeople(camppeople);
			
				vo.setRegclass(regclass);
				vo.setRegname(regname);
				vo.setRegcontent(regcontent);
				vo.setRegsdate(regsdate);
				vo.setRegfdate(regfdate);
				vo.setRegpass(regpass);
				vo.setRegfin(regfin);
				vo.setRegdel(regdel);
				vo.setRegmod(regmod);
				vo.setRegcnt(regcnt);
				vo.setMno(mno);
				vo.setMnick(mnick);
				vo.setImgsrc(imgsrc);
				vo.setMoneypercent(moneyper);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public CampaignVo selectDetail(Connection conn, int num) {
		// sql 준비
				String sql = "SELECT *  FROM CAMPAIGN C JOIN REGIST R ON C.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO JOIN REWARD REW ON C.CAM_NO = REW.F_NO AND R.REG_CLASS = '캠페인' AND R.REG_NO = ?";
				
				PreparedStatement pstmt = null;
				CampaignVo vo = new CampaignVo();
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, num);
					rs = pstmt.executeQuery();
					while (rs.next()) {

						// 테스트
						String camno = rs.getString("CAM_NO");	//캠페인번호
						String regno = rs.getString("REG_NO");	//등록번호
						int camgpeople = rs.getInt("CAM_GPEOPLE");	//목표인원수
						int camppeople = rs.getInt("CAM_PPEOPLE");	//참여인원수
						
						String regclass = rs.getString("REG_CLASS");
						String regname = rs.getString("REG_NAME");
						String regcontent = rs.getString("REG_CONTENT");
						String regsdate = rs.getString("REG_SDATE");
						String regfdate = rs.getString("REG_FDATE");
						String regpass = rs.getString("REG_PASS");
						String regfin = rs.getString("REG_FIN");
						String regdel = rs.getString("REG_DEL");
						String regmod = rs.getString("REG_MOD");
						int regcnt = rs.getInt("REG_CNT");
						String mno = rs.getString("M_NO");
						String mnick = rs.getString("M_NICK");
						String imgsrc = rs.getString("URL");
						double per = (double) camppeople / (double) camgpeople * 100;
						// 수정완료 퍼센트 구하기
						String moneyper = String.format("%.1f", per);
						
						int rewno =rs.getInt("REW_NO");
						String rewname =rs.getString("REW_NAME");
						int rewmoney =rs.getInt("REW_MONEY");
						int rewcnt =rs.getInt("REW_COUNT");
						
						vo = new CampaignVo();
						vo.setCamno(camno);
						vo.setRegno(regno);
						vo.setCamgpeople(camgpeople);
						vo.setCamppeople(camppeople);
						
						vo.setRegclass(regclass);
						vo.setRegname(regname);
						vo.setRegcontent(regcontent);
						vo.setRegsdate(regsdate);
						vo.setRegfdate(regfdate);
						vo.setRegpass(regpass);
						vo.setRegfin(regfin);
						vo.setRegdel(regdel);
						vo.setRegmod(regmod);
						vo.setRegcnt(regcnt);
						vo.setMno(mno);
						vo.setMnick(mnick);
						vo.setImgsrc(imgsrc);
						vo.setMoneypercent(moneyper);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rs);
				}
				return vo;
	}

	public List<CampaignProofVo> selectProof(Connection conn, int num) {
		// sql 준비
		String sql = "SELECT * FROM  CAMPAIGNPROOF CP JOIN MEMBER M ON CP.M_NO = M.M_NO JOIN CAMPAIGN C ON CP.CAM_NO = C.CAM_NO JOIN PROOFIMG PF ON CP.CP_NO = PF.CP_NO WHERE C.REG_NO = ? AND CP.CP_DEL = 'N' ORDER BY CP.CP_NO DESC";
		String paraclass = "";			

		PreparedStatement pstmt = null;
		List<CampaignProofVo> volist = new ArrayList<CampaignProofVo>();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
//			if(type!=0) {
//				pstmt.setString(2, paraclass);
//			}
			rs = pstmt.executeQuery();
			while (rs.next()) {

				// 테스트
				String cpno = rs.getString("CP_NO");		//행동번호
				String mno = rs.getString("M_NO");			//사용자번호
				String camno = rs.getString("CAM_NO");		//캠페인번호
				String cpcontent = rs.getString("CP_CONTENT");	//댓글내용
				String cpdate = rs.getString("CP_DATE");		//작성일
				String cpdel = rs.getString("CP_DEL");		//삭제여부
				String cpban = rs.getString("CP_BAN");		//신고여부
				String cpmod = rs.getString("CP_MOD");		//마지막수정일자
				String mnick = rs.getString("M_NICK");		//닉네임
				String imgsrc = rs.getString("URL");		//사진주소
				String regno = rs.getString("REG_NO");		//등록번호
				
				CampaignProofVo vo = new CampaignProofVo();
				vo.setCpno(cpno);
				vo.setMno(mno);
				vo.setCamno(camno);
				vo.setCpcontent(cpcontent);
				vo.setCpdate(cpdate);
				vo.setCpdel(cpdel);
				vo.setCpban(cpban);
				vo.setCpmod(cpmod);
				vo.setMnick(mnick);;
				vo.setImgsrc(imgsrc);
				vo.setRegno(regno);

				volist.add(vo);
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return volist;
	}

}
