package com.pro.green.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pro.green.member.vo.MemberVO;

public interface MemberService {
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public String overlapped(String id) throws Exception;
	public MemberVO login(MemberVO memberVO) throws Exception;
	public String findId(MemberVO member) throws Exception;
	public String findPw(MemberVO member) throws Exception;
	public String memberPwChk(MemberVO member) throws Exception;
	public int memeberDelete(MemberVO member) throws Exception;
}
