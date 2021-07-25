package com.pro.green.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.green.board.vo.ArticleVO2;

@Repository("boardDAO2")
public class BoardDAOImpl2 implements BoardDAO2 {
	@Autowired
	private SqlSession sqlSession;

	public List<ArticleVO2> selectList(Map<String, Object> selectOption) throws DataAccessException {
		List<ArticleVO2> result = sqlSession.selectList("mapper.board2.selectList", selectOption);

		List<Map<String, Object>> images = new ArrayList<Map<String, Object>>();

		// 리뷰과 Qna 시에만 실행
		if (selectOption.get("type").equals("qna") || selectOption.get("type").equals("review")) {
			for (int i = 0; i < result.size(); i++) {
				String productId = result.get(i).getProductId();

				if(productId != null) {
					images = sqlSession.selectList("mapper.board2.selectImge", productId);
	
					String imgURL = (String) images.get(0).get("imgURL");
					String p_group = (String) images.get(0).get("p_group");
	
					result.get(i).setImgURL(imgURL);
					result.get(i).setP_group(p_group);
				}
			}
		}
		return result;
	}

	// 상품검색
	public List<Map<String, Object>> productSearch(String keyWord) throws DataAccessException {
		List<Map<String, Object>> result = sqlSession.selectList("mapper.board2.productSearch", keyWord);
		return result;
	}

	// 글 등록
	public int insertArticle(Map<String, Object> selectOption) throws DataAccessException {
		int result = sqlSession.insert("mapper.board2.insertArticle", selectOption);
		return result;
	}
	
	// 글조회
		public ArticleVO2 selectCommunity(Map<String, Object> selectOption) throws DataAccessException{
			ArticleVO2 result = sqlSession.selectOne("mapper.board2.selectCommunity", selectOption);
			
			String name = result.getProductId();
			
			if(name != null) {
				
				String productName = sqlSession.selectOne("mapper.board2.selectProductName", name);
				result.setProductName(productName);
			}
			
			return result;
		}

}
