package com.pro.green.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.board.vo.ArticleVO;
import com.pro.green.board.vo.ArticleVO2;


public interface BoardDAO2 {

	public List<ArticleVO2> selectList(Map<String, Object> selectOption) throws DataAccessException;

	// ��ǰ�˻�
	public List<Map<String, Object>> productSearch(String keyWord) throws DataAccessException;

	// �� ���
	public int insertArticle(Map<String, Object> selectOption) throws DataAccessException;

	// ����ȸ
	public ArticleVO2 selectCommunity(Map<String, Object> selectOption) throws DataAccessException;

	// �� ����
	public int updateArticle(Map<String, Object> selectOption) throws DataAccessException;

	// �� ����
	public int deleteArticle(Map<String, Object> selectOption) throws DataAccessException;

	// ���
	public List<Map<String, Object>> commentList(Map<String, Object> paramMap) throws DataAccessException;

	// ��� ��ȸ
	public List<Map<String, Object>> selectComment(Map<String, Object> paramMap) throws DataAccessException;

	// ��� ����
	public List<Map<String, Object>> DelectComment(Map<String, Object> paramMap) throws DataAccessException;

	
}