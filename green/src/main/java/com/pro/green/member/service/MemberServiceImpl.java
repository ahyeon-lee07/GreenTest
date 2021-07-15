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

	// ȸ������
	@Override
	public int editMember(MemberVO member) throws Exception {
		return memberDAO.editMember(member);
	}

	// ȸ�� Ż��
	@Override
	public int memeberDelete(MemberVO member) throws Exception {
		return memberDAO.memberDelete(member);
	}
	
	//ȸ���� ��ȸ
	public int memberCount() throws Exception {
		return memberDAO.memberCount();
	}
	
	//ȸ�� ��ȸ
	public List<Map<String, Object>> selectMemberList(Criteria cri) throws Exception {
		return memberDAO.selectMemberList(cri);
	}
	
	//ȸ�� �˻�
	public List<Map<String, Object>> searchMemberList(Map<String, Object> searchOption) throws Exception {
		return memberDAO.searchMemberList(searchOption);
	}
	
	//ȸ���󼼳���
	public MemberVO memberDetail(String productId) throws Exception{
		return memberDAO.memberDetail(productId);
	}
	
	//ȸ������ ����
	public int editMember_master(MemberVO memberInf) throws Exception {
		return memberDAO.editMember_master(memberInf);
	}
}
