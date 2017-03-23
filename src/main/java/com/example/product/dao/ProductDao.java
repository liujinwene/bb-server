package com.example.product.dao;

import java.util.List;

import com.example.base.HibernateDao;
import com.example.product.cmd.ListProductByCdCmd;
import com.example.product.po.Product;

public interface ProductDao extends HibernateDao<Product> {
	List<Product> listByCd(ListProductByCdCmd cmd);
	Product findByCd(ListProductByCdCmd cmd);
	Long findCountByCd(ListProductByCdCmd cmd);
}
