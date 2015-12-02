package com.dodam.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dodam.dao.UserDao;
import com.dodam.service.UserService;
import com.dodam.service.domain.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	private SqlSession sqlSession;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	
	public int insertUser(User user) throws Exception {
		userDao.insertUser(user);
		return 0;
	}

	public boolean checkDuplication(String mail) throws Exception {
		boolean result=true;
		//User user=userDao.getUser(mail);
		/*if(user != null){
			result=false;
		}*/
		return result;
	}

	
	public User getUser(int uNo) throws Exception {
		
		return userDao.getUser(uNo);
	}

	
	public List<User> getUserList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("getUserList 들어완??");
		return sqlSession.selectList(null, map);
	}

	
	public int updateUser(User user) throws Exception {
		userDao.updateUser(user);
		return 0;
	}

	
	public int deleteUser(int  uNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	


}
