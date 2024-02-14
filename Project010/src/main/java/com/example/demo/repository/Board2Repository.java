package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Board2;
import com.example.demo.entity.Member;

import jakarta.transaction.Transactional;


@Transactional
public interface Board2Repository extends JpaRepository<Board2, Integer>{
	
	//delete from tbl_board where writer_id = "user1"
	@Modifying
	@Query("delete from Board b where b.writer = :member")
	
	void deleteWriter(@Param("member")Member member);

}
