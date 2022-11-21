package com.gnt.member.service;

import static com.gnt.common.JDBCTemplate.*;

import java.sql.Connection;

import com.gnt.corp.vo.corpVo;
import com.gnt.member.repository.MemberDao;
import com.gnt.member.vo.MemberVo;

public class MemberService {

	public MemberVo login(MemberVo vo) {


		Connection conn = null;
		MemberVo loginMember = null;
		try {
			conn = getConnection();

			//SQL 실행결과 리턴
			loginMember = new MemberDao().login(conn, vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginMember;

	}

	public int memberjoin(MemberVo vo) {

		//id 유효성 검사 (4글자 이상인지)

		if(vo.getId().length() < 4) {
			// 회원가입 불가. 다음단계 진행 x 
			return -1;
		}

		//pwd 검사 (4글자 이상인지)
		if(vo.getPwd().length() < 4) {
			// 회원가입 불가. 다음단계 진행 x 
			return -2;
		}

		//아이디 중복 검사

		//vo 를 DB에 insert 

		//커넥션 준비
		Connection conn = null;
		int result = 0;
		try {
			conn = getConnection(); 

			result = new MemberDao().memberjoin(vo, conn);

			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}

		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}



		return result;
	}

	public int memberSelect(MemberVo vo) {

		int result = 0;
		Connection conn = null;


		try {
			conn = getConnection();

			result = new MemberDao().memberSelect(vo, conn);

			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}


		return result;
	}



	public MemberVo memberUpdate(MemberVo vo) {
		//비지니스 로직 (자바 || SQL)


		Connection conn = null;
		int result = 0;
		MemberVo updateVo = null;

		try {

			conn = getConnection();
			result = new MemberDao().memberUpdate(conn, vo);

			//트랜잭션 처리 (commit || rollback)
			if(result == 1) {
				commit(conn);
				//다시한번 회원정보 조회 (회원번호)
				updateVo = selectOneByNo(vo.getNo());
			}else {
				rollback(conn);
			}

		}catch(Exception e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			close(conn);
		}


		//실행결과 리턴
		return updateVo;
	}

	private MemberVo selectOneByNo(int no) {
		Connection conn = null;
		MemberVo vo = null;

		try {
			conn = getConnection();
			vo = new MemberDao().selectOneByNo(conn,no);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}


		return vo;
	}

	public int quit(int no) {
		int result = 0;
		Connection conn = getConnection();

		result = MemberDao.quit(conn, no);

		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int changePwd(String memberId, String memberPwd, String memberPwdNew, String memberPwdNew2) {



		if(memberPwdNew.equals(memberPwdNew2) == false) {
			return -1;
		}

		if(memberPwdNew.length() < 4) {
			return -2;
		}


		Connection conn = null;
		int result = 0;

		try {
			//DAO 호출 (SQL 실행)
			conn = getConnection();
			result = new MemberDao().changePwd(conn,memberId, memberPwd, memberPwdNew);


			if(result == 3) {
				commit(conn);
			}else {
				rollback(conn);
			}

		}catch(Exception e) {
			rollback(conn);
		}finally {
			close(conn);
		}

		return result;
	
	}



	public int checkId(String memberId) {

		int result = 0;

		Connection conn = getConnection();

		result = MemberDao.checkId(conn, memberId);

		if(result == 1) { commit(conn); } else { rollback(conn); }
		close(conn);

		return result;

	}

	public MemberVo idSearch(String name, String email) {

		MemberVo searchId = null;
		Connection conn = null;
		
		try {
			conn = getConnection();

			searchId = new MemberDao().idSearch(conn, name, email);

			if(searchId != null) {
				commit(conn);
			}else {
				rollback(conn);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}

		return searchId;
	}
	
	public MemberVo pwdSearch(String id, String email) {

		MemberVo searchPwd = null;
		Connection conn = null;
		
		try {
			conn = getConnection();

			searchPwd = new MemberDao().pwdSearch(conn, id, email);

			if(searchPwd != null) {
				commit(conn);
			}else {
				rollback(conn);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}

		return searchPwd;
	}
	
}















