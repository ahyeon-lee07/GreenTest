package com.pro.green.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.board.dao.BoardDAO2;
import com.pro.green.board.vo.ArticleVO2;

@Service("boardService2")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl2 implements BoardService2 {
	@Autowired
	BoardDAO2 boardDAO;

	public List<ArticleVO2> selectList(Map<String, Object> selectOption) throws Exception {
		return boardDAO.selectList(selectOption);
	}

	// ��ǰ�˻�
	public List<Map<String, Object>> productSearch(String keyWord) throws Exception {
		return boardDAO.productSearch(keyWord);
	}

	// �� ���
	public int insertArticle(Map<String, Object> selectOption) throws Exception {
		return boardDAO.insertArticle(selectOption);
	}

	// ����ȸ
	public ArticleVO2 selectCommunity(Map<String, Object> selectOption) throws Exception {
		return boardDAO.selectCommunity(selectOption);
	}

	// �� ����
	public int updateArticle(Map<String, Object> selectOption) throws Exception {
		return boardDAO.updateArticle(selectOption);
	}

	// �� ����
	public int deleteArticle(Map<String, Object> selectOption) throws Exception {
		return boardDAO.deleteArticle(selectOption);
	}

	// ���
	public List<Map<String, Object>> commentList(Map<String, Object> paramMap) throws Exception {
		return boardDAO.commentList(paramMap);
	}

	// ��� ��ȸ
	public List<Map<String, Object>> selectComment(Map<String, Object> paramMap) throws Exception {
		return boardDAO.selectComment(paramMap);
	}

}
