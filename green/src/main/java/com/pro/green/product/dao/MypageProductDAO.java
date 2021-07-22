package com.pro.green.product.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product.vo.CartVO;

public interface MypageProductDAO {

	// ���ɻ�ǰ ����Ʈ
	public List<Map<String, Object>> wishList(Map<String, Object> selectOption) throws DataAccessException;

	// ���ɻ�ǰ ����
	public int wishDelete(String productId) throws DataAccessException;

}
