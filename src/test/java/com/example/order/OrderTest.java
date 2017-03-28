package com.example.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.base.core.CoreServerApp;
import com.example.base.utils.JsonUtil;
import com.example.order.cmd.CreateOrderAddressCmd;
import com.example.order.cmd.CreateOrderCmd;
import com.example.order.cmd.CreateOrderItemCmd;
import com.example.order.cmd.ListOrderCmd;
import com.example.order.constant.PayType;
import com.example.order.dto.OrderDetailDTO;
import com.example.order.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CoreServerApp.class)
@WebAppConfiguration
public class OrderTest {
	
	@Resource
	private OrderService orderService;
	
	@Test
	public void listOrder() {
		ListOrderCmd cmd = new ListOrderCmd();
		List<OrderDetailDTO> orders = orderService.listOrder(cmd);
		System.out.println(JsonUtil.toJsonString(orders));
	}
	
	@Test
	@Ignore
	public void create1() {
		CreateOrderCmd cmd = new CreateOrderCmd();
		cmd.setDescription("2天内送达");
		cmd.setOrderAddress(getOrderAddress());
		cmd.setOrderItems(getOrderItems());
		cmd.setPayType(PayType.DELIVERY_CASH.getCode());
		
		orderService.createOrder(cmd);
		System.out.println("create order success");
	}
	
	@Test
	@Ignore
	public void create2() {
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
		
		orderService.createOrder(cmd);
		System.out.println("create order success");
	}
	
	@Test
	@Ignore
	public void cacheListOrder() {
		ListOrderCmd cmd = new ListOrderCmd();
		cmd.setPageSize(20);
		cmd.setPageNo(1);
		List<OrderDetailDTO> orders = orderService.listOrder(cmd);
		System.out.println(JsonUtil.toJsonString(orders));
	}
	
	@Test
	@Ignore
	public void clearListOrderCache() {
		ListOrderCmd cmd = new ListOrderCmd();
		cmd.setPageSize(20);
		cmd.setPageNo(1);
		orderService.clearListOrder(cmd);
		System.out.println("clearListOrderCache success");
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
