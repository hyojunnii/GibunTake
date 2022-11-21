package com.gnt.search.service;

import java.sql.Connection;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.PageVo;
import com.gnt.project.vo.RegistVo;
import com.gnt.search.repository.SearchDao;

public class SearchService {
	
	private final SearchDao dao = new SearchDao();
	
	//등록테이블 게시글 총 갯수
	public int getCount() {
		int result = 0;
		Connection conn = null;
		try {
			conn = getConnection();
			
			result = dao.getCount(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}
	
	//등록테이블 검색 게시글 갯수
	public int getSearchCount(String search) {
		int result = 0;
		Connection conn = null;
		try {
			conn = getConnection();
			
			result = dao.getSearchCount(conn, search);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}
	
	//주제별 검색 게시글 갯수
	public int getCategoryCount(String project, String category) {
		int result = 0;
		Connection conn = null;
		try {
			conn = getConnection();
			if("기부".equals(project)){
				result = dao.getDonationCount(conn, category);
			} else {
				result = dao.getFundingCount(conn, category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}
	
	//추천목록
	public List<RegistVo> recommendList(PageVo pageVo, String s) {
		Connection conn = null;
		
		List<RegistVo> recommendList = null;
		
		conn = getConnection();
		
		if("1".equals(s)) {
			recommendList = dao.recommendPopularList(conn, pageVo);
		} else {
			recommendList = dao.recommendList(conn, pageVo);
		}
		close(conn);
		return recommendList;
	}

	//통합검색
	public List<RegistVo> searchList(String search, PageVo pageVo, String s) {
		
		if(search == null) {
			return null;
		}
		
		Connection conn = null;
		
		List<RegistVo> searchedList = null;
		
		conn = getConnection();
		
		if(s != null) {
			searchedList = dao.searchPopularList(search, conn, pageVo);
		} else {
			searchedList = dao.searchList(search, conn, pageVo);
		}
		close(conn);
		return searchedList;
	}

	//주제별검색
	public List<RegistVo> categorySearch(String project, String category, PageVo pageVo, String s) {
		Connection conn = null;
		
		List<RegistVo> categoryList = null;
		
		conn = getConnection();
		
		if("기부".equals(project)) {
			if(s != null) {
				categoryList = dao.donationCatePopularList(conn, category, pageVo);
			} else {
				categoryList = dao.donationCateList(conn, category, pageVo);
			}
		} else {
			if(s != null) {
				categoryList = dao.fundingCatePopularList(conn, category, pageVo);
			} else {
				categoryList = dao.fundingCateList(conn, category, pageVo);
			}
		}
		close(conn);
		return categoryList;
	}


}
