package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "tbl_order")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int order_no;
	
	@Column(length = 30)
	String customerName;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate orderDate;
	
	@Column(length = 100)
	String shipAddress;
	
	
}
















