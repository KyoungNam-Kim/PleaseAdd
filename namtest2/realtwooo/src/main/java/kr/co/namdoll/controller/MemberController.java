package kr.co.namdoll.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
import kr.co.namdoll.service.MemberService;
import kr.co.namdoll.vo.MemberVO;

@Controller 
@RequestMapping(value = "/member/")
public class MemberController { //컨트롤러는 데이터를 담아서 어디로갈껀지만 지정해줌

	@Autowired
	private MemberService service; // 컨트롤러는 서비스한테일시킴

	@GetMapping(value = "/memberJoin")  // ip[:80/cp/]member/memberJoin
	public String addMemberForm() {//form 받기
		return "/member/memberJoin";// WEB-INF/views/member/memberJoin.jsp
	}
	/*
	@PostMapping(value = "/memberJoin")// ip[:80/cp/]member/memberJoin
	public String addMember(MemberVO vo, Model model, HttpSession session ) {//DB저장
		int result = service.addMember(vo);	 
		if(result==1) {
			session.setAttribute("vo", vo);
			System.out.println("===================="+vo);
		} 
		return "home";
	}
 */
	@RequestMapping(value = "/memberJoinProc") //이런식으로 아예 다른페이지에 해도됨
	public String addMember(MemberVO vo, Model model, HttpSession session ) {//DB저장
		int result = service.addMember(vo);	 
		if(result == 1) {
			session.setAttribute("vo", vo);
			System.out.println("===================="+vo);
	}
		return "home";
	}
	
	@RequestMapping(value = "/logout")
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "home";
	}
	@RequestMapping(value = "/board/list")
	public void getList() {
	 
	}
	
	@RequestMapping(value = "/login")
	public String login(String memId, String memPwd, Model model, HttpSession session) {
		MemberVO vo = service.getMember(memId,memPwd);
		if(vo == null) {
			//model.addAttribute("msg", "아이디가 일치하지 않거나 비밀번호가 잘못 입력 되었습니다."); //여기안쓰고 loginFail여기페이지가서 메세지로뿌려줘도됨
			return "/member/loginFail";
		} 
		// if(vo == null) return "/member/loginFail";위에 이렇게 한줄로 써도됨
		session.setAttribute("vo", vo);
		//세션의 유효시간 설정해주면 좋음..
		return "home";
	}

	@RequestMapping(value = "/loginForm")
	public String loginForm() {
		return "/member/loginJoin";
	}
	
	
	@RequestMapping(value = "/loginFail")
	public void loginFail() {
		 	
		 
	}
 
	
}
