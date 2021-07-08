package com.pro.green.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.member.vo.MemberVO;
import com.pro.green.product.vo.Criteria;
import com.pro.green.product.vo.ProductVO2;

public interface ProductController2 {
	public ModelAndView productList(@ModelAttribute("member") MemberVO member, HttpServletRequest request) throws Exception;
	
	public ModelAndView productList(@ModelAttribute("member") MemberVO member, HttpServletRequest request, Criteria cri) throws Exception; 
	public ModelAndView addProduct(@ModelAttribute("member") MemberVO member, HttpServletRequest request) throws Exception;
	public ModelAndView addProductEditaddEdit(@ModelAttribute("product") ProductVO2 product, MultipartHttpServletRequest request,HttpServletResponse response) throws Exception;
}
