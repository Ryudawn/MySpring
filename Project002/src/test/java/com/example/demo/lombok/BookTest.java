package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {

	@Test
	void Test() {
		Book book1 = new Book("둘리의 일억년 일대기", 20000,"고길동인력사무소",221);
		book1.setTitle("둘리의 일억년 일대기");
		book1.setPrice(20000);
		book1.setSeller("고길동인력사무소");
		book1.setPage(221);
		
		Book book2 = new Book("고길동의 육아일기", 16000,"고길동인력사무소",170);
		
		
		Book book3 = Book.builder()
				.title("도우너의 길동이 교육일지")
				.price(15000)
				.seller("고길동인력사무소")
				.page(162).build();
		
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(book3.toString());
	}
}
