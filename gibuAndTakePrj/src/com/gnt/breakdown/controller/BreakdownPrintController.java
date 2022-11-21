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

@WebServlet(urlPatterns = "/member/breakPrint")
public class BreakdownPrintController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo m = (MemberVo) req.getSession().getAttribute("loginMember");
		String payNo = req.getParameter("payNo");
		System.out.println(payNo);
		
		BreakdownVo vo = new BreakdownService().printList(payNo, m);
		
		if(vo != null) {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/user2/donationBreakdownPrint.jsp").forward(req, resp);
		}
	}
}
