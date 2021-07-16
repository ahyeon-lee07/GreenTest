package com.pro.green.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.board.dao.BoardDAO;
import com.pro.green.board.vo.ArticleVO;
import com.pro.green.board.vo.ImageVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;

	// �������� ���
	public List<ArticleVO> listNotice() throws Exception {
		List<ArticleVO> listNotice = boardDAO.selectAllNoticeList();
		return listNotice;
	}

	// �������� ��������
	@Override
	public ArticleVO viewNotice(int noticeNum) throws Exception {
		ArticleVO articleVO = boardDAO.selectNotice(noticeNum);
		return articleVO;
	}

	// �������� �����ϱ�
	@Override
	public void removeNotice(int noticeNum) throws Exception {
		boardDAO.deleteNotice(noticeNum);
	}

	// �������� �۾���
	@Override
	public int addNewNotice(Map articleMap) throws Exception {
		return boardDAO.insertNewNotice(articleMap);
	}

	// �������� �����ϱ�
	@Override
	public void modNotice(Map articleMap) throws Exception {
		boardDAO.updateNotice(articleMap);
	}

	// �̺�Ʈ ���
	public List<ArticleVO> listEvent() throws Exception {
		List<ArticleVO> listEvent = boardDAO.selectAllEventList();
		return listEvent;
	}

	// �̺�Ʈ ��������
	@Override
	public ArticleVO viewEvent(int eventNum) throws Exception {
		ArticleVO articleVO = boardDAO.selectEvent(eventNum);
		return articleVO;
	}

	// �̺�Ʈ �����ϱ�
	@Override
	public void removeEvent(int eventNum) throws Exception {
		boardDAO.deleteEvent(eventNum);
	}

	// �̺�Ʈ �۾���
	@Override
	public int addNewEvent(Map articleMap) throws Exception {
		return boardDAO.insertNewEvent(articleMap);
	}

	// �̺�Ʈ �����ϱ�
	@Override
	public void modEvent(Map articleMap) throws Exception {
		boardDAO.updateEvent(articleMap);
	}

	// QnA ���
	public List<ArticleVO> listQnA() throws Exception {
		List<ArticleVO> listQnA = boardDAO.selectAllQnAList();
		return listQnA;
	}

	// QnA ��������
	@Override
	public ArticleVO viewQnA(int questionNum) throws Exception {
		ArticleVO articleVO = boardDAO.selectQnA(questionNum);
		return articleVO;
	}

	// ��ȸ�� �ø���
	@Override
	public void updateQnAHits(int questionNum) {
			boardDAO.updateQnAHits(questionNum);
		}
	
		
	// QnA �����ϱ�
	@Override
	public void removeQnA(int questionNum) throws Exception {
		boardDAO.deleteQnA(questionNum);
	}

	// QnA �����ϱ�
	@Override
	public void modQnA(Map articleMap) throws Exception {
		boardDAO.updateQnA(articleMap);
	}

	// review ���
	public List<ArticleVO> listReview() throws Exception {
		List<ArticleVO> listReview = boardDAO.selectAllReviewList();
		return listReview;
	}

	// review ��������
	@Override
	public ArticleVO viewReview(int reviewNum) throws Exception {
		ArticleVO articleVO = boardDAO.selectReview(reviewNum);
		return articleVO;
	}

	// review �����ϱ�
	@Override
	public void removeReview(int reviewNum) throws Exception {
		boardDAO.deleteReview(reviewNum);
	}

	// review �۾���
	@Override
	public int addNewReview(Map articleMap) throws Exception {
		return boardDAO.insertNewReview(articleMap);
	}

	// review ����
	@Override
	public void modReview(Map articleMap) throws Exception {
		boardDAO.updateReview(articleMap);
	}

	

}
