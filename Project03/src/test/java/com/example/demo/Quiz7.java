package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class Quiz7 {

	@Autowired
	OrderRepository repository;

	@Test
	public void 주소지가인천인_주문검색() {
        List<Order> list = repository.get1("인천");
        for(Order order : list) {
            System.out.println(order);
        }
	}

	@Test
	public void 주문일이7월3일인_주문검색() {
		LocalDate localDate = LocalDate.of(2023,7,3);
		List<Order> list = repository.get2(localDate);
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 주소지가인천인_주문검색_JPQL() {
        List<Order> list = repository.get3("인천");
        for(Order order : list) {
            System.out.println(order);
        }
	}

	@Test
	public void 주문일이7월3일인_주문검색_JPQL() {
		LocalDate localDate = LocalDate.of(2023,7,3);
		List<Order> list = repository.get4(localDate);
		for(Order order : list) {
			System.out.println(order);
		}
		for (int i = 0; i < list.size(); i++) {
			Order od = list.get(i);
			System.out.println(od);
		}
	}
}