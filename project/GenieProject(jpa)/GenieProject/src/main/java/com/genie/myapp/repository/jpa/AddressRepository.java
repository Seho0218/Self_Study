package com.genie.myapp.repository.jpa;

import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findByGenieId_GenieId(String genieId);
}
