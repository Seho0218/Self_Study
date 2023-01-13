package com.genie.myapp.service;

import java.util.List;

import javax.inject.Inject;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.ReplyProductDAO;


@Service
public class ReplyProductServiceImpl implements ReplyProductService{

    @Inject
    ReplyProductDAO DAO;
    
    public List<ReplyProductDTO> replyProductList(int no){
        return DAO.replyProductList(no);
    }

	@Override
	public int replyProductWrite(ReplyProductDTO dto) {
		return DAO.replyProductWrite(dto);
	}

	@Override
	public int replyProductEdit(ReplyProductDTO dto) {
		return DAO.replyProductEdit(dto);
	}

	@Override
	public int replyProductDelete(int reply_no, String genie_id) {
		return DAO.replyProductDelete(reply_no, genie_id);
	}

	@Override
	public int likeInsert(LikeDTO dto) {
		return DAO.likeInsert(dto);
	}

	@Override
	public int likeStatus(LikeDTO dto) {
		return DAO.likeStatus(dto);
	}

	@Override
	public int likeDelete(LikeDTO dto) {
		return DAO.likeDelete(dto);
	}

	@Override
	public int likeHitMinus(LikeDTO dto) {
		return DAO.likeHitMinus(dto);
	}

	@Override
	public int likeHitPlus(LikeDTO dto) {
		return DAO.likeHitPlus(dto);
	}

	


}