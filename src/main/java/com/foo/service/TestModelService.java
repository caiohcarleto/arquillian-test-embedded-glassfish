package com.foo.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.foo.model.TestModel;
import javax.persistence.PersistenceContext;

@Named
@Stateless
public class TestModelService {

	@PersistenceContext(unitName="TestPersistenceUnit")
	private EntityManager em;

	public void addTest(TestModel test) {

		em.persist(test);
	}

	public void deleteTest(Long testId) {

		TestModel test = em.find(TestModel.class, testId);

		if(test != null) {

			em.remove(test);
		}
	}

}	
