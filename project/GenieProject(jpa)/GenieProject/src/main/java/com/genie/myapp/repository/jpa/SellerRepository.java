package com.genie.myapp.repository.jpa;

import com.genie.myapp.entity.Account.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, String> {


}
