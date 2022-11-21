package com.gnt.funding.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.funding.service.FundingService;
import com.gnt.funding.vo.FundingVo;

@WebServlet(urlPatterns = "/view/funding")
public class FundingServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String paratype = req.getParameter("type");	
		if(paratype ==null) {
			paratype = "0";
		}
		int type = Integer.parseInt(paratype);
		
		
		//목록조회
		List<FundingVo> fundingvo = new FundingService().selectList(type);
		//목록 갯수
		int fundingcnt = new FundingService().getListCount(type);
		
		req.setAttribute("fundingvo", fundingvo);
		req.setAttribute("fundingcnt", fundingcnt);
		req.getRequestDispatcher("/views/select_funding/funding_ing.jsp").forward(req, resp);
	}
}
