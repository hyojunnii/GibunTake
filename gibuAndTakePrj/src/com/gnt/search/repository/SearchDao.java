package com.gnt.search.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.PageVo;
import com.gnt.project.vo.RegistVo;

public class SearchDao {
	
	//게시글 총 갯수 조회
	public int getCount(Connection conn) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT COUNT(REG_NO) AS COUNT FROM REGIST WHERE REG_DEL = 'N' AND REG_PASS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}
	
	//등록테이블 검색 게시글 갯수
	public int getSearchCount(Connection conn, String search) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT COUNT(REG_NO) AS COUNT FROM REGIST WHERE (REG_NAME LIKE '%' || ? || '%' OR REG_CONTENT LIKE '%' || ? || '%') AND REG_DEL = 'N' AND REG_PASS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}
	
	//기부 주제별 검색 게시글 갯수
	public int getDonationCount(Connection conn, String category) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT COUNT(D.D_NO) AS COUNT FROM DONATION D JOIN REGIST R ON D.REG_NO = R.REG_NO WHERE D.D_CLASS = ? AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}
	
	//펀딩 주제별 검색 게시글 갯수
	public int getFundingCount(Connection conn, String category) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT COUNT(F.F_NO) AS COUNT FROM FUNDING F JOIN REGIST R ON F.REG_NO = R.REG_NO WHERE F.F_CLASS = ? AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}
	
	//추천목록(현재 페이지 기준) - 최신순
	public List<RegistVo> recommendList(Connection conn, PageVo pageVo) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, RM.* FROM ( SELECT R.REG_NO, R.REG_CLASS, R.REG_NAME, R.REG_CONTENT, R.REG_FIN, R.REG_CNT, M.M_NICK AS CORP, I.URL AS URL FROM REGIST R JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG I ON R.REG_NO = I.REG_NO WHERE R.REG_DEL = 'N' AND R.REG_PASS = 'Y' ORDER BY R.REG_NO DESC ) RM ) R WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegistVo> recommendList = new ArrayList<RegistVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int regNo = rs.getInt("REG_NO");
				String category = rs.getString("REG_CLASS");
				String title = rs.getString("REG_NAME");
				String content = rs.getString("REG_CONTENT");
				String fin = rs.getString("REG_FIN");
				String cnt = rs.getString("REG_CNT");
				String mNo = rs.getString("CORP");
				String url = rs.getString("URL");
				
				RegistVo vo = new RegistVo();
				vo.setRegNo(regNo);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setFin(fin);
				vo.setCnt(cnt);
				vo.setmNo(mNo);
				vo.setUrl(url);
				
				recommendList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return recommendList;
	}
	
	//추천목록(현재 페이지 기준) - 인기순
	public List<RegistVo> recommendPopularList(Connection conn, PageVo pageVo) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, RM.* FROM ( SELECT R.REG_NO, R.REG_CLASS, R.REG_NAME, R.REG_CONTENT, R.REG_FIN, R.REG_CNT, M.M_NICK AS CORP, I.URL AS URL FROM REGIST R JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG I ON R.REG_NO = I.REG_NO WHERE R.REG_DEL = 'N' AND R.REG_PASS = 'Y' ORDER BY R.REG_CNT DESC, R.REG_NO DESC ) RM ) R WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegistVo> recommendList = new ArrayList<RegistVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int regNo = rs.getInt("REG_NO");
				String category = rs.getString("REG_CLASS");
				String title = rs.getString("REG_NAME");
				String content = rs.getString("REG_CONTENT");
				String fin = rs.getString("REG_FIN");
				String cnt = rs.getString("REG_CNT");
				String mNo = rs.getString("CORP");
				String url = rs.getString("URL");
				
				RegistVo vo = new RegistVo();
				vo.setRegNo(regNo);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setFin(fin);
				vo.setCnt(cnt);
				vo.setmNo(mNo);
				vo.setUrl(url);
				
				recommendList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return recommendList;
	}
	
	//통합검색(현재 페이지 기준) - 최신순
	public List<RegistVo> searchList(String search, Connection conn, PageVo pageVo) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, RM.* FROM ( SELECT R.REG_NO, R.REG_CLASS, R.REG_NAME, R.REG_CONTENT, R.REG_FIN, R.REG_CNT, M.M_NICK AS CORP, I.URL AS URL FROM REGIST R JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG I ON R.REG_NO = I.REG_NO WHERE (R.REG_NAME LIKE '%' || ? || '%' OR R.REG_CONTENT LIKE '%' || ? || '%') AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y' ORDER BY R.REG_NO DESC ) RM ) R WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegistVo> searchedList = new ArrayList<RegistVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int regNo = rs.getInt("REG_NO");
				String category = rs.getString("REG_CLASS");
				String title = rs.getString("REG_NAME");
				String content = rs.getString("REG_CONTENT");
				String fin = rs.getString("REG_FIN");
				String cnt = rs.getString("REG_CNT");
				String mNo = rs.getString("CORP");
				String url = rs.getString("URL");
				
				RegistVo vo = new RegistVo();
				vo.setRegNo(regNo);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setFin(fin);
				vo.setCnt(cnt);
				vo.setmNo(mNo);
				vo.setUrl(url);
				
				searchedList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return searchedList;
	}

	//통합검색(현재 페이지 기준) - 인기순
	public List<RegistVo> searchPopularList(String search, Connection conn, PageVo pageVo) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, RM.* FROM ( SELECT R.REG_NO, R.REG_CLASS, R.REG_NAME, R.REG_CONTENT, R.REG_FIN, R.REG_CNT, M.M_NICK AS CORP, I.URL AS URL FROM REGIST R JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG I ON R.REG_NO = I.REG_NO WHERE (R.REG_NAME LIKE '%' || ? || '%' OR R.REG_CONTENT LIKE '%' || ? || '%') AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y' ORDER BY R.REG_CNT DESC, R.REG_NO DESC ) RM ) R WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegistVo> searchedList = new ArrayList<RegistVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int regNo = rs.getInt("REG_NO");
				String category = rs.getString("REG_CLASS");
				String title = rs.getString("REG_NAME");
				String content = rs.getString("REG_CONTENT");
				String fin = rs.getString("REG_FIN");
				String cnt = rs.getString("REG_CNT");
				String mNo = rs.getString("CORP");
				String url = rs.getString("URL");
				
				RegistVo vo = new RegistVo();
				vo.setRegNo(regNo);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setFin(fin);
				vo.setCnt(cnt);
				vo.setmNo(mNo);
				vo.setUrl(url);
				
				searchedList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return searchedList;
	}

	//기부 주제별 검색 - 최신순
	public List<RegistVo> donationCateList(Connection conn, String category, PageVo pageVo) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, RM.* FROM ( SELECT R.REG_NO, R.REG_CLASS, R.REG_NAME, R.REG_CONTENT, R.REG_FIN, R.REG_CNT, M.M_NICK AS CORP, I.URL AS URL FROM REGIST R JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG I ON R.REG_NO = I.REG_NO JOIN DONATION D ON R.REG_NO = D.REG_NO WHERE D.D_CLASS = ? AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y' ORDER BY R.REG_NO DESC ) RM ) R WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegistVo> categoryList = new ArrayList<RegistVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setString(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int regNo = rs.getInt("REG_NO");
				String pcategory = rs.getString("REG_CLASS");
				String title = rs.getString("REG_NAME");
				String content = rs.getString("REG_CONTENT");
				String fin = rs.getString("REG_FIN");
				String cnt = rs.getString("REG_CNT");
				String mNo = rs.getString("CORP");
				String url = rs.getString("URL");
				
				RegistVo vo = new RegistVo();
				vo.setRegNo(regNo);
				vo.setCategory(pcategory);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setFin(fin);
				vo.setCnt(cnt);
				vo.setmNo(mNo);
				vo.setUrl(url);
				
				categoryList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return categoryList;
	}

	//기부 주제별 검색 - 인기순
	public List<RegistVo> donationCatePopularList(Connection conn, String category, PageVo pageVo) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, RM.* FROM ( SELECT R.REG_NO, R.REG_CLASS, R.REG_NAME, R.REG_CONTENT, R.REG_FIN, R.REG_CNT, M.M_NICK AS CORP, I.URL AS URL FROM REGIST R JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG I ON R.REG_NO = I.REG_NO JOIN DONATION D ON R.REG_NO = D.REG_NO WHERE D.D_CLASS = ? AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y' ORDER BY R.REG_CNT DESC, R.REG_NO DESC ) RM ) R WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegistVo> categoryList = new ArrayList<RegistVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setString(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int regNo = rs.getInt("REG_NO");
				String pcategory = rs.getString("REG_CLASS");
				String title = rs.getString("REG_NAME");
				String content = rs.getString("REG_CONTENT");
				String fin = rs.getString("REG_FIN");
				String cnt = rs.getString("REG_CNT");
				String mNo = rs.getString("CORP");
				String url = rs.getString("URL");
				
				RegistVo vo = new RegistVo();
				vo.setRegNo(regNo);
				vo.setCategory(pcategory);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setFin(fin);
				vo.setCnt(cnt);
				vo.setmNo(mNo);
				vo.setUrl(url);
				
				categoryList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return categoryList;
	}

	//펀딩 주제별 검색 - 최신순
	public List<RegistVo> fundingCateList(Connection conn, String category, PageVo pageVo) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, RM.* FROM ( SELECT R.REG_NO, R.REG_CLASS, R.REG_NAME, R.REG_CONTENT, R.REG_FIN, R.REG_CNT, M.M_NICK AS CORP, I.URL AS URL FROM REGIST R JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG I ON R.REG_NO = I.REG_NO JOIN FUNDING F ON R.REG_NO = F.REG_NO WHERE F.F_CLASS = ? AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y' ORDER BY R.REG_NO DESC ) RM ) R WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegistVo> categoryList = new ArrayList<RegistVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setString(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int regNo = rs.getInt("REG_NO");
				String pcategory = rs.getString("REG_CLASS");
				String title = rs.getString("REG_NAME");
				String content = rs.getString("REG_CONTENT");
				String fin = rs.getString("REG_FIN");
				String cnt = rs.getString("REG_CNT");
				String mNo = rs.getString("CORP");
				String url = rs.getString("URL");
				
				RegistVo vo = new RegistVo();
				vo.setRegNo(regNo);
				vo.setCategory(pcategory);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setFin(fin);
				vo.setCnt(cnt);
				vo.setmNo(mNo);
				vo.setUrl(url);
				
				categoryList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return categoryList;
	}

	//펀딩 주제별 검색 - 인기순
	public List<RegistVo> fundingCatePopularList(Connection conn, String category, PageVo pageVo) {
		//나중에 REG_PASS 'Y'
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, RM.* FROM ( SELECT R.REG_NO, R.REG_CLASS, R.REG_NAME, R.REG_CONTENT, R.REG_FIN, R.REG_CNT, M.M_NICK AS CORP, I.URL AS URL FROM REGIST R JOIN MEMBER M ON R.M_NO = M.M_NO JOIN REGIMG I ON R.REG_NO = I.REG_NO JOIN FUNDING F ON R.REG_NO = F.REG_NO WHERE F.F_CLASS = ? AND R.REG_DEL = 'N' AND R.REG_PASS = 'Y' ORDER BY R.REG_CNT DESC, R.REG_NO DESC ) RM ) R WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegistVo> categoryList = new ArrayList<RegistVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setString(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int regNo = rs.getInt("REG_NO");
				String pcategory = rs.getString("REG_CLASS");
				String title = rs.getString("REG_NAME");
				String content = rs.getString("REG_CONTENT");
				String fin = rs.getString("REG_FIN");
				String cnt = rs.getString("REG_CNT");
				String mNo = rs.getString("CORP");
				String url = rs.getString("URL");
				
				RegistVo vo = new RegistVo();
				vo.setRegNo(regNo);
				vo.setCategory(pcategory);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setFin(fin);
				vo.setCnt(cnt);
				vo.setmNo(mNo);
				vo.setUrl(url);
				
				categoryList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return categoryList;
	}






}
