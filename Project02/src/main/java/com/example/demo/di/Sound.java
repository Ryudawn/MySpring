package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sound {

	@Autowired
	Dog dog1;	//의존성주입한거래 이게 ...
}
