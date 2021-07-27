package com.pro.green;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.board.service.BoardService2;
import com.pro.green.board.vo.ArticleVO2;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product_M.vo.Criteria;
import com.pro.green.product_M.vo.PageMaker;
import com.pro.green.product_M.vo.ProductVO2;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BoardService2 boardService;
	@Autowired
	private ArticleVO2 articleVO;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private ProductVO2 product;

	/*
	// ����ȭ��
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("joinOk");
		return "main";
	}
	*/

	// ����ȭ��
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response, Criteria cri) throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		PageMaker pageMaker = new PageMaker();

		List<ArticleVO2> noticeList = new ArrayList<ArticleVO2>();
		Map<String, Object> selectOption = new HashMap<String, Object>();
		
		selectOption.put("selectOption", "noticeNum AS num, id AS id,noticeTitle AS title,noticeContent AS content,noticeHits AS hits, noticeDate AS createDate");
		int pageTotal = 0;
		
		noticeList = boardService.mainSeletNotice(selectOption);

		pageMaker.setCri(cri);

		pageMaker.setTotalCount(noticeList.size());
		
		for(int i=0; i <noticeList.size(); i++) {
			
			if(i>4) {
				noticeList.remove(i);
			}
		}
		
		mav.addObject("member", member);
		mav.addObject("noticeList", noticeList);
		mav.addObject("communityType", "notice");
		mav.addObject("pageMaker", pageMaker);
		mav.setViewName("main");
		return mav;
	}

	// ȸ��Ұ�
	@RequestMapping(value = "/company.do", method = RequestMethod.GET)
	public String COMPANY(Locale locale, Model model) {
		return "company";
	}

	// �̿���
	@RequestMapping(value = "/agreement.do", method = RequestMethod.GET)
	public String agreement(Locale locale, Model model) {
		return "agreement";
	}

	// ��������ó����ħ
	@RequestMapping(value = "/privacyPolicy.do", method = RequestMethod.GET)
	public String privacyPolicy(Locale locale, Model model) {
		return "privacyPolicy";
	}

	// ��ȸ���α���
	@RequestMapping(value = "/noMember.do", method = RequestMethod.GET)
	public String unMember(Locale locale, Model model) {
		return "noMember";
	}

	// ��ٱ���
	@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
	public String cart(Locale locale, Model model) {
		return "cart";
	}

	// �ֹ��� �ۼ�
	@RequestMapping(value = "/orderList.do", method = RequestMethod.GET)
	public String orderList(Locale locale, Model model) {
		return "orderList";
	}

	// ���ų��� ��ȸ
	@RequestMapping(value = "/purchaseList.do", method = RequestMethod.GET)
	public String purchaseList(Locale locale, Model model) {
		return "purchaseList";
	}

	// ����
	@RequestMapping(value = "/review.do", method = RequestMethod.GET)
	public String review(Locale locale, Model model) {
		return "review";
	}

	// �����
	@RequestMapping(value = "/review_in.do", method = RequestMethod.GET)
	public String review_in(Locale locale, Model model) {
		return "review_in";
	}

}
