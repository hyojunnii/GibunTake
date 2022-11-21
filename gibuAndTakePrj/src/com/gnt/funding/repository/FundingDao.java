package com.gnt.funding.repository;

import static com.gnt.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gnt.common.ReplyVo;
import com.gnt.funding.vo.FundingVo;
import com.gnt.gibu.vo.GibuVo;

public class FundingDao {

	public List<FundingVo> selectList(Connection conn, int type) {

		// sql 준비
		String sql = "SELECT *  FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO  AND R.REG_CLASS = '펀딩' AND R.REG_FIN = 'N' ORDER BY F.F_NO DESC";
		String paraclass = "";
		if(type!=0) {
				sql = "SELECT *  FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO  AND R.REG_CLASS = '펀딩' AND R.REG_FIN = 'N' AND F.F_CLASS = ? ORDER BY F.F_NO DESC";	
		}
		
		if (type==1) {
			paraclass = "일자리창출"; 
		}else if(type==2) {
			paraclass = "공정무역"; 
		}else if(type==3) {
			paraclass = "친환경"; 
		}else if(type==4) {
			paraclass = "기부"; 
		}else if(type==5) {
			paraclass = "작은가게"; 
		}else if(type==6) {
			paraclass = "미디어"; 
		}else if(type==7) {
			paraclass = "창작자"; 
		}
		
		
		PreparedStatement pstmt = null;
		List<FundingVo> list = new ArrayList<FundingVo>();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(type!=0) {
				pstmt.setString(1, paraclass);				
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {

				// 테스트
				String fno = rs.getString("F_NO");
				String regno = rs.getString("REG_NO");
				String fclass = rs.getString("F_CLASS");
				int fgmoney = rs.getInt("F_GMONEY");
				int fpmoney = rs.getInt("F_PMONEY");
				int fppeople = rs.getInt("F_PPEOPLE");
				
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
				double per = (double) fpmoney / (double) fgmoney * 100;
				// 수정완료 퍼센트 구하기
				String moneyper = String.format("%.1f", per);
				;

				FundingVo vo = new FundingVo();
				vo.setFno(fno);
				vo.setRegno(regno);
				vo.setFclass(fclass);
				vo.setFgmoney(fgmoney);
				vo.setFpmoney(fpmoney);
				vo.setFppeople(fppeople);
				
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

	public int getListCount(Connection conn, int type) {
		int listcount = 0;
		// sql 준비
				String sql = "SELECT COUNT(*) FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO AND R.REG_FIN = 'N'";
				String paraclass = "";
				if(type!=0) {
						sql = "SELECT COUNT(*) FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO AND R.REG_FIN = 'N' AND F.F_CLASS = ?";	
				}
				
				if (type==1) {
					paraclass = "일자리창출"; 
				}else if(type==2) {
					paraclass = "공정무역"; 
				}else if(type==3) {
					paraclass = "친환경"; 
				}else if(type==4) {
					paraclass = "기부"; 
				}else if(type==5) {
					paraclass = "작은가게"; 
				}else if(type==6) {
					paraclass = "미디어"; 
				}else if(type==7) {
					paraclass = "창작자"; 
				}
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(sql);
					if(type!=0) {
						pstmt.setString(1, paraclass);				
					}
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

	public List<FundingVo> selectDoneList(Connection conn, int type) {
		// sql 준비
				String sql = "SELECT *  FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO  AND R.REG_CLASS = '펀딩' AND R.REG_FIN = 'Y' ORDER BY F.F_NO DESC";
				String paraclass = "";
				if(type!=0) {
						sql = "SELECT *  FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO  AND R.REG_CLASS = '펀딩' AND R.REG_FIN = 'Y' AND F.F_CLASS = ? ORDER BY F.F_NO DESC";	
				}
				
				if (type==1) {
					paraclass = "일자리창출"; 
				}else if(type==2) {
					paraclass = "공정무역"; 
				}else if(type==3) {
					paraclass = "친환경"; 
				}else if(type==4) {
					paraclass = "기부"; 
				}else if(type==5) {
					paraclass = "작은가게"; 
				}else if(type==6) {
					paraclass = "미디어"; 
				}else if(type==7) {
					paraclass = "창작자"; 
				}
				
				
				PreparedStatement pstmt = null;
				List<FundingVo> list = new ArrayList<FundingVo>();
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(sql);
					if(type!=0) {
						pstmt.setString(1, paraclass);				
					}
					rs = pstmt.executeQuery();
					while (rs.next()) {

						// 테스트
						String fno = rs.getString("F_NO");
						String regno = rs.getString("REG_NO");
						String fclass = rs.getString("F_CLASS");
						int fgmoney = rs.getInt("F_GMONEY");
						int fpmoney = rs.getInt("F_PMONEY");
						int fppeople = rs.getInt("F_PPEOPLE");
						
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
						double per = (double) fpmoney / (double) fgmoney * 100;
						// 수정완료 퍼센트 구하기
						String moneyper = String.format("%.1f", per);
						;

						FundingVo vo = new FundingVo();
						vo.setFno(fno);
						vo.setRegno(regno);
						vo.setFclass(fclass);
						vo.setFgmoney(fgmoney);
						vo.setFpmoney(fpmoney);
						vo.setFppeople(fppeople);
						
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

	public int getListDoneCount(Connection conn, int type) {
		int listcount = 0;
		// sql 준비
		String sql = "SELECT COUNT(*) FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO AND R.REG_FIN = 'Y'";
		String paraclass = "";
		if(type!=0) {
				sql = "SELECT COUNT(*) FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO AND R.REG_FIN = 'Y' AND F.F_CLASS = ?";	
		}
		
		if (type==1) {
			paraclass = "일자리창출"; 
		}else if(type==2) {
			paraclass = "공정무역"; 
		}else if(type==3) {
			paraclass = "친환경"; 
		}else if(type==4) {
			paraclass = "기부"; 
		}else if(type==5) {
			paraclass = "작은가게"; 
		}else if(type==6) {
			paraclass = "미디어"; 
		}else if(type==7) {
			paraclass = "창작자"; 
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(type!=0) {
				pstmt.setString(1, paraclass);				
			}
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

	public FundingVo selectDetail(Connection conn, int type, int num) {
		// sql 준비
		String sql = "SELECT *  FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO JOIN REWARD REW ON F.F_NO = REW.F_NO AND R.REG_CLASS = '펀딩' AND R.REG_NO = ?";
		String paraclass = "";
		if(type!=0) {
			sql = "SELECT *  FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO JOIN REWARD REW ON F.F_NO = REW.F_NO AND R.REG_CLASS = '펀딩' AND R.REG_NO = ? AND F.F_CLASS = ? ";	
		}			
		
		
		if (type==1) {
			paraclass = "일자리창출"; 
		}else if(type==2) {
			paraclass = "공정무역"; 
		}else if(type==3) {
			paraclass = "친환경"; 
		}else if(type==4) {
			paraclass = "기부"; 
		}else if(type==5) {
			paraclass = "작은가게"; 
		}else if(type==6) {
			paraclass = "미디어"; 
		}else if(type==7) {
			paraclass = "창작자"; 
		}
		
		PreparedStatement pstmt = null;
		FundingVo vo = new FundingVo();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			if(type!=0) {
				pstmt.setString(2, paraclass);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {

				// 테스트
				String fno = rs.getString("F_NO");
				String regno = rs.getString("REG_NO");
				String fclass = rs.getString("F_CLASS");
				int fgmoney = rs.getInt("F_GMONEY");
				int fpmoney = rs.getInt("F_PMONEY");
				int fppeople = rs.getInt("F_PPEOPLE");
				
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
				double per = (double) fpmoney / (double) fgmoney * 100;
				// 수정완료 퍼센트 구하기
				String moneyper = String.format("%.1f", per);
				
				int rewno =rs.getInt("REW_NO");
				String rewname =rs.getString("REW_NAME");
				int rewmoney =rs.getInt("REW_MONEY");
				int rewcnt =rs.getInt("REW_COUNT");
				
				

				vo = new FundingVo();
				vo.setFno(fno);
				vo.setRegno(regno);
				vo.setFclass(fclass);
				vo.setFgmoney(fgmoney);
				vo.setFpmoney(fpmoney);
				vo.setFppeople(fppeople);
				
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
				
				vo.setRewno(rewno);
				vo.setRewname(rewname);
				vo.setRewmoney(rewmoney);
				vo.setRewcnt(rewcnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}

	public List<ReplyVo> selectReply(Connection conn, int type, int num) {
		// sql 준비
				String sql = "SELECT * FROM REPLY RP JOIN MEMBER M ON RP.M_NO = M.M_NO WHERE RP.REG_NO=? AND RP.REP_DEL= 'N' ORDER BY RP.REP_NO DESC";
				String paraclass = "";
				if(type!=0) {
					sql = "";	
				}			
				
				
//				if (type==1) {
//					paraclass = "아동청소년"; 
//				}else if(type==2) {
//					paraclass = "어르신"; 
//				}else if(type==3) {
//					paraclass = "장애인"; 
//				}else if(type==4) {
//					paraclass = "다문화"; 
//				}else if(type==5) {
//					paraclass = "지구촌"; 
//				}else if(type==6) {
//					paraclass = "가족여성"; 
//				}else if(type==7) {
//					paraclass = "시민사회"; 
//				}else if(type==8) {
//					paraclass = "동물"; 
//				}
				
				PreparedStatement pstmt = null;
				List<ReplyVo> volist = new ArrayList<ReplyVo>();
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, num);
//					if(type!=0) {
//						pstmt.setString(2, paraclass);
//					}
					rs = pstmt.executeQuery();
					while (rs.next()) {

						// 테스트
						String repno = rs.getString("REP_NO");		//댓글번호
						String mno = rs.getString("M_NO");			//사용자번호
						String regno = rs.getString("REG_NO");		//등록번호
						String repcontent = rs.getString("REP_CONTENT");	//댓글내용
						String repdate = rs.getString("REP_DATE");		//작성일
						String repdel = rs.getString("REP_DEL");		//삭제여부
						String repban = rs.getString("REP_BAN");		//신고여부
						String repmod = rs.getString("REP_MOD");		//마지막수정일자
						String mnick = rs.getString("M_NICK");

						ReplyVo vo = new ReplyVo();
						vo.setRepno(repno);
						vo.setMno(mno);
						vo.setRegno(regno);
						vo.setRepcontent(repcontent);
						vo.setRepdate(repdate);
						vo.setRepdel(repdel);
						vo.setRepban(repban);
						vo.setRepmod(repmod);
						vo.setMnick(mnick);;
						
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

	public int insertReply(Connection conn, FundingVo vo) {
		//SQL 준비
		String sql = "INSERT INTO REPLY(REP_NO, M_NO, REG_NO, REP_CONTENT) VALUES(SEQ_REPLY_REP_NO.NEXTVAL, ?, ?, ?)";

		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체에 담기 및 물음표 채우기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMno());
			pstmt.setString(2, vo.getRegno());
			pstmt.setString(3, vo.getRegcontent());;
			
			//SQL 실행
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		//실행결과 리턴
		return result;
	}

	public int FundingReplyDel(Connection conn, String num) {
		//SQL 준비
		String sql = "UPDATE REPLY SET REP_DEL = 'Y' WHERE REP_NO = ?";
		int result =0;
		PreparedStatement pstmt = null;
		//SQL 을 객체에 담기 && SQL 완성
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			//SQL 실행 및 결과저장
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		//실행결과 리턴
		return result;
	}

	public FundingVo selectDetail(Connection conn, int num) {
		// sql 준비
				String sql = "SELECT *  FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG RI ON R.REG_NO = RI.REG_NO JOIN REWARD REW ON F.F_NO = REW.F_NO AND R.REG_CLASS = '펀딩' AND R.REG_NO = ?";
				String paraclass = "";

				
				PreparedStatement pstmt = null;
				FundingVo vo = new FundingVo();
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, num);

					rs = pstmt.executeQuery();
					while (rs.next()) {

						// 테스트
						String fno = rs.getString("F_NO");
						String regno = rs.getString("REG_NO");
						String fclass = rs.getString("F_CLASS");
						int fgmoney = rs.getInt("F_GMONEY");
						int fpmoney = rs.getInt("F_PMONEY");
						int fppeople = rs.getInt("F_PPEOPLE");
						
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
						double per = (double) fpmoney / (double) fgmoney * 100;
						// 수정완료 퍼센트 구하기
						String moneyper = String.format("%.1f", per);
						
						int rewno =rs.getInt("REW_NO");
						String rewname =rs.getString("REW_NAME");
						int rewmoney =rs.getInt("REW_MONEY");
						int rewcnt =rs.getInt("REW_COUNT");
						
						

						vo = new FundingVo();
						vo.setFno(fno);
						vo.setRegno(regno);
						vo.setFclass(fclass);
						vo.setFgmoney(fgmoney);
						vo.setFpmoney(fpmoney);
						vo.setFppeople(fppeople);
						
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
						
						vo.setRewno(rewno);
						vo.setRewname(rewname);
						vo.setRewmoney(rewmoney);
						vo.setRewcnt(rewcnt);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rs);
				}
				return vo;
	}

	public int rewardMoney(Connection conn, int num, int mno, int addmoney) {
		String sql = "UPDATE FUNDING F SET F.F_PMONEY = F.F_PMONEY + ?, F.F_PPEOPLE = F.F_PPEOPLE + 1 WHERE F.REG_NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체에 담기 및 물음표 채우기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, addmoney);
			pstmt.setInt(2, num);
			
			//SQL 실행
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		//실행결과 리턴
		return result;
	}

}
