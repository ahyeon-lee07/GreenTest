package com.pro.green.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product.vo.Criteria;
import com.pro.green.product.vo.ProductVO2;

public interface ProductService2 {
	public int addProductEdit(ProductVO2 product) throws DataAccessException;
	public String selectProductId(ProductVO2 product) throws DataAccessException;
	public int addProductOption(Map<String, Object> paramMap) throws DataAccessException;
	public int addProductImg(Map<String, Object> imageMap) throws DataAccessException;
	
	public List<Map<String, Object>> selectBoardList(Criteria cri) throws DataAccessException;
	public int countBoardListTotal() throws DataAccessException;
	public List<Map<String,Object>> selectOptionLIst(String productId) throws DataAccessException;
	
//	Å×½ºÆ®-------------
	public ProductVO2 viewProductDetail(String productId) throws DataAccessException;
	public Map<String, Object> selectProductDetail(Map<String, Object> map) throws DataAccessException;
	public int updateProduct(ProductVO2 product) throws DataAccessException;
	public List<Map<String,Object>> selectProductImg(String productId) throws DataAccessException;
	public int deleteProduct(String productId) throws DataAccessException;
	public int deleteProductOption(String productId) throws DataAccessException;
	public int deleteProductImge(Map<String, Object> imageMap) throws DataAccessException;
}
