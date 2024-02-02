package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;


@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService service;
	
	@ResponseBody
	@GetMapping("/list")
	public List<CommentDTO> list(@RequestParam(name = "boardNo") int boardNo) {
		
		List<CommentDTO> commentlist = service.getListByBoardNo(boardNo);
		
		return commentlist;
		
	}
	@ResponseBody
	@PostMapping("/register")
	public HashMap<String,Boolean> register(CommentDTO dto) {
		
		HashMap<String,Boolean> map = new HashMap<>();
		
		// 아이디 캐치
		String id = "user1"; //임시 아이디. 시큐리티 배운 후에 변경해야함.
		
		dto.setWriter(id);		
		
		//dto정보를 받아 service에 저장
		service.register(dto);
		
		//처리결과 반환
		map.put("success", true);
		
		
		return map;
	}
	
	@ResponseBody
	@GetMapping("/remove")
	public HashMap<String, Boolean> remove(@RequestParam(name = "commentNo") int commentNo) {
		
		//맵 객체 생성
		HashMap<String,Boolean> map = new HashMap<>();
		
		//댓글 삭제
		boolean result = service.remove(commentNo);
		
		//처리결과 반환
		map.put("success", result);
		
		return map;
	}

}
