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

import com.pro.green.product.service.ProductService;
import com.pro.green.product_M.vo.Criteria;
import com.pro.green.product_M.vo.PageMaker;
import com.pro.green.product_M.vo.ProductVO2;

@Controller("productController")
public class ProductControllerImpl implements ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductVO2 productVO;


	// 상품 목록
	@Override
	@RequestMapping(value = "/prodList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listProduct(@RequestParam("p_group") String p_group, HttpServletRequest request,
			HttpServletResponse response, Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if(p_group.equals("hard")) {
			mav.addObject("pageTitle", "하드케이스");
		}else if(p_group.equals("gel")) {
			mav.addObject("pageTitle", "젤케이스");
		}else if(p_group.equals("card")) {
			mav.addObject("pageTitle", "카드케이스");
		}else if(p_group.equals("airPods")) {
			mav.addObject("pageTitle", "에어팟케이스");
		}else if(p_group.equals("buds")) {
			mav.addObject("pageTitle", "버즈케이스");
		}else if(p_group.equals("keyRing")) {
			mav.addObject("pageTitle", "키링");
		}else if(p_group.equals("smart")) {
			mav.addObject("pageTitle", "스마트톡");
		}else {
			mav.addObject("pageTitle", "상품");
		}
		
		PageMaker pageMaker = new PageMaker();

		//int pageTotal = 0;

		List<ProductVO2> productsList = productService.listProduct(p_group);
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productsList.size());
		
		mav.setViewName("prodList");
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("productsList", productsList);
		return mav;

	}


	// 상품 상세페이지
	@Override
	@RequestMapping(value = "/prodList/prodDetail.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView viewProduct(@RequestParam("productId") String productId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		ProductVO2 prodList = new ProductVO2();

		prodList = productService.viewProdDetail(productId);
		List<Map<String, Object>> prodOption = productService.selectProdOption(productId);
		List<Map<String, Object>> img = productService.selectProdImg(productId);
		
		mav.setViewName("prodDetail");


		mav.addObject("prodList", prodList);
		mav.addObject("prodOption", prodOption);
		mav.addObject("product_M", img.get(0).get("imgURL"));
		mav.addObject("product_S", img.get(1).get("imgURL"));

		mav.addObject("options", request.getParameter("options"));

		return mav;
	}

}
