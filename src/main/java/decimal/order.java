//package decimal,
///**
//*以动手实践为荣,以只看不练为耻.
//*以打印日志为荣,以出错不报为耻.
//*以局部变量为荣,以全局变量为耻.
//*以单元测试为荣,以手工测试为耻.
//*以代码重用为荣,以复制粘贴为耻.
//*以多态应用为荣,以分支判断为耻.
//*以定义常量为荣,以魔法数字为耻.
//*以总结思考为荣,以不求甚解为耻.
//*
//* @author LvZheng
//* 创建时间：2018年7月25日 下午4:16:28
//*/
//public class order {	-- 主单
//	ALTER TABLE `order_main` ADD(
//			  `soldto_country` VARCHAR (3) NULL COMMENT '售达方国家',
//			  `shipto_country` VARCHAR (3) NULL COMMENT '送达方国家',
//		      `shipto_town` VARCHAR (40) NULL COMMENT '送达方乡镇  街道5',
//			  `fareseller_code` VARCHAR (10) NULL COMMENT 'FA Reseller（Z6）编号',
//			  `fareseller_name` VARCHAR (40) NULL COMMENT 'FA Reseller名称',
//			  `fareseller_street` VARCHAR (60) NULL COMMENT 'FA Reseller street',
//			  `fareseller_post_code` VARCHAR (10) NULL COMMENT 'FA Reseller post code',
//			  `fareseller_country` VARCHAR (3) NULL COMMENT 'FA Reseller国家',
//			  `fareseller_province` VARCHAR (3) NULL COMMENT 'FA Reseller 省份 ID',
//			  `fareseller_city` VARCHAR (40) NULL COMMENT 'FA Reseller 城市',
//			  `fareseller_district` VARCHAR (40) NULL COMMENT 'FA Reseller 区县',
//			  `fareseller_telephone` VARCHAR (30) NULL COMMENT 'FA Reseller 电话',
//			  `billto_code` VARCHAR (10) NULL COMMENT 'Billto开票方编码',
//			  `billto_name` VARCHAR (40) NULL COMMENT 'Billto名称',
//			  `billto_street` VARCHAR (60) NULL COMMENT 'Billto street',
//			  `billto_post_code` VARCHAR (10) NULL COMMENT 'Billto post code',
//			  `billto_country` VARCHAR (3) NULL COMMENT '国家',
//			  `billto_province` VARCHAR (3) NULL COMMENT 'Billto 省份 ID',
//			  `billto_city` VARCHAR (40) NULL COMMENT 'Billto 城市',
//			  `billto_district` VARCHAR (40) NULL COMMENT 'Billto 区县',
//			  `billto_telephone` VARCHAR (30) NULL COMMENT 'Billto 电话',
//			  `payer_code` VARCHAR (10) NULL COMMENT 'Payer付款方编码',
//			  `payer_name` VARCHAR (40) NULL COMMENT 'Payer名称',
//			  `payer_street` VARCHAR (60) NULL COMMENT 'Payerstreet',
//			  `payer_post_code` VARCHAR (10) NULL COMMENT 'Payerpost code',
//			  `payer_country` VARCHAR (3) NULL COMMENT '国家',
//			  `payer_province` VARCHAR (3) NULL COMMENT 'Payer省份 ID',
//			  `payer_city` VARCHAR (40) NULL COMMENT 'Payer城市',
//			  `payer_district` VARCHAR (40) NULL COMMENT 'Payer区县',
//			  `payer_telephone` VARCHAR (30) NULL COMMENT 'Payer电话',
//			  `doa_original_order` VARCHAR (10) NULL COMMENT 'DOA关联原始订单SO号：主要用于ZRE ZSD RE类，有参照前面ZOR订单号。ZRE，RE需要参照ZOR。 ZSD订单需要参照ZRE',
//			  `deliver_time` VARCHAR (8) NULL COMMENT '发货时间，TMS发货日期',
//			  `sold_area` VARCHAR (5) NULL COMMENT '订单销售地区（大区ID） ：如果有值写入订单，如果为空取客户soldto销售视图的地区',
//			  `transport_type` VARCHAR (6) NULL COMMENT '运输方式',
//			  `multiaddress_flag` VARCHAR (70) NULL COMMENT '"多地址的标识，订单的Z004文本“客户服务方式”  值zx02多地址的标识-语言 中文=1 英文=E"',
//			  `price_group` VARCHAR (2) NULL COMMENT '代理级别(价格组)：如果有值写入订单，如果为空取客户soldto销售视图的代理级别',
//			  `customer_group1` VARCHAR (2) NULL COMMENT '客户条件组1（condition group1） ZO',
//			  `complete_delivery` VARCHAR (1) NULL COMMENT '是否部分交货 （Complete delivery）： 整单交货值为X，部分交货为空',
//			  `product_info_za03` VARCHAR (70) NULL COMMENT '订单文本ZA03中传入机型信息（逻辑参考商机的CTO）');
//			-- 子单
//			ALTER TABLE `order_sub` ADD(
//			  `soldto_country` VARCHAR (3) NULL COMMENT '售达方国家',
//			  `shipto_country` VARCHAR (3) NULL COMMENT '送达方国家',
//		      `shipto_town` VARCHAR (40) NULL COMMENT '送达方乡镇  街道5',
//			  `fareseller_code` VARCHAR (10) NULL COMMENT 'FA Reseller（Z6）编号',
//			  `fareseller_name` VARCHAR (40) NULL COMMENT 'FA Reseller名称',
//			  `fareseller_street` VARCHAR (60) NULL COMMENT 'FA Reseller street',
//			  `fareseller_post_code` VARCHAR (10) NULL COMMENT 'FA Reseller post code',
//			  `fareseller_country` VARCHAR (3) NULL COMMENT 'FA Reseller国家',
//			  `fareseller_province` VARCHAR (3) NULL COMMENT 'FA Reseller 省份 ID',
//			  `fareseller_city` VARCHAR (40) NULL COMMENT 'FA Reseller 城市',
//			  `fareseller_district` VARCHAR (40) NULL COMMENT 'FA Reseller 区县',
//			  `fareseller_telephone` VARCHAR (30) NULL COMMENT 'FA Reseller 电话',
//			  `billto_code` VARCHAR (10) NULL COMMENT 'Billto开票方编码',
//			  `billto_name` VARCHAR (40) NULL COMMENT 'Billto名称',
//			  `billto_street` VARCHAR (60) NULL COMMENT 'Billto street',
//			  `billto_post_code` VARCHAR (10) NULL COMMENT 'Billto post code',
//			  `billto_country` VARCHAR (3) NULL COMMENT '国家',
//			  `billto_province` VARCHAR (3) NULL COMMENT 'Billto 省份 ID',
//			  `billto_city` VARCHAR (40) NULL COMMENT 'Billto 城市',
//			  `billto_district` VARCHAR (40) NULL COMMENT 'Billto 区县',
//			  `billto_telephone` VARCHAR (30) NULL COMMENT 'Billto 电话',
//			  `payer_code` VARCHAR (10) NULL COMMENT 'Payer付款方编码',
//			  `payer_name` VARCHAR (40) NULL COMMENT 'Payer名称',
//			  `payer_street` VARCHAR (60) NULL COMMENT 'Payerstreet',
//			  `payer_post_code` VARCHAR (10) NULL COMMENT 'Payerpost code',
//			  `payer_country` VARCHAR (3) NULL COMMENT '国家',
//			  `payer_province` VARCHAR (3) NULL COMMENT 'Payer省份 ID',
//			  `payer_city` VARCHAR (40) NULL COMMENT 'Payer城市',
//			  `payer_district` VARCHAR (40) NULL COMMENT 'Payer区县',
//			  `payer_telephone` VARCHAR (30) NULL COMMENT 'Payer电话',
//			  `doa_original_order` VARCHAR (10) NULL COMMENT 'DOA关联原始订单SO号：主要用于ZRE ZSD RE类，有参照前面ZOR订单号。ZRE，RE需要参照ZOR。 ZSD订单需要参照ZRE',
//			  `deliver_time` VARCHAR (8) NULL COMMENT '发货时间，TMS发货日期',
//			  `sold_area` VARCHAR (5) NULL COMMENT '订单销售地区（大区ID） ：如果有值写入订单，如果为空取客户soldto销售视图的地区',
//			  `transport_type` VARCHAR (6) NULL COMMENT '运输方式',
//			  `multiaddress_flag` VARCHAR (70) NULL COMMENT '"多地址的标识，订单的Z004文本“客户服务方式”  值zx02多地址的标识-语言 中文=1 英文=E"',
//			  `price_group` VARCHAR (2) NULL COMMENT '代理级别(价格组)：如果有值写入订单，如果为空取客户soldto销售视图的代理级别',
//			  `customer_group1` VARCHAR (2) NULL COMMENT '客户条件组1（condition group1） ZO',
//			  `complete_delivery` VARCHAR (1) NULL COMMENT '是否部分交货 （Complete delivery）： 整单交货值为X，部分交货为空',
//			  `product_info_za03` VARCHAR (70) NULL COMMENT '订单文本ZA03中传入机型信息（逻辑参考商机的CTO）');
//			-- 商品
//			ALTER TABLE `order_item` ADD(
//			  `sku` VARCHAR (18) NULL COMMENT '物料',
//			  `delivery_priority` VARCHAR (2) NULL COMMENT '发货优先',
//			  `complete_delivery_item` VARCHAR (1) NULL COMMENT '是否部分交货，整单值为C，部分交货为空',
//			  `doa_original_order` VARCHAR (1) NULL COMMENT 'DOA ZRE RE 关联原始ZOR 订单号，ZSD参照ZRE订单',
//			  `doa_original_item` VARCHAR (10) NULL COMMENT 'DOA ZRE RE 关联原始ZOR订单的行项目号 ZSD 参照前面ZRE订单项目行项目号',
//			  `cv_itemno` VARCHAR (6) NULL COMMENT 'CV物料：外部项目号，CV物料对应的BP Portal订单行项目， 对于CTO的商品才有值',
//			  `cv_id` VARCHAR (6) NULL COMMENT 'CV物料：外部配置 ID，CV物料的外部配置号：可以从000001排序，比如订单有多个CV物料，第一行是000001，第二行是000002等',
//			  `cv_instance_id` VARCHAR (8) NULL COMMENT 'CV物料：配置中的实例编号，CV物料的外部实例配置号：可以从00000001排序，比如订单有多个CV物料，第一行是00000001，第二行是00000002等');
//}
