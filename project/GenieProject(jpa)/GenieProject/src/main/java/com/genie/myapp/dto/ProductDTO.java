package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.modelmapper.convention.MatchingStrategies.*;

@Data
@NoArgsConstructor
public class ProductDTO {

	private List<Product> productList;
	private int productId;
	private String genieId;
	private String productCategory;
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
	private String productMBTI;

	private String companyName;


	// Entity -> DTO (정적 팩토리 메서드)
	public static ProductDTO convertEntityToDTO(Product product){

		ModelMapper modelMapper = new CustomerModelMapper();
		// 매핑 전략 설정
		modelMapper.getConfiguration().setMatchingStrategy(STRICT);
		return modelMapper.map(product, ProductDTO.class);
	}

	// DTO -> Entity
	public static Product convertDTOtoEntity(ProductDTO productDTO) {

		ModelMapper modelMapper = new CustomerModelMapper();
		// 매핑 전략 설정
		modelMapper.getConfiguration().setMatchingStrategy(STRICT);
		return modelMapper.map(productDTO, Product.class);
	}

	// Entity -> DTO (List의 경우)
	public static List<ProductDTO> convertEntityToDTO(List<Product> productDTOS) {
		return productDTOS.stream().map(ProductDTO::convertEntityToDTO).collect(Collectors.toList());
	}


	//객체를 지속적으로 생성해야할 때, 팩토리 메소드로 해결한 경우
	public static ProductDTO createProductDTO(int productId) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(productId);
		return productDTO;
	}
}