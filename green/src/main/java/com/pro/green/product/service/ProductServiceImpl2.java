package com.pro.green.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.product.vo.Criteria;
import com.pro.green.product.vo.ProductVO2;
import com.pro.green.product.dao.ProductDAO2;

@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl2 implements ProductService2 {

	@Autowired
	private ProductDAO2 productDAO;

	// 상품등록
	@Override
	public int addProductEdit(ProductVO2 product) throws DataAccessException {
		return productDAO.insertProduct(product);
	}

	// 등록한 상품 아이디 가져오기
	public String selectProductId(ProductVO2 product) throws DataAccessException {
		return productDAO.selectProductId(product);
	}

	// 옵션 등록
	public int addProductOption(Map<String, Object> paramMap) throws DataAccessException {
		return productDAO.insertProductOption(paramMap);
	}

	// 상품 이미지 등록
	public int addProductImg(Map<String, Object> imageMap) throws DataAccessException {
		return productDAO.insertProductImg(imageMap);
	}

	// 관리자 상품 리스트 조회
	public List<Map<String, Object>> selectBoardList(Criteria cri) throws DataAccessException {
		return productDAO.selectBoardList(cri);
	}

	// 관리자 상품 리스트 조회 (필터)
	public List<Map<String, Object>> selectFilterBoardList(Map<String, Object> paramMap) throws DataAccessException {
		return productDAO.selectFilterBoardList(paramMap);
	}

	// 관리자 상품 리스트 개수
	public int countBoardListTotal() throws DataAccessException {
		return productDAO.countBoardListTotal();
	}

	// 관리자 상품 리스트 옵션
	public List<Map<String, Object>> selectOptionLIst(String productId) throws DataAccessException {
		return productDAO.selectOptionLIst(productId);
	}

//	테스트-------------
	public ProductVO2 viewProductDetail(String productId) throws DataAccessException {
		return productDAO.viewProductDetail(productId);
	}

	public Map<String, Object> selectProductDetail(Map<String, Object> map) throws DataAccessException {
		return productDAO.selectProductDetail(map);
	}

	public int updateProduct(ProductVO2 product) throws DataAccessException {
		return productDAO.updateProduct(product);
	}

	public int deleteProduct(String productId) throws DataAccessException {
		return productDAO.deleteProduct(productId);
	}

	// 옵션 삭제
	public int deleteProductOption(String productId) throws DataAccessException {
		return productDAO.deleteProductOption(productId);
	}

	// 이미지 삭제
	public int deleteProductImge(Map<String, Object> imageMap) throws DataAccessException {
		return productDAO.deleteProductImge(imageMap);
	}

	// 상품 이미지조회
	public List<Map<String, Object>> selectProductImg(String productId) throws DataAccessException {
		return productDAO.selectProductImg(productId);
	}
}
