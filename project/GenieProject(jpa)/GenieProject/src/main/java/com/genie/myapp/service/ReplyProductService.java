package com.genie.myapp.service;

import java.util.List;
import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;

public interface ReplyProductService {
    List<ReplyProductDTO> replyProductList(int no);
    int replyProductWrite(ReplyProductDTO likeDTO);
    int replyProductEdit (ReplyProductDTO likeDTO);
    int replyProductDelete(int reply_no, String genie_id);
    int likeInsert(LikeDTO likeDTO);
    int likeStatus(LikeDTO likeDTO);
    int likeDelete(LikeDTO likeDTO);
    int likeHitMinus(LikeDTO likeDTO);
    int likeHitPlus(LikeDTO likeDTO);
}