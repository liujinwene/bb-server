package com.example.order.service;

import java.util.List;

import com.example.order.cmd.CreateOrderCmd;
import com.example.order.cmd.ListOrderCmd;
import com.example.order.dto.OrderDetailDTO;

public interface OrderService {
	void createOrder(CreateOrderCmd cmd);
	List<OrderDetailDTO> listOrder(ListOrderCmd cmd);
	void clearListOrder(ListOrderCmd cmd);
}
