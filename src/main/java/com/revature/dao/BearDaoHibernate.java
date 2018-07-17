package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import static org.hibernate.criterion.Restrictions.*;

import com.revature.pojos.Bear;
import com.revature.utl.ConnectionUtil;

public class BearDaoHibernate implements BearDao{

	@Override
	public Bear getBear(int id) {
		// TODO Auto-generated method stub
		return (Bear) ConnectionUtil.getSession().get(Bear.class, id);
	}

	@Override
	public List<Bear> getAllBears() {
		// TODO Auto-generated method stub
		Session sess = ConnectionUtil.getSession();
		Criteria criteria = sess.createCriteria(Bear.class);
		criteria.add(and(
				eqOrIsNull("height", 6), 
				ilike("bearColor", "blue"),
				eq("weight", 300)
				)
			);
		return criteria.list();
	}

	@Override
	public Bear putBear(Bear bear) {
		// TODO Auto-generated method stub
		Session sess = ConnectionUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.save(bear);
		tx.commit();
		return bear;
	}

	@Override
	public void updateBear(Bear bear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBear(Bear bear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void feedBear(int bearId, double fat) {
		// TODO Auto-generated method stub
		
		Session sess = ConnectionUtil.getSession();
		String hql = "UPDATE Bear SET weight = weight + :fat WHERE bearId = :bearId";
		Query query = sess.createQuery(hql);
		Transaction tx = sess.beginTransaction();
		query.setParameter("fat", fat);
		query.setParameter("bearId", bearId);
		query.executeUpdate();
		tx.commit();
		hql = "FROM Bear AS b WHERE b.breed = :type";
		query = sess.createQuery(hql);
		List<Bear> bears = query.list();
		
	}

	
}
