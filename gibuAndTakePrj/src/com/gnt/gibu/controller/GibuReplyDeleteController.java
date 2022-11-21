package com.gnt.gibu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.common.ReplyVo;
import com.gnt.gibu.service.GibuService;

@WebServlet(urlPatterns = "/view/gibuDetail/del")
public class GibuReplyDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		
		
		int result = new GibuService().GibuReplyDel(num);
		
		if(result == 1) {
			//성공
			req.getSession().setAttribute("alertMsg", "댓글 삭제 완료! 목록으로 이동합니다.");
			resp.sendRedirect(req.getContextPath()+ "/view/gibu");
		}else {
			//실패
//			req.setAttribute("errorMsg", "공지사항 수정 실패...");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
	}
}
