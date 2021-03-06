package com.pro.green.Master.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.Master.service.MasterService;
import com.pro.green.Master.vo.CouponVO;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product_M.service.ProductService2;
import com.pro.green.product_M.vo.Criteria;
import com.pro.green.product_M.vo.PageMaker;

@Controller("masterController")
public class MasterControllerImpl implements MasterController {

	@Autowired
	private MasterService masterService;

	@Autowired
	private CouponVO couponVO;

	// 捻迄包府
	@Override
	@RequestMapping(value = "/couponList.do", method = RequestMethod.GET)
	public ModelAndView couponList(@ModelAttribute("member") MemberVO memberInf, HttpServletResponse response,
			HttpServletRequest request, Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// 包府磊 技记 眉农 (ModelAndView, 技记沥焊, "立加拳搁捞抚")
		sessionChk(mav, sessinLogin, "couponList");

		PageMaker pageMaker = new PageMaker();
		int pageTotal = 0;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		pageTotal = masterService.listCount();
		pageMaker.setCri(cri);

		list = masterService.selectCouponList(cri);

		pageMaker.setTotalCount(pageTotal);

		pageMaker.setCri(cri);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("couponList", list);

		return mav;
	}

	// 捻迄殿废 拳搁
	@RequestMapping(value = "/couponList/add.do", method = RequestMethod.GET)
	public ModelAndView couponAddPage(HttpServletRequest request, Locale locale, Model model) throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// 包府磊 技记 眉农 (ModelAndView, 技记沥焊, "立加拳搁捞抚")
		sessionChk(mav, sessinLogin, "redirect:/couponAdd.do");

