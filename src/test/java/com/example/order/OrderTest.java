package com.example.order;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.base.core.CoreMain;
import com.example.base.utils.JsonUtil;
import com.example.order.cmd.CreateOrderCmd;
import com.example.order.cmd.ListOrderCmd;
import com.example.order.constant.PayType;
import com.example.order.dto.OrderDetailDTO;
import com.example.order.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CoreMain.class)
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
	public void create() {
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

}
