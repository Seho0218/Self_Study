package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class SellerProductDTO {
	private int product_id;
    private String genie_id;
    private String product_category; // a,b,c
	private String product_tag; 
	private String product_name; 
	private int product_price;
	private String product_info; 
	private int product_stock; 
	private int product_quantity; 
	private int product_hit;
    private int product_like;
	private String product_writedate; 
	private String product_image1; 
	private String product_image2;
	private String product_image3;
	private String product_mbti;
	private String company_name;
	
	//여러개의 카테고리를 저장할 컬렉션
	private List<String> categoryList;
	private String[] categoryArray; //체크된 카테고리를 저장할 배열
	
	//여러개의 태그를 저장할 컬렉션
	private List<String> tagList;
	private String[] tagArray; //체크된 태그를 저장할 배열
	
	//여러개의 mbti를 저장할 컬렉션
	private List<String> mbtiList;
	
	public String searchKey;
	public String searchWord;


	public String getProduct_category() {
		String strCategory = String.join(",", categoryList);
		return strCategory;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
		String[] categorySplit = product_category.split(",");
		categoryList = Arrays.asList(categorySplit);
	}

	public String getProduct_tag() {
		String strTag = String.join(",", tagList);
		return strTag;
	}

	public void setProduct_tag(String product_tag) {
		this.product_tag = product_tag;
		String tagSplit[] = product_tag.split(",");
		tagList = Arrays.asList(tagSplit);
	}
	
	public String[] getCategoryArray() {
		return product_category.split(",");
	}

	public String[] getTagArray() {
		return product_tag.split(",");
	}

	public void setTagArray(String[] tagArray) {
		this.tagArray = tagArray;
	}

	public String getProduct_mbti() {
		String strMbti = String.join(",", mbtiList);
		return strMbti;
	}

	public void setProduct_mbti(String product_mbti) {
		this.product_mbti = product_mbti;
		String mbtiSplit[] = product_mbti.split(",");
		mbtiList = Arrays.asList(mbtiSplit);
	}



	
	
	
}
