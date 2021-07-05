package com.pro.green.product.dao;

import org.springframework.dao.DataAccessException;

import com.pro.green.product.vo.ProductVO2;

public interface ProductDAO2 {
	public int insertProduct(ProductVO2 product) throws DataAccessException;

}
