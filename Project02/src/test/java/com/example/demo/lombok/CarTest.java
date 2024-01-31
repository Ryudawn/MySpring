package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarTest {

	@Test
	void Test() {
		Car car1 = new Car();
		car1.setModel("아반떼");
		car1.setBy("현대");
		car1.setColor("쥐색");
		
		Car car2 = new Car("토레스", "쌍용","흰색");
		
		Car car3 = Car.builder().model("렉스턴").by("쌍용").color("검정").build();
		
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		System.out.println(car3.toString());
	}
}
