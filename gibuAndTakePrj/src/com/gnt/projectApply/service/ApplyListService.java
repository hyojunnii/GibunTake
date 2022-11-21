package com.gnt.projectApply.service;

import java.sql.Connection;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.common.PageVo;
import com.gnt.project.vo.RegistVo;
import com.gnt.projectApply.repository.ApplyListDao;

public class ApplyListService {
	
	private final ApplyListDao dao = new ApplyListDao();

	public List<RegistVo> getList(PageVo pageVo, int mno) {
		
		List<RegistVo> applyList = null;
		
		Connection conn = getConnection();
		
		applyList = dao.getList(conn, pageVo, mno);
		
		close(conn);
		
		return applyList;
	}

}
