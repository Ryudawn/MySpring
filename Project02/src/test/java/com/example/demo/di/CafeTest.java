package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CafeTest {
	
	@Autowired
	Cafe cafe1;
	
	@Autowired
	Manager mng1;
	
	@Test
	void 둘다나와() {
		System.out.println(cafe1);
		System.out.println(mng1);
	}
}
