package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.MyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.modelmapper.convention.MatchingStrategies.*;

@Data
@NoArgsConstructor
public class OrderDTO {

    private String orderNum;
    private User genieId;
    private int productId;
    private String productName;

    private String recipientName;
    private String recipientPhone;
    private String recipientAddress;
    private String recipientRequest;
    private String paymentMethod;
    private String recipientDeliveryStatus = "delivery_prepared";
    private LocalDateTime orderWriteDate = LocalDateTime.now();

    private int cartNum;
    private List<Integer> cartList;
    private List<Integer> productIdList;
    private List<String> productNameList;
    private int cartQty;
    private List<Integer> cartQtyList;
    private int orderPrice;
    private int cartPrice;
    private List<Integer> orderPriceList;
    private int orderQty;


    private String monthDay;
    private int totalSales;

    private int soldCounts;
    private String productImage1;
    private String productCategory;


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
           //목록을 스트림으로 // 스트림에 담긴 OrderDTO 클래스의 E->D로 변환된 D스트림 반환 //스트림을 다시 DTO로 변환
    }

    // Entity <- DTO (List의 경우)
    public static List<MyOrder> convertDTOToEntity(List<OrderDTO> orderList) {
        return orderList.stream().map(OrderDTO::convertDTOtoEntity).collect(Collectors.toList());
        //목록을 스트림으로 // 스트림에 담긴 OrderDTO 클래스의 E->D로 변환된 D스트림 반환 //스트림을 다시 DTO로 변환
    }

}
