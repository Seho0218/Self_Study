package com.genie.myapp.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import com.genie.myapp.repository.ReplyProductServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.ReplyProductDAO;


@Service
@Transactional
public class ReplyProductServiceImpl implements ReplyProductService{

    @Autowired ReplyProductDAO DAO;
	@Autowired ReplyProductServiceRepository repository;
    
    public List<ReplyProductDTO> replyProductList(int no){
        return DAO.replyProductList(no);
    }

	@Override
	public int replyProductWrite(ReplyProductDTO dto) {
		return DAO.replyProductWrite(dto);
	}

	@Override
	public int replyProductEdit(ReplyProductDTO dto) {
		return repository.replyProductEdit(dto);
	}

	@Override
	public int replyProductDelete(int reply_no, String genie_id) {
		return repository.replyProductDelete(reply_no, genie_id);
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
	public int likeHitPlus(LikeDTO dto) {
		return repository.likeHitPlus(dto);
	}

	@Override
	public int likeHitMinus(LikeDTO dto) {
		return repository.likeHitMinus(dto);
	}

}