package com.pro.green.board.service;

import java.util.List;
import java.util.Map;

import com.pro.green.board.vo.ArticleVO;

public interface BoardService {
	// 공지사항
	public List<ArticleVO> listNotice() throws Exception;
	public ArticleVO viewNotice(int noticeNum) throws Exception;
	public void removeNotice(int noticeNum) throws Exception;
	public int addNewNotice(Map articleMap) throws Exception;
	public void modNotice(Map articleMap) throws Exception;
	
	// 이벤트
	public List<ArticleVO> listEvent() throws Exception;
	public ArticleVO viewEvent(int eventNum) throws Exception;
	public void removeEvent(int eventNum) throws Exception;
	public int addNewEvent(Map articleMap) throws Exception;
	public void modEvent(Map articleMap) throws Exception;
	
	
	// QnA
	
	// 리뷰
	public List<ArticleVO> listReview() throws Exception;
	public ArticleVO viewReview(int reviewNum) throws Exception;
	public void removeReview(int reviewNum) throws Exception;
	public int addNewReview(Map articleMap) throws Exception;
	public void modReview(Map articleMap) throws Exception;
	
}