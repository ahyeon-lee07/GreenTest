package com.pro.green.Master.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.Master.vo.CouponVO;
import com.pro.green.product_M.vo.Criteria;

public interface MasterService {

	public List<Map<String, Object>> selectCouponList(Criteria cri) throws DataAccessException;

	//�������
	public int couponAdd(CouponVO coupon) throws DataAccessException;

	//����Ʈ ����
	public int listCount() throws DataAccessException;

	//���� ��뿩�� ����
	public int useYNChk(Map<String, Object> paramMap) throws DataAccessException;

}
