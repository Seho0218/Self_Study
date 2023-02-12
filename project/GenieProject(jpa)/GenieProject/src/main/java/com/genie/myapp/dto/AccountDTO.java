package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Account.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import static org.modelmapper.convention.MatchingStrategies.*;

@Data
@NoArgsConstructor
public class AccountDTO {

    private String genieId;
	private String geniePwd;
    private String changedPwd;
    private int withdrawal;

    private String ROLE;


    public static AccountDTO convertEntityToDTO(Account account){

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(STRICT);
        return modelMapper.map(account, AccountDTO.class);
    }

    // DTO -> Entity
    public static Account convertDTOtoEntity(AccountDTO accountDTO) {

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(STRICT);
        return modelMapper.map(accountDTO, Account.class);
    }

    //객체를 지속적으로 생성해야할 때, 팩토리 메소드로 해결한 경우
    public static AccountDTO createAccountDTO(String genie_id) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setGenieId(genie_id);
        return accountDTO;
    }

}

