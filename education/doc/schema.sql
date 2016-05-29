/*
SQLyog Enterprise - MySQL GUI v6.06 Beta 1
Host - 5.5.42-log : Database - new_edu
*********************************************************************
Server version : 5.5.42-log
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `new_edu`;

USE `new_edu`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `t_admin_menu` */

DROP TABLE IF EXISTS `t_admin_menu`;

CREATE TABLE `t_admin_menu` (
  `id` varchar(36) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `isRight` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `no` int(11) DEFAULT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  `menu_type_id` varchar(36) NOT NULL,
  `stat` int(11) DEFAULT '1',
  `tab_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ntq0jbuskbtg914fyen2i1ylm` (`pid`),
  KEY `FK_4ou4518q77nruu6uoqb047x6i` (`menu_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_admin_menu_type` */

DROP TABLE IF EXISTS `t_admin_menu_type`;

CREATE TABLE `t_admin_menu_type` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_admin_role` */

DROP TABLE IF EXISTS `t_admin_role`;

CREATE TABLE `t_admin_role` (
  `id` varchar(36) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `role_name` varchar(50) NOT NULL,
  `no` int(11) DEFAULT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `post_no` varchar(255) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_os4oowh8je9g6ox2qwhuiurha` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_admin_role_menu` */

DROP TABLE IF EXISTS `t_admin_role_menu`;

CREATE TABLE `t_admin_role_menu` (
  `id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  `menu_id` varchar(36) NOT NULL,
  `stat` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_21ifosjxjf3q4121g525vip7n` (`menu_id`),
  KEY `FK_ov5dry220ymp5iplwcpw3eo38` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_admin_role_project` */

DROP TABLE IF EXISTS `t_admin_role_project`;

CREATE TABLE `t_admin_role_project` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色id',
  `proj_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_admin_tab` */

DROP TABLE IF EXISTS `t_admin_tab`;

CREATE TABLE `t_admin_tab` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `tab_name` varchar(50) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_admin_users` */

DROP TABLE IF EXISTS `t_admin_users`;

CREATE TABLE `t_admin_users` (
  `id` varchar(36) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `createdatetime` datetime DEFAULT NULL,
  `dept_id` varchar(36) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` int(11) DEFAULT NULL,
  `isAdmin` int(11) DEFAULT NULL,
  `modifydatetime` datetime DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `post_no` varchar(36) DEFAULT NULL,
  `password` varchar(36) NOT NULL,
  `qjy_account` varchar(36) DEFAULT NULL,
  `user_account` varchar(36) DEFAULT NULL,
  `user_image` varchar(36) DEFAULT NULL,
  `user_no` varchar(36) DEFAULT NULL,
  `stat` int(11) DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_admin_users_role` */

DROP TABLE IF EXISTS `t_admin_users_role`;

CREATE TABLE `t_admin_users_role` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `user_id` varchar(36) NOT NULL DEFAULT '1',
  `role_id` varchar(36) NOT NULL,
  `stat` int(11) DEFAULT '1' COMMENT '是否有效 1 有效 0失效',
  PRIMARY KEY (`id`),
  KEY `FK_cst9w4q9kmdknxckc42i1iclo` (`role_id`),
  KEY `FK_hln6xj2t05u8g67fl2v1j46o3` (`user_id`),
  CONSTRAINT `t_admin_users_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_admin_role` (`id`),
  CONSTRAINT `t_admin_users_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_admin_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_area` */

DROP TABLE IF EXISTS `t_edu_area`;

CREATE TABLE `t_edu_area` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `address_name` varchar(36) DEFAULT NULL COMMENT '区域名称',
  `address_code` varchar(36) DEFAULT NULL COMMENT '区域代码',
  `parent_id` varchar(36) DEFAULT NULL COMMENT '父级ID',
  `parent_code` varchar(36) DEFAULT NULL COMMENT '父级code',
  `longitude` float DEFAULT NULL COMMENT '精度',
  `latitude` float DEFAULT NULL COMMENT '维度',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `stat` int(11) DEFAULT NULL COMMENT '是否失效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域表';

/*Table structure for table `t_edu_canteen` */

DROP TABLE IF EXISTS `t_edu_canteen`;

CREATE TABLE `t_edu_canteen` (
  `id` varchar(36) NOT NULL,
  `school_id` varchar(36) NOT NULL,
  `canteen_name` varchar(30) DEFAULT NULL COMMENT '食堂名称',
  `canteen_contacts` varchar(30) DEFAULT NULL COMMENT '联系人姓名',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '手机',
  `last_update_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `stat` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校食堂表';

/*Table structure for table `t_edu_committee` */

DROP TABLE IF EXISTS `t_edu_committee`;

CREATE TABLE `t_edu_committee` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '教委名称',
  `area_code` varchar(20) DEFAULT NULL COMMENT '区域CODE',
  `type` smallint(6) DEFAULT NULL COMMENT '教委类型 1市教委  2 区教委',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教委信息表';

/*Table structure for table `t_edu_guardian` */

DROP TABLE IF EXISTS `t_edu_guardian`;

CREATE TABLE `t_edu_guardian` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `guardian_name` varchar(30) DEFAULT NULL COMMENT '监护人名称',
  `identity_card` varchar(30) DEFAULT NULL COMMENT '身份证号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='监护人(家长)表';

/*Table structure for table `t_edu_information` */

DROP TABLE IF EXISTS `t_edu_information`;

CREATE TABLE `t_edu_information` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `pic` varchar(200) DEFAULT NULL COMMENT '缩略图',
  `summary` varchar(200) DEFAULT NULL COMMENT '简介',
  `content` text COMMENT '内容',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '新闻类型 枚举定义(0:通知 1:公告 2:卫生检查 3:健康宣教  )',
  `create_admin_id` varchar(36) DEFAULT NULL COMMENT '创建者id',
  `create_admin_name` varchar(20) DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(1) NOT NULL DEFAULT '1' COMMENT '数据状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教委发布的新闻资讯信息公示公告表';

/*Table structure for table `t_edu_menu` */

DROP TABLE IF EXISTS `t_edu_menu`;

CREATE TABLE `t_edu_menu` (
  `id` varchar(36) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `isRight` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `no` int(11) DEFAULT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  `menu_type_id` varchar(36) NOT NULL,
  `stat` int(11) DEFAULT '1',
  `tab_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_menu_type` */

DROP TABLE IF EXISTS `t_edu_menu_type`;

CREATE TABLE `t_edu_menu_type` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_parent` */

DROP TABLE IF EXISTS `t_edu_parent`;

CREATE TABLE `t_edu_parent` (
  `id` varchar(36) NOT NULL COMMENT '	',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '微信昵称',
  `thumbnail` varchar(137) DEFAULT NULL COMMENT '头像路径',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家长h5账号信息表';

/*Table structure for table `t_edu_parent_pack_comment` */

DROP TABLE IF EXISTS `t_edu_parent_pack_comment`;

CREATE TABLE `t_edu_parent_pack_comment` (
  `id` varchar(36) NOT NULL,
  `parent_id` varchar(36) DEFAULT NULL COMMENT '家长Id',
  `package_id` varchar(36) DEFAULT NULL COMMENT '菜谱Id',
  `flavor` int(1) DEFAULT NULL COMMENT '口味 1 2 3 4 5',
  `health` int(1) DEFAULT NULL COMMENT '卫生 1 2 3 4 5',
  `weights` int(1) DEFAULT NULL COMMENT '份量 1 2 3 4 5',
  `comment` varchar(500) DEFAULT NULL COMMENT '点评内容',
  `supply_date` varchar(20) DEFAULT NULL COMMENT '供餐时间',
  `school_name` varchar(500) DEFAULT NULL COMMENT '学校',
  `school_Id` varchar(36) DEFAULT NULL,
  `dishes` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家长针对菜谱的点评';

/*Table structure for table `t_edu_parent_sc_ch` */

DROP TABLE IF EXISTS `t_edu_parent_sc_ch`;

CREATE TABLE `t_edu_parent_sc_ch` (
  `id` varchar(36) NOT NULL,
  `parent_id` varchar(36) DEFAULT NULL COMMENT '家长Id',
  `school_Id` varchar(36) DEFAULT NULL COMMENT '学校Id',
  `school_name` varchar(100) DEFAULT NULL COMMENT '学校名称',
  `school_address` varchar(100) DEFAULT NULL COMMENT '学校地址',
  `child_name` varchar(50) DEFAULT NULL COMMENT '学生名字',
  `child_class` varchar(10) DEFAULT NULL COMMENT '小孩班级',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `child_sex` int(1) DEFAULT '0' COMMENT '性别 0保密 1 男 2 女',
  `relation` int(1) DEFAULT NULL COMMENT '关系 1父亲 2母亲',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家长关注的学校以及学生信息';

/*Table structure for table `t_edu_role` */

DROP TABLE IF EXISTS `t_edu_role`;

CREATE TABLE `t_edu_role` (
  `id` varchar(36) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `role_name` varchar(50) NOT NULL,
  `no` int(11) DEFAULT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `post_no` varchar(255) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_role_menu` */

DROP TABLE IF EXISTS `t_edu_role_menu`;

CREATE TABLE `t_edu_role_menu` (
  `id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  `menu_id` varchar(36) NOT NULL,
  `stat` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_role_project` */

DROP TABLE IF EXISTS `t_edu_role_project`;

CREATE TABLE `t_edu_role_project` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色id',
  `proj_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_school` */

DROP TABLE IF EXISTS `t_edu_school`;

CREATE TABLE `t_edu_school` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `committee_id` varchar(36) DEFAULT NULL COMMENT '所属教委ID',
  `school_name` varchar(50) DEFAULT NULL COMMENT '学校名称',
  `school_thum` varchar(200) DEFAULT NULL COMMENT '学校缩略图',
  `mobile_no` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `contacts` varchar(30) DEFAULT NULL COMMENT '联系人',
  `address` varchar(100) DEFAULT NULL COMMENT '学校地址',
  `longitude` varchar(45) DEFAULT NULL COMMENT '精度',
  `latitude` varchar(45) DEFAULT NULL COMMENT '维度',
  `level` varchar(50) DEFAULT NULL COMMENT '0 幼儿园，1 小学，2 初中，3 高中，4 大学 ',
  `area` varchar(50) DEFAULT NULL COMMENT '省',
  `city` varchar(50) DEFAULT NULL COMMENT '市',
  `province` varchar(50) DEFAULT NULL COMMENT '区',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '学校食堂在供应商表的id',
  `reviewed` tinyint(4) DEFAULT NULL COMMENT '是否审核通过',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) DEFAULT NULL COMMENT '是否失效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校信息表';

/*Table structure for table `t_edu_school_supplier` */

DROP TABLE IF EXISTS `t_edu_school_supplier`;

CREATE TABLE `t_edu_school_supplier` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `school_id` varchar(36) DEFAULT NULL COMMENT '学校id',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校供应商关系表';

/*Table structure for table `t_edu_student` */

DROP TABLE IF EXISTS `t_edu_student`;

CREATE TABLE `t_edu_student` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `date_of_birth` varchar(30) DEFAULT NULL COMMENT '出生日期',
  `height` int(11) DEFAULT NULL COMMENT '身高',
  `gender` int(11) DEFAULT NULL COMMENT '性别:1男,2女',
  `weight` int(11) DEFAULT NULL COMMENT '体重',
  `student_no` varchar(40) DEFAULT NULL COMMENT '学生号',
  `grade_id` varchar(36) DEFAULT NULL COMMENT '年级',
  `school_id` varchar(36) DEFAULT NULL COMMENT '所属学校id',
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生信息表';

/*Table structure for table `t_edu_student_guardian` */

DROP TABLE IF EXISTS `t_edu_student_guardian`;

CREATE TABLE `t_edu_student_guardian` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `student_id` varchar(36) DEFAULT NULL COMMENT '学生id',
  `guardian_id` varchar(36) DEFAULT NULL COMMENT '监护人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生监护人关系表';

/*Table structure for table `t_edu_supplier_review` */

DROP TABLE IF EXISTS `t_edu_supplier_review`;

CREATE TABLE `t_edu_supplier_review` (
  `id` varchar(36) DEFAULT NULL,
  `supplier_id` varchar(36) NOT NULL COMMENT '供应商id',
  `committee_id` varchar(36) NOT NULL COMMENT '审核的区',
  `review_result` smallint(6) DEFAULT NULL COMMENT '0未审核，1未通过，2已通过',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(4) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`,`committee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_tab` */

DROP TABLE IF EXISTS `t_edu_tab`;

CREATE TABLE `t_edu_tab` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `tab_name` varchar(50) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_task` */

DROP TABLE IF EXISTS `t_edu_task`;

CREATE TABLE `t_edu_task` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `pic` varchar(200) DEFAULT NULL COMMENT '缩略图',
  `summary` varchar(200) DEFAULT NULL COMMENT '简介',
  `content` text COMMENT '内容',
  `create_id` varchar(36) DEFAULT NULL COMMENT '创建者id',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(1) NOT NULL DEFAULT '1' COMMENT '数据状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教委发布的任务信息';

/*Table structure for table `t_edu_task_receive` */

DROP TABLE IF EXISTS `t_edu_task_receive`;

CREATE TABLE `t_edu_task_receive` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `task_id` varchar(36) DEFAULT NULL COMMENT '任务Id',
  `readstat` int(4) DEFAULT '0' COMMENT '阅读状态(0:未读;1:已读)',
  `receive_id` varchar(36) DEFAULT NULL COMMENT '接收者Id',
  `school_id` varchar(36) DEFAULT NULL COMMENT '组织Id(学校Id)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(1) NOT NULL DEFAULT '1' COMMENT '数据状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教委发布的任务信息对应的接收组织';

/*Table structure for table `t_edu_users` */

DROP TABLE IF EXISTS `t_edu_users`;

CREATE TABLE `t_edu_users` (
  `id` varchar(36) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `source_id` varchar(36) DEFAULT NULL COMMENT '教委或学校id',
  `source_type` tinyint(4) DEFAULT NULL COMMENT '0市教委，1学校, 2区教委',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` int(11) DEFAULT NULL,
  `isAdmin` int(11) DEFAULT NULL COMMENT '0是true 1是folse',
  `last_update_time` datetime DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `post_no` varchar(36) DEFAULT NULL,
  `password` varchar(36) NOT NULL,
  `qjy_account` varchar(36) DEFAULT NULL COMMENT '聊天账户名',
  `user_account` varchar(36) DEFAULT NULL,
  `user_image` varchar(36) DEFAULT NULL,
  `user_no` varchar(36) DEFAULT NULL COMMENT '用户电话',
  `stat` int(11) DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_edu_users_role` */

DROP TABLE IF EXISTS `t_edu_users_role`;

CREATE TABLE `t_edu_users_role` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `user_id` varchar(36) NOT NULL DEFAULT '1',
  `role_id` varchar(36) NOT NULL,
  `stat` int(11) DEFAULT '1' COMMENT '是否有效 1 有效 0失效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_pro_addresses` */

DROP TABLE IF EXISTS `t_pro_addresses`;

CREATE TABLE `t_pro_addresses` (
  `id` int(11) NOT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `level` int(11) DEFAULT NULL COMMENT '0:国家 1省份 2市 3 区县',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域信息表 省市县 基础信息';

/*Table structure for table `t_pro_dishes` */

DROP TABLE IF EXISTS `t_pro_dishes`;

CREATE TABLE `t_pro_dishes` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键ID',
  `package_id` varchar(36) DEFAULT NULL COMMENT '套餐id',
  `wares_id` varchar(36) DEFAULT NULL COMMENT '商品ID',
  `wares_name` varchar(36) DEFAULT NULL COMMENT '商品名称',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商Id',
  `supplier_name` varchar(36) DEFAULT NULL COMMENT '供应商名称',
  `create_time` datetime NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(6) NOT NULL,
  PRIMARY KEY (`id`)
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
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键ID',
  `master_id` varchar(36) DEFAULT NULL COMMENT '主表ID',
  `wares_id` varchar(40) DEFAULT NULL COMMENT '商品ID',
  `name` varchar(40) DEFAULT NULL COMMENT '名称',
  `spce` varchar(20) DEFAULT NULL COMMENT '规格',
  `supplier_id` varchar(40) DEFAULT '' COMMENT '供应商企业',
  `supplier_code` varchar(36) DEFAULT NULL COMMENT '供应商编码',
  `supplier_name` varchar(36) DEFAULT NULL COMMENT '供应商名称',
  `quantity` decimal(20,2) DEFAULT NULL COMMENT '数量',
  `production_date` date DEFAULT NULL COMMENT '生产日期',
  `production_name` varchar(255) DEFAULT NULL COMMENT '生产单位',
  `batch_no` varchar(36) DEFAULT NULL COMMENT '生产批号',
  `trace_code` varchar(40) DEFAULT NULL COMMENT '追溯码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出入货台账信息';

/*Table structure for table `t_pro_ledger_master` */

DROP TABLE IF EXISTS `t_pro_ledger_master`;

CREATE TABLE `t_pro_ledger_master` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键ID',
  `action_date` date DEFAULT NULL COMMENT '操作日期',
  `receiver_id` varchar(36) DEFAULT NULL COMMENT '收货商Id',
  `receiver_name` varchar(36) DEFAULT NULL COMMENT '收货商名称',
  `driver_name` varchar(20) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL COMMENT '驾驶员ID',
  `source_id` varchar(36) DEFAULT NULL COMMENT '企业ID',
  `ware_batch_no` varchar(36) DEFAULT NULL COMMENT '发货批次',
  `haul_status` int(11) DEFAULT NULL COMMENT '配送状态 0 未配送 1配送中 2 已配送',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出入货台账信息';

/*Table structure for table `t_pro_license` */

DROP TABLE IF EXISTS `t_pro_license`;

CREATE TABLE `t_pro_license` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `lic_name` varchar(60) DEFAULT NULL COMMENT '证书名称',
  `lic_no` varchar(60) DEFAULT NULL COMMENT '证书号码',
  `lic_type` int(2) DEFAULT NULL COMMENT '证书类型 类型数据待定',
  `lic_end_date` date DEFAULT NULL COMMENT '证书有效期截止日',
  `lic_pic` varchar(400) DEFAULT NULL COMMENT '证书图片',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(1) DEFAULT NULL COMMENT '是否有效',
  `relation_id` varchar(36) DEFAULT NULL COMMENT '关联ID',
  `cer_source` smallint(20) DEFAULT NULL COMMENT '证书来源，0：供应商，1：从业人员，2：商品，3：食堂',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='认证信息表';

/*Table structure for table `t_pro_menu` */

DROP TABLE IF EXISTS `t_pro_menu`;

CREATE TABLE `t_pro_menu` (
  `id` varchar(36) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `isRight` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `no` int(11) DEFAULT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  `menu_type_id` varchar(36) NOT NULL,
  `stat` int(11) DEFAULT '1',
  `tab_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ntq0jbuskbtg914fyen2i1ylm` (`pid`),
  KEY `FK_4ou4518q77nruu6uoqb047x6i` (`menu_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Table structure for table `t_pro_menu_type` */

DROP TABLE IF EXISTS `t_pro_menu_type`;

CREATE TABLE `t_pro_menu_type` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单类别';

/*Table structure for table `t_pro_nutritional` */

DROP TABLE IF EXISTS `t_pro_nutritional`;

CREATE TABLE `t_pro_nutritional` (
  `id` varchar(36) NOT NULL,
  `package_id` varchar(36) DEFAULT NULL COMMENT '套餐id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `unit` varchar(50) DEFAULT NULL COMMENT '单位',
  `weight` varchar(50) DEFAULT NULL COMMENT '含量',
  `last_update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `stat` int(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营养成分表';

/*Table structure for table `t_pro_packages` */

DROP TABLE IF EXISTS `t_pro_packages`;

CREATE TABLE `t_pro_packages` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键ID',
  `package_name` varchar(36) DEFAULT NULL COMMENT '套餐名称',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商ID',
  `type` int(4) DEFAULT NULL COMMENT '类型：0：国内班，  1：国际班，2：教工',
  `customer_type` smallint(6) DEFAULT NULL COMMENT '客户类型 默认0 学校',
  `customer_id` varchar(36) DEFAULT NULL COMMENT '客户ID',
  `grade` smallint(6) DEFAULT NULL COMMENT '年级',
  `supply_date` date DEFAULT NULL COMMENT '供应日期',
  `supply_phase` smallint(6) DEFAULT NULL COMMENT '供应阶段，0：早餐，1：午餐，2：午后甜点，3：晚餐，4：夜宵',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后修改日期',
  `stat` int(4) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜品套餐主表';

/*Table structure for table `t_pro_practitioners` */

DROP TABLE IF EXISTS `t_pro_practitioners`;

CREATE TABLE `t_pro_practitioners` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` int(1) DEFAULT NULL COMMENT '性别 0为男 1为女',
  `card_type` int(1) DEFAULT NULL COMMENT '身份证类型 待确定',
  `card_no` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `position` varchar(20) DEFAULT NULL COMMENT '岗位',
  `job_no` varchar(20) DEFAULT NULL COMMENT '工号',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(1) DEFAULT '0' COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商从业人员表';

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

/*Table structure for table `t_pro_role` */

DROP TABLE IF EXISTS `t_pro_role`;

CREATE TABLE `t_pro_role` (
  `id` varchar(36) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `role_name` varchar(50) NOT NULL,
  `no` int(11) DEFAULT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `post_no` varchar(255) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_os4oowh8je9g6ox2qwhuiurha` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

/*Table structure for table `t_pro_role_menu` */

DROP TABLE IF EXISTS `t_pro_role_menu`;

CREATE TABLE `t_pro_role_menu` (
  `id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  `menu_id` varchar(36) NOT NULL,
  `stat` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_21ifosjxjf3q4121g525vip7n` (`menu_id`),
  KEY `FK_ov5dry220ymp5iplwcpw3eo38` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单';

/*Table structure for table `t_pro_role_project` */

DROP TABLE IF EXISTS `t_pro_role_project`;

CREATE TABLE `t_pro_role_project` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色id',
  `proj_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色项目表';

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
  `school_id` varchar(36) DEFAULT NULL COMMENT '学校id',
  `source_id` varchar(36) DEFAULT NULL COMMENT '团餐公司id',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供货商id',
  `ware_id` varchar(36) DEFAULT NULL COMMENT '采购品id',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_pro_supplier` */

DROP TABLE IF EXISTS `t_pro_supplier`;

CREATE TABLE `t_pro_supplier` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `supplier_name` varchar(60) DEFAULT NULL COMMENT '供应商名称',
  `address` varchar(120) DEFAULT NULL COMMENT '供应商地址',
  `provinces` varchar(36) DEFAULT NULL COMMENT '省',
  `city` varchar(36) DEFAULT NULL COMMENT '市',
  `area` varchar(36) DEFAULT NULL COMMENT '区',
  `supplier_type` int(11) DEFAULT NULL COMMENT '供应商类型 0为不区分，1为成品菜供应商，2为原料供应商',
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
  `corporation` varchar(20) DEFAULT NULL COMMENT '法人代表',
  `id_card` varchar(20) DEFAULT NULL COMMENT '法人代表身份证号码',
  `id_type` varchar(20) DEFAULT NULL COMMENT '证件类型 0身份证、1护照、2港澳通行证、3台胞证',
  `contact_way` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `longitude` varchar(20) DEFAULT NULL COMMENT '精度',
  `latitude` varchar(20) DEFAULT NULL COMMENT '维度',
  `reviewed` tinyint(4) DEFAULT NULL COMMENT '是否通过审核 1 审核通过',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商信息表\r\n';

/*Table structure for table `t_pro_supplier_receiver` */

DROP TABLE IF EXISTS `t_pro_supplier_receiver`;

CREATE TABLE `t_pro_supplier_receiver` (
  `supplier_id` varchar(36) NOT NULL COMMENT '供应商主键',
  `receiver_id` varchar(36) NOT NULL COMMENT '收货商主键',
  `supplier_code` varchar(60) DEFAULT NULL COMMENT '供应商编码',
  `receiver_code` varchar(60) DEFAULT NULL COMMENT '收货商编码',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(4) NOT NULL,
  PRIMARY KEY (`supplier_id`,`receiver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_pro_tab` */

DROP TABLE IF EXISTS `t_pro_tab`;

CREATE TABLE `t_pro_tab` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `tab_name` varchar(50) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统模块表';

/*Table structure for table `t_pro_users` */

DROP TABLE IF EXISTS `t_pro_users`;

CREATE TABLE `t_pro_users` (
  `id` varchar(36) NOT NULL,
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `source_id` varchar(36) DEFAULT NULL COMMENT '供应商id',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `isAdmin` int(11) DEFAULT NULL COMMENT '是否管理员',
  `name` varchar(20) NOT NULL,
  `pj_no` varchar(36) DEFAULT NULL,
  `post_no` varchar(36) DEFAULT NULL,
  `password` varchar(36) NOT NULL COMMENT '密码',
  `qjy_account` varchar(36) DEFAULT NULL COMMENT '聊天账户名',
  `user_account` varchar(36) DEFAULT NULL COMMENT '用户账号',
  `user_image` varchar(36) DEFAULT NULL COMMENT '账号头像',
  `user_no` varchar(36) DEFAULT NULL COMMENT '用户电话',
  `user_type` varchar(36) DEFAULT NULL COMMENT '角色类型(0管理员 1驾驶员)',
  `isDelete` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `stat` int(11) DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户帐户表';

/*Table structure for table `t_pro_users_role` */

DROP TABLE IF EXISTS `t_pro_users_role`;

CREATE TABLE `t_pro_users_role` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `user_id` varchar(36) NOT NULL DEFAULT '1',
  `role_id` varchar(36) NOT NULL,
  `stat` int(11) DEFAULT '1' COMMENT '是否有效 1 有效 0失效',
  PRIMARY KEY (`id`),
  KEY `FK_cst9w4q9kmdknxckc42i1iclo` (`role_id`),
  KEY `FK_hln6xj2t05u8g67fl2v1j46o3` (`user_id`),
  CONSTRAINT `t_pro_users_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_pro_role` (`id`),
  CONSTRAINT `t_pro_users_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_pro_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';

/*Table structure for table `t_pro_wares` */

DROP TABLE IF EXISTS `t_pro_wares`;

CREATE TABLE `t_pro_wares` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '商品id',
  `wares_name` varchar(40) DEFAULT NULL COMMENT '名称',
  `spec` varchar(40) DEFAULT NULL COMMENT '规格',
  `shelf_life` int(11) DEFAULT NULL COMMENT '保质期',
  `unit` varchar(10) DEFAULT NULL COMMENT '保质期单位',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '所属供应商id',
  `way` int(11) DEFAULT NULL COMMENT '商品方向 0采购品1为产出品',
  `wares_type` int(11) DEFAULT NULL COMMENT '商品分类(comon工程中枚举已定义)',
  `custom_code` varchar(40) DEFAULT NULL COMMENT '企业自定义代码',
  `image` varchar(400) DEFAULT NULL COMMENT '商品展示图片',
  `manufacturer` varchar(40) DEFAULT NULL COMMENT '生产企业 纯字符串输入',
  `bar_code` varchar(40) DEFAULT NULL COMMENT '商品条形码',
  `en_name` varchar(40) DEFAULT NULL COMMENT '英文名',
  `place` varchar(40) DEFAULT NULL COMMENT '产地',
  `dishes` tinyint(1) DEFAULT NULL COMMENT '是否是菜肴(false-原料,true-成品)',
  `remark` varchar(400) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `stat` int(4) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
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

/*Table structure for table `v_sup_sch_area` */

DROP TABLE IF EXISTS `v_sup_sch_area`;

/*!50001 DROP VIEW IF EXISTS `v_sup_sch_area` */;
/*!50001 DROP TABLE IF EXISTS `v_sup_sch_area` */;

/*!50001 CREATE TABLE `v_sup_sch_area` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `supplier_name` varchar(60) DEFAULT NULL COMMENT '供应商名称',
  `address` varchar(120) DEFAULT NULL COMMENT '供应商地址',
  `provinces` varchar(36) DEFAULT NULL COMMENT '省',
  `city` varchar(36) DEFAULT NULL COMMENT '市',
  `area` varchar(36) DEFAULT NULL COMMENT '区',
  `supplier_type` int(11) DEFAULT NULL COMMENT '供应商类型 0为不区分，1为成品菜供应商，2为原料供应商',
  `business_license` varchar(20) DEFAULT NULL COMMENT '工商执照号',
  `organization_code` varchar(60) DEFAULT NULL COMMENT '组织机构代码',
  `corporation` varchar(20) DEFAULT NULL COMMENT '法人代表',
  `contact_way` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `longitude` varchar(20) DEFAULT NULL COMMENT '精度',
  `latitude` varchar(20) DEFAULT NULL COMMENT '维度',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `stat` int(11) DEFAULT NULL COMMENT '是否有效',
  `school_id` varchar(36) COMMENT '主键ID',
  `school_name` varchar(50) DEFAULT NULL COMMENT '学校名称',
  `area_name` varchar(36) DEFAULT NULL COMMENT '区域名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 */;

/*Table structure for table `v_sup_sch_area_group` */

DROP TABLE IF EXISTS `v_sup_sch_area_group`;

/*!50001 DROP VIEW IF EXISTS `v_sup_sch_area_group` */;
/*!50001 DROP TABLE IF EXISTS `v_sup_sch_area_group` */;

/*!50001 CREATE TABLE `v_sup_sch_area_group` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `supplier_name` varchar(60) DEFAULT NULL COMMENT '供应商名称',
  `address` varchar(120) DEFAULT NULL COMMENT '供应商地址',
  `provinces` varchar(36) DEFAULT NULL COMMENT '省',
  `city` varchar(36) DEFAULT NULL COMMENT '市',
  `area` varchar(36) DEFAULT NULL COMMENT '区',
  `area_name` varchar(36) DEFAULT NULL COMMENT '区域名称',
  `supplier_type` int(11) DEFAULT NULL COMMENT '供应商类型 0为不区分，1为成品菜供应商，2为原料供应商',
  `business_license` varchar(20) DEFAULT NULL COMMENT '工商执照号',
  `organization_code` varchar(60) DEFAULT NULL COMMENT '组织机构代码',
  `corporation` varchar(20) DEFAULT NULL COMMENT '法人代表',
  `contact_way` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `longitude` varchar(20) DEFAULT NULL COMMENT '精度',
  `latitude` varchar(20) DEFAULT NULL COMMENT '维度',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `school_ids` text,
  `school_names` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8 */;

/*View structure for view v_sup_sch_area */

/*!50001 DROP TABLE IF EXISTS `v_sup_sch_area` */;
/*!50001 DROP VIEW IF EXISTS `v_sup_sch_area` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`ims`@`%.%.%.%` SQL SECURITY DEFINER VIEW `v_sup_sch_area` AS select `sup`.`id` AS `id`,`sup`.`supplier_name` AS `supplier_name`,`sup`.`address` AS `address`,`sup`.`provinces` AS `provinces`,`sup`.`city` AS `city`,`sup`.`area` AS `area`,`sup`.`supplier_type` AS `supplier_type`,`sup`.`business_license` AS `business_license`,`sup`.`organization_code` AS `organization_code`,`sup`.`corporation` AS `corporation`,`sup`.`contact_way` AS `contact_way`,`sup`.`longitude` AS `longitude`,`sup`.`latitude` AS `latitude`,`sup`.`create_time` AS `create_time`,`sup`.`last_update_time` AS `last_update_time`,`sup`.`stat` AS `stat`,`sch`.`id` AS `school_id`,`sch`.`school_name` AS `school_name`,`a`.`address_name` AS `area_name` from ((`t_pro_supplier` `sup` left join (`t_edu_school_supplier` `tmp` left join `t_edu_school` `sch` on((`tmp`.`school_id` = `sch`.`id`))) on((`sup`.`id` = `tmp`.`supplier_id`))) left join `t_edu_area` `a` on((`sup`.`area` = `a`.`address_code`))) where ((`sup`.`stat` = 1) and (`a`.`stat` = 1) and (`sch`.`stat` = 1) and (`tmp`.`stat` = 1)) order by `sup`.`create_time` desc */;

/*View structure for view v_sup_sch_area_group */

/*!50001 DROP TABLE IF EXISTS `v_sup_sch_area_group` */;
/*!50001 DROP VIEW IF EXISTS `v_sup_sch_area_group` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`ims`@`%.%.%.%` SQL SECURITY DEFINER VIEW `v_sup_sch_area_group` AS select `v_sup_sch_area`.`id` AS `id`,`v_sup_sch_area`.`supplier_name` AS `supplier_name`,`v_sup_sch_area`.`address` AS `address`,`v_sup_sch_area`.`provinces` AS `provinces`,`v_sup_sch_area`.`city` AS `city`,`v_sup_sch_area`.`area` AS `area`,`v_sup_sch_area`.`area_name` AS `area_name`,`v_sup_sch_area`.`supplier_type` AS `supplier_type`,`v_sup_sch_area`.`business_license` AS `business_license`,`v_sup_sch_area`.`organization_code` AS `organization_code`,`v_sup_sch_area`.`corporation` AS `corporation`,`v_sup_sch_area`.`contact_way` AS `contact_way`,`v_sup_sch_area`.`longitude` AS `longitude`,`v_sup_sch_area`.`latitude` AS `latitude`,`v_sup_sch_area`.`create_time` AS `create_time`,group_concat(`v_sup_sch_area`.`school_id` separator ',') AS `school_ids`,group_concat(`v_sup_sch_area`.`school_name` separator ',') AS `school_names` from `v_sup_sch_area` group by `v_sup_sch_area`.`id` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
