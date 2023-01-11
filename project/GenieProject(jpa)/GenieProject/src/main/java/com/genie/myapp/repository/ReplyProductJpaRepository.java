package com.genie.myapp.repository;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyProductJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
//
//    public List<ReplyProductDTO> replyProductList(int no);
//    public int replyProductWrite (ReplyProductDTO dto);
//    public int replyProductEdit (ReplyProductDTO dto);
//    public int replyProductDelete(int reply_no, String genie_id);
//    public int likeInsert(LikeDTO dto);
//    public int likeStatus(LikeDTO dto);
//    public int likeDelete(LikeDTO dto);
//    public int likeHitMinus(LikeDTO dto);
//    public int likeHitPlus(LikeDTO dto);
}
