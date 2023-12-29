package com.example.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class OrderRepositoryTest {
	
	@Autowired
	OrderRepository repository;
	
	@Test
	public void 확인() {
		System.out.println();
		System.out.println("repository = " + repository);
		System.out.println();
	}
	
	@Test
	public void 데이터추가() {
		LocalDate localdate1 = LocalDate.of(2023, 7, 1);
		LocalDate localdate2 = LocalDate.of(2023, 7, 2);
		LocalDate localdate3 = LocalDate.of(2023, 7, 3);
		
		Order order1 = new Order(1, "둘리", localdate1 ,"인천 구월동");
		repository.save(order1);
		Order order2 = new Order(2, "또치", localdate2, "인천 연수동");
		repository.save(order2);
		Order order3 = new Order(3, "도우너", localdate3, "인천 동래동");
		repository.save(order3);
		
	}
	
	@Test
	public void 데이터조회() {
		List<Order> list = repository.findAll();
		for (Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터수정() {
		LocalDate localdate4 = LocalDate.of(2024, 12, 28);
		Optional<Order> result = repository.findById(1);
		Order order = result.get();
		order.setOrderDate(localdate4); // 일부 값 변경
		repository.save(order); // 1번이 존재하는지 확인하고 update 실행
	}
	
	@Test
	public void 데이터삭제() {
		repository.deleteAll();
	}
	
	
}


















