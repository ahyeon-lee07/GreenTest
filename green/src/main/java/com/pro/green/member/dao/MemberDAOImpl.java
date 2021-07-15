package com.pro.green.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.green.member.vo.MemberVO;
import com.pro.green.product.vo.Criteria;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	// ȸ�� ����
	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	// ���̵� �ߺ� üũ
	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.member.selectOverlappedID", id);
		return result;
	}

	// ���̵� ã��
	@Override
	public String selectFindId(MemberVO memberVO) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.member.selectFindId", memberVO);
		return result;
	}

	// ��� ã��
	@Override
	public String selectFindPw(MemberVO memberVO) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.member.selectFindPw", memberVO);
		return result;
	}

	// ȸ������ ���� ���üũ
	@Override
	public String selectPwChk(MemberVO memberVO) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.member.selectPwChk", memberVO);
		return result;
	}

	// �α���
	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.loginById", memberVO);
		return vo;
	}
	
	// ȸ�� Ż��
	public int memberDelete(MemberVO member) {
		int result = sqlSession.delete("mapper.member.memeberDelete", member);
		return result;
	}
	
	//ȸ�� ����
	public int editMember(MemberVO member) throws DataAccessException {
		int result = sqlSession.update("mapper.member.editMember", member);
		return result;
	}
	
	//ȸ���� ��ȸ
	public int memberCount() throws DataAccessException {
		int result = sqlSession.selectOne("mapper.member.memberCount");
		return result;
	}
	
	//ȸ������Ʈ ��ȸ
	public List<Map<String, Object>> selectMemberList(Criteria cri) throws DataAccessException{
		List<Map<String, Object>> result = sqlSession.selectList("mapper.member.selectMemberList", cri);
		return result;
	}
	
	//ȸ�� �˻�
	public List<Map<String, Object>> searchMemberList(Map<String, Object> searchOption) throws DataAccessException {
		List<Map<String, Object>> result = sqlSession.selectList("mapper.member.searchMemberList", searchOption);
		return result;
	}
	
	//ȸ����
	public MemberVO memberDetail(String productId) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.memberDetail", productId);
		return vo;
	}
	
	//ȸ������ ����
	public int editMember_master(MemberVO memberInf) throws DataAccessException {
		int result = sqlSession.update("mapper.member.editMember_master", memberInf);
		return result;
	}
}