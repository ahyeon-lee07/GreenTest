package com.pro.green.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.green.product.vo.Criteria;
import com.pro.green.product.vo.ProductVO2;

@Repository("productDAO")
public class ProductDAOImpl2 implements ProductDAO2 {
	@Autowired
	private SqlSession sqlSession;

	// ȸ�� ����
	@Override
	public int insertProduct(ProductVO2 product) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.insertProduct", product);
		return result;
	}

	// ����� ��ǰ ���̵� ��������
	public String selectProductId(ProductVO2 product) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.product.selectProductId", product);
		return result;
	}

	// ��ǰ �ɼǵ��
	public int insertProductOption(Map<String, Object> paramMap) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.insertProductOption", paramMap);
		return result;
	}

	// ��ǰ �̹��� ���
	public int insertProductImg(Map<String, Object> imageMap) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.insertProductImg", imageMap);
		return result;
	}

	// ������ ��ǰ ����Ʈ ��ȸ
	public List<Map<String, Object>> selectBoardList(Criteria cri) throws DataAccessException {
		List<Map<String, Object>> result = sqlSession.selectList("mapper.product.selectBoardList", cri);
		return result;
	}

	// ������ ��ǰ ����Ʈ ��ȸ (����)
	public List<Map<String, Object>> selectFilterBoardList(Map<String, Object> paramMap) throws DataAccessException {
		List<Map<String, Object>> result = sqlSession.selectList("mapper.product.selectFilterBoardList", paramMap);
		return result;
	}

	// ������ ��ǰ ����Ʈ ���� ��ȸ
	public int countBoardListTotal() throws DataAccessException {
		int result = sqlSession.selectOne("mapper.product.countBoardList");
		return result;
	}

	// ������ ��ǰ ����Ʈ �ɼ� ��ȸ
	public List<Map<String, Object>> selectOptionLIst(String productId) throws DataAccessException {
		List<Map<String, Object>> result = sqlSession.selectList("mapper.product.selectOptionLIst", productId);
		return result;
	}

	public ProductVO2 viewProductDetail(String productId) throws DataAccessException {
		ProductVO2 result = sqlSession.selectOne("mapper.product.selectProduct", productId);
		return result;
	}

	public Map<String, Object> selectProductDetail(Map<String, Object> map) throws DataAccessException {
		Map<String, Object> result = sqlSession.selectMap(null, null);
		return result;
	}

	public int updateProduct(ProductVO2 product) throws DataAccessException {
		int result = sqlSession.update("mapper.product.updateProduct", product);
		return result;
	}

	public int deleteProductOption(String productId) throws DataAccessException {
		int result = sqlSession.delete("mapper.product.deleteProductOption", productId);
		return result;
	}

	public int deleteProductImge(Map<String, Object> imageMap) throws DataAccessException {
		int result = sqlSession.delete("mapper.product.deleteProductImge", imageMap);
		return result;
	}

	// ������ ��ǰ ����
	public int deleteProduct(String productId) throws DataAccessException {
		int result = sqlSession.delete("mapper.product.deleteProduct", productId);
		return result;
	}

	// ��ǰ �̹��� ��ȸ
	public List<Map<String, Object>> selectProductImg(String productId) throws DataAccessException {
		List<Map<String, Object>> result = sqlSession.selectList("mapper.product.selectProductImg", productId);
		return result;
	}

	// ������ ��ǰ ����Ʈ �˻�
	public List<Map<String, Object>> searchSelectBoardList(Map<String, Object> paramMap) throws DataAccessException{
		List<Map<String, Object>> result = sqlSession.selectList("mapper.product.searchSelectBoardList", paramMap);
		return result;
	}

	public List<Map<String, Object>> searchSelectFilterBoardList(Map<String, Object> paramMap) throws DataAccessException{
		List<Map<String, Object>> result = sqlSession.selectList("mapper.product.searchSelectFilterBoardList", paramMap);
		return result;
	}
}