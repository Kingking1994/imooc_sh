package com.king.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.king.db.MyHibernateSessionFactory;
import com.king.entity.Users;


/**
 * 
 * @author king
 *
 */
public class UsersDAO {

	//添加users
	public Users save(Users u){
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getInstance().getCurrentSession();
			tx = session.beginTransaction();
			session.save(u);
			tx.commit();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		}finally{
			if(tx != null){
				tx = null;
			}
		}
	}
	
	//根据uid查找
	public Users findOne(int uid){
		Transaction tx = null;
		String hql = "";
		Users u = null;
		try {
			Session session = MyHibernateSessionFactory.getInstance().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where uid = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, uid);
			List list = query.list();
			if(list != null && list.size() > 0){
				u = (Users)list.get(0);
			}
			tx.commit();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		}finally{
			if(tx != null){
				tx = null;
			}
		}
	}
	
	//判断是否存在
	public boolean isExist(int uid){
		Transaction tx = null;
		String hql = "";
		boolean exist = false;
		try {
			Session session = MyHibernateSessionFactory.getInstance().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where uid = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, uid);
			List list = query.list();
			if(list != null && list.size() > 0){
				exist = true;
			}
			tx.commit();
			return exist;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}finally{
			if(tx != null){
				tx = null;
			}
		}
	}
	
	//删除
	public void delete(Users u){
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getInstance().getCurrentSession();
			tx = session.beginTransaction();
			session.delete(u);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			if(tx != null){
				tx = null;
			}
		}
	}
	
	//更新
	public void update(Users u){
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getInstance().getCurrentSession();
			tx = session.beginTransaction();
			session.update(u);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			if(tx != null){
				tx = null;
			}
		}
	}
	
	//
	public Users findByUsername(String username){
		Transaction tx = null;
		String hql = "";
		Users tmp = null;
		try {
			Session session = MyHibernateSessionFactory.getInstance().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, username);
			List list = query.list();
			if(list != null && list.size() > 0){
				tmp = (Users)list.get(0);
			}
			tx.commit();
			return tmp;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		}finally{
			if(tx != null){
				tx = null;
			}
		}
	}
}
