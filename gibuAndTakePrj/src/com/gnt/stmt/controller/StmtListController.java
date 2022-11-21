package com.gnt.stmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.corp.vo.corpVo;
import com.gnt.member.vo.MemberVo;
import com.gnt.stmt.service.StmtService;
import com.gnt.stmt.vo.ExeVo;
import com.gnt.stmt.vo.StmtVo;

@WebServlet(urlPatterns = "/corp/stmtList")
public class StmtListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		corpVo loginCorp = (corpVo) req.getSession().getAttribute("loginCorp");
		
		ArrayList<StmtVo> donaResult = new StmtService().showDona(loginCorp);
		ArrayList<ExeVo> exeTest = new StmtService().showExeTest(donaResult);
		
//		System.out.println(donaResult);
//
//		String donaNo = null;
//		ArrayList<ExeVo> exeResult = null;
//		
//		for(int i = 0; i < donaResult.size(); ++i) {
//			donaNo = donaResult.get(i).getDonaNo();
//			exeResult = new StmtService().showExe(donaNo);
//		}
		
//		System.out.println(donaNo);
		System.out.println(exeTest);
		
		req.setAttribute("donaResult", donaResult);
		req.setAttribute("exeResult", exeTest);			
		req.getRequestDispatcher("/views/user2/corpStatementList.jsp").forward(req, resp);						
	}
	
}
