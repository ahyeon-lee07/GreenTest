package com.pro.green.product.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product.vo.ProductVO;


public interface ProductDAO {
	public List<ProductVO> selectAllProductsList() throws DataAccessException;

}