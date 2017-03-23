package com.example.product.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.base.HibernateDaoImpl;
import com.example.product.cmd.ListProductByCdCmd;
import com.example.product.po.Product;

@Repository
@SuppressWarnings("unchecked")
public class ProductDaoImpl extends HibernateDaoImpl<Product>  implements ProductDao {

	@Override
	@Transactional(readOnly = true)
	public List<Product> listByCd(ListProductByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		return criteria.list();
	}

	private void addCondition(Criteria criteria, ListProductByCdCmd cmd) {
		if(cmd.getProductNo() != null) {
			criteria.add(Restrictions.eq("productNo", cmd.getProductNo()));
		}
		if(StringUtils.isNotBlank(cmd.getProductName())) {
			criteria.add(Restrictions.eq("productName", cmd.getProductName()));
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
	public Product findByCd(ListProductByCdCmd cmd) {
		List<Product> list = listByCd(cmd);
		if(list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findCountByCd(ListProductByCdCmd cmd) {
		Criteria criteria = createCriteria();
		addCondition(criteria, cmd);
		return getCount(criteria);
	}

}
