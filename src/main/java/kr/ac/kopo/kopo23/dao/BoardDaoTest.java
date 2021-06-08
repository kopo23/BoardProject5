package kr.ac.kopo.kopo23.dao;

import kr.ac.kopo.kopo23.domain.Board;

public class BoardDaoTest {
	public static void main(String[] args) {
//		Board board = new Board();
//		
//		board.setTitle("cksgur12");
//		board.setContent("hi how are u?");
//		
//		
//		BoardDao boardDao = new BoardDaoImpl();
//		boardDao.create(board);
		
		BoardDao boardDao = new BoardDaoImpl();
		System.out.println(boardDao.selectAll().size());
		for (int i = 0; i < boardDao.selectAll().size(); i++) {
			System.out.println(boardDao.selectAll().get(i).getTitle());
		}
//		
		
//		Board board = new Board();
//		BoardDao boardDao = new BoardDaoImpl();
//		
//		System.out.println(boardDao.selectOne(1).getId());
//		System.out.println(boardDao.selectOne(1).getTitle());
	}
}
