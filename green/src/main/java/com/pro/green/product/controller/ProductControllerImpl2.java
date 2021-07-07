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

	// ��ǰ��� ����Ʈ
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
				mav.addObject("joinMas", "�߸��� ��η� �����ϼ̽��ϴ�.");
				mav.setViewName("redirect:/main.do");
			}
		} else {
			mav.addObject("joinMas", "�߸��� ��η� �����ϼ̽��ϴ�.");
			mav.setViewName("redirect:/main.do");
		}

		return mav;
	}

	// ��ǰ���
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
				mav.addObject("joinMas", "�߸��� ��η� �����ϼ̽��ϴ�.");
				mav.setViewName("redirect:/main.do");
			}
		} else {
			mav.addObject("joinMas", "�߸��� ��η� �����ϼ̽��ϴ�.");
			mav.setViewName("redirect:/main.do");
		}

		return mav;
	}

	
	// ��ǰ ���
	@Override
	@RequestMapping(value = "/product/addEdit.do", method = RequestMethod.POST)
	public ModelAndView addProductEditaddEdit(@ModelAttribute("product") ProductVO2 product, MultipartHttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		
		
		//�̹��� ���ε�
		//Map map = new HashMap();	//�Ű����� ������ ���� ������ ������ Map�� ����
				
		//������ ���ε��� �� ��ȯ�� ���� �̸��� ����� FileList�� �ٽ� map�� ����
		List fileList = fileProcess(request, selectProductID);
		
		//map.put("fileList", fileList);
		//mao�� ���â���� ������
		//mav.addObject("map", map);

		mav.setViewName("redirect:/productList.do");
		return mav;
	}
	
	private static final String CURR_IMAGE_REPO_PATH = "C:\\upload\\green";
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest, String selectProductID) throws Exception {
		
		List<String> fileList = new ArrayList<String>();
		String imgPart = multipartRequest.getParameter("p_group");
		
		Map<String, Object> ImageMap = new HashMap<String, Object>();
		ImageMap.put("productId", selectProductID);
		int result = 0;
		
		//÷�ε� ���� �̸��� �����ɴϴ�.
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()) {
			String FileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(FileName);	//���� �̸��� ���� MultipartFile ��ü�� ������
			String originalFileName = mFile.getOriginalFilename();		//���� ���� �̸��� ������
			fileList.add(originalFileName);		//���� �̸��� �ϳ��� fileList�� ����
			File file = new File(CURR_IMAGE_REPO_PATH + "\\" + imgPart + "\\" + FileName);
			if(mFile.getSize() != 0) {	//÷�ε� ������ �ִ��� üũ
				//��ο� ������ ������ �� ��ο� �ش��ϴ� ���丮�� ���� �� ���� ����
				if(! file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + imgPart + "\\" + originalFileName));	//�ӽ÷� ����� mutipartFile�� ���� ���Ϸ� ����
			}
			
			//�̹��� ��� ����
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
