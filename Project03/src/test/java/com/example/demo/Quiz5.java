package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class Quiz5 {

	@Autowired
	BookRepository repository;
	
	@Test
	public void 제목이_자바프로그래밍입문인_책검색() {
		List<Book> list = repository.get1("자바프로그래밍입문");
		for(Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	public void 가격이_3만원이상이고_출판사가_남가람북스인_책검색() {
		List<Book> list = repository.get2(30000,"남가람북스");
		for(Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	public void 출판사가_한빛출판사_또는_이지스퍼블리싱인_책검색() {
		List<Book> list = repository.get3("한빛출판사","이지스퍼블리싱");
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 제목이_자바프로그래밍입문인_책검색_JPQL() {
		List<Book> list = repository.get4("자바프로그래밍입문");
		for(Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	public void 가격이_3만원이상이고_출판사가_남가람북스인_책검색_JPQL() {
		List<Book> list = repository.get5(30000,"남가람북스");
		for(Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	public void 출판사가_한빛출판사_또는_이지스퍼블리싱인_책검색_JPQL() {
		List<Book> list = repository.get6("한빛출판사","이지스퍼블리싱");
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
}