package com.pro.green.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.product.dao.ProductDAO;
import com.pro.green.product_M.vo.ProductVO2;

@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;
	
	// 상품 목록
	@Override
	public List<ProductVO2> listProduct(String p_group) throws Exception {
		List<ProductVO2> productsList = productDAO.selectAllProductsList(p_group);
		return productsList;
	}

	// 상품 상세페이지
	@Override
	public List<Map<String, Object>> selectProdOption(String productId) throws DataAccessException {
		return productDAO.selectProdOption(productId);
	}

	@Override
	public ProductVO2 viewProdDetail(String productId) throws DataAccessException {
		return productDAO.viewProdDetail(productId);
	}

	@Override
	public Map<String, Object> selectProdDetail(Map<String, Object> map) throws DataAccessException {
		return productDAO.selectProdDetail(map);
	}

	@Override
	public List<Map<String, Object>> selectProdImg(String productId) throws DataAccessException {
		return productDAO.selectProdImg(productId);
	}
}