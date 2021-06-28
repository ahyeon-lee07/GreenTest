package com.pro.green.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pro.green.member.vo.MemberVO;

public interface MemberDAO {
	public int insertMember(MemberVO memberVO) throws DataAccessException ;
	public String selectOverlappedID(String id) throws DataAccessException;
	public MemberVO loginById(MemberVO memberVo)throws DataAccessException;
	public String selectFindId(MemberVO memberVO) throws DataAccessException;
	public String selectFindPw(MemberVO memberVO) throws DataAccessException;
	public String selectPwChk(MemberVO memberVO) throws DataAccessException;
	public int memberDelete(MemberVO member);
}
