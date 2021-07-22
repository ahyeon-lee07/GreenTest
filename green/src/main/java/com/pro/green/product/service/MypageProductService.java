package com.pro.green.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product.vo.CartVO;

public interface MypageProductService {

	//관심상품 리스트
	public List<Map<String, Object>> wishList(Map<String, Object> selectOption) throws DataAccessException;

}
