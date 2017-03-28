package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.base.resp.RestResp;
import com.example.order.cmd.CreateOrderCmd;
import com.example.order.cmd.ListOrderCmd;
import com.example.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/create")
	public Object create(CreateOrderCmd cmd) {
		orderService.createOrder(cmd);
		return new RestResp();
	}
	
	@RequestMapping("/listOrder")
	public Object listOrder(ListOrderCmd cmd) {
		return new RestResp(orderService.listOrder(cmd));
	}
}
