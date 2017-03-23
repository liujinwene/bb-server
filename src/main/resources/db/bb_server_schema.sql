DROP TABLE IF EXISTS `bb_order`;
CREATE TABLE `bb_order` (
	`order_no` BIGINT(20) NOT NULL,
	`status` TINYINT(4) NOT NULL,
	`quantity` INTEGER(10) NOT NULL,
	`total_amount` DECIMAL(10,2) NOT NULL,
	`pay_type` TINYINT(40) DEFAULT NULL COMMENT '1-deliveryCash',
	`description` VARCHAR(1024) DEFAULT NULL,
	`create_time` BIGINT(20) NOT NULL,
	`update_time` BIGINT(20) DEFAULT NULL,
	`delete_flag` TINYINT(4) NOT NULL COMMENT '0-NO,1-YES',
	`delete_time` BIGINT(20) DEFAULT NULL,	
	PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `bb_order_item`;
CREATE TABLE `bb_order_item` (
	`order_item_no` BIGINT(20) NOT NULL,
	`order_no` BIGINT(20) NOT NULL,
	`product_no` BIGINT(20) NOT NULL,
	`product_style_no` BIGINT(20) NOT NULL,
	`product_name` VARCHAR(128) DEFAULT NULL,
	`product_style_name` VARCHAR(128) DEFAULT NULL,
	`price` DECIMAL(10,2) NOT NULL,
	`quantity` INTEGER(10) NOT NULL,
	`total_amount` DECIMAL(10,2) NOT NULL,
	`create_time` BIGINT(20) NOT NULL,
	`update_time` BIGINT(20) DEFAULT NULL,
	`delete_flag` TINYINT(4) NOT NULL COMMENT '0-NO,1-YES',
	`delete_time` BIGINT(20) DEFAULT NULL,
	PRIMARY KEY (`order_item_no`),
	KEY `i_order_no` (`order_no`),
	KEY `i_product_no` (`product_no`),
	KEY `i_product_style_no` (`product_style_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `bb_order_address`;
CREATE TABLE `bb_order_address` (
	`address_no` BIGINT(20) NOT NULL,
	`order_no` BIGINT(20) NOT NULL,
	`user_name` VARCHAR(32) DEFAULT NULL,
	`user_phone` VARCHAR(32) DEFAULT NULL,
	`province_name` VARCHAR(32) NOT NULL,
	`city_name` VARCHAR(32) NOT NULL,
	`area_name` VARCHAR(32) NOT NULL,
	`address` VARCHAR(512) NOT NULL,
	`create_time` BIGINT(20) NOT NULL,
	`update_time` BIGINT(20) DEFAULT NULL,
	`delete_flag` TINYINT(4) NOT NULL COMMENT '0-NO,1-YES',
	`delete_time` BIGINT(20) DEFAULT NULL,
	PRIMARY KEY (`address_no`),
	KEY `i_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `bb_product`;
CREATE TABLE `bb_product` (
	`product_no` BIGINT(20) NOT NULL,
	`product_name` VARCHAR(128) DEFAULT NULL,
	`price` DECIMAL(10,2) NOT NULL,
	`create_time` BIGINT(20) NOT NULL,
	`update_time` BIGINT(20) DEFAULT NULL,
	`delete_flag` TINYINT(4) NOT NULL COMMENT '0-NO,1-YES',
	`delete_time` BIGINT(20) DEFAULT NULL,
	PRIMARY KEY (`product_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `bb_product_style`;
CREATE TABLE `bb_product_style` (
	`product_style_no` BIGINT(20) NOT NULL,
	`product_style_name` VARCHAR(128) DEFAULT NULL,
	`create_time` BIGINT(20) NOT NULL,
	`update_time` BIGINT(20) DEFAULT NULL,
	`delete_flag` TINYINT(4) NOT NULL COMMENT '0-NO,1-YES',
	`delete_time` BIGINT(20) DEFAULT NULL,
	PRIMARY KEY (`product_style_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;