package com.gnt.gibu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.common.ReplyVo;
import com.gnt.gibu.service.GibuService;

@WebServlet(urlPatterns = "/view/gibuDetail/ban")
public class GibuReplyBanController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}
}
