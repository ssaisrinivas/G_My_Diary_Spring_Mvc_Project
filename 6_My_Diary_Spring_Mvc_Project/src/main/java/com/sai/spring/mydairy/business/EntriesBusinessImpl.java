package com.sai.spring.mydairy.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sai.spring.mydairy.dao.EntriesDao;
import com.sai.spring.mydairy.entities.Entries;

@Component
public class EntriesBusinessImpl implements EntriesBusiness {

	@Autowired
	private EntriesDao entriesDao;

	public EntriesDao getEntriesDao() {
		return entriesDao;
	}

	public void setEntriesDao(EntriesDao entriesDao) {
		this.entriesDao = entriesDao;
	}

	@Override
	public void save(Entries entries) {
		entriesDao.save(entries);
	}

	@Override
	public void update(Entries entries) {
		entriesDao.update(entries);
	}

	@Override
	public void delete(Entries entries) {
		entriesDao.delete(entries);
	}

	@Override
	public Entries findById(int id) {
		return entriesDao.findById(id);
	}

	@Override
	public List<Entries> findAll() {
		return entriesDao.findAll();
	}

	@Override
	public List<Entries> findByUserId(int id) {
		return entriesDao.findByUserId(id);
	}

}
