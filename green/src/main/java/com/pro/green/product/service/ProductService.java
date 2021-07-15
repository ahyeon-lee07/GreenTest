package com.pro.green.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product_M.vo.ProductVO2;

public interface ProductService {
	
	public List<ProductVO2> listProduct(String p_group) throws Exception;
	
	public List<Map<String, Object>> selectProdOption(String productId) throws DataAccessException;
	
	public ProductVO2 viewProdDetail(String productId) throws DataAccessException;
	
	public Map<String, Object> selectProdDetail(Map<String, Object> map) throws DataAccessException;
	
	public List<Map<String, Object>> selectProdImg(String productId) throws DataAccessException;
	
}