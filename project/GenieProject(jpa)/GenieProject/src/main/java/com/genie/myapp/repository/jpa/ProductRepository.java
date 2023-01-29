package com.genie.myapp.repository.jpa;

import com.genie.myapp.entity.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByProductId(int ids);

}
