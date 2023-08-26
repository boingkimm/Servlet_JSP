package com.dto;

import java.util.List;

public class PageDTO {

	//list.jsp에서 필요한 4가지 정보 선언
		
	List<BoardDTO> list; //한 페이지에 에 보여줄 list
	int perPage = 3; //페이지 당 출력될 레코드
	int totalCount; //전체 레코드 수
	int curPage; //현재 페이지 번호

	
	//getter, setter  (생성자X)
	public List<BoardDTO> getList() {
		return list;
	}


	public void setList(List<BoardDTO> list) {
		this.list = list;
	}


	public int getPerPage() {
		return perPage;
	}


	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getCurPage() {
		return curPage;
	}


	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	

	
}
