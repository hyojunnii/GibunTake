package com.gnt.manager.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import static com.gnt.common.JDBCTemplate.*;
import com.gnt.manager.vo.ManagerVo;

public class ManagerDao {

	public ManagerVo login(Connection conn, ManagerVo vo) throws Exception{
		
		ManagerVo loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Manager WHERE MN_ID = ? AND MN_PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			 	int no = rs.getInt("MN_NO");
				String id = rs.getString("MN_ID");
				String nick = rs.getString("MN_NICK");
				
				
				loginMember = new ManagerVo();
				loginMember.setNo(no);
				loginMember.setId(id);
				loginMember.setNick(nick);
		}
			
		}finally {
			close(pstmt);
			close(rs);
		}
		return loginMember;
	}

}
