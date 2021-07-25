package com.pro.green.board.service;

import java.util.List;
import java.util.Map;

import com.pro.green.board.vo.ArticleVO;
import com.pro.green.board.vo.ArticleVO2;

public interface BoardService2 {

	public List<ArticleVO2> selectList(Map<String, Object> selectOption) throws Exception;

	//상품검색
	public List<Map<String, Object>> productSearch(String keyWord) throws Exception;

	//글 등록
	public int insertArticle(Map<String, Object> selectOption) throws Exception;

	//글조회
	public ArticleVO2 selectCommunity(Map<String, Object> selectOption) throws Exception;

	
}