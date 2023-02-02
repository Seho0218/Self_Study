package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.AccountDTO;

public interface CertService {

    List<String> FindId(String userEmail);
    void sendUserId(String userEmail, List<String> genie_id);

    int overlapCheck(String value, String valueType);
    boolean emailCheck(String genie_id, String userEmail);

    void sendAuthNum(String userEmail, String authNum);

    void PwdEditOk(AccountDTO accountDTO);

}
 