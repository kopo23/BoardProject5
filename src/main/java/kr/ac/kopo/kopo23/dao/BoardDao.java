package kr.ac.kopo.kopo23.dao;

import java.util.List;

import kr.ac.kopo.kopo23.domain.Board;

public interface BoardDao {
	void create(Board board);
	Board selectOne(int id);
	List<Board> selectAll();
	void update(Board board);
	void delete(Board board);
}
