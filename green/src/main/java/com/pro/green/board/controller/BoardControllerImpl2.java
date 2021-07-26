package com.pro.green.board.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pro.green.board.service.BoardService2;
import com.pro.green.board.vo.ArticleVO2;
import com.pro.green.board.vo.ImageVO;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product_M.vo.Criteria;
import com.pro.green.product_M.vo.PageMaker;
import com.pro.green.product_M.vo.ProductVO2;

@Controller("boardController2")
public class BoardControllerImpl2 implements BoardController2 {
	@Autowired
	private BoardService2 boardService;
	@Autowired
	private ArticleVO2 articleVO;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private ProductVO2 product;

	// Ŀ�´�Ƽ ����Ʈ
	@RequestMapping(value = "/community.do", method = RequestMethod.GET)
	public ModelAndView community(@RequestParam String communityType, HttpServletRequest request,
			HttpServletResponse response, Criteria cri) throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		PageMaker pageMaker = new PageMaker();

		Map<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("type", communityType);
		List<ArticleVO2> list = new ArrayList<ArticleVO2>();

		int pageTotal = 0;

		if (communityType.equals("qna")) {
			mav.addObject("pageTitle", "QnA");
			selectOption.put("selectOption",
					"questionNum AS num, id AS id,productId AS productId,questionTitle AS title,questionContent AS content,questionHits AS hits,commentCount AS commentCount,questionPw AS questionPw,pwYN AS pwYN,questionDate AS createDate");

		} else if (communityType.equals("notice")) {
			mav.addObject("pageTitle", "��������");
			selectOption.put("selectOption",
					"noticeNum AS num, id AS id,noticeTitle AS title,noticeContent AS content,noticeHits AS hits, noticeDate AS createDate");

		} else if (communityType.equals("event")) {
			mav.addObject("pageTitle", "�̺�Ʈ");
			selectOption.put("selectOption",
					"eventNum AS num, id AS id,eventTitle AS title,eventContent AS content,eventHits AS hits, eventDate AS createDate");

		} else if (communityType.equals("review")) {
			mav.addObject("pageTitle", "����");
			selectOption.put("selectOption",
					"reviewNum AS num, id AS id,productId AS productId,reviewTitle AS title,reviewContent AS content,reviewHits AS hits,reviewDate AS createDate");

		}

		list = boardService.selectList(selectOption);

		pageMaker.setCri(cri);

		pageMaker.setTotalCount(list.size());

