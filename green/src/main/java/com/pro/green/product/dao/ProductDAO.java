package com.pro.green.product.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.product_M.vo.ProductVO2;


public interface ProductDAO {
	
	// ��ǰ ���
	public List<ProductVO2> selectAllProductsList(String p_group) throws DataAccessException;
	
	// ��ǰ ��������
	

	// ��ǰ �̸�&����
	public ProductVO2 viewProdDetail(String productId) throws DataAccessException;

	public Map<String, Object> selectProdDetail(Map<String, Object> map) throws DataAccessException;
	
	// ��ǰ �ɼ�
	public List<Map<String, Object>> selectProdOption(String productId) throws DataAccessException;

	// ��ǰ �̹���
	public List<Map<String, Object>> selectProdImg(String productId) throws DataAccessException;

	//��ǰ����
	public List<ProductVO2> prodArray(Map<String, Object> prodArray) throws DataAccessException;

	// ����ȭ�� �Ż�ǰ 10��
	public List<ProductVO2> newProductList() throws DataAccessException;

	// ����ȭ�� ����Ʈ��ǰ 10��
	public List<ProductVO2> bestProductList() throws DataAccessException;

	// ���λ�ǰ 10��
	public List<ProductVO2> discountProductList() throws DataAccessException;


}