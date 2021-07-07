package com.pro.green.product.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.product.vo.ProductVO2;
import com.pro.green.product.dao.ProductDAO2;

@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl2 implements ProductService2 {

	@Autowired
	private ProductDAO2 productDAO;
	
	
	// 상품등록
	@Override
	public int addProductEdit(ProductVO2 product) throws DataAccessException {
		return productDAO.insertProduct(product);
	}
	
	// 등록한 상품 아이디 가져오기
	public String selectProductId(ProductVO2 product) throws DataAccessException {
		return productDAO.selectProductId(product);
	}
	
	//옵션 등록
	public int addProductOption(Map<String, Object> paramMap) throws DataAccessException {
		return productDAO.insertProductOption(paramMap);
	}
	
	//상품 이미지 등록
	public int addProductImg(Map<String, Object> imageMap) throws DataAccessException{
		return productDAO.insertProductImg(imageMap);
	}
}
