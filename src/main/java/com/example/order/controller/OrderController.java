package com.example.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.base.RestResp;
import com.example.order.cmd.CreateOrderAddressCmd;
import com.example.order.cmd.CreateOrderCmd;
import com.example.order.cmd.CreateOrderItemCmd;
import com.example.order.cmd.ListOrderCmd;
import com.example.order.constant.PayType;
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
	
	@RequestMapping("/testListOrder")
	public Object testListOrder() {
		return new RestResp(orderService.testListOrder("123"));
	}
	
	@RequestMapping("/clearListOrder")
	public Object clearListOrder() {
		orderService.clearListOrder();
		return new RestResp();
	}
	
	@RequestMapping("/testCreate")
	public Object testCreate() {
		CreateOrderCmd cmd = new CreateOrderCmd();
		cmd.setDescription("2天内送达");
		cmd.setOrderAddress(getOrderAddress());
		cmd.setOrderItems(getOrderItems());
		cmd.setPayType(PayType.DELIVERY_CASH.getCode());
		
		long st = System.currentTimeMillis();
		create(cmd);
		long et = System.currentTimeMillis();
		long elapse = et - st;
		System.out.println("testCreate-elapse=" + elapse);
		return new RestResp();
	}

	@RequestMapping("/testCreate2")
	public Object testCreate2() {
		CreateOrderCmd cmd = new CreateOrderCmd();
		cmd.setPayType(PayType.DELIVERY_CASH.getCode());
		cmd.setDescription("2天内送达");
		//orderAddress
		cmd.setAddress("大门坊");
		cmd.setAreaName("福田区");
		cmd.setCityName("深圳市");
		cmd.setProvinceName("广东省");
		cmd.setUserName("刘金文");
		cmd.setUserPhone("13711112222");
		//orderItems
		cmd.setProductNo(1L);
		cmd.setProductStyleNo(1L);
		cmd.setQuantity(1);
		
		long st = System.currentTimeMillis();
		create(cmd);
		long et = System.currentTimeMillis();
		long elapse = et - st;
		System.out.println("testCreate2-elapse=" + elapse);
		return new RestResp();
	}

	private List<CreateOrderItemCmd> getOrderItems() {
		List<CreateOrderItemCmd> list = new ArrayList<CreateOrderItemCmd>();
		list.add(getOrderItem());
		return list;
	}

	private CreateOrderItemCmd getOrderItem() {
		CreateOrderItemCmd cmd = new CreateOrderItemCmd();
		cmd.setProductNo(1L);
		cmd.setProductStyleNo(1L);
		cmd.setQuantity(1);
		return cmd;
	}

	private CreateOrderAddressCmd getOrderAddress() {
		CreateOrderAddressCmd cmd = new CreateOrderAddressCmd();
		cmd.setAddress("大门坊");
		cmd.setAreaName("福田区");
		cmd.setCityName("深圳市");
		cmd.setProvinceName("广东省");
		cmd.setUserName("刘金文");
		cmd.setUserPhone("13711112222");
		return cmd;
	}

}
