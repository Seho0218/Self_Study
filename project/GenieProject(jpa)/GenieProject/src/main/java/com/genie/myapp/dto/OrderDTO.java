package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.MyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.modelmapper.convention.MatchingStrategies.*;

@Data
@NoArgsConstructor
public class OrderDTO {

    private String order_num;
    private String genie_id;
    private String product_name;

    private String recipient_name;
    private String recipient_phone;
    private String recipient_address;
    private String recipient_request;
    private String recipient_delivery_status;
    private String payment_method;
    private String order_writedate;

    private int cart_num;
    private List<Integer> cartList;
    private int product_id;
    private List<Integer> product_id_List;
    private List<String> product_name_List;
    private int cart_qty;
    private List<Integer> cart_qty_List;
    private int order_price;
    private int cart_price;
    private List<Integer> order_price_List;
    private int order_qty;


    private String month_day;
    private int total_sales;

    private int sold_counts;
    private String product_image1;
    private String product_category;


    // Entity -> DTO (정적 팩토리 메서드)
    public static OrderDTO convertEntityToDTO(MyOrder myOrder){

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(STRICT);
        return modelMapper.map(myOrder, OrderDTO.class);
    }

    // DTO -> Entity
    public static MyOrder convertDTOtoEntity(OrderDTO orderDTO) {

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(STRICT);
        return modelMapper.map(orderDTO, MyOrder.class);
    }

    // Entity -> DTO (List의 경우)
    public static List<OrderDTO> convertEntityToDTO(List<MyOrder> orderList) {
        return orderList.stream().map(OrderDTO::convertEntityToDTO).collect(Collectors.toList());
    }

}
