package com.example.base;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;


public interface HibernateDao<T> {

	void flush();

	Criteria createCriteria(Criterion[] criterions);

	Long getCount(Criteria criteria);

	Query createSQLQuery(String sql);

	Query createSQLQuery(String sql, Map<String, Object> values);
	
	void create(T entity);
	void update(T entity);
	void delete(T entity);
	
}
