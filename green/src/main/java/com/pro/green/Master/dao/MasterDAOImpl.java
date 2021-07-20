package com.pro.green.Master.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.green.Master.vo.CouponVO;
import com.pro.green.product_M.vo.Criteria;

@Repository("masterDAO")
public class MasterDAOImpl implements MasterDAO {

	@Autowired
	private SqlSession sqlSession;

	public List<Map<String, Object>> selectCouponList(Criteria cri) throws DataAccessException {
		List<Map<String, Object>> result = sqlSession.selectList("mapper.master.selectCouponList", cri);
		return result;
	}

	// �������
	public int couponAdd(CouponVO coupon) throws DataAccessException {
		int result = sqlSession.insert("mapper.master.couponAdd", coupon);
		return result;
	}

	// ����Ʈ ����
	public int listCount() throws DataAccessException {
		int result = sqlSession.selectOne("mapper.master.listCount");
		return result;
	}

	// ���� ��뿩�� ����
	public int useYNChk(Map<String, Object> paramMap) throws DataAccessException {
		int result = sqlSession.update("mapper.master.useYNChk", paramMap);
		return result;
	}

	// ���� �˻�
	public List<Map<String, Object>> searchCouponList(Map<String, Object> searchOption) throws DataAccessException{
		List<Map<String, Object>> result = sqlSession.selectList("mapper.master.searchCouponList", searchOption);
		return result;
	}
}
