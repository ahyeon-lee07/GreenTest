package com.pro.green.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.member.dao.MemberDAO;
import com.pro.green.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	// ȸ������
	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

	// ���̵�üũ
	@Override
	public String overlapped(String id) throws Exception {
		return memberDAO.selectOverlappedID(id);
	}

	// �ƾƵ�ã��
	@Override
	public String findId(MemberVO member) throws Exception {
		return memberDAO.selectFindId(member);
	}

	// ���ã��
	@Override
	public String findPw(MemberVO member) throws Exception {
		return memberDAO.selectFindPw(member);
	}

	// ȸ������ ���� ���üũ
	@Override
	public String memberPwChk(MemberVO member) throws Exception {
		return memberDAO.selectPwChk(member);
	}

	// �α���
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberDAO.loginById(memberVO);
	}
}
