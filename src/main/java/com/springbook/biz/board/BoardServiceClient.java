package com.springbook.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

public class BoardServiceClient {

	public static void main(String[] args) {
		//컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		//boardSErviceImpl 객체를 lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("임시제목");
		vo.setWriter("홍길동");
		vo.setContent("teststesetesetse");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println("------>"+board.toString());
		}
		container.close();
	}

}
