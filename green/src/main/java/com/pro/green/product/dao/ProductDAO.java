package com.pro.green.product.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product_M.vo.ProductVO2;


public interface ProductDAO {
	
	public List<ProductVO2> selectAllProductsList(String p_group) throws DataAccessException;;

	public ProductVO2 selectProduct(String productId) throws DataAccessException;

}