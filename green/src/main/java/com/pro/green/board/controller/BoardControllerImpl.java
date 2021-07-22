package com.pro.green.board.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pro.green.board.service.BoardService;
import com.pro.green.board.vo.ArticleVO;
import com.pro.green.board.vo.ImageVO;
import com.pro.green.member.vo.MemberVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleVO articleVO;

	// �������� ���
	@Override
	@RequestMapping(value = "/listNotice.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List<ArticleVO> listNotice = boardService.listNotice();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("listNotice", listNotice);
		return mav;
	}

	// �������� ��������
	@RequestMapping(value = "/viewNotice.do", method = RequestMethod.GET)
	public ModelAndView viewNotice(@RequestParam("noticeNum") int noticeNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		articleVO = boardService.viewNotice(noticeNum);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("viewNotice", articleVO);
		return mav;
	}

	// �������� �����ϱ�
	@Override
	@RequestMapping(value = "/removeNotice.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeNotice(@RequestParam("noticeNum") int noticeNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.removeNotice(noticeNum);
			message = "<script>";
			message += " alert('���� �����߽��ϴ�.');";
			message += " location.href='" + request.getContextPath() + "/listNotice.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			message = "<script>";
			message += " alert('�۾��� ������ �߻��߽��ϴ�.�ٽ� �õ��� �ּ���.');";
			message += " location.href='" + request.getContextPath() + "/viewNotice.do?noticeNum=" + noticeNum + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	// �������� �۾���
	@Override
	@RequestMapping(value = "/addNewNotice.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewNotice(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String id = memberVO.getId();
		articleMap.put("noticeNum", 0);
		articleMap.put("id", id);

		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int noticeNum = boardService.addNewNotice(articleMap); // �� ������ ����� articleMap�� Service Ŭ������ addArticle()
																	// �޼���� �����Ѵ�.
			message = "<script>";
			message += " alert('������ �߰��߽��ϴ�.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/listNotice.do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED); // �� ���� �߰��� �� �޽����� �����Ѵ�.
		} catch (Exception e) {
			message = " <script>";
			message += " alert('������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');');";
			message += " location.href='" + multipartRequest.getContextPath() + "/addNewNotice.do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED); // ���� �߻� �� ���� �޽����� �����Ѵ�.
			e.printStackTrace();
		}
		return resEnt;
	}

	// �۾���â
	@RequestMapping(value = "/board/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	// �������� ����
	@RequestMapping(value = "/modNotice.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modNotice(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

		String noticeNum = (String) articleMap.get("noticeNum");
		articleMap.put("noticeNum", noticeNum);
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modNotice(articleMap);

			message = "<script>";
			message += " alert('���� �����߽��ϴ�.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/viewNotice.do?noticeNum=" + noticeNum
					+ "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			message = "<script>";
			message += " alert('������ �߻��߽��ϴ�.�ٽ� �������ּ���');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/viewArticle.do?noticeNum="
					+ noticeNum + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}

	// �̺�Ʈ �� ���
	@Override
	@RequestMapping(value = "/eventList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView event(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List eventList = boardService.eventList(); // ��� �� ���� ��ȸ
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("eventList", eventList);
		return mav;

	}

	// �̺�Ʈ ��������
	@RequestMapping(value = "/eventPage.do", method = RequestMethod.GET)
	public ModelAndView eventPage(@RequestParam("eventNum") int eventNum,
				 HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		Map articleMap = boardService.eventPage(eventNum);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("articleMap", articleMap);
		return mav;
	}
		
	// �̺�Ʈ �۾��� â
	@RequestMapping(value = "/eventWrite.do", method = RequestMethod.GET)
	public ModelAndView eventWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	// �̺�Ʈ �� �߰�
	@Override
	@RequestMapping(value = "/addNewEvent.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewEvent(MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
				String value = multipartRequest.getParameter(name);
				articleMap.put(name,value);
		}

		HttpSession session = multipartRequest.getSession(); 
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String id = memberVO.getId();
		articleMap.put("eventNum", 0);
		articleMap.put("id", id);
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int eventNum = boardService.addNewEvent(articleMap);
			message = "<script>";
			message += "alert('�� ���� �߰��߽��ϴ�.');";
			message += "location.href='"
						+multipartRequest.getContextPath()+"/eventList.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				
		}catch (Exception e) {
			message = "<script>";
			message += "alert('������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���.');');";
			message += "location.href='"
						+multipartRequest.getContextPath()+"/eventWrite.do';";
			message +="</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
			return resEnt;
	}

	// �̺�Ʈ �� ����

		
	// �̺�Ʈ �� ����
	@Override
	@RequestMapping(value = "/removeEvent.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeEvent(@RequestParam("eventNum") int eventNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.removeEvent(eventNum);
			message = "<script>";
			message += " alert('���� �����߽��ϴ�.');";
			message += " location.href='" + request.getContextPath() + "/eventList.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			message = "<script>";
			message += " alert('�۾��� ������ �߻��߽��ϴ�.�ٽ� �õ��� �ּ���.');";
			message += " location.href='" + request.getContextPath() + "/eventPage.do?eventNum=" + eventNum + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	// review ���
	@Override
	@RequestMapping(value = "/listReview.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List<ArticleVO> listReview = boardService.listReview();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("listReview", listReview);
		System.out.println(listReview);
		return mav;
	}

	// review ��������
	@RequestMapping(value = "/viewReview.do", method = RequestMethod.GET)
	public ModelAndView viewReview(@RequestParam("reviewNum") int reviewNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		articleVO = boardService.viewReview(reviewNum);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("viewReview", articleVO);
		return mav;
	}

	// review �����ϱ�
	@Override
	@RequestMapping(value = "/removeReview.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeReview(@RequestParam("reviewNum") int reviewNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.removeReview(reviewNum);
			message = "<script>";
			message += " alert('���� �����߽��ϴ�.');";
			message += " location.href='" + request.getContextPath() + "/listReview.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			message = "<script>";
			message += " alert('�۾��� ������ �߻��߽��ϴ�.�ٽ� �õ��� �ּ���.');";
			message += " location.href='" + request.getContextPath() + "/viewReview.do?reviewNum=" + reviewNum + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	// review �۾���
	@Override
	@RequestMapping(value = "/addNewReview.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewReview(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String id = memberVO.getId();
		articleMap.put("reviewNum", 0);
		articleMap.put("id", id);
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int reviewNum = boardService.addNewReview(articleMap);
			message = "<script>";
			message += " alert('������ �߰��߽��ϴ�.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/listReview.do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			message = " <script>";
			message += " alert('������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');');";
			message += " location.href='" + multipartRequest.getContextPath() + "/addNewReview.do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	// ���� ����
	@RequestMapping(value = "/modReview.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modReview(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}
		String reviewNum = (String) articleMap.get("reviewNum");
		articleMap.put("reviewNum", reviewNum);
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modReview(articleMap);
			message = "<script>";
			message += " alert('���� �����߽��ϴ�.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/viewReview.do?reviewNum=" + reviewNum
					+ "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			message = "<script>";
			message += " alert('������ �߻��߽��ϴ�.�ٽ� �������ּ���');";
			message += " location.href='" + multipartRequest.getContextPath() + "/viewReview.do?reviewNum=" + reviewNum
					+ "';";

			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}

	// QnA ���
	@Override
	@RequestMapping(value = "/listQnA.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listQnA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List<ArticleVO> listQnA = boardService.listQnA();
		ModelAndView mav = new ModelAndView(viewName);
		mav.setViewName("listQnA");
		mav.addObject("listQnA", listQnA);
		System.out.println(listQnA);
		return mav;
	}

	// QnA ��������
	@RequestMapping(value = "/viewQnA.do", method = RequestMethod.GET)
	public ModelAndView viewQnA(@RequestParam("questionNum") int questionNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boardService.updateQnAHits(questionNum);
		String viewName = (String) request.getAttribute("viewName");
		articleVO = boardService.viewQnA(questionNum);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("viewQnA", articleVO);
		return mav;
	}

	// QnA �����ϱ�
	@Override
	@RequestMapping(value = "/removeQnA.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeQnA(@RequestParam("questionNum") int questionNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.removeQnA(questionNum);
			message = "<script>";
			message += " alert('���� �����߽��ϴ�.');";
			message += " location.href='" + request.getContextPath() + "/listQnA.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			message = "<script>";
			message += " alert('�۾��� ������ �߻��߽��ϴ�.�ٽ� �õ��� �ּ���.');";
			message += " location.href='" + request.getContextPath() + "/viewQnA.do?questionNum=" + questionNum + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	// QnA ����
	@RequestMapping(value = "/modQnA.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modQnA(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

		String questionNum = (String) articleMap.get("questionNum");
		articleMap.put("questionNum", questionNum);
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modQnA(articleMap);

			message = "<script>";
			message += " alert('���� �����߽��ϴ�.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/viewQnA.do?questionNum=" + questionNum
					+ "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			message = "<script>";
			message += " alert('������ �߻��߽��ϴ�.�ٽ� �������ּ���');";
			message += " location.href='" + multipartRequest.getContextPath() + "/viewQnA.do?questionNum="
					+ questionNum + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}

}
