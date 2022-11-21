package com.gnt.campaignproof.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.campaignproof.service.CampaignProofService;

@WebServlet(urlPatterns = "/campaign/proof/ban")
public class CampaignProofBanController extends HttpServlet {
	//캠페인 인증 삭제
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//등록번호, 댓글번호 가져오기
		com.gnt.campaign.vo.CampaignVo vo = (com.gnt.campaign.vo.CampaignVo)req.getSession().getAttribute("campaignvo");
		int regNo = Integer.parseInt(vo.getRegno());
		int cpNo = Integer.parseInt(req.getParameter("cno"));
		
		int result = new CampaignProofService().proofBan(cpNo);
		
		//알림 + 상세페이지
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "신고가 접수되었습니다.");
			resp.sendRedirect(req.getContextPath() + "/view/campaign_detail?type=0&num=" + regNo);
		} else {
			req.getSession().setAttribute("alertMsg", "신고에 실패하였습니다.");
			resp.sendRedirect(req.getContextPath() + "/view/campaign_detail?type=0&num=" + regNo);
		}
	}
}

