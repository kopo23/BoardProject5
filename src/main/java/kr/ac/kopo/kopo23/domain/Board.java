package kr.ac.kopo.kopo23.domain;

public class Board {
	private int id;
	private String title;
	private String content;
	private String date;
	private String userid;
	private int r_id;
	private String r_content;
	private String r_date;
	private String r_userid;
	private int r_selfnum;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int id) {
		this.r_id = id;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getR_userid() {
		return r_userid;
	}
	public void setR_userid(String r_userid) {
		this.r_userid = r_userid;
	}
	public int getR_selfnum() {
		return r_selfnum;
	}
	public void setR_selfnum(int r_selfnum) {
		this.r_selfnum = r_selfnum;
	}
	
	
}
