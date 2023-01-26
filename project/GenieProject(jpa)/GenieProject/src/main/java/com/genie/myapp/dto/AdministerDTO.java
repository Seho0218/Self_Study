package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Account.Administer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import static org.modelmapper.convention.MatchingStrategies.*;

@Data
@NoArgsConstructor
public class AdministerDTO {

    private String genieId;
    private String administerName;
    private String administerPhone;
    private String geniePwd;
    private String geniePwd2;
    private String administerEmail;
    private String ROLE;
    private String DATETIME;

    // Entity -> DTO (정적 팩토리 메서드)
    public static AdministerDTO convertEntityToDTO(Administer administer) {

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(STRICT);
        return modelMapper.map(administer, AdministerDTO.class);
    }

    // DTO -> Entity
    public static Administer convertDTOtoEntity(AdministerDTO administerDTO) {

        ModelMapper modelMapper = new CustomerModelMapper();
        // 매핑 전략 설정
        modelMapper.getConfiguration().setMatchingStrategy(STRICT);
        return modelMapper.map(administerDTO, Administer.class);
    }
}
