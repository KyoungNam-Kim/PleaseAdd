package kr.co.namdoll.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.namdoll.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSession session;
	
	@Override
	public MemberVO getMember(String memId, String memPwd) { 
		
		return session.selectOne("kr.co.namdoll.MemberDAO.getMember", memId); 
		 
	}

	@Override
	public int addMember(MemberVO vo) {
	 
		return session.update("kr.co.namdoll.MemberDAO.addMember",vo);
	}

	@Override
	public int delMember(String memId) {
	 
		return session.update("kr.co.namdoll.MemberDAO.delMember",memId);
	}

	@Override
	public MemberVO getMember(String memId) {
		// TODO Auto-generated method stub
		return null;
	}

}
