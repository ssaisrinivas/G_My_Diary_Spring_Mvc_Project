package com.sai.spring.mydairy.dao;

import java.awt.image.RescaleOp;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sai.spring.mydairy.entities.User;

@Component
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Transactional(readOnly = false)
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional(readOnly = false)
	public void save(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(User user) {
		hibernateTemplate.update(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}

	@Override
	@Transactional(readOnly = false)
	public User findById(int id) {
		return hibernateTemplate.get(User.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public List<User> findAll() {
		return hibernateTemplate.loadAll(User.class);
	}
	@Override
	public User findByUserName(String username) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user =null;		
		try {
			user = (User) hibernateTemplate.findByCriteria(criteria).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return user;
		
	}

}
