package com.genie.myapp.repository.jpa;

import com.genie.myapp.entity.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByProductId(int ids);

}
