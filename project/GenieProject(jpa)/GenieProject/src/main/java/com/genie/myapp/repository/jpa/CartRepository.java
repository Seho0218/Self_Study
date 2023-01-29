package com.genie.myapp.repository.jpa;

import com.genie.myapp.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    void deleteCartsByCartNumIn(List<Integer> ids);
    List<Cart> findCartsByGenieId_GenieId(String ids);
}
