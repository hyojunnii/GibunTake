package com.gnt.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.manager.service.ManagerService;
import com.gnt.manager.vo.ManagerVo;

@WebServlet(urlPatterns = "/manager/list")
public class ManagerList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/manager/managerList.jsp").forward(req, resp);
	}
	
	
}
