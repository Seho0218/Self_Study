package com.genie.myapp.repository.jpa;

import com.genie.myapp.entity.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByGenieId(String genieId);
}
