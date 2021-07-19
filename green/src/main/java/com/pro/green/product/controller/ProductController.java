package com.pro.green.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.product_M.vo.Criteria;


public interface ProductController {
	
	// ��ǰ ���
	public ModelAndView listProduct(@RequestParam("p_group") String p_group,
			HttpServletRequest request, HttpServletResponse response, Criteria cri) throws Exception;

	// ��ǰ ��������
	public ModelAndView viewProduct(@RequestParam("productId") String productId,
			HttpServletRequest request, HttpServletResponse response, Criteria cri) throws Exception;
	
}