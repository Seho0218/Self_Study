package com.genie.myapp.controller;

import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.service.CertService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RequiredArgsConstructor
class CertControllerTest {
    public final CertService certService;

    @PersistenceContext
    private final EntityManager em;

    @Test
    void modifyPassword() {
        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setChangedPwd("123");
        certService.PwdEditOk(accountDTO);



//        Pay pay = payRepository.save(new Pay("test1",  100));
//
//        //when
//        String updateTradeNo = "test2";
//        payService.update(pay.getId(), updateTradeNo);
//
//        //then
//        Pay saved = payRepository.findAll().get(0);
//        assertThat(saved.getTradeNo()).isEqualTo(updateTradeNo);

    }
}