package com.pro.green.product.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product_M.vo.ProductVO2;


public interface ProductDAO {
	
	// ��ǰ ���
	public List<ProductVO2> selectAllProductsList(String p_group) throws DataAccessException;
	
	// ��ǰ ��������
	
<<<<<<< HEAD
	// ��ǰ �̸�&����
=======
	// ��ǰ��&����
>>>>>>> branch 'hw' of https://github.com/ahyeon-lee07/GreenTest.git
	public ProductVO2 viewProdDetail(String productId) throws DataAccessException;

	public Map<String, Object> selectProdDetail(Map<String, Object> map) throws DataAccessException;
	
	// ��ǰ �ɼ�
	public List<Map<String, Object>> selectProdOption(String productId) throws DataAccessException;

	// ��ǰ �̹���
	public List<Map<String, Object>> selectProdImg(String productId) throws DataAccessException;
<<<<<<< HEAD
=======

>>>>>>> branch 'hw' of https://github.com/ahyeon-lee07/GreenTest.git

}