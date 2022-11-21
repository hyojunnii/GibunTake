package com.gnt.story.service;

import com.gnt.review.vo.ReviewVo;
import com.gnt.story.repository.StoryDao;
import com.gnt.story.vo.StoryVo;
import static com.gnt.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

public class StoryService {
	final StoryDao dao = new StoryDao();

	public StoryVo callPageData(StoryVo vo) {
		
		Connection conn = null;
		StoryVo result = new StoryVo();
		conn = getConnection();
		
		result = dao.returnTotal(conn, result);
		
		
		close(conn);
		
		return result;
		
	}

	public List<ReviewVo> selectList() {
		List<ReviewVo> result = null;
		Connection conn = null;
		
		conn = getConnection();
		result = dao.selectList(conn);
	
		close(conn);
			
		return result;
	}

}
