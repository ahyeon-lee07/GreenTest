package com.pro.green.product.controller;

import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.member.service.MemberService;
import com.pro.green.member.vo.MemberVO;

@Controller("ProductControllerImpl2")
public class ProductControllerImpl2 implements ProductController2 {

	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;

	// 사품등록
	@Override
	@RequestMapping(value = "/addProduct.do", method = RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("member") MemberVO member, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");
		
		
		if (sessinLogin != null) {
			String rightChk = (String) sessinLogin.getMasterYN();
			if(rightChk.equals("M")) {
				mav.addObject("member", sessinLogin);
				mav.setViewName("addProduct");
			}else {
				mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
				mav.setViewName("redirect:/main.do");
			}
		}else {
			mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
			mav.setViewName("redirect:/main.do");
		}
		
		return mav;
	}
}
