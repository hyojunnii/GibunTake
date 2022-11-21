package com.gnt.gibu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.gibu.service.GibuService;
import com.gnt.gibu.vo.GibuVo;

@WebServlet(urlPatterns = "/view/gibu")
public class GibuServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int listCount;		//현재 총 게시글 갯수
		int currentPage;	//현재 페이지 (==사용자가 요청한 페이지)
		int pageLimit;		//페이지 하단의 보여질 페이지버튼의 최대 갯수
		int boardLimit;		//한 페이지 내 보여질 게시글 최대 갯수
		
		int maxPage;		//가장 마지막 페이지 (==총 페이지 수)
		int startPage;		//페이징바의 시작
		int endPage;		//페이징바의 끝
		
		String paratype = req.getParameter("type");	
		if(paratype ==null) {
			paratype = "0";
		}
		int type = Integer.parseInt(paratype);
		
		
		List<GibuVo> gibuvo = new GibuService().selectList(type);
		int gibucnt = new GibuService().getListCount(type);
		// System.out.println(gibuvo);
		req.setAttribute("regtype", type);
		req.setAttribute("gibuvo", gibuvo);
		req.setAttribute("gibucnt", gibucnt);
		
		
		req.getRequestDispatcher("/views/select_gibu/gibu_ing.jsp").forward(req, resp);
	}
	
}
