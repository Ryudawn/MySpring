package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {
	//메인화면
	@GetMapping("/")
	public String home() {
		return "/home/main";
	}
	
	// 커스텀 로그인 페이지 반환하는 메소드	
	@GetMapping("/customlogin")
	public String customLogin() {
		return "home/login";
	}
}