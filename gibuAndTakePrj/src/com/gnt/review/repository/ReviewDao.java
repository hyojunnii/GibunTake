package com.gnt.review.repository;

import static com.gnt.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gnt.common.JDBCTemplate;
import com.gnt.review.vo.ReviewDetailVo;
import com.gnt.review.vo.ReviewPageVo;
import com.gnt.review.vo.ReviewVo;

public class ReviewDao {

	public int getCount(Connection conn, int category) {
		int result = 0;
		
		String sql = "SELECT COUNT(REV_NO) CNT FROM REVIEW WHERE REV_CLASS = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("CNT");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	public List<ReviewVo> selectList(Connection conn, ReviewPageVo pageVo) {
		List<ReviewVo> result = new ArrayList<ReviewVo>();
		
		String sql = "SELECT * FROM (SELECT ROWNUM ROWNO, T.* FROM (SELECT REV.REV_NO, REV.M_NO, M.M_NICK M_NICK, REV.REV_NAME, REV.REV_CONTENT, REV.REV_CLASS, REV.REV_MOD, REV.REV_CNT FROM REVIEW REV JOIN MEMBER M ON REV.M_NO = M.M_NO WHERE REV.REV_CLASS = ? ORDER BY REV.REV_NO DESC) T) WHERE ROWNO BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//sql객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit()+1;
			int end = start+pageVo.getBoardLimit()-1;
			pstmt.setInt(1, pageVo.getCategory());
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			
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
				vo.setRevNo(no);
				String revImg = selectImg(conn, vo);
				
				
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
	
	public ReviewDetailVo selectReviewOne1(Connection conn, String revNo) {
		ReviewDetailVo result = null;
		//여기부터
		String sql = "SELECT R.REV_NO REV_NO, R.M_NO M_NO, M.M_NICK M_NICK, R.REV_NAME REV_NAME, R.REV_CONTENT REV_CONTENT, R.REV_DATE REV_DATE , CAM.CAM_GPEOPLE CAM_GPEOPLE, CAM.CAM_PPEOPLE CAM_PPEOPLE, NVL(CORP.CORP_CONTENT,' ')CORP_CONTENT, REG.REG_SDATE REG_SDATE, REG.REG_FDATE REG_FDATE FROM REVIEW R LEFT OUTER JOIN MEMBER M ON R.M_NO = M.M_NO LEFT OUTER JOIN REVIEWREGIST RR ON R.REV_NO = RR.REV_NO LEFT OUTER JOIN REGIST REG ON REG.REG_NO = RR.REG_NO LEFT OUTER JOIN CORPORATION CORP ON CORP.M_NO = M.M_NO LEFT OUTER JOIN REVIMG RVI ON RVI.REV_NO = R.REV_NO LEFT OUTER JOIN CAMPAIGN CAM ON REG.REG_NO = CAM.REG_NO WHERE R.REV_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//sql객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revNo);
			
			//sql실행
			rs = pstmt.executeQuery();
			//결과반환//resultSet->자바객체(NoticeVo)
			if(rs.next()) {
				result = new ReviewDetailVo();
				result.setRevNo(revNo);
				result.setmNo(rs.getString("M_NO"));
				result.setmNick(rs.getString("M_NICK"));
				result.setRevName(rs.getString("REV_NAME"));
				result.setRevContent(rs.getString("REV_CONTENT"));
				result.setRevDate(rs.getString("REV_DATE"));
				result.setCamGpeople(rs.getString("CAM_GPEOPLE"));
				result.setCamPpeople(rs.getString("CAM_PPEOPLE"));
				result.setCorpContent(rs.getString("CORP_CONTENT"));
				result.setRegSdate(rs.getString("REG_SDATE"));
				result.setRegFdate(rs.getString("REG_FDATE"));
				result.setImg(selectImg(conn, revNo));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	public ReviewDetailVo selectReviewOne2(Connection conn, String revNo) {
		ReviewDetailVo result = null;
		//여기부터
		String sql = "SELECT R.REV_NO REV_NO, R.M_NO M_NO, M.M_NICK M_NICK, R.REV_NAME REV_NAME, R.REV_CONTENT REV_CONTENT, R.REV_DATE REV_DATE , D.D_GMONEY D_GMONEY, D.D_PMONEY D_PMONEY, NVL(CORP.CORP_CONTENT,' ')CORP_CONTENT, REG.REG_SDATE REG_SDATE, REG.REG_FDATE REG_FDATE FROM REVIEW R LEFT OUTER JOIN MEMBER M ON R.M_NO = M.M_NO LEFT OUTER JOIN REVIEWREGIST RR ON R.REV_NO = RR.REV_NO LEFT OUTER JOIN REGIST REG ON REG.REG_NO = RR.REG_NO LEFT OUTER JOIN CORPORATION CORP ON CORP.M_NO = M.M_NO LEFT OUTER JOIN REVIMG RVI ON RVI.REV_NO = R.REV_NO LEFT OUTER JOIN DONATION D ON REG.REG_NO = D.REG_NO WHERE R.REV_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//sql객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revNo);
			
			//sql실행
			rs = pstmt.executeQuery();
			//결과반환//resultSet->자바객체(NoticeVo)
			if(rs.next()) {
				result = new ReviewDetailVo();
				result.setRevNo(revNo);
				result.setmNo(rs.getString("M_NO"));
				result.setmNick(rs.getString("M_NICK"));
				result.setRevName(rs.getString("REV_NAME"));
				result.setRevContent(rs.getString("REV_CONTENT"));
				result.setRevDate(rs.getString("REV_DATE"));
				result.setGmoney(rs.getString("D_GMONEY"));
				result.setPmoney(rs.getString("D_PMONEY"));
				result.setCorpContent(rs.getString("CORP_CONTENT"));
				result.setRegSdate(rs.getString("REG_SDATE"));
				result.setRegFdate(rs.getString("REG_FDATE"));
				result.setImg(selectImg(conn, revNo));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	public ReviewDetailVo selectReviewOne3(Connection conn, String revNo) {
		ReviewDetailVo result = null;
		//여기부터
		String sql = "SELECT R.REV_NO REV_NO, R.M_NO M_NO, M.M_NICK M_NICK, R.REV_NAME REV_NAME, R.REV_CONTENT REV_CONTENT, R.REV_DATE REV_DATE , F.F_GMONEY F_GMONEY, F.F_PMONEY F_PMONEY, NVL(CORP.CORP_CONTENT,' ')CORP_CONTENT, REG.REG_SDATE REG_SDATE, REG.REG_FDATE REG_FDATE FROM REVIEW R LEFT OUTER JOIN MEMBER M ON R.M_NO = M.M_NO LEFT OUTER JOIN REVIEWREGIST RR ON R.REV_NO = RR.REV_NO LEFT OUTER JOIN REGIST REG ON REG.REG_NO = RR.REG_NO LEFT OUTER JOIN CORPORATION CORP ON CORP.M_NO = M.M_NO LEFT OUTER JOIN REVIMG RVI ON RVI.REV_NO = R.REV_NO LEFT OUTER JOIN FUNDING F ON REG.REG_NO = F.REG_NO WHERE R.REV_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//sql객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			
			
			//sql실행
			rs = pstmt.executeQuery();
			//결과반환//resultSet->자바객체(NoticeVo)
			if(rs.next()) {
				result = new ReviewDetailVo();
				result.setRevNo(revNo);
				result.setmNo(rs.getString("M_NO"));
				result.setmNick(rs.getString("M_NICK"));
				result.setRevName(rs.getString("REV_NAME"));
				result.setRevContent(rs.getString("REV_CONTENT"));
				result.setRevDate(rs.getString("REV_DATE"));
				result.setGmoney(rs.getString("F_GMONEY"));
				result.setPmoney(rs.getString("F_PMONEY"));
				result.setCorpContent(rs.getString("CORP_CONTENT"));
				result.setRegSdate(rs.getString("REG_SDATE"));
				result.setRegFdate(rs.getString("REG_FDATE"));
				result.setImg(selectImg(conn, revNo));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	public String selectImg(Connection conn, String revNo) {
		String result = null;
		
		String sql = "SELECT RVI_NO, REV_NO, URL FROM REVIMG WHERE REV_NO = ? ORDER BY RVI_NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//sql객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revNo);
			
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
	
	

	public int updateReviewOne(Connection conn, ReviewVo reviewVo, String regNo) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			
			//sql 준비
			String sql = "UPDATE REVIEW SET REV_NAME = ?, REV_CONTENT=?, REV_MOD = SYSDATE WHERE REV_NO=?";
			//sql 객체에 담기
			pstmt = conn.prepareStatement(sql);
			
			//미완성 sql 완성
			pstmt.setString(1, reviewVo.getRevName());
			pstmt.setString(2, reviewVo.getRevContent());
			pstmt.setString(3, reviewVo.getRevNo());
			
			
			//sql 실행 실행 결과 받기
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//다쓴 자원 정리하기
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

	

}
