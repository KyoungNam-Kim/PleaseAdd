package kr.co.namdoll.dao;

import kr.co.namdoll.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(String memId,String memPwd);

	int addMember(MemberVO vo);

	int delMember(String memId);

	MemberVO getMember(String memId);

}
