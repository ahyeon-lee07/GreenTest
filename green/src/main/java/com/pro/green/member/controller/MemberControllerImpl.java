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

	// 회원가입
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {
		return "join";
	}

	// 일반 회원가입
	@RequestMapping(value = "/normalJoin.do", method = RequestMethod.GET)
	public String normalJoin(Locale locale, Model model) {
		return "normalJoin";
	}

	// 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	// 기존로그인
	@RequestMapping(value = "/member.do", method = RequestMethod.GET)
	public String member(Locale locale, Model model) {
		return "member";
	}

	// 아이디 찾기
	@RequestMapping(value = "/find_id.do", method = RequestMethod.GET)
	public String find_id(Locale locale, Model model) {
		return "find_id";
	}

	// 비밀번호 찾기
	@RequestMapping(value = "/find_pw.do", method = RequestMethod.GET)
	public String find_pw(Locale locale, Model model) {
		return "find_pw";
	}

	// 회원정보 수정/탈퇴 비번체크
	@RequestMapping(value = "/memberEditChk.do", method = RequestMethod.GET)
	public String memberEditChk(Locale locale, Model model) {
		return "memberEditChk";
	}

	// 아이디체크
	@Override
	@RequestMapping(value = "/member/overlapped.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String result = memberService.overlapped(id);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}

	// 아이디 찾기
	@Override
	@RequestMapping(value = "/member/fintId.do", method = RequestMethod.POST)
	public ModelAndView findId(@ModelAttribute("member") MemberVO member) throws Exception {
		ModelAndView mav = new ModelAndView();
		String result = memberService.findId(member);
		mav.addObject("findId", result);
		mav.setViewName("redirect:/find_id.do");
		return mav;
	}

	// 비밀번호 찾기
	@Override
	@RequestMapping(value = "/member/fintPw.do", method = RequestMethod.POST)
	public ModelAndView findPw(@ModelAttribute("member") MemberVO member) throws Exception {
		ModelAndView mav = new ModelAndView();
		String result = memberService.findPw(member);
		mav.addObject("findPw", result);
		mav.setViewName("redirect:/find_pw.do");
		return mav;
	}

	// 회원정보 수정 비번 체트
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

	// 회원정보 수정/탈퇴
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

	// 회원정보 수정
	@Override
	@RequestMapping(value = "/member/memberEdit.do", method = RequestMethod.POST)
	public ModelAndView memberEditOk(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		int result = memberService.editMember(member);
		memberVO = memberService.login(member);

		if (result == 0) {
			mav.addObject("joinMas", "회원 정보 수정에 실패하였습니다. 다시 시도해 주세요.");
			mav.setViewName("redirect:/main.do");
		} else {
			mav.addObject("joinMas", "회원 정보 수정이 완료 되었습니다.");
			session.setAttribute("member", memberVO); // 세션에 회원 정보를 저장
			session.setAttribute("isLogOn", true); // 세션에 로그인 상태를 true로 설정
			mav.setViewName("redirect:/main.do");
		}
		return mav;
	}

	// 회원 가입
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
			mav.addObject("joinMas", "회원 가입에 실패 했습니다. 다시 시도해 주세요.");
		} else {
			mav.addObject("joinMas", "가입해 주셨어 감사합니다.");
		}
		mav.setViewName("/main.do");
		return mav;
	}

	// 로그인
	@Override
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, // 로그인 창에서 전송된 ID와 비밀번호를 MemberVO 객체를 member에
																			// 저장한다.
			RedirectAttributes rAttr, // RedirectAttributes 클래스를 이용해 로그인 실패시 다시 로그인창으로 리다이렉트하여 실패 메시지를 전달합니다.
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(member); // login() 메서드를 호출하면서 로그인 정보를 전달한다.
		if (memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO); // 세션에 회원 정보를 저장
			session.setAttribute("isLogOn", true); // 세션에 로그인 상태를 true로 설정
			mav.setViewName("redirect:/main.do"); // memberVO로 반횐된 값이 있으면 세션을 이용해 로그인 상태를 true로 합니다.
		} else {
			rAttr.addAttribute("result", "loginFailed"); // 로그인 실패 시 실패 메시지를 로그인 창으로 전달
			mav.setViewName("redirect:/member.do"); // 로그인 실패시 다시 로그인차응로 리다이렉트 합니다.
		}
		return mav;
	}

	// 로그아웃
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

	// 회원 탈퇴
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
	public ModelAndView logout(@RequestParam(value = "result", required = false) String result, // 로그인 창 요청시 매개변수
																								// result가 정송되면 변수
																								// result에 값을 저장합니다. 최초로
																								// 로그인창을 요청할 때는 매개변수
																								// result가 전송되지 않으므로
																								// 무시합니
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
