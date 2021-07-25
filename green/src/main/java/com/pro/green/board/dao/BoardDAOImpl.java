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

	// 공지사항 삭제
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

	// 공지사항 수정
	@Override
	public void updateNotice(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateNotice", articleMap);
	}

	// 이벤트 글 목록
	@Override
	public List<ArticleVO> selectAllEventList() throws DataAccessException {
	List<ArticleVO> eventList = sqlSession.selectList("mapper.board.selectAllEventList");
		return eventList;
	}

	// 이벤트 글 상세페이지
	@Override
	public ArticleVO selectEvent(int eventNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectEvent", eventNum);
	}
		
	// 이벤트 글 추가
	@Override
	public int insertNewEvent(Map articleMap) throws DataAccessException {
		int eventNum = selectNewEventNum(); // 새 글에 대한 글 번호 가져오기
		articleMap.put("eventNum", eventNum); // 글 번호를 articleMap에 저장
		sqlSession.insert("mapper.board.insertNewEvent", articleMap); // id에 대한 insert문을 호출하면서 articleMap을 전달
		return eventNum;
	}
		
	// 새 글 번호 가져오기
	private int selectNewEventNum() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewEventNum");
	}
		
	// 이벤트 글 수정
	@Override
	public void updateEvent(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateEvent", articleMap);
	}

	// 이벤트 글 삭제
	@Override
	public void deleteEvent(int eventNum) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteEvent", eventNum);
	}

	// QnA 목록
	@Override
	public List<ArticleVO> selectAllQnAList() throws DataAccessException {
		List<ArticleVO> listQnA = sqlSession.selectList("mapper.board.selectAllQnAList");
		return listQnA;
	}

	// QnA 상세페이지
	@Override
	public ArticleVO selectQnA(int questionNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectQnA", questionNum);
	}
	
	// QnA 글 추가
	@Override
	public int insertNewQnA(Map articleMap) throws DataAccessException {
		int questionNum = selectNewQnANum(); // 새 글에 대한 글 번호 가져오기
		articleMap.put("questionNum", questionNum); // 글 번호를 articleMap에 저장
		sqlSession.insert("mapper.board.insertNewQnA", articleMap); // id에 대한 insert문을 호출하면서 articleMap을 전달
		return questionNum;
	}
			
	// 새 글 번호 가져오기
	private int selectNewQnANum() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewQnANum");
	}
	
	// QnA 수정
	@Override
	public void updateQnA(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateQnA", articleMap);
	}

	// QnA 삭제
	@Override
	public void deleteQnA(int questionNum) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteQnA", questionNum);

	}

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

	// review 삭제
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
