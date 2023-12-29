package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity	//이클래스는 jpa가 관리하는 객체라는 것을 알려주는 어노테이션
@Table(name = "tbl_memo")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no;
	
	@Column(length = 200, nullable = true)
	String text;
	
	
}
