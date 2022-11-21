package com.gnt.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.member.service.MemberService;
import com.gnt.member.vo.MemberVo;

@WebServlet(urlPatterns= "/member/Join")
public class MemberJoinController extends HttpServlet {
	
	/*
	 * 회원가입 화면 보여주기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//다른애한테 떠넘기기
		req.getRequestDispatcher("/views/member/memberJoin.jsp").forward(req, resp);
		
	}
	
	/*
	 * 회원가입 처리
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberName = req.getParameter("memberName");
		String memberNick = req.getParameter("memberNick");
		String memberRegnum= req.getParameter("memberRegnum");
		String memberPhone = req.getParameter("memberPhone");
		String memberEmail = req.getParameter("memberEmail");
		String memberAddr = req.getParameter("memberAddr");
		
		MemberVo vo = new MemberVo();

		vo.setId(memberId);
		vo.setPwd(memberPwd);
		vo.setName(memberName);
		vo.setNick(memberNick);
		vo.setRegnum(memberRegnum);
		vo.setPhone(memberPhone);
		vo.setEmail(memberEmail);
		vo.setAddr(memberAddr);

		//객체 이용해서 회원가입 진행
		int result = new MemberService().memberjoin(vo);
		//insert 결과를 가지고 화면 선택
		if(result == 1) {
			//회원가입 성공
			resp.sendRedirect("/gibuAndTakePrj/views/member/login.jsp");
		} else {
			//회원가입 실패
			//요청 떠넘기기 할건데 , 다음타자 == 실패화면
			resp.sendRedirect("/gibuAndTakePrj/views/error/errorPage.jsp");
		}
	
	}
}

