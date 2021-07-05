package com.pro.green.product.service;

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
}
