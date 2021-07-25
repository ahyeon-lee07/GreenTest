package com.pro.green.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.board.vo.ArticleVO;
import com.pro.green.board.vo.ArticleVO2;


public interface BoardDAO2 {

	public List<ArticleVO2> selectList(Map<String, Object> selectOption) throws DataAccessException;

	// 상품검색
	public List<Map<String, Object>> productSearch(String keyWord) throws DataAccessException;

	// 글 등록
	public int insertArticle(Map<String, Object> selectOption) throws DataAccessException;

	// 글조회
	public ArticleVO2 selectCommunity(Map<String, Object> selectOption) throws DataAccessException;

	
}