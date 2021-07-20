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
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product_M.vo.Criteria;

@Service("masterService")
@Transactional(propagation = Propagation.REQUIRED)
public class MasterServiceImpl implements MasterService {

	@Autowired
	private MasterDAO masterDAO;

	public List<Map<String, Object>> selectCouponList(Criteria cri) throws DataAccessException {
		return masterDAO.selectCouponList(cri);
	}

	// �������
	public int couponAdd(CouponVO coupon) throws DataAccessException {
		return masterDAO.couponAdd(coupon);
	}

	// ����Ʈ ����
	public int listCount() throws DataAccessException {
		return masterDAO.listCount();
	}

	// ���� ��뿩�� ����
	public int useYNChk(Map<String, Object> paramMap) throws DataAccessException {
		return masterDAO.useYNChk(paramMap);
	}

	// ���� �˻�
	public List<Map<String, Object>> searchCouponList(Map<String, Object> searchOption) throws DataAccessException {
		return masterDAO.searchCouponList(searchOption);
	}

	// �������� ��ȸ
	public CouponVO selectCoupon(String productId) throws DataAccessException {
		return masterDAO.selectCoupon(productId);
	}

	// ȸ�� ����Ʈ
	public List<Map<String, Object>> memberList() throws DataAccessException {
		return masterDAO.memberList();
	}

	// ���� ���� ����Ʈ ��ȸ
	public List<Map<String, Object>> hasCouponList(String couponId) throws DataAccessException {
		return masterDAO.hasCouponList(couponId);
	}
}
