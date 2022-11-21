package com.gnt.projectApply.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gnt.common.JDBCTemplate;
import com.gnt.common.PageVo;
import com.gnt.project.vo.RegistVo;

public class ApplyListDao {

	public List<RegistVo> getList(Connection conn, PageVo pageVo, int mno) {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, RM.* FROM ( SELECT REG_NO, REG_CLASS, REG_NAME, REG_PASS, REG_DENY FROM REGIST WHERE M_NO = ? ORDER BY REG_NO DESC ) RM ) R WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegistVo> applyList = new ArrayList<RegistVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setInt(1, mno);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RegistVo rvo = new RegistVo();
				rvo.setRegNo(rs.getInt("REG_NO"));
				rvo.setCategory(rs.getString("REG_CLASS"));
				rvo.setTitle(rs.getString("REG_NAME"));
				rvo.setPass(rs.getString("REG_PASS"));
				rvo.setDeny(rs.getString("REG_DENY"));
				
				applyList.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return applyList;
	}

}
