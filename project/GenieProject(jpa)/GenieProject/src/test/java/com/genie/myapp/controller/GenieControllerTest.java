package com.genie.myapp.controller;

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
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@Transactional
@RequiredArgsConstructor
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class GenieControllerTest {

    @Autowired
    private UserRepository userRepository;



    @Test
    @DisplayName(" 회원 가입 ")
    void userWrite() {

        User user = new User();

        /**
         * account entity
         */
        user.setGenieId("test");
        user.setGeniePwd("asd");
        user.setROLE("user");
        user.setWithdrawal(1);

        /**
         * user entity
         */
        user.setUserTel("010-1234-1234");
        user.setUserName("김유저");
        user.setUserEmail("ghdtpgh@gmail.com");
        user.setPaymentMethod("NULL");
        user.setUserGender('M');
        userRepository.save(user);

        User result = userRepository.findByGenieId("test");
        assertThat(result).isEqualTo(user);

    }
}