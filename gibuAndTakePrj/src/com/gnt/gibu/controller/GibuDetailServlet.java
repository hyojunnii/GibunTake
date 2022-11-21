package com.gnt.gibu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.common.ReplyVo;
import com.gnt.gibu.service.GibuService;
import com.gnt.gibu.vo.GibuVo;

@WebServlet(urlPatterns = "/view/gibu_detail")
public class GibuDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int type = Integer.parseInt(req.getParameter("type"));
		int num = Integer.parseInt(req.getParameter("num"));
		
		
		
		GibuVo gibuvo = new GibuService().selectDetail(type, num);
		List<ReplyVo> replyvo = new GibuService().selectReply(type, num);
		req.getSession().setAttribute("gibuvo", gibuvo);
		req.setAttribute("replyvo", replyvo);
		
		req.getRequestDispatcher("/views/select_gibu/gibu_detail.jsp").forward(req, resp);
	}
}
