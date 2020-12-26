package com.springbook.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

public class BoardServiceClient {

	public static void main(String[] args) {
		//�����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		//boardSErviceImpl ��ü�� lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//�׽�Ʈ
		BoardVO vo = new BoardVO();
		vo.setTitle("�ӽ�����");
		vo.setWriter("ȫ�浿");
		vo.setContent("teststesetesetse");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println("------>"+board.toString());
		}
		container.close();
	}

}
