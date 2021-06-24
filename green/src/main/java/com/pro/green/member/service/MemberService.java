package com.pro.green.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pro.green.member.vo.MemberVO;

public interface MemberService {
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public int idChk(String user_id) throws DataAccessException;
}
