package com.pro.green.member.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pro.green.member.service.MemberService;
import com.pro.green.member.vo.MemberVO;




@Controller("memberController")
//@EnableAspectJAutoProxy
public class MemberControllerImpl   implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO ;
	
	// /pro30/main.do�� ��û �� ���� �������� �����ݴϴ�.
//	@RequestMapping(value= {"/", "/main.do"},method = RequestMethod.GET )
//	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
//		String viewName = (String) request.getAttribute("viewName");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName(viewName);
//		return mav;
//	}
	
	// ȸ������
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {
		return "join";
	}

	// �Ϲ� ȸ������
	@RequestMapping(value = "/normalJoin.do", method = RequestMethod.GET)
	public String normalJoin(Locale locale, Model model) {
		return "normalJoin";
	}
	
	// �α���
		@RequestMapping(value = "/login.do", method = RequestMethod.GET)
		public String login(Locale locale, Model model) {
			return "login";
		}

	
	//���̵�üũ	
	@Override
	@RequestMapping(value="/member/overlapped.do" ,method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = memberService.overlapped(id);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	
	//ȸ�� ����
	@Override
	@RequestMapping(value="/member/addMember.do" ,method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		return mav;
	}
	

	//�α���
	@Override
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, //�α��� â���� ���۵� ID�� ��й�ȣ�� MemberVO ��ü�� member�� �����Ѵ�.
								RedirectAttributes rAttr, //RedirectAttributes Ŭ������ �̿��� �α��� ���н� �ٽ� �α���â���� �����̷�Ʈ�Ͽ� ���� �޽����� �����մϴ�.
								HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(member);          //login() �޼��带 ȣ���ϸ鼭 �α��� ������ �����Ѵ�.
		if(memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);    //���ǿ� ȸ�� ������ ����
			session.setAttribute("isLogOn", true);       //���ǿ� �α��� ���¸� true�� ����
			mav.setViewName("redirect:/main.do");        //memberVO�� ��Ⱥ�� ���� ������ ������ �̿��� �α��� ���¸� true�� �մϴ�.
		}else {
			rAttr.addAttribute("result", "loginFailed"); //�α��� ���� �� ���� �޽����� �α��� â���� ����
			mav.setViewName("redirect:/login.do");       // �α��� ���н� �ٽ� �α��������� �����̷�Ʈ �մϴ�.
		}
		return mav;
	}
	
	//�α׾ƿ�
	@Override
	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}
	
	@RequestMapping(value = "/member/join.do", method = RequestMethod.GET)
	public ModelAndView logout(@RequestParam(value = "result", required = false) String result, //�α��� â ��û�� �Ű����� result�� ���۵Ǹ� ���� result�� ���� �����մϴ�. ���ʷ� �α���â�� ��û�� ���� �Ű����� result�� ���۵��� �����Ƿ� �����մ�
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject(viewName);
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}


}
