package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardRepository extends JpaRepository<Board, Integer> {

    

}
