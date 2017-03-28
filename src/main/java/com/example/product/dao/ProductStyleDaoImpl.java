package com.example.product.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.base.dao.HibernateDaoImpl;
import com.example.product.cmd.ListProductByCdCmd;
import com.example.product.cmd.ListProductStyleByCdCmd;
import com.example.product.po.ProductStyle;

@Repository
@SuppressWarnings("unchecked")
public class ProductStyleDaoImpl extends HibernateDaoImpl<ProductStyle> implements ProductStyleDao {
	@Override
	@Transactional(readOnly = true)
	public List<ProductStyle> listByCd(ListProductStyleByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		return criteria.list();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductStyle findByCd(ListProductStyleByCdCmd cmd) {
		List<ProductStyle> list = listByCd(cmd);
		if(list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findCountByCd(ListProductStyleByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		return getCount(criteria);
	}

	private void addCondition(Criteria criteria, ListProductStyleByCdCmd cmd) {
		if(cmd.getProductStyleNo() != null) {
			criteria.add(Restrictions.eq("productStyleNo", cmd.getProductStyleNo()));
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
}
