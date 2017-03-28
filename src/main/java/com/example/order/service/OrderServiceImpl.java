package com.example.order.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.base.DeleteFlag;
import com.example.base.NumberNoType;
import com.example.base.RestRunningException;
import com.example.base.utils.BigDecimalUtil;
import com.example.base.utils.GenerateNoUtil;
import com.example.base.utils.PageUtil;
import com.example.order.cmd.CreateOrderAddressCmd;
import com.example.order.cmd.CreateOrderCmd;
import com.example.order.cmd.CreateOrderItemCmd;
import com.example.order.cmd.ListOrderCmd;
import com.example.order.constant.OrderStatus;
import com.example.order.constant.PayType;
import com.example.order.dao.OrderAddressDao;
import com.example.order.dao.OrderDao;
import com.example.order.dao.OrderItemDao;
import com.example.order.dto.OrderDetailDTO;
import com.example.order.po.Order;
import com.example.order.po.OrderAddress;
import com.example.order.po.OrderItem;
import com.example.product.cmd.ListProductByCdCmd;
import com.example.product.cmd.ListProductStyleByCdCmd;
import com.example.product.dto.ProductDTO;
import com.example.product.dto.ProductStyleDTO;
import com.example.product.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private OrderAddressDao orderAddressDao;
	@Autowired
	private ProductService productService;


	@Override
	public void createOrder(CreateOrderCmd cmd) {
		long t1 = System.currentTimeMillis();
		checkCreateOrderCmd(cmd);
		long t2 = System.currentTimeMillis();
		Order order = generateOrder(cmd);
		long t3 = System.currentTimeMillis();
		List<OrderItem> orderItems = generateOrderItems(cmd.getOrderItems(), order);
		long t4 = System.currentTimeMillis();
		OrderAddress orderAddress = generateOrderAddress(cmd.getOrderAddress(), order);
		long t5 = System.currentTimeMillis();
		setOrderOtherParameter(order, orderItems);
		long t6 = System.currentTimeMillis();

		orderDao.create(order);
		long t7 = System.currentTimeMillis();
		if(orderAddress != null) {
			orderAddressDao.create(orderAddress);
		}
		long t8 = System.currentTimeMillis();
		if(orderItems != null && !orderItems.isEmpty()) {
			for(OrderItem orderItem : orderItems) {
				orderItemDao.create(orderItem);
			}
		}
		long t9 = System.currentTimeMillis();
		System.out.println("createOrder-elapse."
				+ "t2=" + (t2-t1)
				+ ",t3=" + (t3-t2)
				+ ",t4=" + (t4-t3)
				+ ",t5=" + (t5-t4)
				+ ",t6=" + (t6-t5)
				+ ",t7=" + (t7-t6)
				+ ",t8=" + (t8-t7)
				+ ",t9=" + (t9-t8)
				);
	}
	
	@Override
	@Cacheable(value = "Order-ListOrder", key="{#cmd.pageSize, #cmd.pageNo}")
	public List<OrderDetailDTO> listOrder(ListOrderCmd  cmd) {
		cmd.setPageNo(PageUtil.getPageNoInDefault(cmd.getPageNo()));
		cmd.setPageSize(PageUtil.getPageSizeInDefault(cmd.getPageSize()));
		cmd.setOffset(PageUtil.getStartPageOffset(cmd.getPageSize(), cmd.getPageNo()));
		return orderDao.listOrder(cmd);
	}
	
	private void setOrderOtherParameter(Order order, List<OrderItem> orderItems) {
		Integer totalQuantity = 0;
		BigDecimal totalAmount = BigDecimal.ZERO;
		if(orderItems != null && !orderItems.isEmpty()) {
			for(OrderItem orderItem : orderItems) {
				totalQuantity += orderItem.getQuantity();
				totalAmount = totalAmount.add(orderItem.getTotalAmount());
			}
		}
		order.setQuantity(totalQuantity);
		order.setTotalAmount(totalAmount);
	}

	

	private OrderAddress generateOrderAddress(CreateOrderAddressCmd cmd, Order order) {
		OrderAddress orderAddress = new OrderAddress();
		orderAddress.setAddress(cmd.getAddress());
		orderAddress.setAddressNo(GenerateNoUtil.getNumberNo(NumberNoType.ORDER_ADDRESS));
		orderAddress.setAreaName(cmd.getAreaName());
		orderAddress.setCityName(cmd.getCityName());
		orderAddress.setCreateTime(System.currentTimeMillis());
		orderAddress.setDeleteFlag(DeleteFlag.NO.getCode());
		orderAddress.setOrderNo(order.getOrderNo());
		orderAddress.setProvinceName(cmd.getProvinceName());
		orderAddress.setUserName(cmd.getUserName());
		orderAddress.setUserPhone(cmd.getUserPhone());
		return orderAddress;
	}

	private List<OrderItem> generateOrderItems(List<CreateOrderItemCmd> cmd, Order order) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		//only use first item
		cmd = cmd.subList(0, 1);
		for(CreateOrderItemCmd itemCmd : cmd) {
			orderItems.add(genereateOrderItem(itemCmd, order));
		}

		return orderItems;
	}

	private OrderItem genereateOrderItem(CreateOrderItemCmd cmd, Order order) {
		long t1 = System.currentTimeMillis();
		ProductDTO product =  productCanFound(cmd.getProductNo());
		long t2 = System.currentTimeMillis();
		ProductStyleDTO productStyle =  productStyleCanFound(cmd.getProductStyleNo());
		long t3 = System.currentTimeMillis();
		
		OrderItem orderItem = new OrderItem();
		orderItem.setCreateTime(System.currentTimeMillis());
		orderItem.setDeleteFlag(DeleteFlag.NO.getCode());
		orderItem.setOrderItemNo(GenerateNoUtil.getNumberNo(NumberNoType.ORDER_ITEM));
		orderItem.setOrderNo(order.getOrderNo());
		orderItem.setPrice(product.getPrice());
		orderItem.setProductName(product.getProductName());
		orderItem.setProductNo(product.getProductNo());
		orderItem.setProductStyleName(productStyle.getProductStyleName());
		orderItem.setProductStyleNo(productStyle.getProductStyleNo());
		orderItem.setQuantity(cmd.getQuantity());
		orderItem.setTotalAmount(getTotalAmount(product.getPrice(), cmd.getQuantity()));
		long t4 = System.currentTimeMillis();
		
		System.out.println("genereateOrderItem-elapse."
				+ "t2=" + (t2-t1)
				+ ",t3=" + (t3-t2)
				+ ",t4=" + (t4-t3)
				);
		return orderItem;
	}

	private BigDecimal getTotalAmount(BigDecimal price, Integer quantity) {
		BigDecimal dQuantity = new BigDecimal(quantity);
		return BigDecimalUtil.roundDown(price.multiply(dQuantity));
	}

	private ProductDTO productCanFound(Long productNo) {
		ListProductByCdCmd productCmd = new ListProductByCdCmd();
		productCmd.setProductNo(productNo);
		productCmd.setDeleteFlag(DeleteFlag.NO.getCode());
		ProductDTO product = productService.findProductByCd(productCmd);
		if(product == null) {
			LOGGER.error("product not found.productNo=" + productNo);
			throw RestRunningException.error("商品不存在");
		}
		return product;
	}

	private ProductStyleDTO productStyleCanFound(Long productStyleNo) {
		ListProductStyleByCdCmd productStyleCmd = new ListProductStyleByCdCmd();
		productStyleCmd.setProductStyleNo(productStyleNo);
		productStyleCmd.setDeleteFlag(DeleteFlag.NO.getCode());
		ProductStyleDTO productStyle = productService.findProductStyleByCd(productStyleCmd);
		if(productStyle == null) {
			LOGGER.error("productStyle not found.productStyleNo=" + productStyleNo);
			throw RestRunningException.error("款式不存在");
		}
		return productStyle;
	}

	private Order generateOrder(CreateOrderCmd cmd) {
		Order order = new Order();
		order.setCreateTime(System.currentTimeMillis());
		order.setDeleteFlag(DeleteFlag.NO.getCode());
		order.setDescription(cmd.getDescription());
		order.setOrderNo(GenerateNoUtil.getNumberNo(NumberNoType.ORDER));
		order.setPayType(cmd.getPayType());
		order.setStatus(OrderStatus.WAIT_DELIVERY.getCode());
		return order;
	}

	private void checkCreateOrderCmd(CreateOrderCmd cmd) {
		payTypeNotBeNull(cmd.getPayType());
		//fill orderItmes
		fillOrderItems(cmd);
		fillOrderAddress(cmd);
		
		orderItemsNotBeEmpty(cmd.getOrderItems());
		orderAddressNotBeEmpty(cmd.getOrderAddress());

		checkOrderItems(cmd.getOrderItems());
		checkOrderAddress(cmd.getOrderAddress());
	}

	private void fillOrderAddress(CreateOrderCmd cmd) {
		CreateOrderAddressCmd orderAddress = new CreateOrderAddressCmd();
		orderAddress.setAddress(cmd.getAddress());
		orderAddress.setAreaName(cmd.getAreaName());
		orderAddress.setCityName(cmd.getCityName());
		orderAddress.setProvinceName(cmd.getProvinceName());
		orderAddress.setUserName(cmd.getUserName());
		orderAddress.setUserPhone(cmd.getUserPhone());
		
		cmd.setOrderAddress(orderAddress);
	}

	private void fillOrderItems(CreateOrderCmd cmd) {
		CreateOrderItemCmd orderItem = new CreateOrderItemCmd();
		orderItem.setProductNo(cmd.getProductNo());
		orderItem.setProductStyleNo(cmd.getProductStyleNo());
		orderItem.setQuantity(cmd.getQuantity());
		
		List<CreateOrderItemCmd> orderItems = new ArrayList<CreateOrderItemCmd>();
		orderItems.add(orderItem);
		cmd.setOrderItems(orderItems);
	}

	private void checkOrderAddress(CreateOrderAddressCmd orderAddress) {
		userNameNotBeEmpty(orderAddress.getUserName());
		userPhoneNotBeEmpty(orderAddress.getUserPhone());
		provinceNameNotBeEmpty(orderAddress.getProvinceName());
		cityNameNotBeEmpty(orderAddress.getCityName());
		areaNameNotBeEmpty(orderAddress.getAreaName());
		addressNotBeEmpty(orderAddress.getAddress());
	}

	private void addressNotBeEmpty(String address) {
		if(StringUtils.isBlank(address)) {
			LOGGER.error("address is null");
			throw RestRunningException.error("详细地址不能为空");
		}
	}

	private void areaNameNotBeEmpty(String areaName) {
		if(StringUtils.isBlank(areaName)) {
			LOGGER.error("areaName is null");
			throw RestRunningException.error("区域不能为空");
		}
	}

	private void cityNameNotBeEmpty(String cityName) {
		if(StringUtils.isBlank(cityName)) {
			LOGGER.error("cityName is null");
			throw RestRunningException.error("城市不能为空");
		}
	}

	private void provinceNameNotBeEmpty(String provinceName) {
		if(StringUtils.isBlank(provinceName)) {
			LOGGER.error("provinceName is null");
			throw RestRunningException.error("省份不能为空");
		}
	}

	private void checkOrderItems(List<CreateOrderItemCmd> orderItems) {
		for(CreateOrderItemCmd orderItem : orderItems) {
			productNoNotBeEmtpy(orderItem.getProductNo());
			productStyleNoNotBeEmtpy(orderItem.getProductStyleNo());
			quantityNotBeNull(orderItem.getQuantity());
		}
	}

	private void quantityNotBeNull(Integer quantity) {
		if(quantity == null|| quantity.intValue() <= 0) {
			LOGGER.error("quantity is null.quantity=" + quantity);
			throw RestRunningException.error("商品数量不能为空");
		}
	}

	private void productStyleNoNotBeEmtpy(Long productStyleNo) {
		if(productStyleNo == null) {
			LOGGER.error("productStyleNo is null");
			throw RestRunningException.error("款式不能为空");
		}
	}

	private void productNoNotBeEmtpy(Long productNo) {
		if(productNo == null) {
			LOGGER.error("productNo is null");
			throw RestRunningException.error("商品编号不能为空");
		}
	}

	private void orderAddressNotBeEmpty(CreateOrderAddressCmd orderAddress) {
		if(orderAddress == null) {
			LOGGER.error("orderAddress is null");
			throw RestRunningException.error("地址信息不能为空");
		}
	}

	private void orderItemsNotBeEmpty(List<CreateOrderItemCmd> orderItems) {
		if(orderItems == null || orderItems.isEmpty()) {
			LOGGER.error("orderItems is null");
			throw RestRunningException.error("订单明细信息不能为空");
		}
	}

	private void payTypeNotBeNull(Byte payType) {
		if(payType == null) {
			LOGGER.error("payType is null");
			throw RestRunningException.error("支付方式不能为空");
		}
		if(PayType.fromCode(payType) != PayType.DELIVERY_CASH) {
			LOGGER.error("payType not be deliveryCash");
			throw RestRunningException.error("支付方式应为货到付款");
		}
	}

	private void userPhoneNotBeEmpty(String userPhone) {
		if(StringUtils.isBlank(userPhone)) {
			LOGGER.error("userPhone is null");
			throw RestRunningException.error("联系电话不能为空");
		}
	}

	private void userNameNotBeEmpty(String userName) {
		if(StringUtils.isBlank(userName)) {
			LOGGER.error("userName is null");
			throw RestRunningException.error("用户名不能为空");
		}

	}

	@Override
	@CacheEvict(value = "Order-ListOrder", key="{#cmd.pageSize, #cmd.pageNo}")
	public void clearListOrder(ListOrderCmd cmd) {
		System.out.println("clearListOrder");
	}
}
