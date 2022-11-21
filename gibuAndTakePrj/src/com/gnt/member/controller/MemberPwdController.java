package com.gnt.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.member.service.MemberService;

@WebServlet(urlPatterns = "/member/pwd")
public class MemberPwdController extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.setCharacterEncoding("UTF-8");
			
			//data 꺼내기 (클라이언트가 보낸)
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwdNew = req.getParameter("memberPwdNew");
			String memberPwdNew2= req.getParameter("memberPwdNew2");
			
			//서비스 호출
			int result = new MemberService().changePwd(memberId, memberPwd, memberPwdNew, memberPwdNew2);
			
			System.out.println(result);
			
			//실행결과에 따라 화면 선택
			if(result == 3) {
				//성공
				//마이페이지
				req.getSession().setAttribute("alertMsg","비밀번호 변경 성공!");
				req.getSession().invalidate();
				resp.sendRedirect("/gibuAndTakePrj");
			}else {
				//실패
				//에러페이지
				req.getSession().setAttribute("alertMsg","비밀번호 변경 실패...");
				req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
			}
		}
}
