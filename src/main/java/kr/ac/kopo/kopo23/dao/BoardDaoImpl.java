package kr.ac.kopo.kopo23.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo23.domain.Board;

public class BoardDaoImpl implements BoardDao {

	@Override
	public void create(Board board) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			stmt.execute("insert into Board (title, content, date, userid) values('" + board.getTitle() + "','"
					+ board.getContent() + "',now(),'" + board.getUserid() + "');");
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}

	@Override
	public Board selectOne(int id) {
		Board board = new Board();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			String QueryTxt;
			QueryTxt = String.format("select * from Board where id = " + id + ";");
			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {
				board.setId(rset.getInt(1));
				board.setTitle(rset.getString(2));
				board.setContent(rset.getString(3));
				board.setDate(rset.getString(4));
				board.setUserid(rset.getString(5));
			}
			rset.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}

		return board;
	}

	@Override
	public List<Board> selectAll() {
		List<Board> boardlist = new ArrayList<Board>();
		Board board = new Board();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			String QueryTxt;
			QueryTxt = String.format("select * from Board;");
			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {

				board = new Board(); // 객체선언해줘야한다.. 매번 why?..
				board.setId(rset.getInt(1));
				board.setTitle(rset.getString(2));
				board.setContent(rset.getString(3));
				board.setDate(rset.getString(4));
				board.setUserid(rset.getString(5));
				boardlist.add(board);

			}

			rset.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}

		return boardlist;
	}

	@Override
	public void update(Board board) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			stmt.execute("update Board set title = '" + board.getTitle() + "', content ='" + board.getContent()
					+ "', date = now() where id = " + board.getId() + ";");
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}

	@Override
	public void delete(Board board) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			stmt.execute("delete from Board_reply where id = " + board.getId() + ";"); // 댓글부터 지우고
			stmt.close();

			stmt = conn.createStatement();
			stmt.execute("delete from Board where id = " + board.getId() + ";"); // 글지운다.
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}

	}

	@Override // 검색어
	public List<Board> searchAll(String type, String keywords, boolean search_true) {
		List<Board> boardlist = new ArrayList<Board>();
		Board board = new Board();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			String QueryTxt = null;
			
			if (type.trim().equals("") && keywords.trim().equals("") ) {
				QueryTxt = String.format("select * from Board;");
			} else {
				QueryTxt = String.format("select * from Board where " + type + " like '%%" + keywords + "%%';");
			}
			
			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {

				board = new Board(); // 객체선언해줘야한다.. 매번 why?..
				board.setId(rset.getInt(1));
				board.setTitle(rset.getString(2));
				board.setContent(rset.getString(3));
				board.setDate(rset.getString(4));
				board.setUserid(rset.getString(5));
				boardlist.add(board);

			}

			rset.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}

		return boardlist;
	}

	@Override
	public void create_reply(Board board) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			stmt.execute("insert into Board_reply (id, userid, content , date) values('" + board.getR_id() + "','"
					+ board.getR_userid() + "','" + board.getR_content() + "',now());");
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}

	}

	@Override
	public void delete_reply(Board board) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			stmt.execute("delete from Board_reply where selfnum = " + board.getR_selfnum() + ";");
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}

	@Override
	public void update_reply(Board board) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			stmt.execute("update Board_reply set content ='" + board.getR_content()
					+ "', date = now() where selfnum = " + board.getR_selfnum() + ";");
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}

	@Override
	public List<Board> selectReply(int id) {
		// TODO Auto-generated method stub
		List<Board> boardlist = new ArrayList<Board>();
		Board board = new Board();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			String QueryTxt;
			QueryTxt = String.format("select * from Board_reply where id = "+id+";");
			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {

				board = new Board(); // 객체선언해줘야한다.. 매번 why?..
				board.setR_id(rset.getInt(1));
				board.setR_userid(rset.getString(2));
				board.setR_content(rset.getString(3));
				board.setR_date(rset.getString(4));
				board.setR_selfnum(rset.getInt(5));
				boardlist.add(board);

			}

			rset.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("error" + e);
		}

		return boardlist;
	}

}
