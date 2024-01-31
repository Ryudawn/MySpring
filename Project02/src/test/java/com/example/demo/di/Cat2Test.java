package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Cat2Test {
	
	@Autowired
	Cat2 cat1;
	
	@Test
	void 고양이먹이() {
		cat1.eat();
	}
}
