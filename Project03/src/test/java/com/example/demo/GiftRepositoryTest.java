package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;
import com.example.demo.repository.GiftRepository;

@SpringBootTest
public class GiftRepositoryTest {

	@Autowired
	GiftRepository repository;
	
	@Test
	public void 레포지토리를가져왔나() {
		System.out.println();
		System.out.println("repository = " + repository);
		System.out.println();
	}
	
	@Test
	public void 데이터추가하기() {
		Gift gift1 = new Gift(1,"참치세트",10000,"식품");
		repository.save(gift1);
		Gift gift2 = new Gift(2,"햄세트",20000,"식품");
		repository.save(gift2);
		Gift gift3 = new Gift(3, "샴푸세트", 30000, "생활용품");
		repository.save(gift3);
		Gift gift4 = new Gift(4, "세차용품", 40000, "생활용품");
		repository.save(gift4);
		Gift gift5 = new Gift(5, "주방용품", 50000, "생활용품");
		repository.save(gift5);
		Gift gift6 = new Gift(6, "노트북", 60000, "가전제품");
		repository.save(gift6);
		Gift gift7 = new Gift(7, "벽걸이TV", 70000, "가전제품");
		repository.save(gift7);
	}
	
	@Test
	public void 데이터조회() {
		List<Gift> list = repository.findAll();
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Gift> result = repository.findById(1);
		Gift gift = result.get();
		gift.setName("식용유세트");
		repository.save(gift);
	}
	
	@Test
	public void 데이터삭제() {
		repository.deleteAll();
	}
}

















