/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : limsdb

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-03-03 14:49:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `lims_consumable`
-- ----------------------------
DROP TABLE IF EXISTS `lims_consumable`;
CREATE TABLE `lims_consumable` (
  `consumable_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `comsumable_name` varchar(255) NOT NULL COMMENT '耗材名称',
  `comsumable_number` int(11) NOT NULL COMMENT '耗材数量',
  `comsumable_desc` varchar(255) DEFAULT NULL COMMENT '耗材描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`consumable_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lims_consumable
-- ----------------------------

-- ----------------------------
-- Table structure for `lims_instrument`
-- ----------------------------
DROP TABLE IF EXISTS `lims_instrument`;
CREATE TABLE `lims_instrument` (
  `instrument_id` int(11) NOT NULL AUTO_INCREMENT,
  `instrument_name` varchar(255) NOT NULL COMMENT '仪器名称',
  `instrument_number` int(11) NOT NULL COMMENT '仪器数量',
  `instrument_desc` varchar(255) DEFAULT NULL COMMENT '仪器的描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`instrument_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lims_instrument
-- ----------------------------

-- ----------------------------
-- Table structure for `lims_menu`
-- ----------------------------
DROP TABLE IF EXISTS `lims_menu`;
CREATE TABLE `lims_menu` (
  `menu_id` int(11) NOT NULL COMMENT '权限id',
  `menu_name` varchar(255) NOT NULL COMMENT '权限名称',
  `parent_id` int(11) NOT NULL,
  `menu_url` varchar(255) DEFAULT NULL COMMENT '路径URL',
  `create_time` datetime NOT NULL,
  `display_order` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lims_menu
-- ----------------------------
INSERT INTO `lims_menu` VALUES ('1', '实验管理', '0', null, '2016-02-27 15:08:58', '1');
INSERT INTO `lims_menu` VALUES ('2', '公告管理', '0', null, '2016-02-27 15:09:39', '6');
INSERT INTO `lims_menu` VALUES ('3', '资源管理', '0', null, '2016-02-27 15:10:10', '9');
INSERT INTO `lims_menu` VALUES ('4', '仪器管理', '0', null, '2016-02-27 15:10:37', '12');
INSERT INTO `lims_menu` VALUES ('5', '耗材管理', '0', null, '2016-02-27 15:11:12', '13');
INSERT INTO `lims_menu` VALUES ('6', '角色管理', '0', null, '2016-02-27 15:11:32', '14');
INSERT INTO `lims_menu` VALUES ('7', '预约实验', '1', null, '2016-02-27 15:13:59', '2');
INSERT INTO `lims_menu` VALUES ('8', '加入实验', '1', null, '2016-02-27 15:14:36', '3');
INSERT INTO `lims_menu` VALUES ('9', '审核实验', '1', null, '2016-02-27 15:15:18', '4');
INSERT INTO `lims_menu` VALUES ('10', '查看实验', '1', null, '2016-02-27 15:42:32', '5');
INSERT INTO `lims_menu` VALUES ('11', '查看公告', '2', null, '2016-02-27 15:19:00', '7');
INSERT INTO `lims_menu` VALUES ('12', '发布公告', '2', null, '2016-02-27 15:19:46', '8');
INSERT INTO `lims_menu` VALUES ('13', '上传资源', '3', null, '2016-02-27 15:21:31', '10');
INSERT INTO `lims_menu` VALUES ('14', '查看资源', '3', null, '2016-02-27 15:23:44', '11');
INSERT INTO `lims_menu` VALUES ('15', '实验室管理', '0', null, '2016-02-27 15:31:40', '15');

-- ----------------------------
-- Table structure for `lims_roles`
-- ----------------------------
DROP TABLE IF EXISTS `lims_roles`;
CREATE TABLE `lims_roles` (
  `role` int(11) NOT NULL COMMENT '用户类别',
  `role_name` varchar(255) NOT NULL COMMENT '用户类别名',
  `role_type` int(11) NOT NULL COMMENT '角色类型，0为系统角色，1为新增角色',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `role_desc` varchar(512) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lims_roles
-- ----------------------------
INSERT INTO `lims_roles` VALUES ('1', '系统管理员', '0', '2016-02-27 17:40:00', null);
INSERT INTO `lims_roles` VALUES ('2', '老师', '0', '2016-02-27 17:40:30', null);
INSERT INTO `lims_roles` VALUES ('3', '学生', '0', '2016-02-27 17:40:33', null);

-- ----------------------------
-- Table structure for `lims_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `lims_role_menu`;
CREATE TABLE `lims_role_menu` (
  `role` int(11) NOT NULL COMMENT '用户类别',
  `menu_id` int(11) NOT NULL COMMENT '权限id',
  `parent_id` int(11) NOT NULL COMMENT '父菜单',
  PRIMARY KEY (`role`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lims_role_menu
-- ----------------------------
INSERT INTO `lims_role_menu` VALUES ('1', '0', '0');
INSERT INTO `lims_role_menu` VALUES ('1', '1', '0');
INSERT INTO `lims_role_menu` VALUES ('1', '2', '0');
INSERT INTO `lims_role_menu` VALUES ('1', '3', '0');
INSERT INTO `lims_role_menu` VALUES ('1', '4', '0');
INSERT INTO `lims_role_menu` VALUES ('1', '5', '0');
INSERT INTO `lims_role_menu` VALUES ('1', '6', '0');
INSERT INTO `lims_role_menu` VALUES ('1', '9', '1');
INSERT INTO `lims_role_menu` VALUES ('1', '10', '1');
INSERT INTO `lims_role_menu` VALUES ('1', '11', '2');
INSERT INTO `lims_role_menu` VALUES ('1', '12', '2');
INSERT INTO `lims_role_menu` VALUES ('1', '14', '3');
INSERT INTO `lims_role_menu` VALUES ('1', '15', '0');
INSERT INTO `lims_role_menu` VALUES ('2', '1', '0');
INSERT INTO `lims_role_menu` VALUES ('2', '2', '0');
INSERT INTO `lims_role_menu` VALUES ('2', '3', '0');
INSERT INTO `lims_role_menu` VALUES ('2', '7', '1');
INSERT INTO `lims_role_menu` VALUES ('2', '10', '1');
INSERT INTO `lims_role_menu` VALUES ('2', '11', '2');
INSERT INTO `lims_role_menu` VALUES ('2', '12', '2');
INSERT INTO `lims_role_menu` VALUES ('2', '13', '3');
INSERT INTO `lims_role_menu` VALUES ('2', '14', '3');
INSERT INTO `lims_role_menu` VALUES ('3', '0', '0');
INSERT INTO `lims_role_menu` VALUES ('3', '1', '0');
INSERT INTO `lims_role_menu` VALUES ('3', '2', '0');
INSERT INTO `lims_role_menu` VALUES ('3', '3', '0');
INSERT INTO `lims_role_menu` VALUES ('3', '10', '1');
INSERT INTO `lims_role_menu` VALUES ('3', '11', '2');
INSERT INTO `lims_role_menu` VALUES ('3', '14', '3');

-- ----------------------------
-- Table structure for `lims_users`
-- ----------------------------
DROP TABLE IF EXISTS `lims_users`;
CREATE TABLE `lims_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `cnname` varchar(255) NOT NULL COMMENT '用户名',
  `role` int(11) NOT NULL COMMENT '用户类别',
  `gender` varchar(8) NOT NULL COMMENT '用户性别',
  `status` int(11) NOT NULL COMMENT '用户状态',
  `phone` varchar(16) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '用户创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lims_users
-- ----------------------------
INSERT INTO `lims_users` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '系统管理员', '1', '男', '0', '11111111111', '2016-02-27 16:07:55', '2016-02-27 16:08:01');
