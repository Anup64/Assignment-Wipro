package com.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

public class StoreData {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
//		Student obj = new Student();
//		
//		obj.setStd_name("Anup");
//		obj.setStd_city("Bihar");
//		
//		session.persist(obj);
//		
//		t.commit();
		
		Student obj = session.get(Student.class, 1);
		System.out.println(obj.getId()+" "+obj.getStd_name()+" "+obj.getStd_city());
		
		obj.setStd_city("Blr");
		obj.setStd_name("Virat");
		
		session.persist(obj);
		
		t.commit();
//		
//		Student obj = session.get(Student.class, 2);
//		session.remove(obj);
		
		
		System.out.println("Done");
		session.close();
	}

}



	



