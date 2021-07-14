package com.pro.green.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("articleVO")
public class ArticleVO {

	// 공지사항
	private int noticeNum;
	private String id;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeDate;

	// 이벤트
	private int eventNum;
	private String eventTitle;
	private String eventContent;
	private Date eventDate;

	// QnA
	private int QnANum;
	private String productId;
	private String QnATitle;
	private String QnAContent;
	private int QnAHits;
	private String QnAPw;
	private Date QnADate;

	// Review
	private int reviewNum;
	private String reviewTitle;
	private String reviewContent;
	private int reviewHits;
	private Date reviewDate;

	private String imageFileName;

	public ArticleVO() {
		System.out.println("articleVO 생성자");
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	// 이벤트
	public int getEventNum() {
		return eventNum;
	}

	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	// QnA
	public int getQnANum() {
		return QnANum;
	}

	public void setQnANum(int QnANum) {
		this.QnANum = QnANum;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQnATitle() {
		return QnATitle;
	}

	public void setQnATitle(String QnATitle) {
		this.QnATitle = QnATitle;
	}

	public String getQnAContent() {
		return QnAContent;
	}

	public void setQnAContent(String QnAContent) {
		this.QnAContent = QnAContent;
	}

	public int getQnAHits() {
		return QnAHits;
	}

	public void setQnAHits(int QnAHits) {
		this.QnAHits = QnAHits;
	}

	public String getQnAPw() {
		return QnAPw;
	}

	public void setQnAPw(String QnAPw) {
		this.QnAPw = QnAPw;
	}

	public Date getQnADate() {
		return QnADate;
	}

	public void setQnADate(Date QnADate) {
		this.QnADate = QnADate;
	}

	// review
	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewHits() {
		return reviewHits;
	}

	public void setReviewHits(int reviewHits) {
		this.reviewHits = reviewHits;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	// 이미지
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

}