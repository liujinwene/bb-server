package com.example.order.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.base.HibernateDaoImpl;
import com.example.order.cmd.ListOrderItemByCdCmd;
import com.example.order.po.OrderItem;

@Repository
@SuppressWarnings("unchecked")
public class OrderItemDaoImpl extends HibernateDaoImpl<OrderItem> implements OrderItemDao {
	
	@Override
	@Transactional(readOnly = true)
	public List<OrderItem> listByCd(ListOrderItemByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		return criteria.list();
	}

	private void addCondition(Criteria criteria, ListOrderItemByCdCmd cmd) {
		if(cmd.getOrderItemNo() != null) {
			criteria.add(Restrictions.eq("orderItemNo", cmd.getOrderItemNo()));
		}
		if(cmd.getOrderNo() != null) {
			criteria.add(Restrictions.eq("orderNo", cmd.getOrderNo()));
		}
		if(cmd.getProductNo() != null) {
			criteria.add(Restrictions.eq("productNo", cmd.getProductNo()));
		}
		if(cmd.getProductStyleNo() != null) {
			criteria.add(Restrictions.eq("productStyleNo", cmd.getProductStyleNo()));
		}
		if(StringUtils.isNotBlank(cmd.getProductName())) {
			criteria.add(Restrictions.eq("productName", cmd.getProductName()));
		}
		if(StringUtils.isNotBlank(cmd.getProductStyleName())) {
			criteria.add(Restrictions.eq("productStyleName", cmd.getProductStyleName()));
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

	@Override
	@Transactional(readOnly = true)
	public OrderItem findByCd(ListOrderItemByCdCmd cmd) {
		List<OrderItem> list = listByCd(cmd);
		if(list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findCountByCd(ListOrderItemByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		return getCount(criteria);
	}
}
