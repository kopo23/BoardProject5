package kr.ac.kopo.kopo23.service;

import java.util.List;

import kr.ac.kopo.kopo23.dao.BoardDao;
import kr.ac.kopo.kopo23.dao.BoardDaoImpl;
import kr.ac.kopo.kopo23.domain.Board;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public void create(Board board) {
		
		boardDao.create(board);
	}

	@Override
	public Board selectOne(int id) {
		
		return boardDao.selectOne(id);
	}

	@Override
	public List<Board> selectAll() {
		
		return boardDao.selectAll();
	}
	
	@Override
	public List<Board> searchAll(String type, String keywords, boolean search_true) {
		// TODO Auto-generated method stub
		return boardDao.searchAll(type, keywords, search_true);
	}

	@Override
	public void update(Board board) {
		
		boardDao.update(board);
	}

	@Override
	public void delete(Board board) {
		
		boardDao.delete(board);
	}

	@Override
	public void create_reply(Board board) {
		
		boardDao.create_reply(board);
	}

	@Override
	public void delete_reply(Board board) {
		
		boardDao.delete_reply(board);
	}
	
	@Override
	public void update_reply(Board board) {

		boardDao.update_reply(board);
	}

	@Override
	public List<Board> selectReply(int id) {
		
		return boardDao.selectReply(id);
	}

	@Override
	public void writeList() {
		
		
	}


	
	

}
