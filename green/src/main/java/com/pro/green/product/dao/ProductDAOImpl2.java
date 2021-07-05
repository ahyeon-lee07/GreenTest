package com.pro.green.product.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.green.product.vo.ProductVO2;

@Repository("productDAO")
public class ProductDAOImpl2 implements ProductDAO2 {
	@Autowired
	private SqlSession sqlSession;

	// 회원 가입
	@Override
	public int insertProduct(ProductVO2 product) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.insertProduct", product);
		return result;
	}
}
