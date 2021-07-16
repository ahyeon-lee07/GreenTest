package com.pro.green.product.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product_M.vo.ProductVO2;


public interface ProductDAO {
	
	// 상품 목록
	public List<ProductVO2> selectAllProductsList(String p_group) throws DataAccessException;
	
	// 상품 상세페이지
	
<<<<<<< HEAD
	// 상품 이름&가격
=======
	// 상품명&가격
>>>>>>> branch 'hw' of https://github.com/ahyeon-lee07/GreenTest.git
	public ProductVO2 viewProdDetail(String productId) throws DataAccessException;

	public Map<String, Object> selectProdDetail(Map<String, Object> map) throws DataAccessException;
	
	// 상품 옵션
	public List<Map<String, Object>> selectProdOption(String productId) throws DataAccessException;

	// 상품 이미지
	public List<Map<String, Object>> selectProdImg(String productId) throws DataAccessException;
<<<<<<< HEAD
=======

>>>>>>> branch 'hw' of https://github.com/ahyeon-lee07/GreenTest.git

}