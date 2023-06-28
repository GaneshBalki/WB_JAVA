package com.demo.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.User;

public class Test {

	public static void main(String[] args) {
		Address addr=new Address(1,"Pune");
		User user = new User(13, "Ganesh", "India@123",addr);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		
		tr.commit();
		session.close();
		sf.close();
	}

}
