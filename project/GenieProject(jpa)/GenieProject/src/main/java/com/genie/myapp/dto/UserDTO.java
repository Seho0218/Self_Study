package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Account.User;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {

    @NotEmpty
    private String genieId;

    @NotEmpty
    private String geniePwd;

    //비밀번호 확인
    @NotEmpty
    private String geniePwd2;
    private String ROLE;


    //사용자 이름 (실명)
    @NotEmpty
    private String userName;
    
	private String userTel;
	private String userPhoneNum1;
	private String userPhoneNum2;
	private String userPhoneNum3;
    private String userEmail;

    private char userGender;
	
    private String signInDate;
    private String paymentMethod;


    public String getUserTel() {
        return userPhoneNum1 + "-"+userPhoneNum2+"-"+userPhoneNum3;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
        String[] telSplit = userTel.split("-");
		userPhoneNum1 = telSplit[0];
		userPhoneNum2 = telSplit[1];
		userPhoneNum3 = telSplit[2];
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

    //객체를 지속적으로 생성해야할 때, 팩토리 메소드로 해결한 경우
    public static UserDTO createUserDTO(String genieId) {
        UserDTO userDTO = new UserDTO();
        userDTO.setGenieId(genieId);
        return userDTO;
    }


}

