package com.pro.green.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pro.green.member.service.MemberService;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product.vo.Criteria;
import com.pro.green.product.vo.PageMaker;
import com.pro.green.product.vo.ProductVO2;

import net.coobird.thumbnailator.Thumbnails;

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
	
	// 사품등록 리스트
	@Override
	@RequestMapping(value = "/productList.do", method = RequestMethod.GET)
	public ModelAndView productList(@ModelAttribute("member") MemberVO member, HttpServletRequest request, Criteria cri)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		//관리자 세션 체크 (ModelAndView, 세션정보, "접속화면이름")
		sessionChk(mav, sessinLogin, "productList");
		
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
	    mav.addObject("optionList", optionList);
	    mav.addObject("pageMaker", pageMaker);

		return mav;
	}
	
	
// 테스트 ----------------------------------------------------
	
	//관리자 상세페이지
	@RequestMapping("/productList/productDetail_M.do")
    public ModelAndView boardDetail(HttpServletRequest request, HttpServletResponse response, Criteria cri) throws Exception {
        
        ModelAndView mav = new ModelAndView();
        
        HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");
		
		//상품 아이디
		String productId = request.getParameter("productId");

		//관리자 세션 체크 (ModelAndView, 세션정보, "화면이름")
		sessionChk(mav, sessinLogin, "productDetail_M");
		
		ProductVO2 ProductVO = new ProductVO2();
        
		//상품 정보 가져오기
		ProductVO = productService.viewProductDetail(productId);
		//상품 옵션 가져오기
		List<Map<String,Object>> option = productService.selectOptionLIst(productId);
		List<Map<String,Object>> img = productService.selectProductImg(productId);
		
		mav.addObject("pageTitle","상품 상세");
        mav.addObject("ProductVO",ProductVO);
        mav.addObject("option",option);
        mav.addObject("product_M",img.get(0).get("imgURL"));
        mav.addObject("product_S",img.get(1).get("imgURL"));
        
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        mav.addObject("page",cri.getPage());
        mav.addObject("pageMaker", pageMaker);
        
        return mav;
    }
 
    @RequestMapping(value="/productList/productUpdate_M.do")
    public ModelAndView boardUpdate( Criteria cri) throws Exception {
        
        ModelAndView mv = new ModelAndView("/board/boardUpdate");
       // Map<String, Object> detail = productService.selectProductDetail(commandMap.getMap());
       // mv.addObject("detail",detail);
        
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        mv.addObject("page",cri.getPage());
        mv.addObject("pageMaker", pageMaker);
        
        return mv;
    }
 
    @RequestMapping(value="/productList/productUpdate_M.do", method=RequestMethod.POST)
    public ModelAndView boardUpdatePOST( Criteria cri, RedirectAttributes redAttr) throws Exception {
        
        ModelAndView mv = new ModelAndView("redirect:/board/boardDetail");
       // mv.addObject("idx", commandMap.get("idx"));
        
        int result = 0;
       // result  = productService.updateProduct(commandMap.getMap());
        
        redAttr.addAttribute("page", cri.getPage());
        redAttr.addAttribute("perPagNum", cri.getPerPageNum());
        
        return mv;
    }
    
    @RequestMapping(value="/productList/productDelete_M.do")
    public ModelAndView boardDelete( Criteria cri, RedirectAttributes redAttr) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/board/boardList");
        
        int result = 0;
       // result  = productService.deleteProduct(commandMap.getMap());
        
        redAttr.addAttribute("page", cri.getPage());
        redAttr.addAttribute("perPagNum", cri.getPerPageNum());
        
        return mv;
    }

	
 // 테스트 ----------------------------------------------------
	
	// 사품등록
	@Override
	@RequestMapping(value = "/addProduct.do", method = RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("member") MemberVO member, HttpServletRequest request)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");
		
		mav.addObject("pageTitle","상품 등록");
		//관리자 세션 체크 (ModelAndView, 세션정보, "접속화면이름")
		sessionChk(mav, sessinLogin, "addProduct");

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
		
		//파일을 업로드한 후 반환된 파일 이름이 저장된 FileList를 다시 map에 저장
		List fileList = fileProcess(request, selectProductID);
		
		
		mav.setViewName("redirect:/productList.do");
		return mav;
	}
	
	//이미지 저장
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
	
	
	//관리자 세션 체크 (ModelAndView, 세션정보, 접속할 화면 )
	private ModelAndView sessionChk(ModelAndView mav, MemberVO sessinLogin, String view) throws Exception {
		if (sessinLogin != null) {
			String rightChk = (String) sessinLogin.getMasterYN();
			if (rightChk.equals("M")) {
				mav.addObject("member", sessinLogin);
				mav.setViewName(view);
				return mav;
			} else {
				mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
				mav.setViewName("redirect:/main.do");
				return mav;
			}
		} else {
			mav.addObject("joinMas", "잘못된 경로로 접속하셨습니다.");
			mav.setViewName("redirect:/main.do");
			return mav;
		}
	}
}

