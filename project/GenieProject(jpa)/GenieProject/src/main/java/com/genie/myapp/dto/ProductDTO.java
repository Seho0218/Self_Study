package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ProductDTO {

	private int product_id;
	private String genie_id;
	private String product_category;
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


	// Entity -> DTO (정적 팩토리 메서드)
	public static ProductDTO convertEntityToDTO(Product product){

		ModelMapper modelMapper = new CustomerModelMapper();
		// 매핑 전략 설정
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(product, ProductDTO.class);
	}

	// DTO -> Entity
	public static Product convertDTOtoEntity(ProductDTO productDTO) {

		ModelMapper modelMapper = new CustomerModelMapper();
		// 매핑 전략 설정
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(productDTO, Product.class);
	}

	// Entity -> DTO (List의 경우)
	public static List<ProductDTO> convertEntityToDTO(List<Product> productDTOS) {
		return productDTOS.stream().map(ProductDTO::convertEntityToDTO).collect(Collectors.toList());
	}

}