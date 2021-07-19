package com.pro.green.Master.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.Master.vo.CouponVO;

public interface MasterController {
	public ModelAndView couponAdd(@ModelAttribute("coupon") CouponVO coupon, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
