/*
SQLyog Enterprise - MySQL GUI v6.06 Beta 1
Host - 5.5.42-log : Database - edu_test
*********************************************************************
Server version : 5.5.42-log
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `t_edu_canteen` */

DROP TABLE IF EXISTS `t_edu_canteen`;

CREATE TABLE `t_edu_canteen` (
  `id` varchar(36) NOT NULL,
  `school_id` varchar(36) NOT NULL,
  `canteen_name` varchar(30) NOT NULL COMMENT '食堂名称',
  `canteen_contacts` varchar(30) DEFAULT NULL COMMENT '联系人姓名',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '手机',
  `updater` varchar(36) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `creator` varchar(36) NOT NULL,
  `create_time` datetime NOT NULL,
  `stat` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `school_id` (`school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校食堂表';

/*Table structure for table `t_edu_committee` */

DROP TABLE IF EXISTS `t_edu_committee`;

CREATE TABLE `t_edu_committee` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '教委名称',
  `area_code` varchar(20) NOT NULL COMMENT '区域CODE',
  `type` smallint(6) NOT NULL COMMENT '教委类型 1市教委  2 区教委',
  `creator` varchar(36) NOT NULL,
  `create_time` datetime NOT NULL,
  `updater` varchar(36) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教委信息表';

/*Table structure for table `t_edu_information` */

DROP TABLE IF EXISTS `t_edu_information`;

CREATE TABLE `t_edu_information` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `title` varchar(20) NOT NULL COMMENT '标题',
  `pic` varchar(200) DEFAULT NULL COMMENT '缩略图',
  `summary` varchar(200) DEFAULT NULL COMMENT '简介',
  `content` text COMMENT '内容',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '新闻类型 枚举定义(0:通知 1:公告 2:卫生检查 3:健康宣教  )',
  `create_admin_id` varchar(36) NOT NULL COMMENT '创建者id',
  `create_admin_name` varchar(20) NOT NULL COMMENT '创建者姓名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_source_id` varchar(36) NOT NULL COMMENT '创建者sourceId',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(1) NOT NULL DEFAULT '1' COMMENT '数据状态',
  PRIMARY KEY (`id`),
  KEY `create_source_id` (`create_source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教委发布的新闻资讯信息公示公告表';

/*Table structure for table `t_edu_information_list` */

DROP TABLE IF EXISTS `t_edu_information_list`;

CREATE TABLE `t_edu_information_list` (
  `id` varchar(36) NOT NULL,
  `infomation_id` varchar(36) NOT NULL,
  `info_title` varchar(100) NOT NULL COMMENT '标题',
  `source_id` varchar(36) NOT NULL COMMENT '来源Id 教委 或学校',
  `source_name` varchar(100) NOT NULL COMMENT '来源名称',
  `create_id` varchar(36) NOT NULL COMMENT '创建者Id',
  `is_read` int(4) NOT NULL DEFAULT '0' COMMENT '是否读取 1是 0 否',
  `read_time` datetime DEFAULT NULL COMMENT '阅读时间',
  `create_time` datetime NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `infomation_id` (`infomation_id`),
  KEY `source_id` (`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知公告对应的人员或组织信息';

/*Table structure for table `t_edu_parent` */

DROP TABLE IF EXISTS `t_edu_parent`;

CREATE TABLE `t_edu_parent` (
  `id` varchar(36) NOT NULL COMMENT '	',
  `nick_name` varchar(20) NOT NULL COMMENT '微信昵称',
  `thumbnail` varchar(137) DEFAULT NULL COMMENT '头像路径',
  `create_time` datetime NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家长h5账号信息表';

/*Table structure for table `t_edu_parent_pack_comment` */

DROP TABLE IF EXISTS `t_edu_parent_pack_comment`;

CREATE TABLE `t_edu_parent_pack_comment` (
  `id` varchar(36) NOT NULL,
  `parent_id` varchar(36) NOT NULL COMMENT '家长Id',
  `package_id` varchar(36) NOT NULL COMMENT '菜谱Id',
  `flavor` int(1) NOT NULL COMMENT '口味 1 2 3 4 5',
  `health` int(1) NOT NULL COMMENT '卫生 1 2 3 4 5',
  `weights` int(1) NOT NULL COMMENT '份量 1 2 3 4 5',
  `comment` varchar(500) DEFAULT NULL COMMENT '点评内容',
  `supply_date` varchar(20) NOT NULL COMMENT '供餐时间',
  `school_name` varchar(500) NOT NULL COMMENT '学校',
  `school_Id` varchar(36) NOT NULL,
  `dishes` varchar(1000) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `package_id` (`package_id`),
  KEY `school_Id` (`school_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家长针对菜谱的点评';

/*Table structure for table `t_edu_parent_sc_ch` */

DROP TABLE IF EXISTS `t_edu_parent_sc_ch`;

CREATE TABLE `t_edu_parent_sc_ch` (
  `id` varchar(36) NOT NULL,
  `parent_id` varchar(36) NOT NULL COMMENT '家长Id',
  `school_Id` varchar(36) NOT NULL COMMENT '学校Id',
  `school_name` varchar(100) NOT NULL COMMENT '学校名称',
  `school_address` varchar(100) DEFAULT NULL COMMENT '学校地址',
  `child_name` varchar(50) NOT NULL COMMENT '学生名字',
  `child_class` varchar(10) DEFAULT NULL COMMENT '小孩班级',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `child_sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别 0保密 1 男 2 女',
  `relation` int(1) NOT NULL COMMENT '关系 1父亲 2母亲',
  `create_time` datetime NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `school_Id` (`school_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家长关注的学校以及学生信息';

/*Table structure for table `t_edu_school` */

DROP TABLE IF EXISTS `t_edu_school`;

CREATE TABLE `t_edu_school` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `committee_id` varchar(36) NOT NULL COMMENT '所属教委ID',
  `school_name` varchar(50) NOT NULL COMMENT '学校名称',
  `school_thum` varchar(200) DEFAULT NULL COMMENT '学校缩略图',
  `mobile_no` varchar(30) NOT NULL COMMENT '联系电话',
  `contacts` varchar(30) NOT NULL COMMENT '联系人',
  `address` varchar(100) NOT NULL COMMENT '学校地址',
  `longitude` varchar(45) DEFAULT NULL COMMENT '精度',
  `latitude` varchar(45) DEFAULT NULL COMMENT '维度',
  `level` varchar(50) NOT NULL COMMENT '0 幼儿园，1 小学，2 初中，3 高中，4 大学 ',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '学校食堂在供应商表的id',
  `reviewed` tinyint(4) NOT NULL COMMENT '是否审核通过0：未审核，1：审核通过，2：审核不通过',
  `create_time` datetime NOT NULL,
  `updater` varchar(36) DEFAULT NULL COMMENT '更新者',
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) NOT NULL COMMENT '是否失效',
  PRIMARY KEY (`id`),
  KEY `committee_id` (`committee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校信息表';

/*Table structure for table `t_edu_school_supplier` */

DROP TABLE IF EXISTS `t_edu_school_supplier`;

CREATE TABLE `t_edu_school_supplier` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `school_id` varchar(36) NOT NULL COMMENT '学校id',
  `supplier_id` varchar(36) NOT NULL COMMENT '供应商id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(11) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`),
  KEY `school_id` (`school_id`),
  KEY `supplier_id` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校供应商关系表';

/*Table structure for table `t_edu_supplier_review` */

DROP TABLE IF EXISTS `t_edu_supplier_review`;

CREATE TABLE `t_edu_supplier_review` (
  `id` varchar(36) NOT NULL,
  `supplier_id` varchar(36) NOT NULL COMMENT '供应商id',
  `committee_id` varchar(36) NOT NULL COMMENT '审核的区',
  `review_result` smallint(6) NOT NULL COMMENT '0未审核，1未通过，2已通过',
  `create_time` datetime NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `committee_id` (`committee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_task` */

DROP TABLE IF EXISTS `t_edu_task`;

CREATE TABLE `t_edu_task` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `title` varchar(20) NOT NULL COMMENT '标题',
  `pic` varchar(200) DEFAULT NULL COMMENT '缩略图',
  `summary` varchar(200) DEFAULT NULL COMMENT '简介',
  `content` text COMMENT '内容',
  `create_id` varchar(36) NOT NULL COMMENT '创建者id',
  `create_name` varchar(20) NOT NULL COMMENT '创建者姓名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(1) NOT NULL DEFAULT '1' COMMENT '数据状态',
  PRIMARY KEY (`id`),
  KEY `create_id` (`create_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教委发布的任务信息';

/*Table structure for table `t_edu_task_receive` */

DROP TABLE IF EXISTS `t_edu_task_receive`;

CREATE TABLE `t_edu_task_receive` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `task_id` varchar(36) NOT NULL COMMENT '任务Id',
  `task_title` varchar(100) NOT NULL COMMENT '任务通知的标题',
  `read_time` datetime DEFAULT NULL,
  `readstat` int(4) NOT NULL DEFAULT '0' COMMENT '阅读状态(0:未读;1:已读)',
  `receive_id` varchar(36) NOT NULL COMMENT '接收者Id',
  `receive_name` varchar(100) NOT NULL COMMENT '接收者名称 学校或教委',
  `send_name` varchar(100) NOT NULL COMMENT '发送者名称 学校或教委',
  `create_id` varchar(36) NOT NULL COMMENT '创建者Id(登陆的sourceId)',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(1) NOT NULL DEFAULT '1' COMMENT '数据状态',
  PRIMARY KEY (`id`),
  KEY `task_id` (`task_id`),
  KEY `receive_id` (`receive_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教委发布的任务信息对应的接收组织';

/*Table structure for table `t_edu_users` */

DROP TABLE IF EXISTS `t_edu_users`;

CREATE TABLE `t_edu_users` (
  `id` varchar(36) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `source_id` varchar(36) NOT NULL COMMENT '教委或学校id',
  `source_type` tinyint(4) NOT NULL COMMENT '0市教委，1学校, 2区教委',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` int(11) DEFAULT NULL,
  `isAdmin` int(11) NOT NULL COMMENT '0是true 1是false',
  `last_update_time` datetime DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `post_no` varchar(36) DEFAULT NULL,
  `password` varchar(36) NOT NULL,
  `qjy_account` varchar(36) DEFAULT NULL COMMENT '聊天账户名',
  `user_account` varchar(36) NOT NULL COMMENT '登录账户名',
  `user_image` varchar(36) DEFAULT NULL,
  `user_no` varchar(36) DEFAULT NULL COMMENT '用户电话',
  `stat` int(11) NOT NULL DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  PRIMARY KEY (`id`),
  KEY `source_id` (`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_pro_dishes` */

DROP TABLE IF EXISTS `t_pro_dishes`;

CREATE TABLE `t_pro_dishes` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `package_id` varchar(36) NOT NULL COMMENT '套餐id',
  `name` varchar(36) NOT NULL COMMENT '菜肴名称',
  `creator` varchar(36) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL,
  `updater` varchar(36) DEFAULT NULL COMMENT '更新者',
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `package_id` (`package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜品套餐子表';

/*Table structure for table `t_pro_employee` */

DROP TABLE IF EXISTS `t_pro_employee`;

CREATE TABLE `t_pro_employee` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商id',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `id_type` smallint(6) DEFAULT NULL COMMENT '身份证类型',
  `id_code` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `position` smallint(6) DEFAULT NULL COMMENT '岗位',
  `work_num` varchar(30) DEFAULT NULL COMMENT '工号',
  `health_code` varchar(50) DEFAULT NULL COMMENT '健康证号码',
  `health_code_date` date DEFAULT NULL COMMENT '健康证号码失效期',
  `train_code` varchar(50) DEFAULT NULL COMMENT '培训证号码',
  `train__level` smallint(6) DEFAULT NULL COMMENT '培训证登记',
  `train_code_date` date DEFAULT NULL COMMENT '培训证号码失效期',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` smallint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_pro_ledger` */

DROP TABLE IF EXISTS `t_pro_ledger`;

CREATE TABLE `t_pro_ledger` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `master_id` varchar(36) NOT NULL COMMENT '主表ID',
  `wares_id` varchar(40) NOT NULL COMMENT '商品ID',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `spce` varchar(20) NOT NULL COMMENT '规格',
  `supplier_id` varchar(40) DEFAULT NULL COMMENT '供应商企业',
  `supplier_code` varchar(36) DEFAULT NULL COMMENT '供应商编码',
  `supplier_name` varchar(36) DEFAULT NULL COMMENT '供应商名称',
  `quantity` decimal(20,2) NOT NULL COMMENT '数量',
  `production_date` date DEFAULT NULL COMMENT '生产日期',
  `production_name` varchar(255) DEFAULT NULL COMMENT '生产单位',
  `batch_no` varchar(36) DEFAULT NULL COMMENT '生产批号',
  `trace_code` varchar(40) DEFAULT NULL COMMENT '追溯码',
  `creator` varchar(36) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updater` varchar(36) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(11) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`),
  KEY `master_id` (`master_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出入货台账信息';

/*Table structure for table `t_pro_ledger_master` */

DROP TABLE IF EXISTS `t_pro_ledger_master`;

CREATE TABLE `t_pro_ledger_master` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键ID',
  `action_date` date NOT NULL COMMENT '操作日期',
  `receiver_id` varchar(36) NOT NULL COMMENT '收货商Id',
  `receiver_name` varchar(36) NOT NULL COMMENT '收货商名称',
  `driver_name` varchar(20) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL COMMENT '驾驶员ID',
  `source_id` varchar(36) NOT NULL COMMENT '企业ID',
  `ware_batch_no` varchar(36) NOT NULL COMMENT '发货批次',
  `haul_status` int(11) NOT NULL COMMENT '配送状态 0 未配送 1配送中 2 已配送',
  `start_time` datetime DEFAULT NULL COMMENT '配送开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '配送结束时间',
  `creator` varchar(36) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updater` varchar(36) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(11) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`),
  KEY `receiver_id` (`receiver_id`),
  KEY `source_id` (`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出入货台账信息';

/*Table structure for table `t_pro_license` */

DROP TABLE IF EXISTS `t_pro_license`;

CREATE TABLE `t_pro_license` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `lic_name` varchar(60) DEFAULT NULL COMMENT '证书名称',
  `lic_no` varchar(60) DEFAULT NULL COMMENT '证书号码',
  `lic_type` int(2) NOT NULL COMMENT '证书类型 0:餐饮服务证、1:食品经营许可证、2:食品流通证、3:食品生产证、4:工商执照',
  `lic_end_date` date DEFAULT NULL COMMENT '证书有效期截止日',
  `lic_pic` varchar(400) NOT NULL COMMENT '证书图片',
  `creator` varchar(36) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updater` varchar(36) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(1) NOT NULL COMMENT '是否有效',
  `relation_id` varchar(36) NOT NULL COMMENT '关联ID',
  `cer_source` smallint(20) NOT NULL COMMENT '证书来源，0：供应商，1：从业人员，2：商品，3：食堂',
  PRIMARY KEY (`id`),
  KEY `relation_id` (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='认证信息表';

/*Table structure for table `t_pro_nutritional` */

DROP TABLE IF EXISTS `t_pro_nutritional`;

CREATE TABLE `t_pro_nutritional` (
  `id` varchar(36) NOT NULL,
  `package_id` varchar(36) NOT NULL COMMENT '套餐id',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `unit` varchar(50) NOT NULL COMMENT '单位',
  `weight` varchar(50) NOT NULL COMMENT '含量',
  `last_update_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `stat` int(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `package_id` (`package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营养成分表';

/*Table structure for table `t_pro_packages` */

DROP TABLE IF EXISTS `t_pro_packages`;

CREATE TABLE `t_pro_packages` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `package_name` varchar(36) NOT NULL COMMENT '套餐名称',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商ID',
  `type` int(4) NOT NULL COMMENT '类型：0：国内班，  1：国际班，2：教工',
  `customer_type` smallint(6) NOT NULL COMMENT '客户类型 默认0 学校',
  `customer_id` varchar(36) NOT NULL COMMENT '客户ID',
  `grade` smallint(6) DEFAULT NULL COMMENT '年级',
  `supply_date` date NOT NULL COMMENT '供应日期',
  `supply_phase` smallint(6) NOT NULL COMMENT '供应阶段，0：早餐，1：午餐，2：午后甜点，3：晚餐，4：夜宵',
  `creator` varchar(36) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updater` varchar(36) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL COMMENT '最后修改日期',
  `stat` int(4) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜品套餐主表';

/*Table structure for table `t_pro_recycle_oil` */

DROP TABLE IF EXISTS `t_pro_recycle_oil`;

CREATE TABLE `t_pro_recycle_oil` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `recycler_id` varchar(36) DEFAULT NULL COMMENT '回收商id',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商id',
  `recycle_date` date DEFAULT NULL COMMENT '回收日期',
  `type` smallint(6) DEFAULT NULL COMMENT '回收种类',
  `amount` int(11) DEFAULT NULL COMMENT '回收数量',
  `recycler_name` varchar(50) DEFAULT NULL COMMENT '回收人',
  `document_url` varchar(400) DEFAULT NULL COMMENT '单据url',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='废弃油脂回收台账';

/*Table structure for table `t_pro_recycle_waste` */

DROP TABLE IF EXISTS `t_pro_recycle_waste`;

CREATE TABLE `t_pro_recycle_waste` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `recycler_id` varchar(36) DEFAULT NULL COMMENT '回收商id',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商id',
  `recycle_date` date DEFAULT NULL COMMENT '回收日期',
  `amount` int(11) DEFAULT NULL COMMENT '回收数量',
  `recycler_name` varchar(50) DEFAULT NULL COMMENT '回收人',
  `document_url` varchar(400) DEFAULT NULL COMMENT '单据url',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='废弃餐厨回收台账';

/*Table structure for table `t_pro_sample` */

DROP TABLE IF EXISTS `t_pro_sample`;

CREATE TABLE `t_pro_sample` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商id',
  `eat_time` smallint(6) DEFAULT NULL COMMENT '留样餐次',
  `type` smallint(6) DEFAULT NULL COMMENT '留样类型',
  `eat_num` bigint(20) DEFAULT NULL COMMENT '就餐人数',
  `supply_type` varchar(50) DEFAULT NULL COMMENT '供餐方式',
  `description` varchar(100) DEFAULT NULL COMMENT '留样说明',
  `sample_name` varchar(60) DEFAULT NULL COMMENT '样品名称',
  `sample_amount` int(11) DEFAULT NULL COMMENT '样品数量',
  `amount_unit` varchar(20) DEFAULT NULL COMMENT '数量单位',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_pro_school_ware` */

DROP TABLE IF EXISTS `t_pro_school_ware`;

CREATE TABLE `t_pro_school_ware` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `school_id` varchar(36) NOT NULL COMMENT '学校id',
  `source_id` varchar(36) NOT NULL COMMENT '团餐公司id',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供货商id',
  `ware_id` varchar(36) NOT NULL COMMENT '采购品id',
  `create_time` datetime NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `school_id` (`school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_pro_supplier` */

DROP TABLE IF EXISTS `t_pro_supplier`;

CREATE TABLE `t_pro_supplier` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `supplier_name` varchar(60) NOT NULL COMMENT '供应商名称',
  `address` varchar(120) NOT NULL COMMENT '供应商地址',
  `provinces` varchar(36) DEFAULT NULL COMMENT '省',
  `city` varchar(36) DEFAULT NULL COMMENT '市',
  `area` varchar(36) DEFAULT NULL COMMENT '区',
  `supplier_type` int(11) NOT NULL COMMENT '供应商类型 0为不区分，1为成品菜供应商，2为原料供应商',
  `business_license` varchar(20) DEFAULT NULL COMMENT '工商执照号',
  `organization_code` varchar(60) DEFAULT NULL COMMENT '组织机构代码',
  `food_service_code` varchar(50) DEFAULT NULL COMMENT '餐饮服务证号',
  `food_service_code_date` date DEFAULT NULL COMMENT '餐饮服务证号失效日期',
  `food_business_code` varchar(50) DEFAULT NULL COMMENT '食品经营许可证号',
  `food_business_code_date` date DEFAULT NULL COMMENT '食品经营许可证号失效日期',
  `food_circulation_code` varchar(50) DEFAULT NULL COMMENT '食品流通证号',
  `food_circulation_code_date` date DEFAULT NULL COMMENT '食品流通证号失效日期',
  `food_produce_code` varchar(50) DEFAULT NULL COMMENT '食品生产证号',
  `food_produce_code_date` date DEFAULT NULL COMMENT '食品生产证号失效日期',
  `corporation` varchar(20) NOT NULL COMMENT '联系人',
  `id_card` varchar(20) DEFAULT NULL COMMENT '法人代表身份证号码',
  `id_type` varchar(20) DEFAULT NULL COMMENT '证件类型 0身份证、1护照、2港澳通行证、3台胞证',
  `contact_way` varchar(20) NOT NULL COMMENT '联系方式',
  `longitude` varchar(20) DEFAULT NULL COMMENT '精度',
  `latitude` varchar(20) DEFAULT NULL COMMENT '维度',
  `reviewed` tinyint(4) NOT NULL COMMENT '是否通过审核 1 审核通过',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updater` varchar(36) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(11) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商信息表\r\n';

/*Table structure for table `t_pro_supplier_receiver` */

DROP TABLE IF EXISTS `t_pro_supplier_receiver`;

CREATE TABLE `t_pro_supplier_receiver` (
  `id` varchar(36) NOT NULL,
  `supplier_id` varchar(36) NOT NULL COMMENT '供应商主键',
  `receiver_id` varchar(36) NOT NULL COMMENT '收货商主键',
  `supplier_code` varchar(60) DEFAULT NULL COMMENT '供应商编码',
  `receiver_code` varchar(60) DEFAULT NULL COMMENT '收货商编码',
  `create_time` datetime NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `receiver_id` (`receiver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_pro_users` */

DROP TABLE IF EXISTS `t_pro_users`;

CREATE TABLE `t_pro_users` (
  `id` varchar(36) NOT NULL,
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `source_id` varchar(36) NOT NULL COMMENT '供应商id',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `isAdmin` int(11) NOT NULL COMMENT '是否管理员',
  `name` varchar(20) NOT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `post_no` varchar(36) DEFAULT NULL,
  `password` varchar(36) NOT NULL COMMENT '密码',
  `qjy_account` varchar(36) DEFAULT NULL COMMENT '聊天账户名',
  `user_account` varchar(36) NOT NULL COMMENT '用户账号',
  `user_image` varchar(36) DEFAULT NULL COMMENT '账号头像',
  `user_no` varchar(36) DEFAULT NULL COMMENT '用户电话',
  `user_type` varchar(36) DEFAULT NULL COMMENT '角色类型(0管理员 1驾驶员)',
  `creator` varchar(36) NOT NULL,
  `create_time` datetime NOT NULL,
  `updater` varchar(36) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) NOT NULL DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  PRIMARY KEY (`id`),
  KEY `user_account` (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户帐户表';

/*Table structure for table `t_pro_wares` */

DROP TABLE IF EXISTS `t_pro_wares`;

CREATE TABLE `t_pro_wares` (
  `id` varchar(36) NOT NULL COMMENT '商品id',
  `wares_name` varchar(40) NOT NULL COMMENT '名称',
  `spec` varchar(40) NOT NULL COMMENT '规格',
  `shelf_life` int(11) DEFAULT NULL COMMENT '保质期',
  `unit` varchar(10) DEFAULT NULL COMMENT '保质期单位',
  `supplier_id` varchar(36) NOT NULL COMMENT '所属供应商id',
  `way` int(11) NOT NULL COMMENT '商品方向 0采购品1为产出品',
  `wares_type` int(11) NOT NULL COMMENT '商品分类(comon工程中枚举已定义)',
  `custom_code` varchar(40) DEFAULT NULL COMMENT '企业自定义代码',
  `image` varchar(400) DEFAULT NULL COMMENT '商品展示图片',
  `manufacturer` varchar(40) DEFAULT NULL COMMENT '生产企业 纯字符串输入',
  `bar_code` varchar(40) DEFAULT NULL COMMENT '商品条形码',
  `en_name` varchar(40) DEFAULT NULL COMMENT '英文名',
  `place` varchar(40) DEFAULT NULL COMMENT '产地',
  `dishes` tinyint(1) NOT NULL COMMENT '是否是菜肴(false-原料,true-成品)',
  `remark` varchar(400) DEFAULT NULL COMMENT '备注',
  `creator` varchar(36) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updater` varchar(36) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(4) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`),
  KEY `supplier_id` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

/*Table structure for table `t_pro_waste_recycler` */

DROP TABLE IF EXISTS `t_pro_waste_recycler`;

CREATE TABLE `t_pro_waste_recycler` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商id',
  `type` smallint(6) DEFAULT NULL COMMENT '0餐厨垃圾，1废弃油脂',
  `name` varchar(100) DEFAULT NULL COMMENT '回收单位',
  `address` varchar(100) DEFAULT NULL COMMENT '单位地址',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系人',
  `contact_tel` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
