/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : lab_controller

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-01-02 17:56:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `announcement`
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `an_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告表',
  `an_teacher` varchar(255) NOT NULL COMMENT '发布公告的老师',
  `an_text` text NOT NULL COMMENT '公告内容',
  `an_time` varchar(255) NOT NULL COMMENT '公告时间',
  `an_name` varchar(255) NOT NULL COMMENT '公告名称',
  PRIMARY KEY (`an_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('6', '张华伟', '发发阿发阿发啊', '2015-12-30 07:22', '按法律');
INSERT INTO `announcement` VALUES ('7', '张华伟', '发啊啊水电费萨法是撒发是', '2015-12-30 08:59', '哈佛啊哈');
INSERT INTO `announcement` VALUES ('8', '张华伟', '舒服舒服是算法 是冯绍峰三算法是', '2015-12-30 09:07', '冯绍峰三');
INSERT INTO `announcement` VALUES ('9', '张华伟', '法法师算法撒发萨发生发', '2015-12-30 09:14', '简历将了解了解');
INSERT INTO `announcement` VALUES ('11', '张华伟', '李开复撒娇垃圾六块腹肌老时间', '2015-12-30 09:36', '剪短发垃圾');
INSERT INTO `announcement` VALUES ('12', '张华伟', '机房拉丝机了房间垃圾垃圾', '2015-12-31 03:44', '好的');
INSERT INTO `announcement` VALUES ('13', '张华伟', '减肥收垃圾量减少浪费就是垃圾垃圾了', '2015-12-31 04:34', '若肯德基浪费');

-- ----------------------------
-- Table structure for `consumable`
-- ----------------------------
DROP TABLE IF EXISTS `consumable`;
CREATE TABLE `consumable` (
  `consumable_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '耗材id',
  `consum_number` int(11) NOT NULL COMMENT '耗材数量',
  `consum_name` varchar(255) NOT NULL COMMENT '耗材名称',
  PRIMARY KEY (`consumable_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consumable
-- ----------------------------
INSERT INTO `consumable` VALUES ('1', '160', '塑料手套');
INSERT INTO `consumable` VALUES ('2', '200', '塑料瓶');
INSERT INTO `consumable` VALUES ('3', '300', '过滤器');
INSERT INTO `consumable` VALUES ('4', '200', '二极管');

-- ----------------------------
-- Table structure for `experiment`
-- ----------------------------
DROP TABLE IF EXISTS `experiment`;
CREATE TABLE `experiment` (
  `experiment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '实验表',
  `experiment_name` varchar(255) NOT NULL COMMENT '实验名称',
  `experiment_teacher` varchar(255) NOT NULL COMMENT '老师名字',
  `experiment_date` varchar(255) NOT NULL COMMENT '实验日期',
  `experiment_time` varchar(255) NOT NULL COMMENT '实验时间范围',
  `experiment_place` varchar(255) NOT NULL COMMENT '实验室名称',
  `experiment_sort` int(11) NOT NULL COMMENT '预约实验状态，1待审核，2已通过，3已结束',
  `experiment_max` int(11) NOT NULL COMMENT '实验室最大人数',
  `experiment_number` int(11) NOT NULL COMMENT '现有报名人数',
  `instrument_id` int(11) DEFAULT NULL COMMENT '仪器id',
  `instrument_number` int(11) DEFAULT NULL COMMENT '仪器数量',
  `consumable_id` int(11) DEFAULT NULL COMMENT '耗材id',
  `consumable_number` int(11) DEFAULT NULL COMMENT '耗材数量',
  `experiment_over` varchar(255) NOT NULL COMMENT '实验结束时间',
  PRIMARY KEY (`experiment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of experiment
-- ----------------------------
INSERT INTO `experiment` VALUES ('1', '发生了积分', '张华伟', '2016-01-08', '08:00~09:40', '新一101', '2', '40', '0', '1', '40', '1', '40', '2016-01-08 09:40');

-- ----------------------------
-- Table structure for `instrument`
-- ----------------------------
DROP TABLE IF EXISTS `instrument`;
CREATE TABLE `instrument` (
  `instrument_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '仪器id',
  `instrument_number` int(11) NOT NULL COMMENT '仪器数量',
  `instrument_name` varchar(255) NOT NULL COMMENT '实验仪器名称',
  PRIMARY KEY (`instrument_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of instrument
-- ----------------------------
INSERT INTO `instrument` VALUES ('1', '60', '显示屏');
INSERT INTO `instrument` VALUES ('2', '100', '键盘');
INSERT INTO `instrument` VALUES ('3', '100', '鼠标');
INSERT INTO `instrument` VALUES ('4', '200', '放大镜');

-- ----------------------------
-- Table structure for `lab`
-- ----------------------------
DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab` (
  `lab_id` int(11) NOT NULL COMMENT '实验室id',
  `lab_name` varchar(255) NOT NULL COMMENT '实验室名称',
  `lab_number` int(11) NOT NULL COMMENT '实验室人数',
  PRIMARY KEY (`lab_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lab
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `user_number` varchar(20) NOT NULL COMMENT '账号',
  `user_password` varchar(255) NOT NULL COMMENT '密码',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `user_sort` int(11) NOT NULL COMMENT '用户类别,1为学生，2为老师，3为管理员',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '111111', '111111', '刘银', '3');
INSERT INTO `user` VALUES ('2', '333333', '111111', '张玉斌', '1');
INSERT INTO `user` VALUES ('3', '222222', '111111', '张华伟', '2');
INSERT INTO `user` VALUES ('4', '111', '111', '大斌', '1');

-- ----------------------------
-- Table structure for `user_ann`
-- ----------------------------
DROP TABLE IF EXISTS `user_ann`;
CREATE TABLE `user_ann` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `ann_id` int(11) NOT NULL COMMENT '实验id',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编辑id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_ann
-- ----------------------------
INSERT INTO `user_ann` VALUES ('3', '6', '1');
INSERT INTO `user_ann` VALUES ('3', '7', '2');
INSERT INTO `user_ann` VALUES ('3', '8', '3');
INSERT INTO `user_ann` VALUES ('3', '9', '4');
INSERT INTO `user_ann` VALUES ('3', '11', '5');
INSERT INTO `user_ann` VALUES ('3', '12', '6');
INSERT INTO `user_ann` VALUES ('3', '13', '7');

-- ----------------------------
-- Table structure for `user_lab`
-- ----------------------------
DROP TABLE IF EXISTS `user_lab`;
CREATE TABLE `user_lab` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `lab_id` int(11) NOT NULL COMMENT '实验id',
  `user_sort` int(11) NOT NULL COMMENT '用户类型，1位学生，2为老师，3为管理员',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编辑id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_lab
-- ----------------------------
INSERT INTO `user_lab` VALUES ('3', '1', '2', '1');
