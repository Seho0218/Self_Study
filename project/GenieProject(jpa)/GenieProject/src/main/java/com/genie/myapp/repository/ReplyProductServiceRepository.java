package com.genie.myapp.repository;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.genie.myapp.entity.Account.QAccount.*;
import static com.genie.myapp.entity.Account.QUser.*;
import static com.genie.myapp.entity.Product.QProduct.*;
import static com.genie.myapp.entity.Product.QProductLike.productLike;
import static com.genie.myapp.entity.Product.QReply_product.*;

@Repository
@RequiredArgsConstructor
public class ReplyProductServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;


    public int replyProductEdit(ReplyProductDTO replyProductDTO){
        return (int) queryFactory
                .update(reply_product)
                .set(reply_product.comment, replyProductDTO.getComment())
                .set(reply_product.rating, replyProductDTO.getRating())
                .where(reply_product.replyNo.eq(replyProductDTO.getReplyNo()),
                        account.genieId.eq(replyProductDTO.getGenieId()))
                .execute();
    }

    public int replyProductDelete(int replyNo, String genieId) {
        return (int) queryFactory
                .delete(reply_product)
                .where(
                        reply_product.replyNo.eq(replyNo),
                        user.genieId.eq(genieId)
                )
                .execute();
    }

    public int likeHitPlus(LikeDTO dto) {
        return (int) queryFactory
                .update(product)
                .set(product.productLike, product.productLike.add(1))
                .where(product.productId.eq(dto.getProductId()))
                .execute();
    }

    public int likeHitMinus(LikeDTO dto) {
        return (int) queryFactory
                .update(product)
                .set(product.productLike, product.productLike.add(-1))
                .where(product.productId.eq(dto.getProductId()))
                .execute();
    }

    public int likeDelete(LikeDTO dto) {
        return (int) queryFactory
                .delete(productLike)
                .where(
                        user.genieId.eq(dto.getGenieId()),
                        product.productId.eq(dto.getProductId())
                )
                .execute();
    }
}
