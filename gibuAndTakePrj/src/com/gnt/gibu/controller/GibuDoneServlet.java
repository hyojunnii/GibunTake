package com.gnt.gibu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.gibu.service.GibuService;
import com.gnt.gibu.vo.GibuVo;

@WebServlet(urlPatterns = "/view/gibu_done")
public class GibuDoneServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String paratype = req.getParameter("type");	
		if(paratype ==null) {
			paratype = "0";
		}
		int type = Integer.parseInt(paratype);
		
		List<GibuVo> gibuvo = new GibuService().selectDoneList(type);
		int gibucnt = new GibuService().getListDoneCount(type);
		// System.out.println(gibuvo);
		req.setAttribute("regtype", type);
		req.setAttribute("gibuvo", gibuvo);
		req.setAttribute("gibucnt", gibucnt);
		

		
		req.getRequestDispatcher("/views/select_gibu/gibu_finish.jsp").forward(req, resp);
	}
}