		return mav;
	}

	// 捻迄殿废
	@Override
	@RequestMapping(value = "/couponList/couponAdd.do", method = RequestMethod.POST)
	public ModelAndView couponAdd(@ModelAttribute("coupon") CouponVO coupon, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");

		int result = 0;
		ModelAndView mav = new ModelAndView();

		result = masterService.couponAdd(coupon);

		if (result == 0) {
			mav.addObject("addMsg", "捻迄殿废俊 角菩 沁嚼聪促. 促矫 矫档秦 林技夸.");
		} else {
			mav.addObject("addMsg", "捻迄捞 殿废登菌嚼聪促.");
		}

		mav.setViewName("redirect:/couponList.do");

		return mav;
	}

	// 包府磊 捻迄 荤侩 咯何 函版
	@RequestMapping(value = "/couponList/useYNChk.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String id = request.getParameter("id");
		String value = request.getParameter("value");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("value", value);

		int result = masterService.useYNChk(paramMap);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}

	// 捻迄府胶飘 八祸 八祸
	@RequestMapping(value = "/couponList/search.do", method = RequestMethod.GET)
	public ModelAndView couponListSearch(@RequestParam(value = "searchKeyWordOption") String searchKeyWordOption,
			@RequestParam(value = "keyWord") String keyWord, HttpServletRequest request, Criteria cri)
			throws Exception {

		ModelAndView mav = new ModelAndView();
		PageMaker pageMaker = new PageMaker();

		int pageTotal = 0;

		pageMaker.setCri(cri);
		pageMaker.setTotalCount(pageTotal);

		Map<String, Object> searchOption = new HashMap<String, Object>();
		searchOption.put("cri", cri);
		searchOption.put("searchKeyWordOption", searchKeyWordOption);
		searchOption.put("keyWord", keyWord);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = masterService.searchCouponList(searchOption);

		mav.addObject("couponList", list);
		mav.addObject("pageMaker", pageMaker);
		mav.setViewName("couponList");

		return mav;
	}

	// 捻迄惑技
	@RequestMapping(value = "/couponList/couponDetail.do", method = RequestMethod.GET)
	public ModelAndView couponDetail(@RequestParam("couponId") String couponId, HttpServletRequest request,
			Criteria cri) throws Exception {

		ModelAndView mav = new ModelAndView();
		PageMaker pageMaker = new PageMaker();
		HttpSession session = request.getSession();

		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// 包府磊 技记 眉农 (ModelAndView, 技记沥焊, "立加拳搁捞抚")
		sessionChk(mav, sessinLogin, "couponDetail");

		// 捻迄沥焊
		CouponVO couponInf = new CouponVO();
		couponInf = masterService.selectCoupon(couponId);

		List<Map<String, Object>> memberList = masterService.memberList();
		List<Map<String, Object>> hasCoupon = masterService.hasCouponList(couponId);
		
		for(int i=0; i<hasCoupon.size(); i++) {
			
			String couponid = hasCoupon.get(i).get("id").toString();
			for(int j=0; j<memberList.size(); j++) {
				
				String memberid = memberList.get(j).get("id").toString();
				if(couponid.equals(memberid)) {
					memberList.get(j).put("hasCoupon", "Y");
				}
			}
		}

		pageMaker.setCri(cri);
		mav.addObject("page", cri.getPage());
		mav.addObject("couponInf", couponInf);
		mav.addObject("memberList", memberList);
		mav.addObject("hasCoupon", hasCoupon);

		return mav;
	}
	
	//捻迄 焊蜡 沥焊 函版
	@RequestMapping(value = "/couponList/hasCouponYN.do", method = RequestMethod.POST)
	public ResponseEntity hasCouponYN(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String couponId = request.getParameter("couponId");
		String value = request.getParameter("value");
		String userId = request.getParameter("userId");
		

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("couponId", couponId);
		paramMap.put("userId", userId);
		
		int result;
		
		if(value.equals("Y")) {
			result = masterService.hasCouponAdd(paramMap);
		}else {
			result = masterService.hasCouponDelete(paramMap);
		}

		List<Map<String, Object>> memberList = masterService.memberList();
		List<Map<String, Object>> hasCoupon = masterService.hasCouponList(couponId);
		
		for(int i=0; i<hasCoupon.size(); i++) {
			
			String couponid = hasCoupon.get(i).get("id").toString();
			for(int j=0; j<memberList.size(); j++) {
				
				String memberid = memberList.get(j).get("id").toString();
				if(couponid.equals(memberid)) {
					memberList.get(j).put("hasCoupon", "Y");
				}
			}
		}
		
		Map<String, Object> list = new HashMap();
		list.put("memberList", memberList);
		list.put("hasCoupon", hasCoupon);
		
		resEntity = new ResponseEntity(list, HttpStatus.OK);
		
		return resEntity;
	}

	// 捻迄郴侩 荐沥
	@RequestMapping(value = "/couponList/couponUpdate.do", method = RequestMethod.POST)
	public ModelAndView couponUpdate(@RequestParam(value = "couponId") String couponId, @ModelAttribute("coupon") CouponVO coupon, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();
		PageMaker pageMaker = new PageMaker();
		HttpSession session = request.getSession();

		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// 包府磊 技记 眉农 (ModelAndView, 技记沥焊, "立加拳搁捞抚")
		sessionChk(mav, sessinLogin, "redirect:/couponList.do");

		// 荐沥
		int result = masterService.couponUpdate(coupon);

		return mav;
	}
	
	

	// 包府磊 技记 眉农 (ModelAndView, 技记沥焊, 立加且 拳搁 )
	private ModelAndView sessionChk(ModelAndView mav, MemberVO sessinLogin, String view) throws Exception {
		if (sessinLogin != null) {
			String rightChk = (String) sessinLogin.getMasterYN();
			if (rightChk.equals("M")) {
				mav.addObject("member", sessinLogin);
				mav.setViewName(view);
				return mav;
			} else {
				mav.addObject("joinMas", "肋给等 版肺肺 立加窍继嚼聪促.");
				mav.setViewName("redirect:/main.do");
				return mav;
			}
		} else {
			mav.addObject("joinMas", "肋给等 版肺肺 立加窍继嚼聪促.");
			mav.setViewName("redirect:/main.do");
			return mav;
		}
	}
}
