package com.sai.spring.mydairy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sai.spring.mydairy.entities.Entries;

@Component
public class EntriesDaoImpl implements EntriesDao {

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
	public void save(Entries entries) {
		hibernateTemplate.save(entries);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Entries entries) {
		hibernateTemplate.update(entries);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Entries entries) {
		hibernateTemplate.delete(entries);
	}

	@Override
	@Transactional(readOnly = false)
	public Entries findById(int id) {
		return hibernateTemplate.get(Entries.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public List<Entries> findAll() {
		return hibernateTemplate.loadAll(Entries.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entries> findByUserId(int id) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Entries.class);
		 criteria.add(Restrictions.eq("userid", id));		 
		 List<Entries> entriesList=null;
		try {
			entriesList = (List<Entries>) hibernateTemplate.findByCriteria(criteria);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return entriesList;
	}

}
