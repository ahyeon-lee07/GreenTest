package com.pro.green.board.service;

import java.util.List;
import java.util.Map;

import com.pro.green.board.vo.ArticleVO;
import com.pro.green.board.vo.ArticleVO2;

public interface BoardService2 {

	public List<ArticleVO2> selectList(Map<String, Object> selectOption) throws Exception;

	//��ǰ�˻�
	public List<Map<String, Object>> productSearch(String keyWord) throws Exception;

	//�� ���
	public int insertArticle(Map<String, Object> selectOption) throws Exception;

	//����ȸ
	public ArticleVO2 selectCommunity(Map<String, Object> selectOption) throws Exception;

	
}