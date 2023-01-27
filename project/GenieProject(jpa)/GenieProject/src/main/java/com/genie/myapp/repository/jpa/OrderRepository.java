package com.genie.myapp.repository.jpa;

import com.genie.myapp.entity.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<MyOrder, String> {

    List<MyOrder> findByGenieId_GenieId(String genieId);
}
