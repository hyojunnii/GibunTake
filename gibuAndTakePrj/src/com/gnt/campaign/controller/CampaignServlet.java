package com.gnt.campaign.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.campaign.service.CampaignService;
import com.gnt.campaign.vo.CampaignVo;

@WebServlet(urlPatterns = "/view/campaign")
public class CampaignServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CampaignVo> campaignvo =  new CampaignService().selectList();
		List<CampaignVo> campaignbannervo = new CampaignService().selectbanner();
		int campaigncnt =  new CampaignService().getListCount();
		
		req.setAttribute("campaignvo", campaignvo);
		req.setAttribute("campaignbannervo", campaignbannervo);
		req.setAttribute("campaigncnt", campaigncnt);
		
		
		req.getRequestDispatcher("/views/select_campaign/campaign_ing.jsp").forward(req, resp);
	}
}
