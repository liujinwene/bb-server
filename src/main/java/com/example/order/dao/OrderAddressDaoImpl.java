package com.example.order.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.base.HibernateDaoImpl;
import com.example.order.cmd.ListOrderAddressByCdCmd;
import com.example.order.cmd.ListOrderByCdCmd;
import com.example.order.po.OrderAddress;


@Repository
@SuppressWarnings("unchecked")
public class OrderAddressDaoImpl extends HibernateDaoImpl<OrderAddress> implements OrderAddressDao {
	@Override
	@Transactional(readOnly = true)
	public List<OrderAddress> listByCd(ListOrderAddressByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		pageBy(criteria, cmd);
		return criteria.list();
	}

	@Override
	@Transactional(readOnly = true)
	public OrderAddress findByCd(ListOrderAddressByCdCmd cmd) {
		List<OrderAddress> list = listByCd(cmd);
		if(list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findCountByCd(ListOrderAddressByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		return getCount(criteria);
	}

	private void addCondition(Criteria criteria, ListOrderAddressByCdCmd cmd) {
		if(cmd.getAddressNo() != null) {
			criteria.add(Restrictions.eq("addressNo", cmd.getAddressNo()));
		}
		if(cmd.getOrderNo() != null) {
			criteria.add(Restrictions.eq("orderNo", cmd.getOrderNo()));
		}
		if(StringUtils.isNotBlank(cmd.getUserName())) {
			criteria.add(Restrictions.eq("userName", cmd.getUserName()));
		}
		if(StringUtils.isNotBlank(cmd.getUserPhone())) {
			criteria.add(Restrictions.eq("userPhone", cmd.getUserPhone()));
		}
		if(StringUtils.isNotBlank(cmd.getProvinceName())) {
			criteria.add(Restrictions.eq("provinceName", cmd.getProvinceName()));
		}
		if(StringUtils.isNotBlank(cmd.getCityName())) {
			criteria.add(Restrictions.eq("cityName", cmd.getCityName()));
		}
		if(StringUtils.isNotBlank(cmd.getAreaName())) {
			criteria.add(Restrictions.eq("areaName", cmd.getAreaName()));
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
	
	private void pageBy(Criteria criteria, ListOrderAddressByCdCmd cmd) {
		if(cmd.getPageSize() != null) {
			criteria.setMaxResults(cmd.getPageSize());
		}
		if(cmd.getOffset() != null) {
			criteria.setFirstResult(cmd.getOffset());
		}
	}
}
