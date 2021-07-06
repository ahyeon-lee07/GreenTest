package com.pro.green.product.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.pro.green.board.vo.ArticleVO;
import com.pro.green.product.service.ProductService;
import com.pro.green.product.vo.ProductVO;
import com.pro.green.product.vo.ImageFileVO;

@Controller("productController")
public class ProductControllerImpl  implements ProductController{
	private static final String PRODUCT_IMAGE_REPO = "C:\\product\\product_image";
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductVO productVO;
	
	/*log4jÀÛ¾÷*/
	// private static final Logger logger = LoggerFactory.getLogger(ProductControllerImpl.class);
	
	
	
	@Override
	@RequestMapping(value= "/HardCase.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView HardCase(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List<ProductVO> productsList = productService.HardCase();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("productsList", productsList);
		return mav;
		
	}
	
	
	/*
	@Override
	@RequestMapping(value="/HardCase.do", method=RequestMethod.GET)
	public ModelAndView listProducts(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName=getViewName(request);
		List productsList=productService.listProducts();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("productsList", productsList);
		return mav;
	}

	
	private String getViewName(HttpServletRequest request) throws Exception{
		String contextPath=request.getContextPath();
		String uri=(String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri==null||uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		int end;
		if(uri.indexOf(";") != -1) {
			end=uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end=uri.length();
		}
		
		String viewName= uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName=viewName.substring(0, viewName.lastIndexOf("."));
		} if (viewName.lastIndexOf("/") != -1) {
			viewName=viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
		}
		return viewName;
	}
*/

}

