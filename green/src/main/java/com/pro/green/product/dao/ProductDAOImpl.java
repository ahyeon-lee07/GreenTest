package com.pro.green.product.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.green.board.dao.BoardDAO;
import com.pro.green.board.vo.ArticleVO;
import com.pro.green.product.vo.ProductVO;


@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ProductVO> selectAllProductsList() throws DataAccessException {
		List<ProductVO> productsList = sqlSession.selectList("mapper.product.selectAllProductsList");
		return productsList;
	}

}

