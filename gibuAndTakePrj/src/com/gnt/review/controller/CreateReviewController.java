package com.gnt.review.controller;

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
import com.gnt.review.service.CreateReviewService;
import com.gnt.review.service.UploadImgService;
import com.gnt.review.vo.ReviewImgVo;
import com.gnt.review.vo.ReviewVo;

@MultipartConfig(
		maxFileSize = 1024*1024*200,
		maxRequestSize = 1024*1024*200*5
		)

@WebServlet(urlPatterns = "/review/create")
public class CreateReviewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String getCreateReviewNo = new CreateReviewService().getCreateReviewNo();
		
		req.getSession().setAttribute("CreateReviewNo", getCreateReviewNo);
		
		String category = req.getParameter("category");
		String regNo = req.getParameter("regNo");
		req.setAttribute("category", category);
		req.setAttribute("regNo", regNo);
		req.getRequestDispatcher("/views/review/createReview.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String revNo = (String)req.getSession().getAttribute("CreateReviewNo");
		String title = req.getParameter("title");
		
		String editordata = req.getParameter("editordata");
		String category = req.getParameter("category");
		if("기부".equals(category)) {
			category = "1";
		}else if("펀딩".equals(category)) {
			category = "3";
		}else if("캠페인".equals(category)) {
			category = "2";
		}
		
		String regNo = req.getParameter("regNo");
		System.out.println(regNo);
		String no = null;
		MemberVo m = null;
		corpVo c = null;
		if((MemberVo)req.getSession().getAttribute("loginMember")!=null) {
			m = (MemberVo)req.getSession().getAttribute("loginMember");
			no = Integer.toString(m.getNo());
		}else {
			c = (corpVo)req.getSession().getAttribute("loginCorp");
			no = Integer.toString(c.getNo());
		}
		
		Part f = req.getPart("f");
		
		req.getSession().removeAttribute("CreateReviewNo");
		
		ReviewImgVo imgVo =null;

		
		String savePath = null;
		if(f.getSubmittedFileName().length()!=0) {
			
			String originName = f.getSubmittedFileName();//원본 파일명
			
			InputStream is = f.getInputStream();//인풋 스트림 준비
			BufferedInputStream bis = new BufferedInputStream(is);
			
			
			//아웃풋 스트림 준비
			String realPath = req.getServletContext().getRealPath("/resources/upload");
			String changeName = new UploadImgService().createChangeName(originName);
			savePath = realPath+File.separator+changeName;
			System.out.println(savePath);
			FileOutputStream os = new FileOutputStream(savePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = bis.read(buf))!=-1) {
				bos.write(buf, 0, size);
			}
			
			
			bos.flush();
			bis.close();
			bos.close();
		
			imgVo = new ReviewImgVo();
			String[] strArr = savePath.split("\\\\");
			String[] relatePathArr = new String[3];
			relatePathArr[2] = strArr[strArr.length-1];
			relatePathArr[1] = strArr[strArr.length-2];
			relatePathArr[0] = strArr[strArr.length-3];
			String relatePath = req.getContextPath()+"/"+String.join("/", relatePathArr);
			System.out.println(relatePath);
			imgVo.setUrl(relatePath);
			imgVo.setRevNo(revNo);
		}
		
		ReviewVo reviewVo = new ReviewVo();
		reviewVo.setRevNo(revNo);
		reviewVo.setmNo(no);
		reviewVo.setRevName(title);
		reviewVo.setRevClass(category);
		reviewVo.setRevContent(editordata);
		System.out.println(category);
		int result = new UploadImgService().InsertReview(reviewVo,imgVo,regNo,category);
		if(result==1) {
			req.setAttribute("alertMsg", "후기 작성 성공");
			if("1".equals(category)) {
				resp.sendRedirect(req.getContextPath()+"/donate/review/list?p=1");
			}else if("2".equals(category)) {
				resp.sendRedirect(req.getContextPath()+"/campaign/review/list?p=1");
			}else if("3".equals(category)) {
				resp.sendRedirect(req.getContextPath()+"/funding/review/list?p=1");
			}
		}else {
			req.setAttribute("errorMsg", "로그인 실패!");
			req.getRequestDispatcher("/gibuAndTakePrj/views/error/errorPage.jsp").forward(req, resp);
		}
		
		
		
	}
}
