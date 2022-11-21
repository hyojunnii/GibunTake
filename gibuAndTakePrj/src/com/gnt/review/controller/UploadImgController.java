package com.gnt.review.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import com.gnt.review.service.UploadImgService;
import com.gnt.review.vo.ReviewImgVo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


@WebServlet(urlPatterns = "/uploadSummernoteImageFile")
public class UploadImgController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("file"));
		String reviewNo = (String)req.getSession().getAttribute("CreateReviewNo");
		Part f = req.getPart("file");
		
		
		
		String savePath = null;
		if(f.getSubmittedFileName().length()!=0) {
			
		String originName = f.getSubmittedFileName();//원본 파일명
		
		InputStream is = f.getInputStream();//인풋 스트림 준비
		BufferedInputStream bis = new BufferedInputStream(is);
		
		
		//아웃풋 스트림 준비
		String realPath = req.getServletContext().getRealPath("/resources/upload");
		String changeName = new UploadImgService().createChangeName(originName);
		savePath = realPath+File.separator+changeName;
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
		
		Gson gson = new Gson();
		
		ReviewImgVo vo = new ReviewImgVo();
		
		vo.setRevNo(reviewNo);
		vo.setUrl(savePath);
		vo.setResponseCode("success");
		
		int result = new UploadImgService().UploadImg(vo);
		
		
		
		String jsonResult = gson.toJson(vo);
		
		resp.getWriter().write(jsonResult);
		}
		
		
	}
}
