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

	// 커뮤니티 리스트
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

			list = boardService.selectList(selectOption);

		} else if (communityType.equals("notice")) {
			mav.addObject("pageTitle", "공지사항");

		} else if (communityType.equals("event")) {
			mav.addObject("pageTitle", "이벤트");

		} else if (communityType.equals("review")) {
			mav.addObject("pageTitle", "리뷰");

		}

		pageMaker.setCri(cri);

		pageMaker.setTotalCount(list.size());

		mav.addObject("member", member);
		mav.addObject("list", list);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("communityType", communityType);
		mav.setViewName("communityList");
		return mav;
	}

	// 커뮤니티 등록화면
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
			mav.addObject("pageTitle", "QnA 등록");

			// 주소로 접근 방지
			loginChk(mav, member, "communityAdd");

		} else if (communityType.equals("notice")) {
			mav.addObject("pageTitle", "공지사항 등록");

			// 관리자 세션 체크 (ModelAndView, 세션정보, "접속화면이름")
			sessionChk(mav, member, "communityAdd");

		} else if (communityType.equals("event")) {
			mav.addObject("pageTitle", "이벤트 등록");

			// 관리자 세션 체크 (ModelAndView, 세션정보, "접속화면이름")
			sessionChk(mav, member, "communityAdd");

		} else if (communityType.equals("review")) {
			mav.addObject("pageTitle", "리뷰 등록");

			// 주소로 접근 방지
			loginChk(mav, member, "communityAdd");

		}

		mav.addObject("member", member);
		mav.addObject("list", list);
		mav.addObject("communityType", communityType);

		return mav;
	}

	// 커뮤니티 등록
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

		} else if (communityType.equals("event")) {

		} else if (communityType.equals("review")) {

		}

		result = boardService.insertArticle(selectOption);

		mav.addObject("member", member);
		mav.addObject("communityType", communityType);
		mav.setViewName("redirect:/community.do");

		return mav;
	}

	// 상품검색 창
	@RequestMapping(value = "/productSearch.do", method = RequestMethod.GET)
	public String productSearch(Locale locale, Model model) {
		return "productSearch";
	}

	// 상품검색
	@RequestMapping(value = "/productSearch/search.do", method = RequestMethod.POST)
	public ResponseEntity productSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String keyWord = request.getParameter("keyWord");

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		result = boardService.productSearch(keyWord);

		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}

	// 페이지상세
	@RequestMapping(value = "/communityDerail/derailPage.do", method = RequestMethod.GET)
	public ModelAndView communityDerail(@RequestParam(value = "communityNum") String communityNum,
										@RequestParam(value = "communityType") String communityType,
			HttpServletRequest request, HttpServletResponse response, Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView(); 
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		ArticleVO2 community = new ArticleVO2();
		Map<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("type", communityType);
		selectOption.put("communityNum", "questionNum='"+ communityNum +"'" );
		
		if(communityType.equals("qna")) {
			selectOption.put("value", "questionNum AS num, id AS id, productId AS productId, questionTitle AS title, questionContent AS content, questionHits AS hits, questionPw AS questionPw, pwYN AS pwYN");
			
			community = boardService.selectCommunity(selectOption);
			
			if(community.getPwYN().equals("Y")) {
				mav.setViewName("redirect:/communityChk.do?communityNum=" +communityNum+"&communityType="+communityType);
			}else {
				mav.addObject("pageTitle", "QnA");
				mav.setViewName("communityDerail");
			}
			
		}else {
			mav.setViewName("communityDerail");
		}
		
		community = boardService.selectCommunity(selectOption);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("page", cri.getPage());
		mav.addObject("communityType", communityType);
		mav.addObject("community", community);
		mav.addObject("member", member);
		return mav;
	}
	
	// 게시물 비번체크
	@RequestMapping(value = "/communityChk.do", method = RequestMethod.GET)
	public ModelAndView communityChk(@RequestParam(value = "communityNum") String communityNum,
										@RequestParam(value = "communityType") String communityType,
			HttpServletRequest request, HttpServletResponse response, Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		mav.addObject("page", cri.getPage());
		return mav;
	}

	// 로그인 상테 체크 (ModelAndView, 세션정보, 접속할 화면 )
	private ModelAndView loginChk(ModelAndView mav, MemberVO sessinLogin, String view) throws Exception {
		if (sessinLogin != null) {
			mav.setViewName(view);
			return mav;
		} else {
			mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
			mav.setViewName("redirect:/main.do");
			return mav;
		}
	}

	// 관리자 세션 체크 (ModelAndView, 세션정보, 접속할 화면 )
	private ModelAndView sessionChk(ModelAndView mav, MemberVO sessinLogin, String view) throws Exception {
		if (sessinLogin != null) {
			String rightChk = (String) sessinLogin.getMasterYN();
			if (rightChk.equals("M")) {
				mav.addObject("member", sessinLogin);
				mav.setViewName(view);
				return mav;
			} else {
				mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
				mav.setViewName("redirect:/main.do");
				return mav;
			}
		} else {
			mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
			mav.setViewName("redirect:/main.do");
			return mav;
		}
	}

}
