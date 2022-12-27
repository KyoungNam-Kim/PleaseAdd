package kr.co.namdoll;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.namdoll.service.MemberService;
import kr.co.namdoll.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberTest {

	@Autowired
	MemberService service;
	
	@Test
	public void getMemberTest() {
		MemberVO vo = service.getMember("kkn0130", "0000");
		log.info("====================> " + vo);
		assertNotNull(vo);
	} 
	@Test
	public void addMemberTest() {
		 
		MemberVO vo = new MemberVO();
		vo.setMemId("kkkku");
		vo.setMemName("kkkku");
		vo.setMemPwd("89999");
		vo.setPhone("0784557"); 

		int result = service.addMember(vo); 
		assertEquals(result, 1);
		MemberVO resultVo = service.getMember(vo.getMemId(), vo.getMemPwd());
		checkVo(vo, resultVo);
		service.delMember(vo.getMemId());
    } 
		
	private void checkVo(MemberVO inVO, MemberVO resultVo) {
			 assertEquals(inVO.getMemName(), resultVo.getMemName());
			 assertEquals(inVO.getMemPwd(), resultVo.getMemPwd());
			 assertEquals(inVO.getPhone(), resultVo.getPhone());
		}
}
