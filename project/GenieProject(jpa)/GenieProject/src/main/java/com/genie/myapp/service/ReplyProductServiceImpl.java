package com.genie.myapp.service;

import java.util.List;

import javax.inject.Inject;

import com.genie.myapp.repository.ReplyProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyProductServiceImpl implements ReplyProductService{

    @Inject
	ReplyProductJpaRepository repository;
    
    public List<ReplyProductDTO> replyProductList(int no){
        return repository.replyProductList(no);
    }

	@Override
	public int replyProductWrite(ReplyProductDTO dto) {
		return repository.replyProductWrite(dto);
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
		return repository.likeInsert(dto);
	}

	@Override
	public int likeStatus(LikeDTO dto) {
		return repository.likeStatus(dto);
	}

	@Override
	public int likeDelete(LikeDTO dto) {
		return repository.likeDelete(dto);
	}

	@Override
	public int likeHitMinus(LikeDTO dto) {
		return repository.likeHitMinus(dto);
	}

	@Override
	public int likeHitPlus(LikeDTO dto) {
		return repository.likeHitPlus(dto);
	}

	


}