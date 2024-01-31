package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

public interface BoardService {
	//게시물 등록
	int register(BoardDTO dto);

	// 게시물 목록조회
	
	Page<BoardDTO> getList(int pageNumber);

	// 게시물 상세조회
	BoardDTO read(int no);

	// 게시물 수정
	void modify(BoardDTO dto);

	// 게시물 삭제
	int remove(int no);

	
	/* 작성자 필드 수정 */
	default Board dtoToEntity(BoardDTO dto) {
		Member member = Member.builder().id(dto.getWriter()).build(); //작성자 객체 생성

		Board entity = Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
//				.writer(dto.getWriter())
				.writer(member) //값 변경
				.build();
		return entity;
	}

	/* 작성자 필드 수정 */
	default BoardDTO entityToDto(Board entity) {
		BoardDTO dto = BoardDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())
//				.writer(entity.getWriter())
				.writer(entity.getWriter().getId()) //값변경
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}
}
