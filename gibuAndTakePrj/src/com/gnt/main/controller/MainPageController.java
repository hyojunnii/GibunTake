package com.gnt.main.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.main.service.MainService;
import com.gnt.main.vo.TodayStoryVo;

@WebServlet(urlPatterns = "/main")
public class MainPageController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//오늘의 참여현황
		Date date = new Date();
		SimpleDateFormat dbFormat = new SimpleDateFormat("yy/MM/dd");
		SimpleDateFormat todayFormat = new SimpleDateFormat("yyyy.MM.dd");
		
		String today = dbFormat.format(date);
		String voToday = todayFormat.format(date);
	
		TodayStoryVo todayStory = new MainService().todayStory(today);
		
		if(todayStory != null) {
			todayStory.setToday(voToday);
		}
		
		req.setAttribute("todayStory", todayStory);
		req.getRequestDispatcher("/views/main/mainPage.jsp").forward(req, resp);
	}
}
