package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.Board2DTO;
import com.example.demo.entity.Board2;
import com.example.demo.entity.Member;


public interface Board2Service {

	int register(Board2DTO dto);

	Page<Board2DTO> getList(int pageNumber);

	Board2DTO read(int no);

	void modify(Board2DTO dto);

	int remove(int no);

	default Board2 dtoToEntity(Board2DTO dto) {
		Member member = Member.builder().id(dto.getWriter()).build(); //작성자 객체 생성

		Board2 entity = Board2.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(member)
				.build();
		
		return entity;
	}

	default Board2DTO entityToDto(Board2 entity) {
		Board2DTO dto = Board2DTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter().getId())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}

}
