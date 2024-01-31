package com.example.demo.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;
	

	@Test
	public void 게시물등록() {
		Member member1 = Member.builder().id("user2").build(); //회원 엔티티 생성
		List<Board> list = new ArrayList<>();
		list.add(new Board(0,"1번글","내용입니다", member1)); //작성자는 현재 존재하는 사용자아이디를 사용해야함 
		list.add(new Board(0,"2번글","내용입니다", member1));
		list.add(new Board(0,"3번글","내용입니다", member1)); //아이디 하나로 여러 게시물 등록
		repository.saveAll(list);
	}

	@Test
	public void 없는아이디로게시물등록하기() {
		Member member = Member.builder().id("user2").build(); //회원 엔티티 생성
		Board board = new Board(0,"4번글","내용입니다", member); //회원테이블에 없는 아이디를 사용하면 에러남
		repository.save(board);
	}

	 @Test
	    public void 게시물단건조회(){
	        Optional<Board> optional =  repository.findById(29); //쿼리가 내부적으로 join 처리됨
	        Board board = optional.get();
	        System.out.println(board); //회원정보가 함께 출력됨
	    }

		@Test
		public void 게시물삭제() {
			repository.deleteAll();
		}
		
		

	
	@Test 
	public void 페이지테스트() {
		//1페이지 10개
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<Board> result = repository.findAll(pageable);
		//게시물리스트 + 페이지정보
		System.out.println(result);
		
		List<Board> list = result.getContent();
		//게시물 리스트
		System.out.println(list);
	}
	
	
	@Test
	public void 정렬조건추가하기() {
		
		//no 필드값 기준으로 역정렬
		Sort sort = Sort.by("no").descending();
		
		//정렬정보 추가
		Pageable pageable = PageRequest.of(2, 10, sort);
		
		Page<Board> result = repository.findAll(pageable);
		
		List<Board> list = result.getContent();
		
		System.out.println(list);
	}
	
	
	
	
}
