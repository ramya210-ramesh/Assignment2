package com.te.SpringAssement.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.te.SpringAssement.bean.ProductDetails;
import com.te.SpringAssement.exception.ProductException;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public ProductDetails authenticate(int id, String password) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
		EntityManager manager = factory.createEntityManager();
		ProductDetails details = manager.find(ProductDetails.class, id);
		if (details != null) {
			if (details.getPassword().equals(password)) {
				return details;
			} else {
				throw new ProductException("Invalid Password");
			}
		}

		throw new ProductException("Invalid ID");
	}

	public boolean addData(ProductDetails details) {
		boolean isAdded = false;
		EntityTransaction transaction = null;
		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(details);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return isAdded;

	}

	@Override
	public boolean deleteData(int id) {
		boolean isDeleted = false;
		EntityTransaction transaction = null;
		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			ProductDetails details = manager.find(ProductDetails.class, id);
			manager.remove(details);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return isDeleted;
	}

	@Override
	public ProductDetails getData(int id) {
		ProductDetails details;

//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
		EntityManager manager = factory.createEntityManager();
		details = manager.find(ProductDetails.class, id);
		if (details != null) {
			return details;
		}
		return null;
	}

	@Override
	public boolean updateData(ProductDetails details, int id) {
		boolean isUpdated = false;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			ProductDetails details2 = manager.find(ProductDetails.class, id);
			if (details2 != null) {
				details2.setPassword(details.getPassword());
				details2.setName(details.getName());
				details2.setBrand(details.getBrand());
			}
			manager.persist(details2);
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public List<ProductDetails> getAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
		EntityManager manager = factory.createEntityManager();
		Query query =  manager.createQuery("from ProductDetails");
		List<ProductDetails> list = query.getResultList();
	
		return list;
	}
}