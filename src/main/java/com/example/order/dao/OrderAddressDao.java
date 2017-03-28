package com.example.order.dao;

import java.util.List;

import com.example.base.dao.HibernateDao;
import com.example.order.cmd.ListOrderAddressByCdCmd;
import com.example.order.po.OrderAddress;

public interface OrderAddressDao extends HibernateDao<OrderAddress> {
	
	List<OrderAddress> listByCd(ListOrderAddressByCdCmd cmd);
	OrderAddress findByCd(ListOrderAddressByCdCmd cmd);
	Long findCountByCd(ListOrderAddressByCdCmd cmd);

}
