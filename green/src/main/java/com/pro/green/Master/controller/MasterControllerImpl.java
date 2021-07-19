package com.pro.green.Master.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.Master.service.MasterService;
import com.pro.green.Master.vo.CouponVO;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product_M.service.ProductService2;
import com.pro.green.product_M.vo.Criteria;
import com.pro.green.product_M.vo.PageMaker;

@Controller("masterController")
public class MasterControllerImpl implements MasterController {

	@Autowired
	private MasterService masterService;

	// ��������
	@Override
	@RequestMapping(value = "/couponList.do", method = RequestMethod.GET)
	public ModelAndView couponList(@ModelAttribute("member") MemberVO memberInf, HttpServletResponse response,
			HttpServletRequest request, Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// ������ ���� üũ (ModelAndView, ��������, "����ȭ���̸�")
		sessionChk(mav, sessinLogin, "couponList");

		PageMaker pageMaker = new PageMaker();
		int pageTotal = 0;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		pageTotal = masterService.listCount();
		pageMaker.setCri(cri);

		list = masterService.selectCouponList(cri);

		pageMaker.setTotalCount(pageTotal);

		pageMaker.setCri(cri);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("couponList", list);

		return mav;
	}

	// ������� ȭ��
	@RequestMapping(value = "/couponList/add.do", method = RequestMethod.GET)
	public ModelAndView couponAddPage(HttpServletRequest request, Locale locale, Model model) throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// ������ ���� üũ (ModelAndView, ��������, "����ȭ���̸�")
		sessionChk(mav, sessinLogin, "redirect:/couponAdd.do");

		return mav;
	}

	// �������
	@Override
	@RequestMapping(value = "/couponList/couponAdd.do", method = RequestMethod.POST)
	public ModelAndView couponAdd(@ModelAttribute("coupon") CouponVO coupon, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");

		int result = 0;
		ModelAndView mav = new ModelAndView();

		result = masterService.couponAdd(coupon);

		if (result == 0) {
			mav.addObject("addMsg", "������Ͽ� ���� �߽��ϴ�. �ٽ� �õ��� �ּ���.");
		} else {
			mav.addObject("addMsg", "������ ��ϵǾ����ϴ�.");
		}

		mav.setViewName("redirect:/couponList.do");

		return mav;
	}

	// ������ ���� ��� ���� ����
	@RequestMapping(value = "/couponList/useYNChk.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String id = request.getParameter("id");
		String value = request.getParameter("value");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("value", value);

		int result = masterService.useYNChk(paramMap);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
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
