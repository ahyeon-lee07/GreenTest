package com.pro.green.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.member.vo.MemberVO;

public interface ProductController2 {
	public ModelAndView productList(@ModelAttribute("member") MemberVO member, HttpServletRequest request) throws Exception;
	public ModelAndView addProduct(@ModelAttribute("member") MemberVO member, HttpServletRequest request) throws Exception;
}
