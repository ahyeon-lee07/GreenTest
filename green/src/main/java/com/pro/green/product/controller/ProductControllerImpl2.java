package com.pro.green.product.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.member.service.MemberService;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product.vo.Criteria;
import com.pro.green.product.vo.PageMaker;
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
	
	@Autowired
	private Criteria criteria;
	@Autowired
	private PageMaker pageMaker;
	
	// 사품등록 리스트 Test
	@Override
	@RequestMapping(value = "/productListTest.do", method = RequestMethod.GET)
	public ModelAndView productListTest(@ModelAttribute("member") MemberVO member, HttpServletRequest request, Criteria cri)
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
		
		PageMaker pageMaker = new PageMaker();
		
		int pageTotal = productService.countBoardListTotal();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(pageTotal);
		
		List<Map<String,Object>> list = productService.selectBoardList(cri);
		List optionList = new ArrayList();
		
		for(int i=0; i<list.size(); i++) {
			String productId = (String) list.get(i).get("productId");
			List<Map<String,Object>> option = productService.selectOptionLIst(productId);
			optionList.add(option);
		}
		
		
	    mav.addObject("list", list);
	    System.out.println(list.get(0).get("productId"));
	    System.out.println(list.get(0));
	    mav.addObject("optionList", optionList);
	    System.out.println(optionList.get(0));
	    mav.addObject("pageMaker", pageMaker);

	    
		return mav;
	}

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

	
	// 상품 등록
	@Override
	@RequestMapping(value = "/product/addEdit.do", method = RequestMethod.POST)
	public ModelAndView addProductEditaddEdit(@ModelAttribute("product") ProductVO2 product, MultipartHttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		ModelAndView mav = new ModelAndView();

		int result = 0;
		result = productService.addProductEdit(product);

		// 등록한 상품 아이디 가져오기
		String selectProductID = productService.selectProductId(product);

		// 상품 옵션등록
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productId", selectProductID);

		for (int i = 0; i < product.getProductVOList().size(); i++) {

			paramMap.put("option", product.getProductVOList().get(i).getOption());
			paramMap.put("stock", product.getProductVOList().get(i).getStock());

			result = productService.addProductOption(paramMap);
		}
		
		
		//이미지 업로드
		//Map map = new HashMap();	//매개변수 정보와 파일 정보를 저장할 Map을 생성
				
		//파일을 업로드한 후 반환된 파일 이름이 저장된 FileList를 다시 map에 저장
		List fileList = fileProcess(request, selectProductID);
		
		//map.put("fileList", fileList);
		//mao을 결과창으로 포워딩
		//mav.addObject("map", map);

		mav.setViewName("redirect:/productList.do");
		return mav;
	}
	
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest, String selectProductID) throws Exception {
		
		//이미지 경로
		String root_path = multipartRequest.getSession().getServletContext().getRealPath("/");  
		String image_path = root_path + "resources\\img" ;

		List<String> fileList = new ArrayList<String>();
		String imgPart = multipartRequest.getParameter("p_group");
		
		Map<String, Object> ImageMap = new HashMap<String, Object>();
		ImageMap.put("productId", selectProductID);
		int result = 0;
		
		//첨부된 파일 이름을 가져옵니다.
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()) {
			String FileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(FileName);	//파일 이름에 대한 MultipartFile 객체를 가져옴
			String originalFileName = mFile.getOriginalFilename();		//실제 파일 이름을 가져옴
			fileList.add(originalFileName);		//파일 이름을 하나씩 fileList에 저장
			File file = new File(image_path + "\\" + imgPart + "\\" + FileName);
			if(mFile.getSize() != 0) {	//첨부된 파일이 있는지 체크
				//경로에 파일이 없으면 그 경로에 해당하는 디렉토리를 만든 후 파일 생성
				if(! file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(image_path + "\\" + imgPart + "\\" + originalFileName));	//임시로 저장된 mutipartFile을 실제 파일로 전송
			}
			
			//이미지 디비에 저장
			if(FileName.equals("imgURL_product_M")) {
				ImageMap.put("imgType", "product_M");
				ImageMap.put("imgURL", originalFileName);
				result = productService.addProductImg(ImageMap);
				
			}else if(FileName.equals("imgURL_product_S")) {
				ImageMap.put("imgType", "product_S");
				ImageMap.put("imgURL", originalFileName);
				result = productService.addProductImg(ImageMap);
			}
			
		}
		return fileList;
	}

}
