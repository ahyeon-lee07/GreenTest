package com.pro.green.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product.vo.Criteria;
import com.pro.green.product.vo.ProductVO2;

public interface ProductDAO2 {
	public int insertProduct(ProductVO2 product) throws DataAccessException;
	public String selectProductId(ProductVO2 product) throws DataAccessException;
	public int insertProductOption(Map<String, Object> paramMap) throws DataAccessException;
	public int insertProductImg(Map<String, Object> imageMap) throws DataAccessException;
	
	public List<Map<String, Object>> selectBoardList(Criteria cri) throws DataAccessException;
	public int countBoardListTotal() throws DataAccessException;
	public List<Map<String,Object>> selectOptionLIst(String productId) throws DataAccessException;
}
