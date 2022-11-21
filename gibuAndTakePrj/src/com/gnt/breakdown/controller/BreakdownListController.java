package com.gnt.breakdown.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.breakdown.service.BreakdownService;
import com.gnt.breakdown.vo.BreakdownVo;
import com.gnt.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/breakList")
public class BreakdownListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo m = (MemberVo) req.getSession().getAttribute("loginMember");
	
		ArrayList<BreakdownVo> result = new BreakdownService().showList(m);

		System.out.println(result);
		if(m != null) {
			req.setAttribute("voList", result);
			req.getRequestDispatcher("/views/user2/donationBreakdownList.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/views/mainPage.jsp").forward(req, resp);
		}
	}
	
}
