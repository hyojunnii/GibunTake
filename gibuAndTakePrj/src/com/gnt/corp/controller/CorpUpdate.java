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

@WebServlet(urlPatterns="/corp/corpUpdate")
public class CorpUpdate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		corpVo loginCorp = (corpVo)req.getSession().getAttribute("loginCorp");

		if(loginCorp != null) {
			req.getRequestDispatcher("/views/corparation/corpUpdate.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "로그인 후 접근 가능합니다!");
			resp.sendRedirect(req.getContextPath());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		//데이터 받기 -> 객체
		String rprName = req.getParameter("rprName");
		String corpName = req.getParameter("corpName");
		String corpPhone = req.getParameter("corpPhone");
		String corpEmail = req.getParameter("corpEmail");
		String corpAddr = req.getParameter("corpAddr");
		String corpContent = req.getParameter("corpContent");
	
		
		int no = ((corpVo)req.getSession().getAttribute("loginCorp")).getNo();
		
		corpVo vo = new corpVo();
		
		vo.setNo(no);
		vo.setName(rprName);
		vo.setNick(corpName);
		vo.setPhone(corpPhone);
		vo.setEmail(corpEmail);
		vo.setAddr(corpAddr);
		vo.setContent(corpContent);
	
		//서비스 호출(객체)
		corpVo updateVo = new corpService().corpUpdate(vo);
		
		//실행결과에 따라 화면 선택
		if(updateVo != null) {
			//성공 화면
			req.getSession().setAttribute("loginCorp", updateVo);
			req.getSession().setAttribute("alertMsg", "회원 정보 수정 완료!");
			resp.sendRedirect("/gibuAndTakePrj/");
		}else {
			//로그인 실패
			req.setAttribute("errorMsg", "로그인 실패!");
			req.getRequestDispatcher("/gibuAndTakePrj/views/error/errorPage.jsp").forward(req, resp);
		}
	}

}
