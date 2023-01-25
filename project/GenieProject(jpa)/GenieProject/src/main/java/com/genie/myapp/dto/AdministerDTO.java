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

    private String genie_id;
    private String administer_name;
    private String administer_phone;
    private String genie_pwd;
    private String genie_pwd2;
    private String administer_email;
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
