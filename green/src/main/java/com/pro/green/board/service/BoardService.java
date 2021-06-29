package com.pro.green.board.service;

import java.util.List;
import java.util.Map;

import com.pro.green.board.vo.ArticleVO;

public interface BoardService {
	public List<ArticleVO> notice() throws Exception;
	
	public ArticleVO viewArticle(int articleNO) throws Exception;
	/*
	public Map viewArticle(int articleNO) throws Exception;
	
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;
	*/
}