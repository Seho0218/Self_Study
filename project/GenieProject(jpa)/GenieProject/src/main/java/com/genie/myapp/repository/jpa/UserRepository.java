package com.genie.myapp.repository.jpa;

import com.genie.myapp.entity.Account.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByGenieId(String genieId);

}
