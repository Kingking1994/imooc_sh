package com.king.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.king.db.MyHibernateSessionFactory;
import com.king.entity.Students;

public class StudentsDAO {

	// 添加students
	public Students save(Students s) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getInstance()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	// 根据sid查找
	public Students findOne(String sid) {
		Transaction tx = null;
		String hql = "";
		Students s = null;
		try {
			Session session = MyHibernateSessionFactory.getInstance()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students where sid = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, sid);
			List list = query.list();
			if (list != null && list.size() > 0) {
				s = (Students) list.get(0);
			}
			tx.commit();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}
	
	/**
	 * 获取所有student
	 * @return
	 */
	public List<Students> findAll(){
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getInstance()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	// 判断是否存在
	public boolean isExist(String sid) {
		Transaction tx = null;
		String hql = "";
		boolean exist = false;
		try {
			Session session = MyHibernateSessionFactory.getInstance()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students where sid = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, sid);
			List list = query.list();
			if (list != null && list.size() > 0) {
				exist = true;
			}
			tx.commit();
			return exist;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	// 删除
	public void delete(String sid) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getInstance()
					.getCurrentSession();
			tx = session.beginTransaction();
			Students s = (Students)session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	// 更新
	public void update(Students s) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getInstance()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}
	
//	/**
//	
//	exception:students is not mapped [SELECT MAX(sid) from students]
//	 * 获得数据库中当前最大的学号
//	 * @return
//	 */
//	public String getMaxSid(){
//		Transaction tx = null;
//		String hql = "";
//		String maxSid = "";
//		try {
//			Session session = MyHibernateSessionFactory.getInstance()
//					.getCurrentSession();
//			tx = session.beginTransaction();
//			hql = "SELECT MAX(sid) from students";
//			Query query = session.createQuery(hql);
//			maxSid = (String)query.uniqueResult();
//			tx.commit();
//			return maxSid;
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//			return null;
//		} finally {
//			if (tx != null) {
//				tx = null;
//			}
//		}
//	}
//	

}
