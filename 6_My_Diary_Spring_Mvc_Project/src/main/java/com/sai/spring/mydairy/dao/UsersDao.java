package com.sai.spring.mydairy.dao;

import java.util.List;

import com.sai.spring.mydairy.entities.User;

public interface UsersDao {
	
	public void save(User user) ;

	public void update(User user);

	public void delete(User user);
	
	public User findById(int id);

	public User findByUserName(String username) ;
	
	public List<User> findAll() ;

}
