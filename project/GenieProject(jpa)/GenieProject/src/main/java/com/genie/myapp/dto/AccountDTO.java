package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Account.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.management.relation.Role;

import static org.modelmapper.convention.MatchingStrategies.*;

@Data
@NoArgsConstructor
public class AccountDTO {

    private String genieId;
	private String geniePwd;
    private int withdrawal;

    private String ROLE;
    private Role role;


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

}

