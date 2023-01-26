package com.genie.myapp.service;

import java.util.List;

import javax.transaction.Transactional;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import com.genie.myapp.repository.ReplyProductServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.ReplyProductDAO;


@Service
@Transactional
@RequiredArgsConstructor
public class ReplyProductServiceImpl implements ReplyProductService{

    public final ReplyProductDAO DAO;
	public final ReplyProductServiceRepository repository;
    
    public List<ReplyProductDTO> replyProductList(int no){
        return DAO.replyProductList(no);
    }

	@Override
	public int replyProductWrite(ReplyProductDTO replyProductDTO) {
		return DAO.replyProductWrite(replyProductDTO);
	}

	@Override
	public int replyProductEdit(ReplyProductDTO replyProductDTO) {
		return repository.replyProductEdit(replyProductDTO);
	}

	@Override
	public int replyProductDelete(int reply_no, String genie_id) {
		return repository.replyProductDelete(reply_no, genie_id);
	}

	@Override
	public int likeInsert(LikeDTO likeDTO) {
		return DAO.likeInsert(likeDTO);
	}

	@Override
	public int likeStatus(LikeDTO likeDTO) {
		return DAO.likeStatus(likeDTO);
	}

	@Override
	public int likeDelete(LikeDTO likeDTO) {
		return repository.likeDelete(likeDTO);
	}

	@Override
	public int likeHitPlus(LikeDTO likeDTO) {
		return repository.likeHitPlus(likeDTO);
	}

	@Override
	public int likeHitMinus(LikeDTO likeDTO) {
		return repository.likeHitMinus(likeDTO);
	}

}