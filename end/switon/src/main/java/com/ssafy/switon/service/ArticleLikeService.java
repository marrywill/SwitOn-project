package com.ssafy.switon.service;

import java.util.List;

import com.ssafy.switon.dto.ArticleLike;

public interface ArticleLikeService {
	
	// 글좋아요 모두 조회
	List<ArticleLike> searchAll();
	// 글좋아요 조회
	ArticleLike search(int id);
	// 글좋아요 작성
	boolean createArticleLike(ArticleLike articlelike);
	// 글좋아요 삭제
	boolean deleteArticleLike(int id);
}
