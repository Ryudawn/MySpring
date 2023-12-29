package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {

	@Test
	void test() {
		Student std1 = Student.builder().studentid(1001).name("둘리").age(21).build();
		Student std2 = Student.builder().studentid(1002).name("도우너").age(20).build();
		Student std3 = Student.builder().studentid(1003).name("희동이").age(19).build();
		
		System.out.println(std1.toString());
		System.out.println(std2.toString());
		System.out.println(std3.toString());
	}
}
