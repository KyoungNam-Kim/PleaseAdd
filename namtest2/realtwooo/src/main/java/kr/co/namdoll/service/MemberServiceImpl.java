package kr.co.namdoll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.namdoll.dao.MemberDAO;
import kr.co.namdoll.vo.MemberVO;

@Repository
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao; 
	@Override
	public MemberVO getMember(String memId, String memPwd) {

		MemberVO vo = null;
		vo = dao.getMember(memId,memPwd);
		if (vo != null) { //회원id가 존재함
			if (memPwd.equals(vo.getMemPwd())) {//비번이 일치함
				return vo;
			}
		}
		return null;
		// return dao.getMember(memId); 이렇게써도됨
	}

	@Override
	public int addMember(MemberVO vo) { 
		return dao.addMember(vo); 
	} 
	@Override
	public int delMember(String memId) { 
		return dao.delMember(memId);
	}

	 

}
