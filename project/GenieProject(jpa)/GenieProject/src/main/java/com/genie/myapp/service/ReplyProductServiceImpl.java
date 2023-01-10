package com.genie.myapp.service;

import java.util.List;

import javax.inject.Inject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.ReplyProductDAO;
import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyProductServiceImpl implements ReplyProductService{

    @Inject ReplyProductDAO DAO;
    
    public List<ReplyProductDTO> replyProductList(int no){
        return DAO.replyProductList(no);
    }

	@Override
	public int replyProductWrite(ReplyProductDTO vo) {
		return DAO.replyProductWrite(vo);
	}

	@Override
	public int replyProductEdit(ReplyProductDTO vo) {
		return DAO.replyProductEdit(vo);
	}

	@Override
	public int replyProductDelete(int reply_no, String genie_id) {
		return DAO.replyProductDelete(reply_no, genie_id);
	}

	@Override
	public int likeInsert(LikeDTO vo) {
		return DAO.likeInsert(vo);
	}

	@Override
	public int likeStatus(LikeDTO vo) {
		return DAO.likeStatus(vo);
	}

	@Override
	public int likeDelete(LikeDTO vo) {
		return DAO.likeDelete(vo);
	}

	@Override
	public int likeHitMinus(LikeDTO vo) {
		return DAO.likeHitMinus(vo);
	}

	@Override
	public int likeHitPlus(LikeDTO vo) {
		return DAO.likeHitPlus(vo);
	}

	


}