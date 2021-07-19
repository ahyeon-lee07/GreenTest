package com.pro.green.Master.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.Master.dao.MasterDAO;
import com.pro.green.Master.vo.CouponVO;
import com.pro.green.product_M.vo.Criteria;

@Service("masterService")
@Transactional(propagation = Propagation.REQUIRED)
public class MasterServiceImpl implements MasterService {

	@Autowired
	private MasterDAO masterDAO;

	public List<Map<String, Object>> selectCouponList(Criteria cri) throws DataAccessException {
		return masterDAO.selectCouponList(cri);
	}

	// 쿠폰등록
	public int couponAdd(CouponVO coupon) throws DataAccessException {
		return masterDAO.couponAdd(coupon);
	}

	// 리스트 개수
	public int listCount() throws DataAccessException {
		return masterDAO.listCount();
	}

	// 쿠폰 사용여부 변경
	public int useYNChk(Map<String, Object> paramMap) throws DataAccessException {
		return masterDAO.useYNChk(paramMap);
	}
}
