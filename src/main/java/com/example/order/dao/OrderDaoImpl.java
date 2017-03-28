package com.example.order.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.base.HibernateDaoImpl;
import com.example.order.cmd.ListOrderByCdCmd;
import com.example.order.cmd.ListOrderCmd;
import com.example.order.dto.OrderDetailDTO;
import com.example.order.po.Order;

@Repository
@SuppressWarnings("unchecked")
public class OrderDaoImpl extends HibernateDaoImpl<Order> implements OrderDao {

	@Override
	@Transactional(readOnly = true)
	public List<Order> listByCd(ListOrderByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		pageBy(criteria, cmd);
		return criteria.list();
	}

	@Override
	@Transactional(readOnly = true)
	public Order findByCd(ListOrderByCdCmd cmd) {
		List<Order> list = listByCd(cmd);
		if(list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findCountByCd(ListOrderByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		return getCount(criteria);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderDetailDTO> listOrder(ListOrderCmd cmd) {
		String sql = "select "
				+ "o.order_no orderNo,"
				+ "o.status status,"
				+ "o.pay_type payType,"
				+ "o.description description,"
				+ "o.create_time createTime,"
				+ "o.update_time updateTime,"
				
				+ "oi.product_no productNo,"
				+ "oi.product_style_no productStyleNo,"
				+ "oi.product_name productName,"
				+ "oi.product_style_name productStyleName,"
				+ "oi.price price,"
				+ "oi.quantity quantity,"
				+ "oi.total_amount totalAmount,"
				
				+ "oa.user_name userName,"
				+ "oa.user_phone userPhone,"
				+ "oa.province_name provinceName,"
				+ "oa.city_name cityName,"
				+ "oa.area_name areaName,"
				+ "oa.address address"
				
				+ " from bb_order o"
				+ " join bb_order_item oi on oi.order_no=o.order_no"
				+ " join bb_order_address oa on oa.order_no=o.order_no"
				+ " where 1=1";
		
		Map<String, Object> values = new HashMap<String, Object>();
		sql = addCondition(sql, cmd, values);
		
		Query query = createSQLQuery(sql, values);
		query.setResultTransformer(Transformers.aliasToBean(OrderDetailDTO.class));
		pageBy(query, cmd);
		return query.list();
	}
	
	private void pageBy(Criteria criteria, ListOrderByCdCmd cmd) {
		if(cmd.getPageSize() != null) {
			criteria.setMaxResults(cmd.getPageSize());
		}
		if(cmd.getOffset() != null) {
			criteria.setFirstResult(cmd.getOffset());
		}
	}
	
	private void pageBy(Query query, ListOrderCmd cmd) {
		if(cmd.getPageSize() != null) {
			query.setMaxResults(cmd.getPageSize());
		}
		if(cmd.getOffset() != null) {
			query.setFirstResult(cmd.getOffset());
		}
	}

	private String addCondition(String sql, ListOrderCmd cmd, Map<String, Object> values) {
		return sql;
	}

	private void addCondition(Criteria criteria, ListOrderByCdCmd cmd) {
		if(cmd.getOrderNo() != null) {
			criteria.add(Restrictions.eq("orderNo", cmd.getOrderNo()));
		}
		if(cmd.getStatus() != null) {
			criteria.add(Restrictions.eq("status", cmd.getStatus()));
		}
		if(cmd.getPayType() != null) {
			criteria.add(Restrictions.eq("payType", cmd.getPayType()));
		}
		if(StringUtils.isNotBlank(cmd.getDescription())) {
			criteria.add(Restrictions.eq("description", cmd.getDescription()));
		}
		if(cmd.getStartCreateTime() != null) {
			criteria.add(Restrictions.ge("createTime", cmd.getStartCreateTime()));
		}
		if(cmd.getEndCreateTime() != null) {
			criteria.add(Restrictions.le("createTime", cmd.getEndCreateTime()));
		}
		if(cmd.getDeleteFlag() != null) {
			criteria.add(Restrictions.eq("deleteFlag", cmd.getDeleteFlag()));
		}
		if(cmd.getPageSize() != null) {
			criteria.setMaxResults(cmd.getPageSize());
		}
		if(cmd.getOffset() != null) {
			criteria.setFirstResult(cmd.getOffset());
		}
	}

}
