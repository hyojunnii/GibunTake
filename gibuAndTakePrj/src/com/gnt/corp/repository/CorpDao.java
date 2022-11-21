package com.gnt.corp.repository;

import static com.gnt.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.gnt.corp.vo.corpVo;
import com.gnt.member.vo.MemberVo;

public class CorpDao {

	public int memberjoin(corpVo vo, Connection conn) throws Exception {


		PreparedStatement pstmt = null;
		int result = 0;

		try {

			//SQL 준비
			String sql = "INSERT INTO MEMBER( M_NO , M_CLASS , M_REGNUM , M_NAME , M_ID , M_PWD , M_NICK , M_EMAIL , M_ADD , M_PHONE ) VALUES ( SEQ_MEMBER_M_NO.NEXTVAL , 2, ?, ?, ?, ?, ?, ?, ?, ?)";

			//SQL 객체에 담기
			pstmt = conn.prepareStatement(sql);

			//SQL 객체에 담고, SQL 완성하기
			pstmt.setString(1, vo.getRegnum());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());
			pstmt.setString(4, vo.getPwd());
			pstmt.setString(5, vo.getNick());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getAddr());
			pstmt.setString(8, vo.getPhone());

			//SQL 실행 및 실행결과 받기
			result = pstmt.executeUpdate();


		} catch (Exception e) {
			//롤백해야함
			throw e;
		} finally {
			//다 쓴 자원 정리하기
			close(pstmt);
		}
		return result;

	}

	public int corpjoin(corpVo vo, Connection conn) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;

		try {

			//SQL 준비
			String sql = "INSERT INTO corporation (CORP_NO, M_NO, CORP_CONTENT, CORP_CLASS) VALUES (SEQ_CORPORATION_CORP_NO.NEXTVAL, SEQ_MEMBER_M_NO.CURRVAL, ?, ?)";

			//SQL 객체에 담기
			pstmt = conn.prepareStatement(sql);

			//SQL 객체에 담고, SQL 완성하기
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, vo.getClasss());

			//SQL 실행 및 실행결과 받기
			result = pstmt.executeUpdate();


		} catch (Exception e) {
			//롤백해야함
			throw e;
		} finally {
			//다 쓴 자원 정리하기
			close(pstmt);
		}
		return result;

	}


	public corpVo login(Connection conn, corpVo vo) throws Exception {

		corpVo loginCorp = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//SQL 준비
		String sql = "SELECT * FROM MEMBER M JOIN CORPORATION C USING (M_NO) WHERE M.M_ID = ? AND M.M_PWD = ? AND M.M_CLASS = '2' AND M.M_DEL = 'N'";

		try {
			//SQL 객체에 담고, 물음표 채우기
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());

			//SQL 실행 및 결과저장
			rs = pstmt.executeQuery();

			//rs 에서 데이터 꺼내서 객체로 만들기
			if(rs.next()) {
				int no = rs.getInt("M_NO");
				int cno = rs.getInt("CORP_NO");
				int m = rs.getInt("M_CLASS");
				String num = rs.getString("M_REGNUM");
				String name = rs.getString("M_NAME");									
				String id = rs.getString("M_ID");
				String pwd = rs.getString("M_PWD");
				String nick = rs.getString("M_NICK");
				String email = rs.getString("M_EMAIL");
				String addr = rs.getString("M_ADD");
				String phone = rs.getString("M_PHONE");
				Timestamp enrolDate = rs.getTimestamp("M_DATE");
				String delete = rs.getString("M_DEL");
				String ban = rs.getString("M_BAN");
				Timestamp modifyDate = rs.getTimestamp("M_MOD");
				String content = rs.getString("CORP_CONTENT");
				String classs = rs.getString("CORP_CLASS");

				loginCorp = new corpVo();
				
				loginCorp.setNo(no);
				loginCorp.setCno(cno);
				loginCorp.setClas(m);
				loginCorp.setRegnum(num);
				loginCorp.setName(name);
				loginCorp.setId(id);
				loginCorp.setPwd(pwd);
				loginCorp.setNick(nick);
				loginCorp.setEmail(email);
				loginCorp.setAddr(addr);
				loginCorp.setPhone(phone);
				loginCorp.setDate(enrolDate);
				loginCorp.setDel(delete);
				loginCorp.setBan(ban);
				loginCorp.setMod(modifyDate);
				loginCorp.setContent(content);
				loginCorp.setClasss(classs);
				
			}
		}
		finally {
			//자원 반납
			close(pstmt);
			close(rs);
		}

		//만들어진 객체 리턴
		return loginCorp;

	}	
	public int corpSelect(corpVo cvo, Connection conn) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;

		try {

			//SQL 준비
			String sql = "SELECT * FROM MEMBER M JOIN CORPORATION C USING (M_NO) WHERE M.M_ID = ? AND M.M_PWD = ? AND M.M_CLASS = '2' AND M.M_DEL = 'N'";

			//SQL 객체에 담기
			pstmt = conn.prepareStatement(sql);

			//SQL 객체에 담고, SQL 완성하기
			pstmt.setString(1, cvo.getId());
			pstmt.setString(2, cvo.getPwd());
			pstmt.setString(3, cvo.getName());
			pstmt.setString(4, cvo.getNick());
			pstmt.setString(5, cvo.getRegnum());
			pstmt.setString(6, cvo.getPhone());
			pstmt.setString(7, cvo.getEmail());
			pstmt.setString(8, cvo.getAddr());
			pstmt.setString(9, cvo.getClasss());
			pstmt.setString(10, cvo.getContent());


			//SQL 실행 및 실행결과 받기
			result = pstmt.executeUpdate();


		} catch (Exception e) {
			//롤백해야함
			throw e;
		} finally {
			//다 쓴 자원 정리하기
			close(pstmt);
		}
		return result;
	}
	
	public int memberUpdate(Connection conn, corpVo vo) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			//SQL 준비
			String sql = "UPDATE MEMBER SET M_NICK = ? , M_PHONE = ? , M_EMAIL = ? , M_ADD= ? , M_NAME = ?, M_MOD = SYSDATE WHERE M_NO = ?";

			//SQL 객체에 담기
			pstmt = conn.prepareStatement(sql);
			
			//SQL 객체에 담고, SQL 완성하기
			pstmt.setString(1, vo.getNick());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getName());
			pstmt.setInt(6, vo.getNo());

			//SQL 실행 및 실행결과 받기
			result = pstmt.executeUpdate();


		} catch (Exception e) {
			//롤백해야함
			throw e;
		} finally {
			//다 쓴 자원 정리하기
			close(pstmt);
		}
		return result;
	}
	
	public int corpUpdate(Connection conn, corpVo vo) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;

		try {

			//SQL 준비
			String sql = "UPDATE CORPORATION SET CORP_CONTENT = ?  WHERE M_NO = ?";
			
			//SQL 객체에 담기
			pstmt = conn.prepareStatement(sql);
			
			//SQL 객체에 담고, SQL 완성하기
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getNo());
			
			//SQL 실행 및 실행결과 받기
			result = pstmt.executeUpdate();
	
		} catch (Exception e) {
			//롤백해야함
			throw e;
		} finally {
			//다 쓴 자원 정리하기
			close(pstmt);
		}
		return result;
		}

	
	public corpVo selectOneByNo(Connection conn, int number) {
		//connection 준비
		
		//SQL 준비
		String sql = "SELECT * FROM MEMBER M , CORPORATION C WHERE M.M_NO = C.M_NO AND M.M_NO = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		corpVo vo = null;
		
		
		try {
			
			//SQL 객체에 담기 및 쿼리 완성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			
			//SQL 실행 및 결과저장
		
			rs = pstmt.executeQuery();
		
			//ResultSet -> 자바객체(MemberVo)
		
			if(rs.next()) {
				
				int no = rs.getInt("M_NO");
				int cNo = rs.getInt("CORP_NO");
				int m = rs.getInt("M_CLASS");
				String num = rs.getString("M_REGNUM");
				String name = rs.getString("M_NAME");									
				String id = rs.getString("M_ID");
				String pwd = rs.getString("M_PWD");
				String nick = rs.getString("M_NICK");
				String email = rs.getString("M_EMAIL");
				String addr = rs.getString("M_ADD");
				String phone = rs.getString("M_PHONE");
				Timestamp enrolDate = rs.getTimestamp("M_DATE");
				String delete = rs.getString("M_DEL");
				String ban = rs.getString("M_BAN");
				Timestamp modifyDate = rs.getTimestamp("M_MOD");
				String content = rs.getString("CORP_CONTENT");
				String clss = rs.getString("CORP_CLASS");
				
				
				vo = new corpVo();
				
				vo.setNo(no);
				vo.setCno(cNo);
				vo.setClas(m);
				vo.setRegnum(num);
				vo.setName(name);
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setNick(nick);
				vo.setEmail(email);
				vo.setAddr(addr);
				vo.setPhone(phone);
				vo.setDate(enrolDate);
				vo.setDel(delete);
				vo.setBan(ban);
				vo.setMod(modifyDate);
				vo.setContent(content);
				vo.setClasss(clss);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		//SQL 실행결과(자바객체) 리턴
		return vo;
	}

	public int changePwd(Connection conn, String memberId, String memberPwd, String memberPwdNew) throws Exception{
		//connection 준비
		
		//sql 준비
		String sql = "UPDATE MEMBER SET M_PWD = ? WHERE M_ID = ? AND M_PWD = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//sql 객체에 담기 및 sql 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberPwdNew);
			pstmt.setString(2, memberId);
			pstmt.setString(3, memberPwd);
			
			//sql 실행 및 결과저장
			result = pstmt.executeUpdate();
			//실행결과 -> 자바에서 사용가능하게 변경
			//실행결과 리턴
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			close(pstmt);
		}
	
		//실행결과 리턴
		return result;
	}

	public static int quit(Connection conn, int no) {
		
		String sql = "UPDATE MEMBER SET M_DEL='Y' WHERE M_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public static int checkId(Connection conn,String corpId) {
		
		
		PreparedStatement pstmt = null;
		int idCheck = 0;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ?";
		

		try {
				pstmt = conn.prepareStatement(sql);
			
				
				pstmt.setString(1 , corpId);
				rs = pstmt.executeQuery();
			
				if(rs.next() || corpId.equals("")) {
					idCheck = 0;
				}else {
					idCheck = 1;
				}
				}catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
			}
				return idCheck;
		}
	
}


