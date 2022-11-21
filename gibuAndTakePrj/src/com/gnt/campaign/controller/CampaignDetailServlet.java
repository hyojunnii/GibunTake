package com.gnt.campaign.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.campaign.service.CampaignService;
import com.gnt.campaign.vo.CampaignProofVo;
import com.gnt.campaign.vo.CampaignVo;

@WebServlet(urlPatterns = "/view/campaign_detail")
public class CampaignDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		
		CampaignVo campaignvo = new CampaignService().selectDetail(num);
		List<CampaignProofVo> proofvo = new CampaignService().selectProof(num);
		
		System.out.println(proofvo);
		req.getSession().setAttribute("campaignvo", campaignvo);
		req.setAttribute("proofvo", proofvo);
		
		
		
		
		req.getRequestDispatcher("/views/select_campaign/campaign_detail.jsp").forward(req, resp);
	}
}
