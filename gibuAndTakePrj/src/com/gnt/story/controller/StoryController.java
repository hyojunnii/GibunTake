package com.gnt.story.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.review.service.ReviewService;
import com.gnt.review.vo.ReviewVo;
import com.gnt.story.service.StoryService;
import com.gnt.story.vo.StoryVo;

@WebServlet(urlPatterns = "/story")
public class StoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StoryVo vo = new StoryVo();
		vo = new StoryService().callPageData(vo);
		
		List<ReviewVo> boardVoList = new StoryService().selectList();
		
		req.setAttribute("storyVo", vo);
		req.setAttribute("boardVoList", boardVoList);
		req.getRequestDispatcher("views/story/storyView.jsp").forward(req, resp);
	}
}
