package com.sai.spring.mydairy.business;

import java.util.List;

import com.sai.spring.mydairy.entities.Entries;


public interface EntriesBusiness {
	
	public void save(Entries entries) ;

	public void update(Entries entries);

	public void delete(Entries entries);
	
	public Entries findById(int id);

	public List<Entries> findAll() ;
	
	public List<Entries> findByUserId(int id);

}
