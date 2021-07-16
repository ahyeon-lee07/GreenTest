package com.pro.green.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.pro.green.board.vo.ArticleVO;


public interface BoardDAO {
	// 공지사항
	public List<ArticleVO> selectAllNoticeList() throws DataAccessException;
	public ArticleVO selectNotice(int noticeNum) throws DataAccessException;
	public void deleteNotice(int noticeNum) throws DataAccessException;
	public int insertNewNotice(Map articleMap) throws DataAccessException;
	public void updateNotice(Map articleMap) throws DataAccessException;
	
	// 이벤트
	public List<ArticleVO> selectAllEventList() throws DataAccessException;
	public ArticleVO selectEvent(int eventNum) throws DataAccessException;
	public void deleteEvent(int eventNum) throws DataAccessException;
	public int insertNewEvent(Map articleMap) throws DataAccessException;
	public void updateEvent(Map articleMap) throws DataAccessException;
	
	// QnA
	public List<ArticleVO> selectAllQnAList() throws DataAccessException;
	public ArticleVO selectQnA(int qnaNum) throws DataAccessException;
	
	// 리뷰
	public List<ArticleVO> selectAllReviewList() throws DataAccessException;
	public ArticleVO selectReview(int reviewNum) throws DataAccessException;
	public void deleteReview(int reviewNum) throws DataAccessException;
	public int insertNewReview(Map articleMap) throws DataAccessException;
	public void updateReview(Map articleMap) throws DataAccessException;
}