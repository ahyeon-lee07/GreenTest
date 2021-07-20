package com.pro.green.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.pro.green.member.service.MemberService;
import com.pro.green.member.vo.MemberVO;

public class MemberControllerImplTest {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	@Test
	 public void �½�Ʈ( ) throws Exception {
		MemberVO member = new MemberVO();
		
		member.setName("�̱���");
		member.setEmail1("time2209");
		member.setEmail2("naver.com");

		
		String result = memberService.findId(member);
	    assertEquals("admin",  result);
	  }

}
