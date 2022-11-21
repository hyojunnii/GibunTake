package com.gnt.faq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.common.PageVo;
import com.gnt.faq.service.FaqService;
import com.gnt.faq.vo.FaqVo;

@WebServlet(urlPatterns = "/faq/fundinglist")
public class FaqFundingList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int listCount;			//현재 총 게시글 갯수
		int currentPage;		//현재 페이지(사용자가 요청한 페이지)
		int pageLimit;			//페이지 하단에 보여질 페이지 버튼의 최대 갯수
		int boardLimit;			//한 페이지 내 보여질 게시글 최대 갯수
		
		int maxPage;			//가장 마지막 페이지 (==총 페이지 수)
		int startPage;			//페이징바의 시작
		int endPage;			//페이징바의 끝
		
		listCount = new FaqService().getCount(); 

		if(req.getParameter("p") != null) {
			currentPage = Integer.parseInt(req.getParameter("p"));
		}else {
			currentPage = 1;
		}
		
		pageLimit = 5;
		
		boardLimit = 5;
		
		maxPage = (int)Math.ceil(((double)listCount / boardLimit));
		
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit -1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		PageVo pageVo = new PageVo();
		pageVo.setBoardLimit(boardLimit);
		pageVo.setCurrentPage(currentPage);
		pageVo.setEndPage(endPage);
		pageVo.setListCount(listCount);
		pageVo.setMaxPage(maxPage);
		pageVo.setPageLimit(pageLimit);
		pageVo.setStartPage(startPage);
		
		req.setAttribute("pv", pageVo);
		
		ArrayList<FaqVo> vo = new FaqService().selectList(pageVo);
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/views/FAQ/faqFundingList.jsp").forward(req, resp);
	}
}
