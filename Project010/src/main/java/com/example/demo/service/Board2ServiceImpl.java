package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Board2DTO;
import com.example.demo.entity.Board2;
import com.example.demo.repository.Board2Repository;


@Service
public class Board2ServiceImpl implements Board2Service {

	@Autowired
	private Board2Repository repository;

	@Override
	public int register(Board2DTO dto) {
		Board2 entity = dtoToEntity(dto);
		repository.save(entity);

		return entity.getNo();
	}

	@Override
	public Page<Board2DTO> getList(int page) {
		
		int pageNum = (page == 0) ? 0 : page - 1;
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("no").descending());
		Page<Board2> entityPage = repository.findAll(pageable);
		Page<Board2DTO> dtoPage = entityPage.map( entity -> entityToDto(entity) );

		return dtoPage;
	}

	@Override
	public Board2DTO read(int no) {
        Optional<Board2> result = repository.findById(no);
        if(result.isPresent()) {
        	Board2 board =  result.get();
        	return entityToDto(board);
        } else {
        	return null;
        }
	}

	@Override
	public void modify(Board2DTO dto) {
        Optional<Board2> result = repository.findById(dto.getNo());
        if(result.isPresent()){
            Board2 entity = result.get();
            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());
            repository.save(entity);
        }
	}

	@Override
	public int remove(int no) {

		Optional<Board2> result = repository.findById(no);

		if (result.isPresent()) {
			repository.deleteById(no);
			return 1;
		} else {
			return 0;
		}

	}

}
