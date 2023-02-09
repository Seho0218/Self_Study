package com.genie.myapp.controller;

import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.entity.Account.Account;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.repository.jpa.AccountRepository;
import com.genie.myapp.repository.jpa.UserRepository;
import com.genie.myapp.service.CertServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class CertControllerTest {

    @Autowired
    private CertServiceImpl certServiceimpl;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Test
    void modifyPassword() {

        //given
        User user = userRepository.findByGenieId("user");

        //when
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setChangedPwd("123");
        certServiceimpl.PwdEditOk(accountDTO);

        Account testUser = AccountDTO.convertDTOtoEntity(accountDTO);
        accountRepository.save(testUser);

        //then
        Account result = accountRepository.findByGenieId("user");
        assertThat(result).isEqualTo(user);






    }
}