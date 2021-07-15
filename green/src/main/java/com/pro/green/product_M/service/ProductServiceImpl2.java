package com.pro.green.product_M.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.product_M.dao.ProductDAO2;
import com.pro.green.product_M.vo.Criteria;
import com.pro.green.product_M.vo.ProductVO2;

@Service("productService_M")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl2 implements ProductService2 {

	@Autowired
	private ProductDAO2 productDAO;

	// ��ǰ���
	@Override
	public int addProductEdit(ProductVO2 product) throws DataAccessException {
		return productDAO.insertProduct(product);
	}

	// ����� ��ǰ ���̵� ��������
	public String selectProductId(ProductVO2 product) throws DataAccessException {
		return productDAO.selectProductId(product);
	}

	// �ɼ� ���
	public int addProductOption(Map<String, Object> paramMap) throws DataAccessException {
		return productDAO.insertProductOption(paramMap);
	}

	// ��ǰ �̹��� ���
	public int addProductImg(Map<String, Object> imageMap) throws DataAccessException {
		return productDAO.insertProductImg(imageMap);
	}

	// ������ ��ǰ ����Ʈ ��ȸ
	public List<Map<String, Object>> selectBoardList(Criteria cri) throws DataAccessException {
		return productDAO.selectBoardList(cri);
	}

	// ������ ����Ʈ���� Ȱ��ȭ ���� ����
	public int showYNChk(Map<String, Object> paramMap) throws DataAccessException {
		return productDAO.showYNChk(paramMap);
	}

	// ������ ��ǰ ����Ʈ ��ȸ (����)
	public List<Map<String, Object>> selectFilterBoardList(Map<String, Object> paramMap) throws DataAccessException {
		return productDAO.selectFilterBoardList(paramMap);
	}

	// ������ ��ǰ ����Ʈ ����
	public int countBoardListTotal() throws DataAccessException {
		return productDAO.countBoardListTotal();
	}

	public int filterCountBoardListTotal(String options) throws DataAccessException {
		return productDAO.filterCountBoardListTotal(options);
	}

	// ������ ��ǰ ����Ʈ �ɼ�
	public List<Map<String, Object>> selectOptionLIst(String productId) throws DataAccessException {
		return productDAO.selectOptionLIst(productId);
	}

	// ������ ��ǰ ��������
	public ProductVO2 viewProductDetail(String productId) throws DataAccessException {
		return productDAO.viewProductDetail(productId);
	}

	// ������ ��ǰ ��������
	public Map<String, Object> selectProductDetail(Map<String, Object> map) throws DataAccessException {
		return productDAO.selectProductDetail(map);
	}

	public int updateProduct(ProductVO2 product) throws DataAccessException {
		return productDAO.updateProduct(product);
	}

	public int deleteProduct(String productId) throws DataAccessException {
		return productDAO.deleteProduct(productId);
	}

	// �ɼ� ����
	public int deleteProductOption(String productId) throws DataAccessException {
		return productDAO.deleteProductOption(productId);
	}

	// �̹��� ����
	public int deleteProductImge(Map<String, Object> imageMap) throws DataAccessException {
		return productDAO.deleteProductImge(imageMap);
	}

	// ��ǰ �̹�����ȸ
	public List<Map<String, Object>> selectProductImg(String productId) throws DataAccessException {
		return productDAO.selectProductImg(productId);
	}

	// ������ ��ǰ ����Ʈ �˻�
	public List<Map<String, Object>> searchSelectBoardList(Map<String, Object> paramMap) throws DataAccessException {
		return productDAO.searchSelectBoardList(paramMap);
	}

	// ������ ��ǰ ����Ʈ �˻�
	public List<Map<String, Object>> searchSelectFilterBoardList(Map<String, Object> paramMap)
			throws DataAccessException {
		return productDAO.searchSelectFilterBoardList(paramMap);
	}
}