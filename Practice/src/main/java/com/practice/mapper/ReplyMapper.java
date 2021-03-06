package com.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.practice.domain.ReplyPagingDto;
import com.practice.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int deleteAll(Long bno);
	
	public int update(ReplyVO reply);
	
	public List<ReplyVO> getReplies(@Param("bno")Long bno, @Param("paging")ReplyPagingDto paging);
	
	public int getCountByBno(Long bno);
}
