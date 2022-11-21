package com.gnt.manager.service;

import java.sql.Connection;

import static com.gnt.common.JDBCTemplate.*;
import com.gnt.manager.repository.ManagerDao;
import com.gnt.manager.vo.ManagerVo;

public class ManagerService {

	public ManagerVo login(ManagerVo vo) {
		Connection conn = null;
		ManagerVo loginMember = null;
		
		try {
			conn = getConnection();
			
			loginMember = new ManagerDao().login(conn, vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return loginMember;
	}

}
