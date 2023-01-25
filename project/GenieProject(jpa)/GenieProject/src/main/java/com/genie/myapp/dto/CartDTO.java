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
    private int cart_num;
    private String genie_id;
    private int product_id;
    private String product_name;
    private List<String> product_name_List;
    private int cart_price;
    private int product_price;
    private int cart_qty;
    private String cart_writedate;
    private String product_image1;
    private int product_quantity;

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