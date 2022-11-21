package com.gnt.pay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.funding.service.FundingService;
import com.gnt.funding.vo.FundingVo;
import com.gnt.gibu.vo.GibuVo;
import com.gnt.member.vo.MemberVo;
import com.gnt.pay.service.PayService;
import com.gnt.pay.vo.PayListVo;
import com.gnt.pay.vo.PaymentVo;

@WebServlet(urlPatterns = "/funding/pay")
public class FundingPayController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num = Integer.parseInt(req.getParameter("num"));
		
		FundingVo fundingvo = new FundingService().selectDetail(num);	
		
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		List<PaymentVo> pVo = new PayService().callPaymentList(loginMember.getNo());
		req.setAttribute("list", pVo);
		
		req.setAttribute("fundingvo", fundingvo);
		req.getRequestDispatcher("/views/payment/fundingPay.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
		
		int num = Integer.parseInt(req.getParameter("num"));
		int mno = Integer.parseInt(req.getParameter("mno"));
		int addmoney = Integer.parseInt(req.getParameter("addmoney"));
		
		FundingVo fundingvo = (FundingVo)req.getAttribute("vo");
		String pNo = req.getParameter("pNo");
		String plMoney = req.getParameter("addmoney");
		String regNo = fundingvo.getRegno();
		
		PayListVo payListVo = new PayListVo(); 
		payListVo.setpNo(pNo);
		payListVo.setPlMoney(plMoney);
		payListVo.setRegNo(regNo);
	
		int result1 = new FundingService().rewardMoney(num, mno, addmoney);
		
		int result2 = new PayService().insertPayList(payListVo);
		
		
		//결과에 따라, 화면 선택
		if(result1*result2 == 1 ) {
			//성공 -> 목록(alertMsg)
			req.getSession().setAttribute("alertMsg", "펀딩 완료!");
			resp.sendRedirect(path+"/view/funding_detail?type=0&num="+num);
		}else {
			//실패 -> 에러페이지(errorMsg)
			req.setAttribute("errorMsg", "펀딩 실패");
			RequestDispatcher view = req.getRequestDispatcher("/views/error/errorPage.jsp");
			view.forward(req, resp);
		}
	}
}
