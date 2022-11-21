package com.gnt.pay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.gibu.service.GibuService;
import com.gnt.gibu.vo.GibuVo;
import com.gnt.member.vo.MemberVo;
import com.gnt.pay.service.PayService;
import com.gnt.pay.vo.PayListVo;
import com.gnt.pay.vo.PaymentVo;

@WebServlet(urlPatterns = "/donate/pay")
public class DonatePayController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		
		GibuVo gibuvo = new GibuService().selectDetail(num);
		
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		List<PaymentVo> pVo = new PayService().callPaymentList(loginMember.getNo());
		req.setAttribute("list", pVo);
		
		
		req.setAttribute("vo", gibuvo);
		req.getRequestDispatcher("/views/payment/donatePay.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
		
		GibuVo gibuvo = (GibuVo)req.getSession().getAttribute("gibuvo");
		req.getSession().removeAttribute("gibuvo");
		System.out.println(gibuvo);
		
		int num = Integer.parseInt(req.getParameter("num"));
		int mno = Integer.parseInt(req.getParameter("mno"));
		int addmoney = Integer.parseInt(req.getParameter("addmoney"));
		System.out.println(num + ", " + addmoney +", " + mno);
		
		String pNo = req.getParameter("pNo");
		String plMoney = req.getParameter("addmoney");
		String regNo = gibuvo.getRegno();
		PayListVo payListVo = new PayListVo(); 
		payListVo.setpNo(pNo);
		payListVo.setPlMoney(plMoney);
		payListVo.setRegNo(regNo);
		
		
		int result1 = new GibuService().donateMoney(num, mno, addmoney);
		int result2 = new PayService().insertPayList(payListVo);
		//결과에 따라, 화면 선택
		if(result1*result2 == 1 ) {
			//성공 -> 목록(alertMsg)
			req.getSession().setAttribute("alertMsg", "기부 완료!");
			resp.sendRedirect(path+"/view/gibu_detail?type=0&num="+num);
		}else {
			//실패 -> 에러페이지(errorMsg)
			req.setAttribute("errorMsg", "기부 실패");
			RequestDispatcher view = req.getRequestDispatcher("/views/error/errorPage.jsp");
			view.forward(req, resp);
		}
	}
}
