package com.sai.spring.mydairy.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sai.spring.mydairy.dao.UsersDao;
import com.sai.spring.mydairy.entities.User;

@Component
public class UsersBusinessImpl implements UsersBusiness {

	@Autowired
	private UsersDao usersDao;

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public void save(User user) {
		usersDao.save(user);
	}

	@Override
	public void update(User user) {
		usersDao.update(user);
	}

	@Override
	public void delete(User user) {
		usersDao.delete(user);
	}

	@Override
	public User findById(int id) {
		return usersDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		return usersDao.findAll();
	}

	@Override
	public User findByUserName(String username) {
		return  usersDao.findByUserName(username);
	}

}
