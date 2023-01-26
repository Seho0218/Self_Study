package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.UserDTO;

public interface CertService {

    public List<String> FindId(String userEmail);
    void sendUserId(String userEmail, List<String> genieId);

    public int overlapCheck(String value, String valueType);
    public boolean emailCheck(String genieId, String userEmail);

    void sendAuthNum(String userEmail, String authNum);

    public int PwdEditOk(UserDTO userDTO);

	
    
}
 