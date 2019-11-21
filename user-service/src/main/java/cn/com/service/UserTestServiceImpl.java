package cn.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.bean.User;
import cn.com.dao.UserTestDao;
@Service
public class UserTestServiceImpl implements UserTestService{

	@Autowired
	UserTestDao userTestDao;
	
	@Override
	public int addUser(User user) {
		return userTestDao.addUser(user);
		
	}

	@Override
	public int updateUserInfo(User user) {
//		return userTestDao.updateUserInfo();
		return 1;
		
	}

	@Override
	public User getUserById(Long id) {
		
//		return userTestDao.getUserbyId(id);
		return new User();
	}

	
	
}
