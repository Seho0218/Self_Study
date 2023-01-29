package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagingDTO {

	private int nowPage = 1; 
	private int onePageRecord=5; 
	private int totalRecord; 
	private int totalPage;
	private int offsetPoint;
	private int notApproved;
	
	
	private int startPage = 1;
	private int onePageCount = 5;

	private String searchKey;
	private String searchWord; 
	
	public String genie_id;
	

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;

		offsetPoint = (nowPage-1)*onePageRecord;

		startPage = (nowPage-1)/onePageCount*onePageCount+1;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//총페이지수 구하기
		totalPage = totalRecord/onePageRecord;
		if (totalRecord % onePageRecord != 0) totalPage++;
	}
}