package com.gnt.member.repository;

import static com.gnt.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.gnt.member.vo.MemberVo;

public class MemberDao {

	public MemberVo login(Connection conn ,MemberVo vo) throws Exception {

		MemberVo loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//SQL 준비
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ? AND M_PWD = ? AND M_DEL = 'N'";

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

				loginMember = new MemberVo();

				loginMember.setNo(no);
				loginMember.setClas(m);
				loginMember.setRegnum(num);
				loginMember.setName(name);
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setNick(nick);
				loginMember.setEmail(email);
				loginMember.setAddr(addr);
				loginMember.setPhone(phone);
				loginMember.setDate(enrolDate);
				loginMember.setDel(delete);
				loginMember.setBan(ban);
				loginMember.setMod(modifyDate);

			}
		}
		finally {
			//자원 반납
			close(pstmt);
			close(rs);
		}

		//만들어진 객체 리턴
		return loginMember;

	}

	public int memberjoin(MemberVo vo, Connection conn) throws Exception {


		PreparedStatement pstmt = null;
		int result = 0;

		try {

			//SQL 준비
			String sql = "INSERT INTO MEMBER( M_NO , M_CLASS , M_REGNUM , M_NAME , M_ID , M_PWD , M_NICK , M_EMAIL , M_ADD , M_PHONE ) VALUES ( SEQ_MEMBER_M_NO.NEXTVAL , 1, ?, ?, ?, ?, ?, ?, ?, ?)";

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

	public int memberSelect(MemberVo vo, Connection conn) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;

		try {

			//SQL 준비
			String sql = "SELECT M_ID, M_NAME, M_REGNUM, M_PHONE, M_EMAIL, M_ADD  FROM MEMBER WHERE M_ID= ? AND M_NAME = ? AND M_REGNUM = ? AND M_PHONE = ? AND M_EMAIL = ? AND M_ADD = ?";

			//SQL 객체에 담기
			pstmt = conn.prepareStatement(sql);

			//SQL 객체에 담고, SQL 완성하기
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getRegnum());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getAddr());


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

	public int memberUpdate(Connection conn, MemberVo vo) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			//SQL 준비
			String sql = "UPDATE MEMBER SET M_NICK = ? , M_PHONE = ? , M_EMAIL = ? , M_ADD= ?, M_NAME = ?, M_MOD = SYSDATE WHERE M_NO = ?";

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

	public MemberVo selectOneByNo(Connection conn, int number) {
		//connection 준비

		//SQL 준비
		String sql = "SELECT * FROM MEMBER WHERE M_NO = ? AND M_DEL = 'N'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;


		try {

			//SQL 객체에 담기 및 쿼리 완성
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, number);

			//SQL 실행 및 결과저장

			rs = pstmt.executeQuery();


			//ResultSet -> 자바객체(MemberVo)

			if(rs.next()) {

				int no = rs.getInt("M_NO");
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

				vo = new MemberVo();

				vo.setNo(no);
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




	public static int checkId(Connection conn,String memberId) {


		PreparedStatement pstmt = null;
		int idCheck = 0;
		ResultSet rs = null;

		String sql = "SELECT * FROM MEMBER WHERE M_ID = ?";


		try {
			pstmt = conn.prepareStatement(sql);


			pstmt.setString(1 , memberId);
			rs = pstmt.executeQuery();

			if(rs.next() || memberId.equals("")) {
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
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			close(pstmt);
		}

		//실행결과 리턴
		return result;
	}

	public MemberVo idSearch(Connection conn, String name ,String email) throws Exception {
		
		MemberVo searchId = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//SQL 준비
		String sql = "SELECT * FROM MEMBER WHERE M_NAME = ? AND M_EMAIL = ? AND M_DEL = 'N'";

		try {
			//SQL 객체에 담고, 물음표 채우기
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);

			//SQL 실행 및 결과저장
			rs = pstmt.executeQuery();

			//rs 에서 데이터 꺼내서 객체로 만들기
			if(rs.next()) {
				String id = rs.getString("M_ID");									

				searchId = new MemberVo();

				searchId.setId(id);

			}
		}
		finally {
			//자원 반납
			close(pstmt);
			close(rs);
		}

		//만들어진 객체 리턴
		return searchId;
	}
	
public MemberVo pwdSearch(Connection conn, String id ,String email) throws Exception {
		
		MemberVo searchPwd = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//SQL 준비
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ? AND M_EMAIL = ? AND M_DEL = 'N'";

		try {
			//SQL 객체에 담고, 물음표 채우기
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);

			//SQL 실행 및 결과저장
			rs = pstmt.executeQuery();

			//rs 에서 데이터 꺼내서 객체로 만들기
			if(rs.next()) {
				String pwd = rs.getString("M_PWD");									

				searchPwd = new MemberVo();

				searchPwd.setPwd(pwd);
			}
		}
		finally {
			//자원 반납
			close(pstmt);
			close(rs);
		}

		//만들어진 객체 리턴
		return searchPwd;
	}
}







