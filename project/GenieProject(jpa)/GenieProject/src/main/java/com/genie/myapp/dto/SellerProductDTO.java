package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class SellerProductDTO {
	private int productId;
	private String genieId;
	private String productCategory; // a,b,c
	private String productTag;
	private String productName;
	private int productPrice;
	private String productInfo;
	private int productStock;
	private int productQuantity;
	private int productHit;
	private int productLike;
	private String productWriteDate;
	private String productImage1;
	private String productImage2;
	private String productImage3;
	private String productMbti;
	private String companyName;

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


	public String getProductCategory() {
		String strCategory = String.join(",", categoryList);
		return strCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
		String[] categorySplit = productCategory.split(",");
		categoryList = Arrays.asList(categorySplit);
	}

	public String getProductTag() {
		String strTag = String.join(",", tagList);
		return strTag;
	}

	public void setProductTag(String productTag) {
		this.productTag = productTag;
		String tagSplit[] = productTag.split(",");
		tagList = Arrays.asList(tagSplit);
	}

	public String[] getCategoryArray() {
		return productCategory.split(",");
	}

	public String[] getTagArray() {
		return productTag.split(",");
	}

	public void setTagArray(String[] tagArray) {
		this.tagArray = tagArray;
	}

	public String getProductMbti() {
		String strMbti = String.join(",", mbtiList);
		return strMbti;
	}

	public void setProductMbti(String productMbti) {
		this.productMbti = productMbti;
		String mbtiSplit[] = productMbti.split(",");
		mbtiList = Arrays.asList(mbtiSplit);
	}

}
