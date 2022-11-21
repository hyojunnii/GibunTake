package com.gnt.main.service;

import static com.gnt.common.JDBCTemplate.*;

import java.sql.Connection;

import com.gnt.main.repository.MainDao;
import com.gnt.main.vo.TodayStoryVo;

public class MainService {

	//오늘의 참여현황
	public TodayStoryVo todayStory(String today) {
		TodayStoryVo todayVo = null;
		
		Connection conn = getConnection();
		
		todayVo = new MainDao().todayDonationStory(conn, today);
		
		if(todayVo != null) {
			todayVo = new MainDao().todayFundingStory(conn, today, todayVo);
		}
		close(conn);
		return todayVo;
	}
}
