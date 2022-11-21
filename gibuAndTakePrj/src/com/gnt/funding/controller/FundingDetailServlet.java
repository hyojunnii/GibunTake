package com.gnt.funding.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.common.ReplyVo;
import com.gnt.funding.service.FundingService;
import com.gnt.funding.vo.FundingVo;

@WebServlet(urlPatterns = "/view/funding_detail")
public class FundingDetailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int type = Integer.parseInt(req.getParameter("type"));
		int num = Integer.parseInt(req.getParameter("num"));
		
		FundingVo fundingvo = new FundingService().selectDetail(type, num);
		List<ReplyVo> replyvo = new FundingService().selectReply(type, num);
		req.getSession().setAttribute("fundingvo", fundingvo);
		req.setAttribute("replyvo", replyvo);
		
		
		req.getRequestDispatcher("/views/select_funding/funding_detail.jsp").forward(req, resp);
	}
}
