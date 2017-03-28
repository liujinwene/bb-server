package com.example.order.dao;

import java.util.List;

import com.example.base.dao.HibernateDao;
import com.example.order.cmd.ListOrderByCdCmd;
import com.example.order.cmd.ListOrderCmd;
import com.example.order.dto.OrderDetailDTO;
import com.example.order.po.Order;

public interface OrderDao extends HibernateDao<Order> {
	
	List<Order> listByCd(ListOrderByCdCmd cmd);
	Order findByCd(ListOrderByCdCmd cmd);
	Long findCountByCd(ListOrderByCdCmd cmd);
	List<OrderDetailDTO> listOrder(ListOrderCmd cmd);

}
