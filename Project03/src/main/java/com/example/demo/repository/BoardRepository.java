package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {	//Jpa레포지토리라는 클래스는 스프링에서 기본으로 제공됨. 내가 생성하는게 아님

}