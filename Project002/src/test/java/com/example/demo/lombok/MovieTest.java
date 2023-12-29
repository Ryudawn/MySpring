package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieTest {
	@Test
	void test() {
		Movie mv1 = Movie.builder().title("둘리의 엄마찾아삼만리").producer("둘리엄마").date("내일모래").build();
		Movie mv2 = Movie.builder().title("도우너의 그러지 말아다오").producer("고길동").date("내일").build();
		Movie mv3 = Movie.builder().title("고길동의 인생이쓰다").producer("철수").date("글피").build();
		
		System.out.println(mv1.toString());
		System.out.println(mv2.toString());
		System.out.println(mv3.toString());
	}
}
