package com.pro.green.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.member.dao.MemberDAO;
import com.pro.green.member.vo.MemberVO;
import com.pro.green.product_M.vo.Criteria;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	// 회원가입
	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

	// 아이디체크
	@Override
	public String overlapped(String id) throws Exception {
		return memberDAO.selectOverlappedID(id);
	}

	// 아아디찾기
	@Override
	public String findId(MemberVO member) throws Exception {
		return memberDAO.selectFindId(member);
	}

	// 비번찾기
	@Override
	public String findPw(MemberVO member) throws Exception {
		return memberDAO.selectFindPw(member);
	}

	// 회원정보 수정 비번체크
	@Override
	public String memberPwChk(MemberVO member) throws Exception {
		return memberDAO.selectPwChk(member);
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberDAO.loginById(memberVO);
	}

	// 회원수정
	@Override
	public int editMember(MemberVO member) throws Exception {
		return memberDAO.editMember(member);
	}

	// 회원 탈퇴
	@Override
	public int memeberDelete(MemberVO member) throws Exception {
		return memberDAO.memberDelete(member);
	}
	
	//회원수 조회
	public int memberCount() throws Exception {
		return memberDAO.memberCount();
	}
	
	//회원 조회
	public List<Map<String, Object>> selectMemberList(Criteria cri) throws Exception {
		return memberDAO.selectMemberList(cri);
	}
	
	//회원 검색
	public List<Map<String, Object>> searchMemberList(Map<String, Object> searchOption) throws Exception {
		return memberDAO.searchMemberList(searchOption);
	}
	
	//회원상세내용
	public MemberVO memberDetail(String productId) throws Exception{
		return memberDAO.memberDetail(productId);
	}
	
	//회원관리 수정
	public int editMember_master(MemberVO memberInf) throws Exception {
		return memberDAO.editMember_master(memberInf);
	}
}
