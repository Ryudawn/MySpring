package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepository repository;
	
	@Test 
	void 리파지토리객체를가져왔는지확인() {
		System.out.println();
		System.out.println("Repository = " + repository);
		System.out.println();
	}
	
	@Test
	public void 데이터등록() {
		Book book1 = new Book(1,20000,"한빛출판사","자바프로그래밍입문");
		repository.save(book1);
		Book book2 = new Book(2,25000,"남가람북스","스프링부트프로젝트");
		repository.save(book2);
		Book book3 = new Book(3,40000,"남가람북스","실무로 끝내는 PHP");
		repository.save(book3);
		Book book4 = new Book(4,35000,"이지스퍼블리싱","알고리즘코딩테스트");
		repository.save(book4);

	}
	
	@Test
	public void 데이터조회() {
		List<Book> list = repository.findAll();
		
		for(Book book : list) {
			System.out.println(book);
		}
	}
	@Test
	public void 데이터수정() {
		Optional<Book> result = repository.findById(1);
		Book book = result.get();
		book.setPrice(15000);
		repository.save(book);
	}
	
	@Test
	public void 데이터삭제() {
		repository.deleteAll();
	}
	
}













