package com.pro.green.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface BoardController {
	// 공지사항
	public ModelAndView listNotice(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView viewNotice(@RequestParam("noticeNum") int noticeNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	public ResponseEntity removeNotice(@RequestParam("noticeNum") int noticeNum,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addNewNotice(MultipartHttpServletRequest multipartRequest,HttpServletResponse response) throws Exception;
	
	
	// 이벤트
	// 글 목록
	public ModelAndView eventList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 글 상세
	public ModelAndView eventView(@RequestParam("eventNum") int eventNum, HttpServletRequest request,
										HttpServletResponse response) throws Exception;
	// 글 추가
	public ResponseEntity addNewEvent(MultipartHttpServletRequest multipartRequest,
										HttpServletResponse response) throws Exception;
	// 글 수정
	public ResponseEntity modEvent(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;
	
	// 글 삭제
	public ResponseEntity removeEvent(@RequestParam("eventNum") int eventNum, HttpServletRequest request,
										HttpServletResponse response) throws Exception;
	

	// QnA
	// 글 목록
	public ModelAndView listQnA(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 글 상세
	public ModelAndView viewQnA(@RequestParam("questionNum") int questionNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	// 글 추가
	public ResponseEntity addNewQnA(MultipartHttpServletRequest multipartRequest,
											HttpServletResponse response) throws Exception;
	// 글 수정
	public ResponseEntity modQnA(MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response) throws Exception;
	// 글 삭제
	public ResponseEntity removeQnA(@RequestParam("questionNum") int questionNum,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 리뷰
	public ModelAndView listReview(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView viewReview(@RequestParam("reviewNum") int reviewNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	public ResponseEntity removeReview(@RequestParam("reviewNum") int reviewNum,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addNewReview(MultipartHttpServletRequest multipartRequest,HttpServletResponse response) throws Exception;
	public ResponseEntity modReview(MultipartHttpServletRequest multipartRequest,  HttpServletResponse response) throws Exception;
}