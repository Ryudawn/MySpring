package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberRepository repository;
	
	@Override
	public Page<MemberDTO> getList(int pageNumber) {
		
		int pageIndex = (pageNumber == 0) ? 0 : pageNumber -1;
		
		Sort sort = Sort.by("regDate").descending();

		//페이지 번호, 데이터 건수, 정렬방법을 입력하여 페이징 조건 생성
		Pageable pageable = PageRequest.of(pageIndex, 10,sort);
		
		Page<Member> entityPage = repository.findAll(pageable);
		
		// 엔티티리스트를 DTO리스트로 변환
		Page<MemberDTO> dtoPage = entityPage.map(entity -> entityToDto(entity));
		
		return dtoPage;		
		
		
	}

	@Override
	public boolean register(MemberDTO dto) {
		
		//아이디 중복여부확인
		String id = dto.getId();
		
		MemberDTO getDto = read(id);
		
		//해당 아이디가 이미 사용중이라면 false반환
		if(getDto != null) {
			
			System.out.println("사용중인 아이디입니다.");
			return false;	
		}
		
		Member entity = dtoToEntity(dto);
		
		repository.save(entity);
		
		return true;
		
		
	}

	@Override
	public MemberDTO read(String id) {
		
		Optional<Member> result = repository.findById(id);
		
		if(result.isPresent()) {
			
			Member member = result.get();
			
			return entityToDto(member);
			
		}else {
			
			return null;
		
		}
		
		
	}

}
