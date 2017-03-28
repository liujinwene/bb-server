package com.example.base.dao;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.base.utils.ReflectionUtil;

public class HibernateDaoImpl<T> implements HibernateDao<T> {
	private final Class<T> entityClass;
	
	@Autowired
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public HibernateDaoImpl() {
		this.entityClass = ReflectionUtil.getSuperClassGenricType(this.getClass(), 0);
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public void flush() {
		this.getSession().flush();
	}

	protected void clear() {
		this.getSession().clear();
	}

	@Override
	public Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = this.getSession().createCriteria(this.entityClass);
		if(criterions !=null && criterions.length > 0){
			for (Criterion c : criterions) {
				criteria.add(c);
			}
		}
		return criteria;
	}

	@Override
	public Long getCount(Criteria criteria) {
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}
	
	@Override
	public Query createSQLQuery(String sql) {
		return getSession().createSQLQuery(sql);
	}
	
	@Override
	public Query createSQLQuery(String sql, Map<String, Object> values) {
		Query query = createSQLQuery(sql);
		if(values != null && !values.isEmpty()) {
			query.setProperties(values);
		}
		return query;
	}

	@Override
	@Transactional
	public void create(T entity) {
		getSession().save(entity);
	}

	@Override
	@Transactional
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	@Transactional
	public void delete(T entity) {
		getSession().delete(entity);
	}
}
