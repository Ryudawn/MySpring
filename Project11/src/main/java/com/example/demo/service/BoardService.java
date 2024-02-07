package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {

	int register(BoardDTO dto);

	Page<BoardDTO> getList(int pageNumber);

	BoardDTO read(int no);

	void modify(BoardDTO dto);

	int remove(int no);

	default Board dtoToEntity(BoardDTO dto) {


		Board entity = Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())

				.build();
		
		return entity;
	}

	default BoardDTO entityToDto(Board entity) {
		BoardDTO dto = BoardDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())

				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}

}
