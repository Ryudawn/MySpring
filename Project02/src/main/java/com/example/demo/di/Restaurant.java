package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	Chef chef1 = new Chef();	//기본형식
	
	@Autowired
	Chef chef2;	//의존성주입
}
