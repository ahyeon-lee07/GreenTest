package com.pro.green.board.service;

import java.util.List;
import java.util.Map;

import com.pro.green.board.vo.ArticleVO;

public interface BoardService {
	// ��������
	public List<ArticleVO> listNotice() throws Exception; // �� ���
	public ArticleVO viewNotice(int noticeNum) throws Exception; // �� ��
	public int addNewNotice(Map articleMap) throws Exception; // �� �߰�
	public void modNotice(Map articleMap) throws Exception; // �� ����
	public void removeNotice(int noticeNum) throws Exception; // �� ����
	
	// �̺�Ʈ
	public List<ArticleVO> eventList() throws Exception; // �� ���
	public Map eventView(int eventNum) throws Exception; // �� ��
	public int addNewEvent(Map articleMap) throws Exception; // �� �߰�
	public void modEvent(Map articleMap) throws Exception; // �� ����
	public void removeEvent(int eventNum) throws Exception; // �� ����
	
	// QnA
	public List<ArticleVO> listQnA() throws Exception; // �� ���
	public ArticleVO viewQnA(int questionNum) throws Exception; // �� ��
	public int addNewQnA(Map articleMap) throws Exception; // �� �߰�
	public void modQnA(Map articleMap) throws Exception; // �� ����
	public void removeQnA(int questionNum) throws Exception; // �� ����
	
	// Review
	public List<ArticleVO> listReview() throws Exception; // �� ���
	public ArticleVO viewReview(int reviewNum) throws Exception; //�� ��
	public int addNewReview(Map articleMap) throws Exception; // �� �߰�
	public void modReview(Map articleMap) throws Exception; // �� ����
	public void removeReview(int reviewNum) throws Exception; // �� ����
	
}