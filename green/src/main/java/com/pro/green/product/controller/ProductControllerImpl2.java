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
import com.pro.green.product.vo.ProductVO2;
import com.pro.green.product.service.ProductService2;

@Controller("ProductController")
public class ProductControllerImpl2 implements ProductController2 {

	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private ProductService2 productService;
	@Autowired
	private ProductVO2 product;

	// 사품등록 리스트
	@Override
	@RequestMapping(value = "/productList.do", method = RequestMethod.GET)
	public ModelAndView productList(@ModelAttribute("member") MemberVO member, HttpServletRequest request)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		if (sessinLogin != null) {
			String rightChk = (String) sessinLogin.getMasterYN();
			if (rightChk.equals("M")) {
				mav.addObject("member", sessinLogin);
				mav.setViewName("productList");
			} else {
				mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
				mav.setViewName("redirect:/main.do");
			}
		} else {
			mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
			mav.setViewName("redirect:/main.do");
		}

		return mav;
	}

	// 사품등록
	@Override
	@RequestMapping(value = "/addProduct.do", method = RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("member") MemberVO member, HttpServletRequest request)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		if (sessinLogin != null) {
			String rightChk = (String) sessinLogin.getMasterYN();
			if (rightChk.equals("M")) {
				mav.addObject("member", sessinLogin);
				mav.setViewName("addProduct");
			} else {
				mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
				mav.setViewName("redirect:/main.do");
			}
		} else {
			mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
			mav.setViewName("redirect:/main.do");
		}

		return mav;
	}
	
	
	//상품 등록
	@Override
	@RequestMapping(value = "/product/addEdit.do", method = RequestMethod.POST)
	public ModelAndView addProductEdit(@ModelAttribute("product") ProductVO2 product , HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		ModelAndView mav = new ModelAndView();
		
		int result = 0;
		result = productService.addProductEdit(product);
		
		mav.setViewName("redirect:/productList.do");
		return mav;
	}
}
