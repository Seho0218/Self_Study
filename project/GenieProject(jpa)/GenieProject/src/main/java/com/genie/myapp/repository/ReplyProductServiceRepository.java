package com.genie.myapp.repository;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.QReplyProductDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import com.genie.myapp.entity.Account.QAccount;
import com.genie.myapp.entity.Account.QUser;
import com.genie.myapp.entity.Product.QProduct;
import com.genie.myapp.entity.Product.QProduct_like;
import com.genie.myapp.entity.Product.QReply_product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.genie.myapp.entity.Account.QAccount.*;
import static com.genie.myapp.entity.Account.QUser.*;
import static com.genie.myapp.entity.Product.QProduct.*;
import static com.genie.myapp.entity.Product.QProduct_like.*;
import static com.genie.myapp.entity.Product.QReply_product.*;

@Repository
@RequiredArgsConstructor
public class ReplyProductServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;


    public int replyProductEdit(ReplyProductDTO dto){
        return (int) queryFactory
                .update(reply_product)
                .set(reply_product.comment, dto.getComment())
                .set(reply_product.rating, dto.getRating())
                .where(reply_product.reply_no.eq(dto.getReply_no()),
                        account.genie_id.eq(dto.getGenie_id()))
                .execute();
    }

    public int replyProductDelete(int reply_no, String genie_id) {
        return (int) queryFactory
                .delete(reply_product)
                .where(
                        reply_product.reply_no.eq(reply_no),
                        user.genie_id.eq(genie_id)
                )
                .execute();
    }

    public int likeHitPlus(LikeDTO dto) {
        return (int) queryFactory
                .update(product)
                .set(product.product_like, product.product_like.add(1))
                .where(product.product_id.eq(dto.getProduct_id()))
                .execute();
    }

    public int likeHitMinus(LikeDTO dto) {
        return (int) queryFactory
                .update(product)
                .set(product.product_like, product.product_like.add(-1))
                .where(product.product_id.eq(dto.getProduct_id()))
                .execute();
    }

    public int likeDelete(LikeDTO dto) {
        return (int) queryFactory
                .delete(product_like)
                .where(
                        user.genie_id.eq(dto.getGenie_id()),
                        product.product_id.eq(dto.getProduct_id())
                )
                .execute();
    }
}
