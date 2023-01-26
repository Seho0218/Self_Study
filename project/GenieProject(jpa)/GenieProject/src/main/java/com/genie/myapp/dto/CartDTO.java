package com.genie.myapp.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Cart;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
@NoArgsConstructor
public class CartDTO {

    private List<Integer> cartList;
    private int cartNum;
    private String genieId;
    private int productId;
    private String productName;
    private List<String> productNameList;
    private int cartPrice;
    private int productPrice;
    private int cartQty;
    private String cartWriteDate;
    private String productImage1;
    private int productQuantity;

    // Entity -> DTO (정적 팩토리 메서드)
    public static CartDTO convertEntityToDTO(Cart cart) {

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(cart, CartDTO.class);
    }

    // DTO -> Entity
    public static Cart convertDTOtoEntity(CartDTO cartDTO) {

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(cartDTO, Cart.class);
    }

    // Entity -> DTO (List의 경우)
    public static List<CartDTO> convertEntityToDTO(List<Cart> cartList) {
        return cartList.stream().map(CartDTO::convertEntityToDTO).collect(Collectors.toList());
    }
}