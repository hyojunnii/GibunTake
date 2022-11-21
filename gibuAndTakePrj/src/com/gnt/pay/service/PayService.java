package com.gnt.pay.service;

import java.sql.Connection;
import java.util.List;

import static com.gnt.common.JDBCTemplate.*;

import com.gnt.pay.repository.PaymentDao;
import com.gnt.pay.vo.PayListVo;
import com.gnt.pay.vo.PaymentVo;

public class PayService {
	
	private final PaymentDao dao = new PaymentDao();

	public List<PaymentVo> callPaymentList(int no) {
		List<PaymentVo> result = null;
		
		Connection conn = null;
		
		conn = getConnection();
		result = dao.callPaymentList(conn, no);
	
		close(conn);
		
		return result;
	}

	public int insertPayList(PayListVo payListVo) {
		int result = 0;
		
		Connection conn = null;
		
		conn = getConnection();
		result = dao.insertPayList(conn, payListVo);
	
		close(conn);
		
		return result;
	}

	

	

}
