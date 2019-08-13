package com.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.domain.BoardVO;
import com.practice.domain.PagingDto;
import com.practice.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList(PagingDto pagingDto) {
		// TODO Auto-generated method stub
		return mapper.getList(pagingDto);
	}
	
	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("register: "+board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("get: "+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("modify: "+board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove: "+bno);
		return mapper.delete(bno)==1;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		log.info("get total count");
		return mapper.getTotalCount();
	}
	
}