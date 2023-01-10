package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.vo.LikeDTO;
import com.genie.myapp.vo.ReplyProductDTO;

public interface ReplyProductService {
    public List<ReplyProductDTO> replyProductList(int no);
    public int replyProductWrite(ReplyProductDTO vo);
    public int replyProductEdit (ReplyProductDTO vo);
    public int replyProductDelete(int reply_no, String genie_id);
    public int likeInsert(LikeDTO vo);
    public int likeStatus(LikeDTO vo);
    public int likeDelete(LikeDTO vo);
    public int likeHitMinus(LikeDTO vo);
    public int likeHitPlus(LikeDTO vo);
}