package com.gnt.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.common.PageVo;
import com.gnt.project.vo.RegistVo;
import com.gnt.search.service.SearchService;

@WebServlet(urlPatterns = "/search/content")
public class SearchContentController extends HttpServlet{
	
	//통합검색
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		req.getSession().removeAttribute("searchedList");
		
		String search = req.getParameter("search");
		
		//----------페이징 처리-----------
		int listCount;		//현재 총 게시글 갯수
		int currentPage;	//현재 페이지(사용자요청)
		int pageLimit;		//페이지 하단에 보여질 페이지버튼의 최대 갯수
		int boardLimit;		//한 페이지 내 보여질 게시글 최대 갯수
		int maxPage;		//가장 마지막 페이지
		int startPage;		//페이징바의 시작
		int endPage;		//페이징바의 끝
		
		listCount = new SearchService().getSearchCount(search);
		
		if(req.getParameter("p") != null) {
			currentPage = Integer.parseInt(req.getParameter("p"));
		} else {
			currentPage = 1;
		}
		
		pageLimit = 10;
		
		boardLimit = 5;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageVo pageVo = new PageVo();
		pageVo.setListCount(listCount);
		pageVo.setCurrentPage(currentPage);
		pageVo.setPageLimit(pageLimit);
		pageVo.setBoardLimit(boardLimit);
		pageVo.setMaxPage(maxPage);
		pageVo.setStartPage(startPage);
		pageVo.setEndPage(endPage);
		
		req.getSession().setAttribute("pv", pageVo);
	
		String s = req.getParameter("s");
		
		List<RegistVo> searchedList = new SearchService().searchList(search, pageVo, s);
		
		if(searchedList.size() == 0 || searchedList == null) {
			req.setAttribute("NullList", 0);
		} else {
			req.setAttribute("searchedList", searchedList);
			req.setAttribute("par", search);
		}
		req.getRequestDispatcher("/views/search/searchPage.jsp").forward(req, resp);
		
	}
}
