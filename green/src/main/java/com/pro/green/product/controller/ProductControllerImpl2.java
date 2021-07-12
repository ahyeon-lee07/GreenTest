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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	// ��ǰ��� ����Ʈ
	@Override
	@RequestMapping(value = "/productList.do", method = RequestMethod.GET)
	public ModelAndView productList(@ModelAttribute("member") MemberVO member, @RequestParam String options,
			HttpServletRequest request, Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		// ������ ���� üũ (ModelAndView, ��������, "����ȭ���̸�")
		sessionChk(mav, sessinLogin, "productList");

		PageMaker pageMaker = new PageMaker();

		int pageTotal = 0;

		pageMaker.setCri(cri);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		if (options == "") {
			// �ɼ� ���� ������
			pageTotal = productService.countBoardListTotal();
			list = productService.selectBoardList(cri);
		} else {
			// �ɼǰ��� ������ (����)
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("cri", cri);
			paramMap.put("options", options);
			
			pageTotal = productService.filterCountBoardListTotal(options);
			list = productService.selectFilterBoardList(paramMap);
		}
		
		pageMaker.setTotalCount(pageTotal);

		List optionList = new ArrayList();

		for (int i = 0; i < list.size(); i++) {
			String productId = (String) list.get(i).get("productId");
			List<Map<String, Object>> option = productService.selectOptionLIst(productId);
			optionList.add(option);
		}
		
		mav.addObject("list", list);
		mav.addObject("optionList", optionList);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("options", options);

		return mav;
	}
	
	// ������ ��ǰ ����Ʈ Ȱ��ȭ��� ����
	@RequestMapping(value = "/productList/showYNChk.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String id = request.getParameter("id");
		String value = request.getParameter("value");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("value", value);
		
		int result = productService.showYNChk(paramMap);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}

	//������ ��ǰ �˻�
	@RequestMapping(value = "/productList/search.do", method = RequestMethod.GET)
	public ModelAndView productList(@RequestParam(value = "searchKeyWordOption") String searchKeyWordOption,
									@RequestParam(value = "keyWord") String keyWord,
									@RequestParam(value = "searchOptions") String options,
									HttpServletRequest request, Criteria cri) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		PageMaker pageMaker = new PageMaker();
		
		int pageTotal = productService.countBoardListTotal();

		pageMaker.setCri(cri);
		pageMaker.setTotalCount(pageTotal);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		if (options == "") {
			// �ɼ� ���� ������
			paramMap.put("cri", cri);
			paramMap.put("keyWord", keyWord);
			list = productService.searchSelectBoardList(paramMap);
		} else {
			// �ɼǰ��� ������ (����)
			paramMap.put("cri", cri);
			paramMap.put("options", options);
			paramMap.put("keyWord", keyWord);
			
			list = productService.searchSelectFilterBoardList(paramMap);
		}

		List optionList = new ArrayList();

		for (int i = 0; i < list.size(); i++) {
			String productId = (String) list.get(i).get("productId");
			List<Map<String, Object>> option = productService.selectOptionLIst(productId);
			optionList.add(option);
		}
		
		mav.addObject("list", list);
		mav.addObject("optionList", optionList);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("options", options);
		mav.setViewName("productList");
		
		return mav;
	}
	
	// ������ ��������
	@RequestMapping("/productList/productDetail_M.do")
	public ModelAndView boardDetail(HttpServletRequest request, HttpServletResponse response, Criteria cri)
			throws Exception {

		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");
		
		// ��ǰ ���̵�
		String productId = request.getParameter("productId");

		// ������ ���� üũ (ModelAndView, ��������, "ȭ���̸�")
		sessionChk(mav, sessinLogin, "productDetail_M");

		ProductVO2 ProductVO = new ProductVO2();

		// ��ǰ ���� ��������
		ProductVO = productService.viewProductDetail(productId);
		// ��ǰ �ɼ� ��������
		List<Map<String, Object>> option = productService.selectOptionLIst(productId);
		List<Map<String, Object>> img = productService.selectProductImg(productId);

		mav.addObject("pageTitle", "��ǰ ��");
		mav.addObject("ProductVO", ProductVO);
		mav.addObject("option", option);
		mav.addObject("product_M", img.get(0).get("imgURL"));
		mav.addObject("product_S", img.get(1).get("imgURL"));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		mav.addObject("page", cri.getPage());
		mav.addObject("options", request.getParameter("options"));
		mav.addObject("pageMaker", pageMaker);

		return mav;
	}

	//������ ��ǰ ����
	@RequestMapping(value = "/productList/productUpdate_M.do", method = RequestMethod.POST)
	public ModelAndView boardUpdatePOST(@ModelAttribute("product") ProductVO2 product, @RequestParam String productId,
			MultipartHttpServletRequest request, Criteria cri, RedirectAttributes redAttr) throws Exception {

		ModelAndView mav = new ModelAndView("redirect:/productList.do");

		product.setProductId(productId);

		int result = 0;
		result = productService.updateProduct(product);

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productId", productId);

		// �ɼ� ���� �� �� ���
		result = productService.deleteProductOption(productId);
		for (int i = 0; i < product.getProductVOList().size(); i++) {

			paramMap.put("option", product.getProductVOList().get(i).getOption());
			paramMap.put("stock", product.getProductVOList().get(i).getStock());

			result = productService.addProductOption(paramMap);
		}

		// ������ ���ε��� �� ��ȯ�� ���� �̸��� ����� FileList�� �ٽ� map�� ����
		List fileList = fileProcess(request, productId);

		redAttr.addAttribute("page", cri.getPage());
		redAttr.addAttribute("perPagNum", cri.getPerPageNum());
		redAttr.addAttribute("options", request.getParameter("options"));
		
		return mav;
	}

	// ��ǰ ����
	@RequestMapping(value = "/productList/productDelete_M.do")
	public ModelAndView boardDelete(@RequestParam String productId, Criteria cri, RedirectAttributes redAttr)
			throws Exception {

		ModelAndView mv = new ModelAndView("redirect:/productList.do?options=");

		int result = 0;
		result = productService.deleteProduct(productId);

		redAttr.addAttribute("page", cri.getPage());
		redAttr.addAttribute("perPagNum", cri.getPerPageNum());

		return mv;
	}


	// ��ǰ���
	@Override
	@RequestMapping(value = "/addProduct.do", method = RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("member") MemberVO member, HttpServletRequest request)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");

		mav.addObject("pageTitle", "��ǰ ���");
		// ������ ���� üũ (ModelAndView, ��������, "����ȭ���̸�")
		sessionChk(mav, sessinLogin, "addProduct");

		return mav;
	}

	// ��ǰ ���
	@Override
	@RequestMapping(value = "/product/addEdit.do", method = RequestMethod.POST)
	public ModelAndView addProductEditaddEdit(@ModelAttribute("product") ProductVO2 product,
			MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		ModelAndView mav = new ModelAndView();

		int result = 0;
		result = productService.addProductEdit(product);

		// ����� ��ǰ ���̵� ��������
		String selectProductID = productService.selectProductId(product);

		// ��ǰ �ɼǵ��
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productId", selectProductID);

		for (int i = 0; i < product.getProductVOList().size(); i++) {

			paramMap.put("option", product.getProductVOList().get(i).getOption());
			paramMap.put("stock", product.getProductVOList().get(i).getStock());

			result = productService.addProductOption(paramMap);
		}

		// ������ ���ε��� �� ��ȯ�� ���� �̸��� ����� FileList�� �ٽ� map�� ����
		List fileList = fileProcess(request, selectProductID);

		mav.setViewName("redirect:/productList.do?options=");
		return mav;
	}

	// �̹��� ����
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest, String selectProductID)
			throws Exception {
		// �̹��� ���
		String root_path = multipartRequest.getSession().getServletContext().getRealPath("/");
		String image_path = root_path + "resources\\img";

		List<String> fileList = new ArrayList<String>();
		String imgPart = multipartRequest.getParameter("p_group");

		Map<String, Object> ImageMap = new HashMap<String, Object>();
		ImageMap.put("productId", selectProductID);
		int result = 0;

		// ÷�ε� ���� �̸��� �����ɴϴ�.
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while (fileNames.hasNext()) {
			String FileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(FileName); // ���� �̸��� ���� MultipartFile ��ü�� ������
			String originalFileName = mFile.getOriginalFilename(); // ���� ���� �̸��� ������
			fileList.add(originalFileName); // ���� �̸��� �ϳ��� fileList�� ����
			File file = new File(image_path + "\\" + imgPart + "\\" + FileName);
			if (mFile.getSize() != 0) { // ÷�ε� ������ �ִ��� üũ
				// ��ο� ������ ������ �� ��ο� �ش��ϴ� ���丮�� ���� �� ���� ����
				if (!file.exists()) {
					if (file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(image_path + "\\" + imgPart + "\\" + originalFileName)); // �ӽ÷� �����
																									// mutipartFile�� ����
																									// ���Ϸ� ����

				// �̹��� ��� ����
				if (FileName.equals("imgURL_product_M")) {
					ImageMap.put("imgType", "product_M");
					ImageMap.put("imgURL", originalFileName);

					result = productService.deleteProductImge(ImageMap);
					result = productService.addProductImg(ImageMap);

				} else if (FileName.equals("imgURL_product_S")) {
					ImageMap.put("imgType", "product_S");
					ImageMap.put("imgURL", originalFileName);

					result = productService.deleteProductImge(ImageMap);
					result = productService.addProductImg(ImageMap);
				}
			}
		}
		return fileList;
	}

	// ������ ���� üũ (ModelAndView, ��������, ������ ȭ�� )
	private ModelAndView sessionChk(ModelAndView mav, MemberVO sessinLogin, String view) throws Exception {
		if (sessinLogin != null) {
			String rightChk = (String) sessinLogin.getMasterYN();
			if (rightChk.equals("M")) {
				mav.addObject("member", sessinLogin);
				mav.setViewName(view);
				return mav;
			} else {
				mav.addObject("joinMas", "�߸��� ��η� �����ϼ̽��ϴ�.");
				mav.setViewName("redirect:/main.do");
				return mav;
			}
		} else {
			mav.addObject("joinMas", "�߸��� ��η� �����ϼ̽��ϴ�.");
			mav.setViewName("redirect:/main.do");
			return mav;
		}
	}

}
