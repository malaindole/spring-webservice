package com.codereq.spring.json;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public class UserDao {

	
	private EntityManagerFactory emf;
	
	public boolean createUser(UserEntity userEntity) {
		
		if(getEmf() == null) {
			throw new IllegalArgumentException("EMF is null..");
		}
		try {
			EntityManager em = getEmf().createEntityManager();
			em.getTransaction().begin();
			em.persist(userEntity);
			em.getTransaction().commit();
		} catch (Throwable th) {
			th.printStackTrace();
			return false;
		}
		return true;
	}

	

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
