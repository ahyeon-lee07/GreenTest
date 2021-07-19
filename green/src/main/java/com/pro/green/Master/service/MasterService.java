package com.pro.green.Master.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.Master.vo.CouponVO;
import com.pro.green.product_M.vo.Criteria;

public interface MasterService {

	public List<Map<String, Object>> selectCouponList(Criteria cri) throws DataAccessException;

	//쿠폰등록
	public int couponAdd(CouponVO coupon) throws DataAccessException;

	//리스트 개수
	public int listCount() throws DataAccessException;

	//쿠폰 사용여부 변경
	public int useYNChk(Map<String, Object> paramMap) throws DataAccessException;

}
