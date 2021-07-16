package com.pro.green.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.green.board.vo.ArticleVO;
import com.pro.green.board.vo.ImageVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	// 공지사항 목록
	@Override
	public List<ArticleVO> selectAllNoticeList() throws DataAccessException {
		List<ArticleVO> listNotice = sqlSession.selectList("mapper.board.selectAllNoticeList");
		return listNotice;
	}

	// 공지사항 상세페이지
	@Override
	public ArticleVO selectNotice(int noticeNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNotice", noticeNum);
	}

	// 공지사항 삭제하기
	@Override
	public void deleteNotice(int noticeNum) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteNotice", noticeNum);

	}

	// 공지사항 글쓰기
	@Override
	public int insertNewNotice(Map articleMap) throws DataAccessException {
		int noticeNum = selectNewNoticeNum();
		articleMap.put("noticeNum", noticeNum);
		sqlSession.insert("mapper.board.insertNewNotice", articleMap);
		return noticeNum;
	}

	private int selectNewNoticeNum() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewNoticeNum");
	}

	// 공지사항 수정하기
	@Override
	public void updateNotice(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateNotice", articleMap);
	}

	// 이벤트 목록
	@Override
	public List<ArticleVO> selectAllEventList() throws DataAccessException {
		List<ArticleVO> listEvent = sqlSession.selectList("mapper.board.selectAllEventList");
		return listEvent;
	}

	// 이벤트 상세페이지
	@Override
	public ArticleVO selectEvent(int eventNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectEvent", eventNum);
	}

	// 이벤트 삭제하기
	@Override
	public void deleteEvent(int eventNum) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteEvent", eventNum);

	}

	// 이벤트 글쓰기
	@Override
	public int insertNewEvent(Map articleMap) throws DataAccessException {
		int eventNum = selectNewEventNum();
		articleMap.put("eventNum", eventNum);
		sqlSession.insert("mapper.board.insertNewEvent", articleMap);
		return eventNum;
	}

	private int selectNewEventNum() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewEventNum");
	}

	// 이벤트 수정하기
	@Override
	public void updateEvent(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateEvent", articleMap);
	}

	// QnA 목록

	// review 목록
	@Override
	public List<ArticleVO> selectAllReviewList() throws DataAccessException {
		List<ArticleVO> listReview = sqlSession.selectList("mapper.board.selectAllReviewList");
		return listReview;
	}

	// review 상세페이지
	@Override
	public ArticleVO selectReview(int reviewNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectReview", reviewNum);
	}

	// review 삭제하기
	@Override
	public void deleteReview(int reviewNum) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteReview", reviewNum);

	}

	// review 글쓰기
	@Override
	public int insertNewReview(Map articleMap) throws DataAccessException {
		int reviewNum = selectNewReviewNum();
		articleMap.put("reviewNum", reviewNum);
		sqlSession.insert("mapper.board.insertNewReview", articleMap);
		return reviewNum;
	}

	private int selectNewReviewNum() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewReviewNum");
	}

	// review 수정
	@Override
	public void updateReview(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateReview", articleMap);
	}

}
