package com.genie.myapp.service;

import java.util.List;
import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;

public interface ReplyProductService {
    public List<ReplyProductDTO> replyProductList(int no);
    public int replyProductWrite(ReplyProductDTO dto);
    public int replyProductEdit (ReplyProductDTO dto);
    public int replyProductDelete(int reply_no, String genie_id);
    public int likeInsert(LikeDTO dto);
    public int likeStatus(LikeDTO dto);
    public int likeDelete(LikeDTO dto);
    public int likeHitMinus(LikeDTO dto);
    public int likeHitPlus(LikeDTO dto);
}