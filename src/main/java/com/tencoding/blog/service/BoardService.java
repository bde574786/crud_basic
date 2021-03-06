package com.tencoding.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tencoding.blog.dto.BoardSaveRequestDto;
import com.tencoding.blog.model.Board;
import com.tencoding.blog.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void 글쓰기(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);
	}

	@Transactional
	public Page<Board> 글목록보기(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Transactional
	public Board 글상세보기(int id) {
		Board board = boardRepository.mFindById(id).orElseThrow(() -> {
			return new RuntimeException("id 값이 잘못 들어왔어요");
		});
		
		// 더티체킹 = 조회 수 증가
		board.setReadCount(board.getReadCount() + 1);
		System.out.println(board.getReadCount());
		return board;
	}
	
	@Transactional
	public void 글수정하기(int id, BoardSaveRequestDto dto) {
		// 가져오기
		Board boardEntity = boardRepository.findById(id).orElseThrow(() -> {
			return new RuntimeException("해당 글은 없는 데이터입니다.");
		});
		
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
		
//		boardRepository.save(boardEntity); // 더티체킹 하지 않은 경우
	
		// 트랜잭션 처리 --> 글 수정하기() 메서드가 종료된느 시점에 더티 체킹 발생
		
	}
	
	@Transactional
	public int 글삭제하기(int id) {
//		boardRepository.deleteById(id);
		
		return boardRepository.mDeleteById(id);
	}
	

	
}
