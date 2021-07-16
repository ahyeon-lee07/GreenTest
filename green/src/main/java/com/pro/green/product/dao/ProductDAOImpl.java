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
import com.pro.green.product_M.vo.ProductVO2;


@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;

	// ��ǰ ���
	@Override
	public List<ProductVO2> selectAllProductsList(String p_group) throws DataAccessException {
		List<ProductVO2> productsList = sqlSession.selectList("mapper.product.selectAllProductsList", p_group);
		return productsList;
	}
	
	// ��ǰ ��������
	
	// ��ǰ��&����
	@Override
	public ProductVO2 viewProdDetail(String productId) throws DataAccessException {
		ProductVO2 prodDetail = sqlSession.selectOne("mapper.product.selectProduct", productId);
		return prodDetail;
	}
	
	@Override
	public Map<String, Object> selectProdDetail(Map<String, Object> map) throws DataAccessException {
		Map<String, Object> result = sqlSession.selectMap(null, null);
		return result;
	}
	
	// ��ǰ �ɼ�
	@Override
	public List<Map<String, Object>> selectProdOption(String productId) throws DataAccessException {
		List<Map<String, Object>> prodOption = sqlSession.selectList("mapper.product.selectOptionList", productId);
		return prodOption;
	}

	// ��ǰ �̹���
	@Override
	public List<Map<String, Object>> selectProdImg(String productId) throws DataAccessException {
		List<Map<String, Object>> prodImg = sqlSession.selectList("mapper.product.selectProductImg", productId);
		return prodImg;
	}

}

