package com.gnt.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.review.service.ReviewService;
import com.gnt.review.vo.ReviewPageVo;
import com.gnt.review.vo.ReviewVo;

@WebServlet(urlPatterns = "/campaign/review/list")
public class CampaignReviewListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//--페이징 처리--
		int listCount;  //현재 총 게시글 갯수
		int currentPage;//현재 페이지
		int pageLimit=10;	//페이지 하단에 보여질 페이지의 최대 갯수
		int boardLimit; //한 페이지 내 보여질 게시글 최대 갯수
		//위의 값을 이용해서 아래 3개 값 구하기
		int maxPage;	//가장 마지막 페이지
		int startPage;  //페이징 바 시작
		int endPage;	//페이징 바 끝
		int category = 2;
		
		//listCount 구하기
		listCount = new ReviewService().getCount(category);
		
		//currentPage 구하기
		
		currentPage = Integer.parseInt(req.getParameter("p"));
		
		//pageLimit
		pageLimit = 10;
		
		//boardLimit
		boardLimit = 6;
		
		//maxPage(총 페이지 수)
//				if(listCount%boardLimit==0) {
//					maxPage = listCount/boardLimit;
//				}else {
//					maxPage = listCount/boardLimit+1;
//				}
		
		maxPage = (int)Math.ceil(((double)listCount/boardLimit));
		
		//startPage
		//pageLimit, currentPage
		startPage = (currentPage-1)/pageLimit*pageLimit+1;
		
		//endpage
		//startPage, pageLimit, (maxPage)
		endPage = startPage + pageLimit -1;
		if(endPage>maxPage) {
			endPage = maxPage;
		}
		
		ReviewPageVo pageVo = new ReviewPageVo();
		pageVo.setListCount(listCount);  
		pageVo.setCurrentPage(currentPage);
		pageVo.setPageLimit(pageLimit);	
		pageVo.setBoardLimit(boardLimit); 
		pageVo.setMaxPage(maxPage);	
		pageVo.setStartPage(startPage);
		pageVo.setEndPage(endPage);
		pageVo.setCategory(category);
		
		List<ReviewVo> boardVoList = new ReviewService().selectList(pageVo);
		
		req.setAttribute("PageVo", pageVo);
		req.setAttribute("boardVoList", boardVoList);
		req.getRequestDispatcher("/views/review/campaignReviewList.jsp").forward(req, resp);
	}
}
