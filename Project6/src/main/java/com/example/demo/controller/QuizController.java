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
import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/return")
public class QuizController {
	
	@GetMapping("/q1")
	public void q1() {
		
	}
	@GetMapping("/q2")
	public String q2() {
		return "/return/test.html";
	}
	@ResponseBody
	@GetMapping("/q3")
	public StudentDTO q3() {
		StudentDTO student = new StudentDTO(1, "둘리",3);
		return student;
	}
	@ResponseBody
	@GetMapping("/q4")
	public List<CarDTO> q4() {
		List<CarDTO> list = new ArrayList<>();
		list.add(new CarDTO("현대", "코나", "블랙"));
		return list;
		
	}
	@ResponseBody
	@GetMapping("/q5")
	public List<StudentDTO> q5() {
		List<StudentDTO> list = new ArrayList<>();
		list.add(new StudentDTO(3,"둘리",3));
		list.add(new StudentDTO(2,"또치",1));
		list.add(new StudentDTO(3,"도우너",2));
		
		return list;
		
	}
	@GetMapping("/q6")
	public ResponseEntity<String> q6() {
		return new ResponseEntity<>("response fail..", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping("/q7")
	public ResponseEntity<CarDTO> q7() {
		CarDTO car = new CarDTO("현대","코나","블랙");
		return new ResponseEntity<>(car, HttpStatus.OK);  
	}
	
}
