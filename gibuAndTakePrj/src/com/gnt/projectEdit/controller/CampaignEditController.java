package com.gnt.projectEdit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.corp.vo.corpVo;
import com.gnt.project.vo.CampaignVo;
import com.gnt.project.vo.RegistVo;
import com.gnt.projectEdit.service.ProjectEditDataService;
import com.gnt.projectEdit.service.ProjectEditService;

@WebServlet(urlPatterns = "/pm/edit/campaign")
public class CampaignEditController extends HttpServlet{
	//캠페인수정페이지 데이터
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//등록번호, 사용자번호 받기
		com.gnt.campaign.vo.CampaignVo vo = (com.gnt.campaign.vo.CampaignVo)req.getSession().getAttribute("campaignvo");
		int regNo = Integer.parseInt(vo.getRegno());
		
		corpVo covo = (corpVo)req.getSession().getAttribute("loginCorp");
		int mNo = covo.getNo();
		
		CampaignVo cvo = new ProjectEditDataService().getCampaignEdit(regNo, mNo);
		
		if(cvo != null) {
			//수정 페이지
			req.getSession().setAttribute("editVo", cvo);
			req.getRequestDispatcher("/views/pm/campaignEditForm.jsp").forward(req, resp);
		} else {
			//상세페이지로 돌아가기
			req.getSession().setAttribute("alertMsg", "조회 실패..");
			resp.sendRedirect(req.getContextPath() + "/view/campaign_detail?type=0&num="+regNo);
		}
	}
	
	//캠페인프로젝트 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//등록 Vo
		RegistVo rvo = new RegistVo();
		
		CampaignVo vo = (CampaignVo)req.getSession().getAttribute("editVo");
		corpVo covo = (corpVo)req.getSession().getAttribute("loginCorp");
		String corpNo = Integer.toString(covo.getNo());
		String content = req.getParameter("content");
		String fDate = req.getParameter("fDate");
		
		rvo.setRegNo(vo.getRegNo());
		rvo.setmNo(corpNo);
		rvo.setContent(content);
		rvo.setfDate(fDate);
		
		//캠페인 Vo
		CampaignVo cvo = new CampaignVo();
		String gPeople = req.getParameter("gPeople");
		
		cvo.setCamNo(vo.getCamNo());
		cvo.setgPeople(gPeople);
		
		int result = new ProjectEditService().campaignEdit(rvo, cvo);
		
		if(result == 1) {
			//수정페이지로
			req.getSession().setAttribute("alertMsg", "프로젝트 수정 성공!");
			resp.sendRedirect(req.getContextPath() + "/pm/edit/campaign");
		} else {
			//상세페이지로
			req.getSession().setAttribute("alertMsg", "프로젝트 수정 실패");
			resp.sendRedirect(req.getContextPath() + "/view/campaign_detail?type=0&num="+vo.getRegNo());
		}
	}
}
