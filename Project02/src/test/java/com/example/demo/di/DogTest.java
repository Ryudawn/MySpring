package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DogTest {

//	@Autowired
//	Dog dog;
//	
//	@Test
//	void 강아지객체가만들어졌는지확인() {
//		System.out.println(dog);
//	}
//	@Test
//	void 강아지의기능테스트() {
//		dog.sound();
//	}
	@Autowired
	Dog dog;
	
	@Test
	void 동물의기능테스트() {
		dog.sound();
	}
}
