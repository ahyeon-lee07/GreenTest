package com.pro.green.Master.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.pro.green.Master.vo.CouponVO;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product_M.service.ProductService2;
import com.pro.green.product_M.vo.Criteria;
import com.pro.green.product_M.vo.PageMaker;

@Controller("masterController")
public class MasterControllerImpl implements MasterController {

	@Autowired
	private MasterService masterService;

	// 쿠폰관리
	@RequestMapping(value = "/master/couponList.do", method = RequestMethod.GET)
	public ModelAndView couponList(@ModelAttribute("member") MemberVO memberInf, HttpServletResponse response, HttpServletRequest request,
			Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// 관리자 세션 체크 (ModelAndView, 세션정보, "접속화면이름")
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

	// 쿠폰등록 화면
	@RequestMapping(value = "/couponList/add.do", method = RequestMethod.GET)
	public ModelAndView couponAddPage(HttpServletRequest request, Locale locale, Model model) throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// 관리자 세션 체크 (ModelAndView, 세션정보, "접속화면이름")
		sessionChk(mav, sessinLogin, "redirect:/couponAdd.do");

		return mav;
	}

	// 쿠폰등록
	@Override
	@RequestMapping(value = "/couponList/couponAdd.do", method = RequestMethod.POST)
	public ModelAndView couponAdd(@ModelAttribute("coupon") CouponVO coupon, HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		int result = 0;
		ModelAndView mav = new ModelAndView();
		
		result = masterService.couponAdd(coupon);
		
		if (result == 0) {
			mav.addObject("addMsg", "쿠폰등록에 실패 했습니다. 다시 시도해 주세요.");
			mav.addObject("joinMas", "회원 정보 수정이 완료 되었습니다.");
		} else {
			mav.addObject("addMsg", "쿠폰이 등록되었습니다..");
			mav.addObject("joinMas", "회원 정보 수정이 완료 되었습니다.");
		}
			
		mav.setViewName("redirect:/master/couponList.do");

		return mav;
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
