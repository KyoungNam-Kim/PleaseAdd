package kr.co.namdoll.service;

import kr.co.namdoll.vo.MemberVO;

public interface MemberService {

 
	int addMember(MemberVO vo);

	int delMember(String memId);

	MemberVO getMember(String memId, String memPwd);

}
