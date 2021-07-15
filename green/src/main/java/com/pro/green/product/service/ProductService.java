package com.pro.green.product.service;

import java.util.List;
import java.util.Map;

import com.pro.green.product_M.vo.ProductVO2;

public interface ProductService {
	
	public List<ProductVO2> listProduct(String p_group) throws Exception;
	
	public ProductVO2 viewProduct(String productId) throws Exception;
	
}