package com.gnt.corp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.corp.service.corpService;
import com.gnt.member.repository.MemberDao;
import com.gnt.member.service.MemberService;


@WebServlet(urlPatterns="/corp/idCheck")
public class CorpIdCheck extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/corp/corpJoin.jsp").forward(req, resp);
	}




		@Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String checkId = req.getParameter("corpId");
		System.out.println(checkId);
		
		PrintWriter out = resp.getWriter();
		
		int idCheck = new corpService().checkId(checkId);
		System.out.println(idCheck);

		out.write(idCheck + ""); 

	}


}
