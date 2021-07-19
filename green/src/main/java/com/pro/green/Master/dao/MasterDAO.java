package com.pro.green.Master.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.Master.vo.CouponVO;
import com.pro.green.product_M.vo.Criteria;

public interface MasterDAO {

	public List<Map<String, Object>> selectCouponList(Criteria cri) throws DataAccessException;

	//ÄíÆùµî·Ï
	public int couponAdd(CouponVO coupon) throws DataAccessException;

}
