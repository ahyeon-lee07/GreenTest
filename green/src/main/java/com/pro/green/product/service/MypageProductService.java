package com.pro.green.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product.vo.CartVO;

public interface MypageProductService {

	//���ɻ�ǰ ����Ʈ
	public List<Map<String, Object>> wishList(Map<String, Object> selectOption) throws DataAccessException;

}
