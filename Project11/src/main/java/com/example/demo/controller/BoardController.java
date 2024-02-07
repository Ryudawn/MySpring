package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;

	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody BoardDTO dto) {
		int no = service.register(dto);
		
		return new ResponseEntity<>(no, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BoardDTO>> getList() {
		
		List<BoardDTO> list = service.getList();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
