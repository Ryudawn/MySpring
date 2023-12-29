package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

@SpringBootTest
public class MemoRepositoryTest1_1 {

	@Autowired
	MemoRepository memoRepository;
	
	@Test
	void 리파지토리객체를가져왔는지확인() {
		System.out.println();
		System.out.println("memoRepository = " + memoRepository);
		System.out.println();
	}
	@Test
	public void 데이터등록() {
		Memo memo = Memo.builder().text("새글입니다.").build();
		
		memoRepository.save(memo);
	}
	
	@Test
	public void 데이터일괄등록() {
		List<Memo> list = new ArrayList<>();
		
		Memo memo1 = new Memo(0,"새글입니다");
		Memo memo2 = new Memo(0,null);
		
		list.add(memo1);
		list.add(memo2);
		
		memoRepository.saveAll(list);
	}
	
	@Test
	public void 데이터간단조회() {
		Optional<Memo> result = memoRepository.findById(1);
		
		if(result.isPresent()) {
			Memo memo = result.get();
			System.out.println(memo);
			
		}
	}
	@Test
	public void 데이터전체조회() {
		List<Memo> list = memoRepository.findAll();
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test 
	public void 데이터수정() {
		Memo memo = new Memo(1,"글이 수정되었습니다.");
		
		memoRepository.save(memo);
	}
	@Test 
	public void 데이터삭제() {
		memoRepository.deleteById(1);
	}
	@Test 
	public void 데이터전체삭제() {
		memoRepository.deleteAll();
	}
}
