package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;

@Controller
@RequestMapping("/return")
public class SampleController1 {
	@GetMapping("/ex1") 
	public void ex1() {
		
	}
	@GetMapping("/ex2")
	public String ex2() {
		return "/return/ex1.html";
	}
	@ResponseBody
	@GetMapping("/ex3")
	public BookDTO ex3() {
		BookDTO bookDto = new BookDTO("자바프로그래밍입문", "한빛컴퍼니",20000);
		return bookDto;
	}
	@ResponseBody
	@GetMapping("/ex4")
	public List<BookDTO> ex4() {
		List<BookDTO> list = new ArrayList<>();
		
		list.add(new BookDTO("자바프로그래밍입문", "한빛컴퍼니", 20000));
		list.add(new BookDTO("스프링부터웹프로젝트", "구멍가게코딩", 25000));
		list.add(new BookDTO("모두의리눅스", "길벗출판사", 30000));
		return list;
	}
	@GetMapping("/ex5")
	public ResponseEntity ex5() {
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping("/ex6")
	public ResponseEntity<String> ex6() {
		return new ResponseEntity<>("success..", HttpStatus.OK);
	}
	
	@GetMapping("/ex7")
	public ResponseEntity<BookDTO> ex7() {
		BookDTO bookDto = new BookDTO("자바프로그래밍입문","한빛컴퍼니",20000);
		return new ResponseEntity<>(bookDto, HttpStatus.OK);  //200 ok 응답 + Book 객체
	}
	
}
