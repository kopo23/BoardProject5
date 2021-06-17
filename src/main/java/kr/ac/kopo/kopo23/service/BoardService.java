package kr.ac.kopo.kopo23.service;

import java.util.List;

import kr.ac.kopo.kopo23.domain.Board;

public interface BoardService {
	void create(Board board);
	Board selectOne(int id);
	List<Board> selectAll();
	List<Board> searchAll(String type, String keywords, boolean search_true);
	void update(Board board);
	void delete(Board board);
	
	void create_reply(Board board);
	void delete_reply(Board board);
	void update_reply(Board board);
	List<Board> selectReply(int id);
	
	void writeList();
	
}
