package com.genie.myapp.service;

import com.genie.myapp.dto.UserDTO;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.repository.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.*;


@Transactional
@RequiredArgsConstructor
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName(" 유저 정보 업데이트 확인 ")
    void userUpdateTest(){

        //give
        User user = userRepository.findByGenieId("user");

        //when
        UserDTO userDTO = new UserDTO();
        userDTO.setGenieId("user");
        userDTO.setUserEmail("ghdtpgh8913@gaga");
        userDTO.setUserTel("010-1233-1234");

        User testUser = UserDTO.convertDTOtoEntity(userDTO);
        userRepository.save(testUser);

        //then
        User result = userRepository.findByGenieId("user");
        assertThat(result).isEqualTo(user);
    }


    @Test
    @DisplayName("회원 가입")
    void userWrite() {
        //give
        User user = userRepository.findByGenieId("user");

        //when
        UserDTO userDTO = new UserDTO();
        userDTO.setGenieId("user");
        userDTO.setUserName("이유저");
        userDTO.setUserEmail("ghdtpgh8913@gaga");
        userDTO.setUserTel("010-1233-1234");
        userDTO.setUserGender('M');

        User testUser = UserDTO.convertDTOtoEntity(userDTO);
        userRepository.save(testUser);

        //then
        User result = userRepository.findByGenieId("user");
        assertThat(result).isEqualTo(user);
    }
}