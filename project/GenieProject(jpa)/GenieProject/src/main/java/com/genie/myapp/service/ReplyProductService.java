package com.genie.myapp.service;

import java.util.List;
import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;

public interface ReplyProductService {
    public List<ReplyProductDTO> replyProductList(int no);
    public int replyProductWrite(ReplyProductDTO likeDTO);
    public int replyProductEdit (ReplyProductDTO likeDTO);
    public int replyProductDelete(int reply_no, String genie_id);
    public int likeInsert(LikeDTO likeDTO);
    public int likeStatus(LikeDTO likeDTO);
    public int likeDelete(LikeDTO likeDTO);
    public int likeHitMinus(LikeDTO likeDTO);
    public int likeHitPlus(LikeDTO likeDTO);
}