package com.example.demo.di;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
	
	@Override
	public void sound() {
		System.out.println("멍멍짖는다.");
		
	}
}
