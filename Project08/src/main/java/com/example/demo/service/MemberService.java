package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;

public interface MemberService {

	//회원목록조회
	Page<MemberDTO> getList(int pageNumber);
	
	//회원등록
	boolean register(MemberDTO dto) ;
	
	//회원 단건조회
	MemberDTO read(String id);
	
	//엔티티를 디티오로 바꿔주는 메서드
	default MemberDTO entityToDto(Member entity) {
		
		MemberDTO dto = MemberDTO.builder()
				.id(entity.getId())
				.password(entity.getPassword())
				.name(entity.getName())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
		return dto;
	}
	
	//디티오를 엔티티로 바꿔주는 메서드
	default Member dtoToEntity(MemberDTO dto) {
		
		Member entity = Member.builder()
							.id(dto.getId())
							.password(dto.getPassword())
							.name(dto.getName())
							.build();
		
		return entity;
		
	}
	
	
}
