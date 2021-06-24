package com.pro.green.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pro.green.member.vo.MemberVO;

public interface MemberDAO {
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int idChk(String user_id) throws DataAccessException;
}
