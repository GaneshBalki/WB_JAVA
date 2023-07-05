package com.demo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.beans.Product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Product> getAllProducts() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from Product p");
		List<Product> plist=query.list();
		tr.commit();
		session.close();
		return plist;
	}

	@Override
	public int save(Product p) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
		    session.save(p);
			tr.commit();
			session.close();
			return 1;
		}catch(DataAccessException e) {
			return 0;
		}
		
	}
	
	
}
