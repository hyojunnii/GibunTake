package com.gnt.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.member.service.MemberService;
import com.gnt.member.vo.MemberVo;



@WebServlet(urlPatterns="/member/MemberUpdate")
public class MemberMyUpdate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");

		if(loginMember != null) {
			req.getRequestDispatcher("/views/member/memberUpdate.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "로그인 후 접근 가능합니다!");
			resp.sendRedirect(req.getContextPath());
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		//데이터 받기 -> 객체
		String memberName = req.getParameter("memberName");
		String memberNick = req.getParameter("memberNick");
		String memberPhone = req.getParameter("memberPhone");
		String memberEmail = req.getParameter("memberEmail");
		String memberAddr = req.getParameter("memberAddr");

		int no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();

		MemberVo vo = new MemberVo();
		
		vo.setNo(no);
		vo.setName(memberName);
		vo.setNick(memberNick);
		vo.setPhone(memberPhone);
		vo.setEmail(memberEmail);
		vo.setAddr(memberAddr);


		//서비스 호출(객체)
		MemberVo updateVo = new MemberService().memberUpdate(vo);
		
		//실행결과에 따라 화면 선택
		if(updateVo != null) {
			//성공 화면
			req.getSession().setAttribute("loginMember", updateVo);
			req.getSession().setAttribute("alertMsg", "회원 정보 수정 완료!");
			resp.sendRedirect("/gibuAndTakePrj/member/MemberUpdate");
		}else {
			//로그인 실패
			req.setAttribute("errorMsg", "로그인 실패!");
			req.getRequestDispatcher("/gibuAndTakePrj/views/error/errorPage.jsp").forward(req, resp);
		}
	}
}


