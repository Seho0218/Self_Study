package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.vo.LikeVO;
import com.genie.myapp.vo.ReplyProductVO;

public interface ReplyProductService {
    public List<ReplyProductVO> replyProductList(int no);
    public int replyProductWrite(ReplyProductVO vo);
    public int replyProductEdit (ReplyProductVO vo);
    public int replyProductDelete(int reply_no, String genie_id);
    public int likeInsert(LikeVO vo);
    public int likeStatus(LikeVO vo);
    public int likeDelete(LikeVO vo);
    public int likeHitMinus(LikeVO vo);
    public int likeHitPlus(LikeVO vo);
}