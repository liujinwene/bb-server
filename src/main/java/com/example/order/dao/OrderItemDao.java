package com.example.order.dao;

import java.util.List;

import com.example.base.HibernateDao;
import com.example.order.cmd.ListOrderItemByCdCmd;
import com.example.order.po.OrderItem;

public interface OrderItemDao extends HibernateDao<OrderItem> {
	List<OrderItem> listByCd(ListOrderItemByCdCmd cmd);
	OrderItem findByCd(ListOrderItemByCdCmd cmd);
	Long findCountByCd(ListOrderItemByCdCmd cmd);

}
