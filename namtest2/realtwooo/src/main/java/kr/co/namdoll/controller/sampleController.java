package kr.co.namdoll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class sampleController {

	@RequestMapping(value = "/sample/*" )   // 
	public void sampleMapping() { 
	}
 
	@RequestMapping(value = "/sample/list" ) 
	public String sampleList() {  //void보다 우선권이 있음 ... 입력과 출력이 다를때 사용
		
		return "sample/test";
	} 
	
}
