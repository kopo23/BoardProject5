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
		// TODO Auto-generated method stub
		
		return boardDao.selectAll();
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		
	}

}
