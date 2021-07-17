package com.pro.green.Master.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.Master.service.MasterService;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product_M.service.ProductService2;
import com.pro.green.product_M.vo.Criteria;
import com.pro.green.product_M.vo.PageMaker;

@Controller("masterController")
public class MasterControllerImpl implements MasterController {

	@Autowired
	private MasterService masterService;

	// ��������
	@RequestMapping(value = "/master/couponList.do", method = RequestMethod.GET)
	public ModelAndView couponList(@ModelAttribute("member") MemberVO memberInf, HttpServletRequest request,
			Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// ������ ���� üũ (ModelAndView, ��������, "����ȭ���̸�")
		sessionChk(mav, sessinLogin, "redirect:/couponList.do");

		PageMaker pageMaker = new PageMaker();
		int pageTotal = 0;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		pageMaker.setCri(cri);

		list = masterService.selectCouponList(cri);

		pageMaker.setTotalCount(list.size());

		pageMaker.setCri(cri);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("couponList", list);

		return mav;
	}

	// ������� ȭ��
	@RequestMapping(value = "/couponList/add.do", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {
		return "couponAdd";
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
