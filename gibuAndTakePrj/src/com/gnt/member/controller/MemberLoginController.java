package com.gnt.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.member.service.MemberService;
import com.gnt.member.vo.MemberVo;
import com.gnt.corp.service.corpService;
import com.gnt.corp.vo.corpVo;

@WebServlet(urlPatterns = "/member/login")
public class MemberLoginController extends HttpServlet{


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		int logChk = Integer.parseInt(req.getParameter("check_log"));
		
		if(logChk == 1) {

			//데이터 뭉치기
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);

			//서비스 로직 실행
			MemberVo loginMember = new MemberService().login(vo);
			
			if(loginMember != null) {
				//로그인 성공 세션에 로그인 유저 정보 담기
				req.getSession().setAttribute("loginMember",loginMember);
				req.getSession().setAttribute("alertMsg","로그인 성공!");

				resp.sendRedirect("/gibuAndTakePrj");
			} else {
				//로그인 실패
				req.setAttribute("errorMsg", "로그인 실패!");
				req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
			}
		}else if(logChk == 2) {

			//데이터 뭉치기
			corpVo vo = new corpVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);

			//서비스 로직 실행
			corpVo loginCorp = new corpService().login(vo);

			if(loginCorp != null) {
				//로그인 성공 세션에 로그인 유저 정보 담기
				req.getSession().setAttribute("loginCorp",loginCorp);
				req.getSession().setAttribute("alertMsg","로그인 성공!");

				resp.sendRedirect("/gibuAndTakePrj");
				
			} else {
				//로그인 실패
				req.setAttribute("errorMsg", "로그인 실패!");
				req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
			}
		}
	}
}



