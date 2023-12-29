package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
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

@Table(name = "tbl_member")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Id
	@Column(length = 255)
	String userId;
	
	@Column(length = 255)
	String grade;
	
	@Column(length = 255)
	String password;
	
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate registerDate;
	
	
	
}


















