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

	// �������� ���
	@Override
	public List<ArticleVO> selectAllNoticeList() throws DataAccessException {
		List<ArticleVO> listNotice = sqlSession.selectList("mapper.board.selectAllNoticeList");
		return listNotice;
	}

	// �������� ��������
	@Override
	public ArticleVO selectNotice(int noticeNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNotice", noticeNum);
	}

	// �������� �����ϱ�
	@Override
	public void deleteNotice(int noticeNum) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteNotice", noticeNum);

	}

	// �������� �۾���
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

	// �������� �����ϱ�
	@Override
	public void updateNotice(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateNotice", articleMap);
	}

	// �̺�Ʈ ���
	@Override
	public List<ArticleVO> selectAllEventList() throws DataAccessException {
		List<ArticleVO> listEvent = sqlSession.selectList("mapper.board.selectAllEventList");
		return listEvent;
	}

	// �̺�Ʈ ��������
	@Override
	public ArticleVO selectEvent(int eventNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectEvent", eventNum);
	}

	// �̺�Ʈ �����ϱ�
	@Override
	public void deleteEvent(int eventNum) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteEvent", eventNum);

	}

	// �̺�Ʈ �۾���
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

	// �̺�Ʈ �����ϱ�
	@Override
	public void updateEvent(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateEvent", articleMap);
	}

	// QnA ���

	// review ���
	@Override
	public List<ArticleVO> selectAllReviewList() throws DataAccessException {
		List<ArticleVO> listReview = sqlSession.selectList("mapper.board.selectAllReviewList");
		return listReview;
	}

	// review ��������
	@Override
	public ArticleVO selectReview(int reviewNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectReview", reviewNum);
	}

	// review �����ϱ�
	@Override
	public void deleteReview(int reviewNum) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteReview", reviewNum);

	}

	// review �۾���
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

	// review ����
	@Override
	public void updateReview(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateReview", articleMap);
	}

}
