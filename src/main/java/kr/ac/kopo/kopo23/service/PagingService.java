package kr.ac.kopo.kopo23.service;

public class PagingService {

	private int total_contents;
	private int total_page;
	private int from_num;
	private int to_num;
	private int page_amount;
	private int print_page;
	private int start_page;
	private int last_page;

	public PagingService(String page_count, String from_count, int total_contents) {
		
		this.total_contents = total_contents;
		// <-------------------------------------------------------------->

		int from_num = 0; // 시작번호변수
		if (from_count == null || from_count == "") { // 시작변수 설계
			from_num = 0;
		} else {
			from_num = Integer.parseInt(from_count);
		}

		this.from_num = from_num;

		// <-------------------------------------------------------------->

		// 페이지 출력변수
		int page_amount;
		if (page_count == null || page_count == "") { // 페이지 출력변수 설계
			page_amount = 10;
		} else {
			page_amount = Integer.parseInt(page_count);
		}
		this.page_amount = page_amount;

		// <-------------------------------------------------------------->

		int total_page; // 총출력할 페이지 갯수
		if (total_contents % page_amount == 0) { // 페이지가 딱떨어지면
			total_page = total_contents / page_amount;
		} else { // 페이지가 딱 떨어지지 않는경우
			total_page = (total_contents / page_amount) + 1;
		}

		this.total_page = total_page; // 반환

		// <-------------------------------------------------------------->
		int to_num = 0; // 끝나는 번호 변수
		if (total_contents - from_num >= page_amount) { // 한페이지출력갯수(10) 과 같거나 크면
			to_num = from_num + page_amount; // 그대로
		} else if (total_contents - from_num < page_amount) { // 작으면 == 마지막페이지에서의 경우
			to_num = total_contents; // 마지막까지만 출력
		}

		this.to_num = to_num;
		// <-------------------------------------------------------------->

		print_page = 10; // 한화면에 출력할 페이지수
		if (print_page > total_page) {
			print_page = total_page;
		}
		
		// <-------------------------------------------------------------->
		if(print_page == 0) {print_page = 1;} //만약 전체 데이터 수가 0인경우 0으로나누진 않게합시다.
		int start_page = from_num/(print_page*page_amount); //시작페이지
		int last_page = start_page + print_page;
		
		if (from_num >= print_page*page_amount) { //만약 첫페이지수보다크면 .. 
			start_page += page_amount -1;	//시작 페이지수에 10을 더해주고
			last_page = start_page + print_page; //마지막페이지에는 시작페이지 + 10인데
			if (last_page > total_page) {	//만약 이 수가 전체페이지보다크면
				last_page = total_page;	//그럴땐 전체페이지까지만
			}
		} 
		
		this.start_page = start_page;
		this.last_page = last_page;
	}

	public int getStart_page() {
		return start_page;
	}

	public int getLast_page() {
		return last_page;
	}

	public int getFrom_num() {
		return from_num;
	}

	public int getTo_num() {
		return to_num;
	}

	public int getPage_amount() {
		return page_amount;
	}

		
	public String getFirstPage(String type, String keywords) { 
			
			int beforepage;						//◀ 버튼누를때
			if ((from_num-page_amount) < 0 ) {	//이전페이지가 0보다작으면 0으로
				beforepage = 0;
			} else {
				beforepage = from_num-page_amount; //그렇지않으면 현재페이지 - 10(page_amount)
			}
			
			/***************************
			 * ◀◀: 첫 페이지로 이동 ◀ : 이전 페이지로 이동
			 **************************/
			String href = String.format(
					"<a href='http://localhost:8086/Board_List.jsp?from_num=0&page_amount="+page_amount+"&type="+type+"&keywords="+keywords+"'>"+
					"<h6>" + " ◀◀ " + "</h6></a>" + 
					"<a href='http://localhost:8086/Board_List.jsp?from_num="+beforepage+"&page_amount="+page_amount+"&type="+type+"&keywords="+keywords+"'>"+
					"<h6>" + " ◀ " + "</h6></a>");
			return href;
		}

	public String getFinalPage(String type, String keywords) {
		int nextpage;			//▶ 버튼누를때
		if ((from_num+page_amount) >= last_page*page_amount ) { //만약 현재페이지의 시작+출력량 =(현페이지마지막번호)가 마지막페이지 출력량보다 같거나 크면
			nextpage = (last_page-1)*page_amount; //1빼고 반환
		} else {
			nextpage = from_num+page_amount; //그렇지않은 경우는 모조리 10씩더해서 증가.
		}
		/***************************
		 * ▶ : 다음 페이지로 이동 ▶▶: 끝 페이지로 이동
		 **************************/
		String href = String.format(
				"<a href='http://localhost:8086/Board_List.jsp?from_num="+nextpage+"&page_amount="+page_amount+"&type="+type+"&keywords="+keywords+"'>"+
				"<h6>" + " ▶ " + "</h6></a>" + 
				"<a href='http://localhost:8086/Board_List.jsp?from_num="+(total_page-1)*page_amount+"&page_amount="+page_amount+"&type="+type+"&keywords="+keywords+"'>"+
				"<h6>" + " ▶▶ " + "</h6></a>");
		return href;
	}
	
	

}
