package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {
	//메인화면
	@GetMapping("/")
	public String main() {
		return "/home/main";
	}
}