		mav.addObject("member", member);
		mav.addObject("list", list);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("communityType", communityType);
		mav.setViewName("communityList");
		return mav;
	}

	// Ŀ�´�Ƽ ���ȭ��
	@RequestMapping(value = "/community/communityAdd.do", method = RequestMethod.GET)
	public ModelAndView communityAddForm(@RequestParam String communityType, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		PageMaker pageMaker = new PageMaker();

		Map<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("type", communityType);
		List<ArticleVO2> list = new ArrayList<ArticleVO2>();

		if (communityType.equals("qna")) {
			mav.addObject("pageTitle", "QnA ���");

			// �ּҷ� ���� ����
			loginChk(mav, member, "communityAdd");

		} else if (communityType.equals("notice")) {
			mav.addObject("pageTitle", "�������� ���");

			// ������ ���� üũ (ModelAndView, ��������, "����ȭ���̸�")
			sessionChk(mav, member, "communityAdd");

		} else if (communityType.equals("event")) {
			mav.addObject("pageTitle", "�̺�Ʈ ���");

			// ������ ���� üũ (ModelAndView, ��������, "����ȭ���̸�")
			sessionChk(mav, member, "communityAdd");

		} else if (communityType.equals("review")) {
			mav.addObject("pageTitle", "���� ���");

			// �ּҷ� ���� ����
			loginChk(mav, member, "communityAdd");

		}

		mav.addObject("member", member);
		mav.addObject("list", list);
		mav.addObject("communityType", communityType);

		return mav;
	}

	// Ŀ�´�Ƽ ���
	@RequestMapping(value = "/community/add.do", method = RequestMethod.POST)
	public ModelAndView communityAdd(@RequestParam(value = "communityType") String communityType,
			@ModelAttribute("community") ArticleVO2 articleVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		PageMaker pageMaker = new PageMaker();
		int result = 0;

		Map<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("type", communityType);

		if (communityType.equals("qna")) {

			String productId = articleVO.getProductId();
			String pwYN = articleVO.getPwYN();

			if (!productId.equals("") && pwYN.equals("Y")) {
				selectOption.put("selectOption", "id, productId, questionTitle, questionContent, questionPw, pwYN");
				selectOption.put("value",
						"'" + articleVO.getId() + "','" + articleVO.getProductId() + "','" + articleVO.getTitle()
								+ "','" + articleVO.getContent() + "','" + articleVO.getQuestionPw() + "','"
								+ articleVO.getPwYN() + "'");

			} else if (!productId.equals("") && pwYN.equals("N")) {
				selectOption.put("selectOption", "id, productId, questionTitle, questionContent, pwYN");
				selectOption.put("value", "'" + articleVO.getId() + "','" + articleVO.getProductId() + "','"
						+ articleVO.getTitle() + "','" + articleVO.getContent() + "','" + articleVO.getPwYN() + "'");

			} else if (productId.equals("") && pwYN.equals("Y")) {
				selectOption.put("selectOption", "id, questionTitle, questionContent, questionPw, pwYN");
				selectOption.put("value",
						"'" + articleVO.getId() + "','" + articleVO.getTitle() + "','" + articleVO.getContent() + "','"
								+ articleVO.getQuestionPw() + "','" + articleVO.getPwYN() + "'");

			} else if (productId.equals("") && pwYN.equals("N")) {
				selectOption.put("selectOption", "id, questionTitle, questionContent, pwYN");
				selectOption.put("value", "'" + articleVO.getId() + "','" + articleVO.getTitle() + "','"
						+ articleVO.getContent() + "','" + articleVO.getPwYN() + "'");
			}

		} else if (communityType.equals("notice")) {
			selectOption.put("selectOption", "id, noticeTitle, noticeContent");
			selectOption.put("value",
					"'" + articleVO.getId() + "','" + articleVO.getTitle() + "','" + articleVO.getContent() + "'");

		} else if (communityType.equals("event")) {
			selectOption.put("selectOption", "id, eventTitle, eventContent");
			selectOption.put("value",
					"'" + articleVO.getId() + "','" + articleVO.getTitle() + "','" + articleVO.getContent() + "'");

		} else if (communityType.equals("review")) {
			selectOption.put("selectOption", "id, productId, reviewTitle, reviewContent");
			selectOption.put("value", "'" + articleVO.getId() + "','" + articleVO.getProductId() + "','"
					+ articleVO.getTitle() + "','" + articleVO.getContent() + "'");

		}

		result = boardService.insertArticle(selectOption);

		mav.addObject("member", member);
		mav.addObject("communityType", communityType);
		mav.setViewName("redirect:/community.do");

		return mav;
	}

	// ��ǰ�˻� â
	@RequestMapping(value = "/productSearch.do", method = RequestMethod.GET)
	public String productSearch(Locale locale, Model model) {
		return "productSearch";
	}

	// ��ǰ�˻�
	@RequestMapping(value = "/productSearch/search.do", method = RequestMethod.POST)
	public ResponseEntity productSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String keyWord = request.getParameter("keyWord");

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		result = boardService.productSearch(keyWord);

		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}

	// ��������
	@RequestMapping(value = "/communityDerail/derailPage.do", method = RequestMethod.GET)
	public ModelAndView communityDerail(@RequestParam(value = "communityNum") String communityNum,
			@RequestParam(value = "communityType") String communityType, HttpServletRequest request,
			HttpServletResponse response, Criteria cri) throws Exception {

		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		ArticleVO2 community = new ArticleVO2();
		Map<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("type", communityType);
		List<Map<String, Object>> commentList = new ArrayList<Map<String,Object>>();

		if (communityType.equals("qna")) {
			selectOption.put("communityNum", "questionNum='" + communityNum + "'");
			selectOption.put("hits", "questionHits = questionHits + 1");
			selectOption.put("value",
					"questionNum AS num, id AS id, productId AS productId, questionTitle AS title, questionContent AS content, questionHits AS hits, questionPw AS questionPw, pwYN AS pwYN");

			community = boardService.selectCommunity(selectOption);
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			
			if (community.getPwYN().equals("Y")) {
				mav.setViewName(
						"redirect:/communityChk.do?communityNum=" + communityNum + "&communityType=" + communityType);

			} else {
				mav.addObject("pageTitle", "QnA");
				
				paramMap.put("qnANum", communityNum);
				commentList = boardService.selectComment(paramMap);
				
				mav.setViewName("communityDerail");
			}

		} else if (communityType.equals("notice")) {
			selectOption.put("communityNum", "noticeNum='" + communityNum + "'");
			selectOption.put("hits", "noticeHits = noticeHits + 1");
			selectOption.put("value",
					"noticeNum AS num, id AS id, noticeTitle AS title, noticeContent AS content, noticeHits AS hits");

			community = boardService.selectCommunity(selectOption);

			mav.setViewName("communityDerail");
		} else if (communityType.equals("event")) {
			selectOption.put("communityNum", "eventNum='" + communityNum + "'");
			selectOption.put("hits", "eventHits = eventHits + 1");
			selectOption.put("value",
					"eventNum AS num, id AS id, eventTitle AS title, eventContent AS content, eventHits AS hits");

			community = boardService.selectCommunity(selectOption);

			mav.setViewName("communityDerail");
		} else if (communityType.equals("review")) {
			selectOption.put("communityNum", "reviewNum='" + communityNum + "'");
			selectOption.put("hits", "reviewHits = reviewHits + 1");
			selectOption.put("value",
					"reviewNum AS num, id AS id, productId AS productId, reviewTitle AS title, reviewContent AS content, reviewHits AS hits");

			community = boardService.selectCommunity(selectOption);

			mav.setViewName("communityDerail");
		}

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("page", cri.getPage());
		mav.addObject("communityType", communityType);
		mav.addObject("community", community);
		mav.addObject("member", member);
		mav.addObject("commentList", commentList);
		return mav;
	}

	// Ŀ�´�Ƽ ����
	@RequestMapping(value = "/community/edit.do", method = RequestMethod.POST)
	public ModelAndView communityEdit(@RequestParam(value = "communityType") String communityType,
			@RequestParam(value = "communityNum") String communityNum,
			@ModelAttribute("community") ArticleVO2 articleVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		PageMaker pageMaker = new PageMaker();
		int result = 0;

		Map<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("type", communityType);

		if (communityType.equals("qna")) {

			String productId = articleVO.getProductId();
			String pwYN = articleVO.getPwYN();

			selectOption.put("communityNum", "questionNum='" + communityNum + "'");
			if (!productId.equals("") && pwYN.equals("Y")) {
				selectOption.put("value", "id='" + articleVO.getId() + "',productId='" + articleVO.getProductId()
						+ "',questionTitle='" + articleVO.getTitle() + "',questionContent='" + articleVO.getContent()
						+ "',questionPw=''" + articleVO.getQuestionPw() + "',pwYN='" + articleVO.getPwYN() + "'");

			} else if (!productId.equals("") && pwYN.equals("N")) {
				selectOption.put("value",
						"id='" + articleVO.getId() + "',productId='" + articleVO.getProductId() + "',questionTitle='"
								+ articleVO.getTitle() + "',questionContent='" + articleVO.getContent() + "',pwYN='"
								+ articleVO.getPwYN() + "'");

			} else if (productId.equals("") && pwYN.equals("Y")) {
				selectOption.put("value",
						"id='" + articleVO.getId() + "',questionTitle='" + articleVO.getTitle() + "',questionContent='"
								+ articleVO.getContent() + "',questionPw='" + articleVO.getQuestionPw() + "',pwYN='"
								+ articleVO.getPwYN() + "'");

			} else if (productId.equals("") && pwYN.equals("N")) {
				selectOption.put("value", "id='" + articleVO.getId() + "',questionTitle='" + articleVO.getTitle()
						+ "',questionTitle='" + articleVO.getContent() + "',pwYN='" + articleVO.getPwYN() + "'");
			}

		} else if (communityType.equals("notice")) {
			selectOption.put("communityNum", "noticeNum='" + communityNum + "'");
			selectOption.put("value", "id='" + articleVO.getId() + "',noticeTitle='" + articleVO.getTitle()
					+ "',noticeContent='" + articleVO.getContent() + "'");

		} else if (communityType.equals("event")) {
			selectOption.put("communityNum", "eventNum='" + communityNum + "'");
			selectOption.put("value", "id='" + articleVO.getId() + "',eventTitle='" + articleVO.getTitle()
					+ "',eventContent='" + articleVO.getContent() + "'");

		} else if (communityType.equals("review")) {
			selectOption.put("communityNum", "reviewNum='" + communityNum + "'");
			selectOption.put("value", "id='" + articleVO.getId() + "',productId='" + articleVO.getProductId()
					+ "',reviewTitle='" + articleVO.getTitle() + "',reviewContent='" + articleVO.getContent() + "'");

		}

		result = boardService.updateArticle(selectOption);

		if (result == 0) {
			mav.addObject("joinMas", "���� �Ͽ����ϴ�. ����Ŀ� �õ��� �ֽø� �����ϰڽ��ϴ�.");
		} else {
			mav.addObject("joinMas", "�����Ǿ����ϴ�.");
		}

		mav.addObject("member", member);
		mav.addObject("communityType", communityType);
		mav.setViewName("redirect:/community.do");

		return mav;
	}

	// Ŀ�´�Ƽ ����
	@RequestMapping(value = "/community/delete.do", method = RequestMethod.GET)
	public ModelAndView communityDelete(@RequestParam(value = "communityType") String communityType,
			@RequestParam(value = "communityNum") String communityNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		PageMaker pageMaker = new PageMaker();
		int result = 0;

		Map<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("type", communityType);

		if (communityType.equals("qna")) {

			selectOption.put("communityNum", "questionNum='" + communityNum + "'");

		} else if (communityType.equals("notice")) {

			selectOption.put("communityNum", "noticeNum='" + communityNum + "'");

		} else if (communityType.equals("event")) {

			selectOption.put("communityNum", "eventNum='" + communityNum + "'");

		} else if (communityType.equals("review")) {

			selectOption.put("communityNum", "reviewNum='" + communityNum + "'");

		}

		result = boardService.deleteArticle(selectOption);

		if (result == 0) {
			mav.addObject("joinMas", "���� �Ͽ����ϴ�. ����Ŀ� �õ��� �ֽø� �����ϰڽ��ϴ�.");
		} else {
			mav.addObject("joinMas", "�����Ǿ����ϴ�.");
		}

		mav.addObject("member", member);
		mav.addObject("communityType", communityType);
		mav.setViewName("redirect:/community.do");

		return mav;
	}

	// �Խù� ���üũ
	@RequestMapping(value = "/communityChk.do", method = RequestMethod.POST)
	public ModelAndView communityChk(@RequestParam(value = "communityNum") String communityNum,
			@RequestParam(value = "communityType") String communityType, @RequestParam(value = "pw") String pw,
			HttpServletRequest request, HttpServletResponse response, Criteria cri) throws Exception {

		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		Map<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("type", communityType);
		ArticleVO2 community = new ArticleVO2();

		selectOption.put("communityNum", "questionNum='" + communityNum + "'");
		selectOption.put("value",
				"questionNum AS num, id AS id, productId AS productId, questionTitle AS title, questionContent AS content, questionHits AS hits, questionPw AS questionPw, pwYN AS pwYN");

		selectOption.put("hitsChk", "hitsChk");
		community = boardService.selectCommunity(selectOption);
		
		String communitypw = community.getQuestionPw();
		List<Map<String, Object>> commentList = new ArrayList<Map<String,Object>>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		if(communitypw.equals(pw)) {
			mav.addObject("community", community);
			mav.setViewName("communityDerail");
			
			mav.addObject("pageTitle", "QnA");
			mav.setViewName("communityDerail");
			
			paramMap.put("qnANum", communityNum);
			commentList = boardService.selectComment(paramMap);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			mav.addObject("pageMaker", pageMaker);
			mav.addObject("page", cri.getPage());
			mav.addObject("communityType", communityType);
			mav.addObject("community", community);
			mav.addObject("member", member);
			mav.addObject("commentList", commentList);
			
			
		}else {
			mav.addObject("joinMas", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			mav.setViewName("redirect:/community.do?communityType="+communityType);
		}

		
		return mav;
	}

	//��� �߰�
	@RequestMapping(value = "/communityDerail/commentAdd.do", method = RequestMethod.POST)
	public ResponseEntity commentAdd(@RequestParam(value = "id") String id,
			@RequestParam(value = "qnANum") String qnANum, @RequestParam(value = "commentContent") String commentContent, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ResponseEntity resEntity = null;
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("qnANum", qnANum);
		paramMap.put("commentContent", commentContent);
		
		List<Map<String, Object>> commentList = new ArrayList<Map<String,Object>>();
	
		commentList = boardService.commentList(paramMap);
		
		resEntity = new ResponseEntity(commentList, HttpStatus.OK);
		return resEntity;
	}

	// �α��� ���� üũ (ModelAndView, ��������, ������ ȭ�� )
	private ModelAndView loginChk(ModelAndView mav, MemberVO sessinLogin, String view) throws Exception {
		if (sessinLogin != null) {
			mav.setViewName(view);
			return mav;
		} else {
			mav.addObject("joinMas", "�߸��� ��η� �����ϼ̽��ϴ�.");
			mav.setViewName("redirect:/main.do");
			return mav;
		}
	}

	// ������ ���� üũ (ModelAndView, ��������, ������ ȭ�� )
	private ModelAndView sessionChk(ModelAndView mav, MemberVO sessinLogin, String view) throws Exception {
		if (sessinLogin != null) {
			String rightChk = (String) sessinLogin.getMasterYN();
			if (rightChk.equals("M")) {
				mav.addObject("member", sessinLogin);
				mav.setViewName(view);
				return mav;
			} else {
				mav.addObject("joinMas", "�߸��� ��η� �����ϼ̽��ϴ�.");
				mav.setViewName("redirect:/main.do");
				return mav;
			}
		} else {
			mav.addObject("joinMas", "�߸��� ��η� �����ϼ̽��ϴ�.");
			mav.setViewName("redirect:/main.do");
			return mav;
		}
	}

}
