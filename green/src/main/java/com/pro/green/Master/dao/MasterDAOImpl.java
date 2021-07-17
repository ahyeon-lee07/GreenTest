package com.pro.green.Master.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.green.product_M.vo.Criteria;

@Repository("masterDAO")
public class MasterDAOImpl implements MasterDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String, Object>> selectCouponList(Criteria cri) throws DataAccessException{
		List<Map<String, Object>> result = sqlSession.selectList("mapper.master.selectCouponList", cri);
		return result;
	}
}
