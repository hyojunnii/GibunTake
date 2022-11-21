package com.gnt.stmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.corp.vo.corpVo;
import com.gnt.stmt.service.StmtService;
import com.gnt.stmt.vo.ExeVo;
import com.gnt.stmt.vo.StmtVo;

@WebServlet (urlPatterns = "/corp/stmtRe")
public class StmtReController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		corpVo loginCorp = (corpVo) req.getSession().getAttribute("loginCorp");
		
		String donaNo = req.getParameter("donaNo");
		
		StmtVo donaVo = new StmtService().showReDona(donaNo);
		ArrayList<ExeVo> exeVo = new StmtService().showExe(donaNo);
		req.setAttribute("donaVo", donaVo);
		req.setAttribute("exeVo", exeVo);
		req.getRequestDispatcher("/views/user2/corpStatementRe.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		corpVo c = (corpVo) req.getSession().getAttribute("loginCorp");
		
		req.setCharacterEncoding("UTF-8");
		
		String donaNo = req.getParameter("donaNo");
		String[] exeCnt = req.getParameterValues("exeCnt");
		String[] exeMoney = req.getParameterValues("exeMoney");
		int result = 0;
		
		ExeVo vo = new ExeVo();
		for(int i = 0; i < exeCnt.length; ++i) {
			vo.setDonaNo(donaNo);
			vo.setExeCnt(exeCnt[i]);
			vo.setExeMoney(exeMoney[i]);
			result = new StmtService().insert(vo, c);
		}
		
		if(result == 1) {
			resp.sendRedirect("/gibuAndTakePrj/corp/stmtList");
		}else {
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
	}
}
