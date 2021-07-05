package com.pro.green.product.service;

import org.springframework.dao.DataAccessException;

import com.pro.green.product.vo.ProductVO2;

public interface ProductService2 {
	public int addProductEdit(ProductVO2 product) throws DataAccessException;
}
