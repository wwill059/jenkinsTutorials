package com.revature.driver;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.Bear;
import com.revature.pojos.HoneyPot;
import com.revature.utl.ConnectionUtil;

public class Driver {
	public static void main(String[] args) {
		
		Session s = ConnectionUtil.getSession();
		System.out.println("Connection Made");
		HoneyPot hp = new HoneyPot(1 ,5.0, 4.0);
		Transaction ta = s.beginTransaction();
//		s.save(hp);
//		s.persist(hp);
//		hp.setHoneyAmount(150);
//		s = ConnectionUtil.getSession();
//		ta = s.beginTransaction();
//		hp = (HoneyPot)s.load(HoneyPot.class, 150);
//		hp.setHoneyAmount(200);
//		s.update(hp);
//		hp.setHoneyAmount(500);
//		s.update(hp);
//		
////		hp = (HoneyPot)s.get(HoneyPot.class, 1);
//		System.out.println(hp);
//		ta.commit();
		
		Bear panda = (Bear)s.get(Bear.class, 10);
		Query query = s.getNamedQuery("@HQL_GET_ALL_BEARS");
		List<Bear> bears = query.list();
		query = s.getNamedQuery("@SQL_GET_ALL_BEARS");
		bears = query.list();
		ta.commit();
	}

}
