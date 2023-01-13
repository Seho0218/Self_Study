package com.genie.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;

@Mapper
@Repository
public interface ReplyProductDAO{
    
    public List<ReplyProductDTO> replyProductList(int no);
    public int replyProductWrite (ReplyProductDTO vo);
    public int replyProductEdit (ReplyProductDTO vo);
    public int replyProductDelete(int reply_no, String genie_id);
    public int likeInsert(LikeDTO vo);
    public int likeStatus(LikeDTO vo);
    public int likeDelete(LikeDTO vo);
    public int likeHitMinus(LikeDTO vo);
    public int likeHitPlus(LikeDTO vo);
}