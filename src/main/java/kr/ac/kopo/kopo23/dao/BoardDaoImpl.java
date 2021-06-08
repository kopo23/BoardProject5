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
	    Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc",                  
	                                       "root" , "kopoctc");
	    Statement stmt = conn.createStatement(); 
	    stmt.execute("insert into Board (title, content, date) values('"+board.getTitle()+"','"+board.getContent()+"',now());");
	    stmt.close(); 
	    conn.close();
		
		} catch(Exception e) {
			System.out.println("error" + e);
		}
	}

	@Override
	public Board selectOne(int id) {
		Board board = new Board();
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc",                  
		                                   "root" , "kopoctc");
		    Statement stmt = conn.createStatement();
		    String QueryTxt;
		    QueryTxt = String.format("select * from Board where id = "+id+";");
		    ResultSet rset = stmt.executeQuery(QueryTxt);
		    
		    while (rset.next()) {
		    	board.setId(rset.getInt(1));
		        board.setTitle(rset.getString(2));
		        board.setContent(rset.getString(3));
		        board.setDate(rset.getString(4));
		    }
		    rset.close();
		    stmt.close();
		    conn.close();
	      
	
		} catch (Exception e) {
			System.out.println("error"+e);
		}
		
		return board;
	}

	@Override
	public List<Board> selectAll() {
		List<Board> boardlist = new ArrayList<Board>();
		Board board = new Board();
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.87:3306/kopoctc",                  
		                                   "root" , "kopoctc");
		    Statement stmt = conn.createStatement();
		    String QueryTxt;
		    QueryTxt = String.format("select * from Board;");
		    ResultSet rset = stmt.executeQuery(QueryTxt);
		    
		    while (rset.next()) {
		    	
		    	board = new Board(); //객체선언해줘야한다.. 매번 why?..
		    	board.setId(rset.getInt(1));
		    	board.setTitle(rset.getString(2));
		    	board.setContent(rset.getString(3));
		    	board.setDate(rset.getString(4));
		    	boardlist.add(board);
		    	
		    }
		    
		    rset.close();
		    stmt.close();
		    conn.close();
	      
	
		} catch (Exception e) {
			System.out.println("error"+e);
		}
		
		return boardlist;
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
