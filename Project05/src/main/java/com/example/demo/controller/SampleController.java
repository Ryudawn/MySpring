package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SampleDTO;

@Controller	//컨트롤러 역할지정
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/ex1") 	//주소를 연결하는 어노테이션
	public void ex1() {		//사용자 요청을 처리하는 메소드	
		//리턴타입이 void인 경우, url 경로와 일치하는 html 파일을 찾아 반환
		//템플릿 경로 : /templates/sample/ex1.html
	}	
	
	@GetMapping("/ex2") 
	public void ex2(Model model) {	//Model은 화면에 값을 전달하는 역할
		
		//모델에 문자열을 담기 (첫번째인자: 변수명, 두번째인자: 값)
		model.addAttribute("msg","반갑습니다");
		
	}
	
	@GetMapping("/ex3")
	public void ex3(Model model){
		model.addAttribute("msg1","안녕하세요");
		model.addAttribute("msg2","반가워요");
	}
	
	@GetMapping("/ex4")
	public void ex4(Model model) {
		SampleDTO sampleDTO = new SampleDTO(1,"hello",LocalDate.now());
		model.addAttribute("dto",sampleDTO);
	}
	@GetMapping({"/ex5","/ex6","/ex7","/ex8"})		//다중일때는 {}로 묶어준다
	public void ex5(Model model) {
		List<SampleDTO> list = new ArrayList<>();
		list.add(new SampleDTO(1,"aaa",LocalDate.now()));
		list.add(new SampleDTO(2,"bbb",LocalDate.now()));
		list.add(new SampleDTO(3,"ccc",LocalDate.now()));
		
		model.addAttribute("list",list);
	}
	
	@GetMapping("/ex9")
	public void ex9(Model model) {
		SampleDTO sampleDTO = new SampleDTO(1, "aaa", LocalDate.now());
		model.addAttribute("result", "success"); // 화면에 문자열 전달
		model.addAttribute("dto", sampleDTO); // 화면에 객체 전달
	}
	
	@GetMapping("/ex10")
	public void ex10(Model model) {
		model.addAttribute("date",LocalDateTime.now());
	}
		
	
	
	
}
















