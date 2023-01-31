package com.genie.myapp.controller;

import com.genie.myapp.entity.Account.User;
import org.junit.jupiter.api.Test;


class GenieControllerTest {

    @Test
    void userWrite() {

        User user = new User();

        user.setGenieId("test");
        user.setGeniePwd("asd");
        user.setROLE("user");
        user.setWithdrawal(1);
        user.setUserTel("010-1234-1234");
        user.setUserName("김유저");


    }
}