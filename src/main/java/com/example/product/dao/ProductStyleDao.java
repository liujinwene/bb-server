package com.example.product.dao;

import java.util.List;

import com.example.base.dao.HibernateDao;
import com.example.product.cmd.ListProductStyleByCdCmd;
import com.example.product.po.ProductStyle;

public interface ProductStyleDao extends HibernateDao<ProductStyle> {
	List<ProductStyle> listByCd(ListProductStyleByCdCmd cmd);
	ProductStyle findByCd(ListProductStyleByCdCmd cmd);
	Long findCountByCd(ListProductStyleByCdCmd cmd);
}
