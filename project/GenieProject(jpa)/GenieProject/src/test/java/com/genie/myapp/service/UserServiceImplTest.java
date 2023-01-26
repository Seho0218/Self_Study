package com.genie.myapp.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RequiredArgsConstructor
@DataJpaTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
class UserServiceImplTest {

    @Autowired
    private TestEntityManager em;

//    @Test
//    void 유저_정보_업데이트_확인() {
//
//        UserDTO userDTO = new UserDTO();
//        userDTO.setGenie_id("user");
//        userDTO.setUser_tel("010-1233-1234");
//
//        User user = UserDTO.convertDTOtoEntity(userDTO);
//        User findUser = em.find(User.class, user.getGenie_id());
//
//        findUser.setUser_tel(userDTO.getUser_tel());



    @Test
    void pwdEditOk() {
    }
}