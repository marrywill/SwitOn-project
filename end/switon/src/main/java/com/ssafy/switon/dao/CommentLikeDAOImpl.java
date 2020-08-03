package com.ssafy.switon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.switon.dto.CommentLike;

@Repository
public class CommentLikeDAOImpl implements CommentLikeDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<CommentLike> selectCommentLikes() {
		return sqlsession.selectList("commentlike.selectCommentLikes");
	}

	@Override
	public CommentLike selectCommentLike(int id) {
		return sqlsession.selectOne("commentlike.selectCommentLike", id);
	}

	@Override
	public int insertCommentLike(CommentLike commentlike) {
		return sqlsession.insert("commentlike.insertCommentLike", commentlike);
	}

	@Override
	public int deleteCommentLike(int id) {
		return sqlsession.delete("commentlike.deleteCommentLike", id);
	}

}
