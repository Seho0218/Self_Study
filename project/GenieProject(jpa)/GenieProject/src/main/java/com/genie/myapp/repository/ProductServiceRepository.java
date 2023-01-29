package com.genie.myapp.repository;

import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.SellerDTO;
import com.genie.myapp.entity.Account.QSeller;
import com.genie.myapp.entity.Product.Product;
import com.genie.myapp.entity.Product.QProduct;
import com.genie.myapp.entity.QCart;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.genie.myapp.entity.Account.QSeller.*;
import static com.genie.myapp.entity.Product.QProduct.*;
import static com.genie.myapp.entity.QAddress.address;
import static com.genie.myapp.entity.QCart.cart;

@Repository
@RequiredArgsConstructor
public class ProductServiceRepository {

    private final JPAQueryFactory queryFactory;


}
