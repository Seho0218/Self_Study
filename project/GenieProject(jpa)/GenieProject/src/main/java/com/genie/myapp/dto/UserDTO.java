package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Account.User;
import lombok.Data;
import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
public class UserDTO {

    private String genie_id;
	private String genie_pwd;
    private String genie_pwd2;
    private String ROLE;

    private String user_name;
    
	private String user_tel;
	private String user_phone_num1;
	private String user_phone_num2;
	private String user_phone_num3;

    private String address_num;
	private String user_email;
	private String user_zipcode;
	private String user_addr;
	private String user_detailaddr;
    private char user_gender;
	
    private String sign_in_date;
    private String payment_method;


    public String getUser_tel() {
        return user_phone_num1 + "-"+user_phone_num2+"-"+user_phone_num3;
    }
    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
        String[] telSplit = user_tel.split("-");
		user_phone_num1 = telSplit[0];
		user_phone_num2 = telSplit[1];
		user_phone_num3 = telSplit[2];
    }

    // Entity -> DTO (정적 팩토리 메서드)
    public static UserDTO convertEntityToDTO(User user){

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(user,UserDTO.class);
    }

    // DTO -> Entity
    public static User convertDTOtoEntity(UserDTO userDTO) {

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(userDTO, User.class);
    }

    public static UserDTO createUserDTO(String genie_id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setGenie_id(genie_id);
        return userDTO;
    }
}

