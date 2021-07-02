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
public class MemberControllerImpl implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;

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

	// �����α���
	@RequestMapping(value = "/member.do", method = RequestMethod.GET)
	public String member(Locale locale, Model model) {
		return "member";
	}

	// ���̵� ã��
	@RequestMapping(value = "/find_id.do", method = RequestMethod.GET)
	public String find_id(Locale locale, Model model) {
		return "find_id";
	}

	// ��й�ȣ ã��
	@RequestMapping(value = "/find_pw.do", method = RequestMethod.GET)
	public String find_pw(Locale locale, Model model) {
		return "find_pw";
	}

	// ȸ������ ����/Ż�� ���üũ
	@RequestMapping(value = "/memberEditChk.do", method = RequestMethod.GET)
	public String memberEditChk(Locale locale, Model model) {
		return "memberEditChk";
	}

	// ���̵�üũ
	@Override
	@RequestMapping(value = "/member/overlapped.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String result = memberService.overlapped(id);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}

	// ���̵� ã��
	@Override
	@RequestMapping(value = "/member/fintId.do", method = RequestMethod.POST)
	public ModelAndView findId(@ModelAttribute("member") MemberVO member) throws Exception {
		ModelAndView mav = new ModelAndView();
		String result = memberService.findId(member);
		mav.addObject("findId", result);
		mav.setViewName("redirect:/find_id.do");
		return mav;
	}

	// ��й�ȣ ã��
	@Override
	@RequestMapping(value = "/member/fintPw.do", method = RequestMethod.POST)
	public ModelAndView findPw(@ModelAttribute("member") MemberVO member) throws Exception {
		ModelAndView mav = new ModelAndView();
		String result = memberService.findPw(member);
		mav.addObject("findPw", result);
		mav.setViewName("redirect:/find_pw.do");
		return mav;
	}

	// ȸ������ ���� ��� üƮ
	@Override
	@RequestMapping(value = "/member/pwChk.do", method = RequestMethod.POST)
	public ModelAndView memberPwChk(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr,
			HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String result = memberService.memberPwChk(member);
		if (result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("joinOk", "sessinChk");
			mav.setViewName("redirect:/memberEdit.do");

		} else {
			rAttr.addAttribute("msg", "joinNo");
			mav.setViewName("redirect:/memberEditChk.do");
		}
		return mav;
	}

	// ȸ������ ����/Ż��
	@Override
	@RequestMapping(value = "/memberEdit.do", method = RequestMethod.GET)
	public ModelAndView memberEdit(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO sessinLogin = (MemberVO) session.getAttribute("member");
		String sessinChk = (String) session.getAttribute("joinOk");

		if (sessinLogin == null) {
			mav.setViewName("redirect:/member.do");

		} else if (sessinChk == null) {
			mav.setViewName("redirect:/memberEditChk.do");

		} else {
			mav.addObject("member", sessinLogin);
			mav.addObject("joinOk", sessinChk);
			mav.setViewName("memberEdit");

		}
		;
		return mav;
	}

	// ȸ������ ����
	@Override
	@RequestMapping(value = "/member/memberEdit.do", method = RequestMethod.POST)
	public ModelAndView memberEditOk(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		int result = memberService.editMember(member);
		memberVO = memberService.login(member);

		if (result == 0) {
			mav.addObject("joinMas", "ȸ�� ���� ������ �����Ͽ����ϴ�. �ٽ� �õ��� �ּ���.");
			mav.setViewName("redirect:/main.do");
		} else {
			mav.addObject("joinMas", "ȸ�� ���� ������ �Ϸ� �Ǿ����ϴ�.");
			session.setAttribute("member", memberVO); // ���ǿ� ȸ�� ������ ����
			session.setAttribute("isLogOn", true); // ���ǿ� �α��� ���¸� true�� ����
			mav.setViewName("redirect:/main.do");
		}
		return mav;
	}

	// ȸ�� ����
	@Override
	@RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		ModelAndView mav = new ModelAndView();

		int result = 0;
		result = memberService.addMember(member);
		if (result == 0) {
			mav.addObject("joinMas", "ȸ�� ���Կ� ���� �߽��ϴ�. �ٽ� �õ��� �ּ���.");
		} else {
			mav.addObject("joinMas", "������ �ּ̾� �����մϴ�.");
		}
		mav.setViewName("/main.do");
		return mav;
	}

	// �α���
	@Override
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, // �α��� â���� ���۵� ID�� ��й�ȣ�� MemberVO ��ü�� member��
																			// �����Ѵ�.
			RedirectAttributes rAttr, // RedirectAttributes Ŭ������ �̿��� �α��� ���н� �ٽ� �α���â���� �����̷�Ʈ�Ͽ� ���� �޽����� �����մϴ�.
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(member); // login() �޼��带 ȣ���ϸ鼭 �α��� ������ �����Ѵ�.
		if (memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO); // ���ǿ� ȸ�� ������ ����
			session.setAttribute("isLogOn", true); // ���ǿ� �α��� ���¸� true�� ����
			mav.setViewName("redirect:/main.do"); // memberVO�� ��Ⱥ�� ���� ������ ������ �̿��� �α��� ���¸� true�� �մϴ�.
		} else {
			rAttr.addAttribute("result", "loginFailed"); // �α��� ���� �� ���� �޽����� �α��� â���� ����
			mav.setViewName("redirect:/member.do"); // �α��� ���н� �ٽ� �α��������� �����̷�Ʈ �մϴ�.
		}
		return mav;
	}

	// �α׾ƿ�
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

	// ȸ�� Ż��
	@Override
	@RequestMapping(value = "/member/memberDelete.do", method = RequestMethod.POST)
	public ModelAndView memberDelete(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		int result = memberService.memeberDelete(member);
		if (result == 0) {
			mav.addObject("msg", "fail");
		} else {
			session.removeAttribute("member");
			session.removeAttribute("isLogOn");
			session.removeAttribute("joinOk");
			mav.addObject("msg", "memberDelete");
		}
		mav.setViewName("redirect:/main.do");
		return mav;
	}

	@RequestMapping(value = "/*.do", method = RequestMethod.GET)
	public ModelAndView logout(@RequestParam(value = "result", required = false) String result, // �α��� â ��û�� �Ű�����
																								// result�� ���۵Ǹ� ����
																								// result�� ���� �����մϴ�. ���ʷ�
																								// �α���â�� ��û�� ���� �Ű�����
																								// result�� ���۵��� �����Ƿ�
																								// �����մ�
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
