package com.gnt.corp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.corp.service.corpService;
import com.gnt.corp.vo.corpVo;
import com.gnt.member.service.MemberService;
import com.gnt.member.vo.MemberVo;

@WebServlet(urlPatterns= "/corp/Join")
public class corpJoinController extends HttpServlet {
	
	/*
	 * 회원가입 화면 보여주기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//다른애한테 떠넘기기
		req.getRequestDispatcher("/views/corparation/corpJoin.jsp").forward(req, resp);
		
	}
	
	/*
	 * 회원가입 처리
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String corpId = req.getParameter("corpId");
		String corpPwd = req.getParameter("corpPwd");
		String rprName = req.getParameter("rprName");
		String corpName = req.getParameter("corpName");
		String compNum= req.getParameter("compNum");
		String corpPhone = req.getParameter("corpPhone");
		String corpEmail = req.getParameter("corpEmail");
		String corpAddr = req.getParameter("corpAddr");
		String corpType = req.getParameter("corpType");
		String corpText = req.getParameter("corpText");
		
		corpVo cvo = new corpVo();
		
		cvo.setId(corpId);
		cvo.setPwd(corpPwd);
		cvo.setName(rprName);
		cvo.setNick(corpName);
		cvo.setRegnum(compNum);
		cvo.setPhone(corpPhone);
		cvo.setEmail(corpEmail);
		cvo.setAddr(corpAddr);
		cvo.setContent(corpText);
		cvo.setClasss(corpType);
		
		//객체 이용해서 회원가입 진행
		int result = new corpService().corpjoin(cvo);
		
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


