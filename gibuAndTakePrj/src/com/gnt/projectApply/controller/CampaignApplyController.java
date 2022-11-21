package com.gnt.projectApply.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.gnt.corp.vo.corpVo;
import com.gnt.member.vo.MemberVo;
import com.gnt.project.vo.CampaignVo;
import com.gnt.project.vo.RegistVo;
import com.gnt.projectApply.service.ProjectApplyService;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50, //50mb
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
@WebServlet(urlPatterns = "/pm/apply/campaign")
public class CampaignApplyController extends HttpServlet{
	//캠페인 신청 페이지
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/pm/campaignApplyForm.jsp").forward(req, resp);
	}
	
	//캠페인 신청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//등록 Vo
		String regCategory = "캠페인";
		corpVo covo = (corpVo)req.getSession().getAttribute("loginCorp");
		String corpNo = Integer.toString(covo.getNo());
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String fDate = req.getParameter("fDate");
		
		RegistVo rvo = new RegistVo();
		rvo.setCategory(regCategory);
		rvo.setmNo(corpNo);
		rvo.setTitle(title);
		rvo.setContent(content);
		rvo.setfDate(fDate);
		
		//캠페인 Vo
		String gPeople = req.getParameter("gPeople");
		
		CampaignVo cvo = new CampaignVo();
		cvo.setgPeople(gPeople);
		
		//파일 Vo
		Part file = req.getPart("file");
		String savePath = "";
		String changeName = "";
		if(file.getSubmittedFileName().length() > 0) {
			String originName = file.getSubmittedFileName();
			changeName = new ProjectApplyService().createChangeName(originName);
			
			InputStream is = file.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			String realPath = req.getServletContext().getRealPath("/resources/upload");
			savePath = realPath + File.separator + changeName;
			FileOutputStream os = new FileOutputStream(savePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = bis.read(buf)) != -1) {
				bos.write(buf, 0, size);
			}
			
			bos.flush();
			bis.close();
			bos.close();
		}
		
		int result = new ProjectApplyService().campaignApply(rvo, cvo, changeName);
		
		if(result == 1) {
			//성공시 메인신청페이지
			req.getSession().setAttribute("alertMsg", "캠페인프로젝트 신청 성공!");
			resp.sendRedirect(req.getContextPath() + "/pm/apply/main");
		} else {
			//실패시 기존화면
			req.getSession().setAttribute("alertMsg", "캠페인프로젝트 신청 실패");
			resp.sendRedirect(req.getContextPath() + "/pm/apply/campaign");
		}
	}
}
