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
	
	public List<Map<String, Object>> selectCouponList(Criteria cri) throws DataAccessException{
		return masterDAO.selectCouponList(cri);
	}
	
	//ÄíÆùµî·Ï
	public int couponAdd(CouponVO coupon) throws DataAccessException {
		return masterDAO.couponAdd(coupon);
	}
}
