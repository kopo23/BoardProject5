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

		int from_num = 0; // ���۹�ȣ����
		if (from_count == null || from_count == "") { // ���ۺ��� ����
			from_num = 0;
		} else {
			from_num = Integer.parseInt(from_count);
		}

		this.from_num = from_num;

		// <-------------------------------------------------------------->

		// ������ ��º���
		int page_amount;
		if (page_count == null || page_count == "") { // ������ ��º��� ����
			page_amount = 10;
		} else {
			page_amount = Integer.parseInt(page_count);
		}
		this.page_amount = page_amount;

		// <-------------------------------------------------------------->

		int total_page; // ������� ������ ����
		if (total_contents % page_amount == 0) { // �������� ����������
			total_page = total_contents / page_amount;
		} else { // �������� �� �������� �ʴ°��
			total_page = (total_contents / page_amount) + 1;
		}

		this.total_page = total_page; // ��ȯ

		// <-------------------------------------------------------------->
		int to_num = 0; // ������ ��ȣ ����
		if (total_contents - from_num >= page_amount) { // ����������°���(10) �� ���ų� ũ��
			to_num = from_num + page_amount; // �״��
		} else if (total_contents - from_num < page_amount) { // ������ == ������������������ ���
			to_num = total_contents; // ������������ ���
		}

		this.to_num = to_num;
		// <-------------------------------------------------------------->

		print_page = 10; // ��ȭ�鿡 ����� ��������
		if (print_page > total_page) {
			print_page = total_page;
		}
		
		// <-------------------------------------------------------------->
		if(print_page == 0) {print_page = 1;} //���� ��ü ������ ���� 0�ΰ�� 0���γ����� �ʰ��սô�.
		int start_page = from_num/(print_page*page_amount); //����������
		int last_page = start_page + print_page;
		
		if (from_num >= print_page*page_amount) { //���� ù������������ũ�� .. 
			start_page += page_amount -1;	//���� ���������� 10�� �����ְ�
			last_page = start_page + print_page; //���������������� ���������� + 10�ε�
			if (last_page > total_page) {	//���� �� ���� ��ü����������ũ��
				last_page = total_page;	//�׷��� ��ü������������
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
			
			int beforepage;						//�� ��ư������
			if ((from_num-page_amount) < 0 ) {	//������������ 0���������� 0����
				beforepage = 0;
			} else {
				beforepage = from_num-page_amount; //�׷��������� ���������� - 10(page_amount)
			}
			
			/***************************
			 * ����: ù �������� �̵� �� : ���� �������� �̵�
			 **************************/
			String href = String.format(
					"<a href='http://localhost:8086/Board_List.jsp?from_num=0&page_amount="+page_amount+"&type="+type+"&keywords="+keywords+"'>"+
					"<h6>" + " ���� " + "</h6></a>" + 
					"<a href='http://localhost:8086/Board_List.jsp?from_num="+beforepage+"&page_amount="+page_amount+"&type="+type+"&keywords="+keywords+"'>"+
					"<h6>" + " �� " + "</h6></a>");
			return href;
		}

	public String getFinalPage(String type, String keywords) {
		int nextpage;			//�� ��ư������
		if ((from_num+page_amount) >= last_page*page_amount ) { //���� ������������ ����+��·� =(����������������ȣ)�� ������������ ��·����� ���ų� ũ��
			nextpage = (last_page-1)*page_amount; //1���� ��ȯ
		} else {
			nextpage = from_num+page_amount; //�׷������� ���� ������ 10�����ؼ� ����.
		}
		/***************************
		 * �� : ���� �������� �̵� ����: �� �������� �̵�
		 **************************/
		String href = String.format(
				"<a href='http://localhost:8086/Board_List.jsp?from_num="+nextpage+"&page_amount="+page_amount+"&type="+type+"&keywords="+keywords+"'>"+
				"<h6>" + " �� " + "</h6></a>" + 
				"<a href='http://localhost:8086/Board_List.jsp?from_num="+(total_page-1)*page_amount+"&page_amount="+page_amount+"&type="+type+"&keywords="+keywords+"'>"+
				"<h6>" + " ���� " + "</h6></a>");
		return href;
	}
	
	

}
