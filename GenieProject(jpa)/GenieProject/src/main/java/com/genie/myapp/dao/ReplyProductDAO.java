package com.genie.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.genie.myapp.vo.LikeVO;
import com.genie.myapp.vo.ReplyProductVO;

@Mapper
@Repository
public interface ReplyProductDAO{
    
    public List<ReplyProductVO> replyProductList(int no);
    public int replyProductWrite (ReplyProductVO vo);
    public int replyProductEdit (ReplyProductVO vo);
    public int replyProductDelete(int reply_no, String genie_id);
    public int likeInsert(LikeVO vo);
    public int likeStatus(LikeVO vo);
    public int likeDelete(LikeVO vo);
    public int likeHitMinus(LikeVO vo);
    public int likeHitPlus(LikeVO vo);
}