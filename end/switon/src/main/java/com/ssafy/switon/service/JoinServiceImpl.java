package com.ssafy.switon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.switon.dao.JoinDAO;
import com.ssafy.switon.dao.UserDAO;
import com.ssafy.switon.dto.Join;
import com.ssafy.switon.dto.UserDTO;
import com.ssafy.switon.dto.UserInfoDTO;
import com.ssafy.switon.dto.UserSimpleDTO;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	JoinDAO joinDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<Join> searchAll() {
		return joinDAO.selectJoins();
	}

	@Override
	public Join search(int id) {
		return joinDAO.selectJoin(id);
	}

	@Override
	public boolean createLeader(Join join) {
		return joinDAO.insertJoinLeader(join) == 1;
	}

	@Override
	public List<Join> searchAllByUserId(int userId) {
		return joinDAO.selectJoinsByUserId(userId);
	}

	@Override
	public boolean isMember(int studyId, int userId) {
		Join join = new Join();
		join.setStudy_id(studyId);
		join.setUser_id(userId);
		return joinDAO.isMember(join) == 1;
	}

	@Override
	public boolean join(int studyId, int userId) {
		Join join = new Join();
		join.setStudy_id(studyId);
		join.setUser_id(userId);
		return joinDAO.insertJoin(join) == 1;
	}

	@Override
	public boolean leave(int studyId, int userId) {
		Join join = new Join();
		join.setStudy_id(studyId);
		join.setUser_id(userId);
		return joinDAO.deleteJoinByIds(join) == 1;
	}

	@Override
	public List<UserSimpleDTO> searchMembers(int studyId) {
		List<Integer> ids = joinDAO.selectMemberIds(studyId);
		List<UserSimpleDTO> members = new ArrayList<UserSimpleDTO>();
		for(int id : ids) {
			UserInfoDTO userInfo = userDAO.selectUserById(id);
			UserSimpleDTO user = new UserSimpleDTO(userInfo);
			members.add(user);
		}
		return members;
	}

}
