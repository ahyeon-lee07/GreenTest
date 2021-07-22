package com.pro.green.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.member.vo.MemberVO;
import com.pro.green.product.service.MypageProductService;
import com.pro.green.product.service.ProductService;
import com.pro.green.product.vo.CartVO;
import com.pro.green.product_M.service.ProductService2;
import com.pro.green.product_M.vo.ProductVO2;

@Controller("mypageProductController")
public class MypageProductControllerImpl implements MypageProductController {

	@Autowired
	private MypageProductService mypageProductService;

	@Autowired
	private CartVO cartVO;
	
	@Autowired
	private ProductService2 productService;
	

	// 관심상품 리스트
	@RequestMapping(value = "/wish_list.do", method = RequestMethod.GET)
	public ModelAndView productList(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("member");
		
		String userId = user.getId();
		
		List<Map<String, Object>> wishList = new ArrayList<Map<String, Object>>();
		Map<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("userId", userId);
		selectOption.put("type", "wish");
		
		wishList = mypageProductService.wishList(selectOption);
		
		List optionList = new ArrayList();

		for (int i = 0; i < wishList.size(); i++) {
			String productId = (String) wishList.get(i).get("productId");
			List<Map<String, Object>> option = productService.selectOptionList(productId);
			optionList.add(option);
		}
		
		mav.addObject("wishCount", wishList.size());
		mav.addObject("wishList", wishList);
		mav.addObject("optionList", optionList);
		
		mav.setViewName("wishList");
		return mav;
	}
}
