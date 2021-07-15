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
import com.pro.green.product_M.vo.ProductVO2;

@Controller("productController")
public class ProductControllerImpl implements ProductController {
	private static final String PRODUCT_IMAGE_REPO = "C:\\product\\product_image";
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductVO2 productVO;

	/* log4j작업 */
	// private static final Logger logger =
	// LoggerFactory.getLogger(ProductControllerImpl.class);

	// 상품 목록
	@Override
	@RequestMapping(value = "/list.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listProduct(@RequestParam("p_group") String p_group, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<ProductVO2> productsList = productService.listProduct(p_group);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		mav.addObject("productsList", productsList);
		return mav;

	}

	// 상품 상세페이지
	@RequestMapping(value = "/list/listDetail.do", method = RequestMethod.GET)
	public ModelAndView viewProduct(@RequestParam("productId") String productId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		productVO = productService.viewProduct(productId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listDetail");
		mav.addObject("viewProduct", productVO);
		return mav;

	}

}
