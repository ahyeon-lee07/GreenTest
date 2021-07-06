package com.pro.green.product.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.green.product.vo.ProductVO2;

@Repository("productDAO")
public class ProductDAOImpl2 implements ProductDAO2 {
	@Autowired
	private SqlSession sqlSession;

	// ȸ�� ����
	@Override
	public int insertProduct(ProductVO2 product) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.insertProduct", product);
		return result;
	}
	
	// ����� ��ǰ ���̵� ��������
	public String selectProductId(ProductVO2 product) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.product.selectProductId", product);
		return result;
	}
	
	//��ǰ �ɼǵ��
	public int insertProductOption(Map<String, Object> paramMap) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.insertProductOption", paramMap);
		return result;
	}
}