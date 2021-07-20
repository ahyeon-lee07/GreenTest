package com.pro.green.Master.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.Master.vo.CouponVO;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product_M.vo.Criteria;

public interface MasterService {

	public List<Map<String, Object>> selectCouponList(Criteria cri) throws DataAccessException;

	//�������
	public int couponAdd(CouponVO coupon) throws DataAccessException;

	//����Ʈ ����
	public int listCount() throws DataAccessException;

	//���� ��뿩�� ����
	public int useYNChk(Map<String, Object> paramMap) throws DataAccessException;

	//���� �˻�
	public List<Map<String, Object>> searchCouponList(Map<String, Object> searchOption) throws DataAccessException;

	//�������� ��ȸ
	public CouponVO selectCoupon(String productId) throws DataAccessException;

	//ȸ�� ����Ʈ 
	public List<Map<String, Object>> memberList() throws DataAccessException;

	//���� ���� ����Ʈ ��ȸ
	public List<Map<String, Object>> hasCouponList(String couponId) throws DataAccessException;

	//���� ���� ����
	public int couponUpdate(CouponVO coupon) throws DataAccessException;

}
