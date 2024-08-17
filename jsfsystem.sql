/*
Navicat MySQL Data Transfer

Source Server         : ceshi
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : jsfsystem

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2023-11-19 15:20:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for baoming
-- ----------------------------
DROP TABLE IF EXISTS `baoming`;
CREATE TABLE `baoming` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kcid` int(11) DEFAULT NULL,
  `kcname` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `time` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `jiaolian` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `huiyuanid` int(11) DEFAULT NULL,
  `huiyuanname` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of baoming
-- ----------------------------
INSERT INTO `baoming` VALUES ('3', '3', '增肌', '2023-11-16', '张供', '3', '黄家驹');
INSERT INTO `baoming` VALUES ('4', '3', '增肌', '2023-11-16', '张供', '2', '叶世荣');
INSERT INTO `baoming` VALUES ('5', '4', '塑形', '2023-11-22', '张晚意', '2', '叶世荣');
INSERT INTO `baoming` VALUES ('6', '5', '举重', '2023-11-17', '檀建次', '2', '叶世荣');

-- ----------------------------
-- Table structure for huiyuan
-- ----------------------------
DROP TABLE IF EXISTS `huiyuan`;
CREATE TABLE `huiyuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardno` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `createTime` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `year` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `height` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `weight` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `buytime` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `shengyutime` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `hyimg` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `pass` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of huiyuan
-- ----------------------------
INSERT INTO `huiyuan` VALUES ('1', '75825331', '黄贯中', '2023-11-23', '男', '59', '18803268331', '175', '90', '12', '12', 'http://demo-mp3.oss-cn-shenzhen.aliyuncs.com/egg-edu-demo/2110c2df6eeed73379fe.jpg', 'huangguanzhong');
INSERT INTO `huiyuan` VALUES ('2', '90273317', '叶世荣', '2023-11-11', '男', '60', '18803268331', '173', '70', '98', '98', 'http://demo-mp3.oss-cn-shenzhen.aliyuncs.com/egg-edu-demo/d5fecb99cb3fefef5a75.jpg', '123456');
INSERT INTO `huiyuan` VALUES ('3', '03354164', '黄家驹', '2023-11-24', '男', '31', '18803268331', '173', '98', '87', '87', 'http://demo-mp3.oss-cn-shenzhen.aliyuncs.com/egg-edu-demo/2f09b50daea8e9a12002.jpg', '123456');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `path` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '首页', '/index', '1');
INSERT INTO `menu` VALUES ('2', '会员管理', '/hygl', '1');
INSERT INTO `menu` VALUES ('3', '员工管理', '/yggl', '1');
INSERT INTO `menu` VALUES ('4', '器材管理', '/qcgl', '1');
INSERT INTO `menu` VALUES ('5', '课程管理', '/kcgl', '1');
INSERT INTO `menu` VALUES ('6', '我的', '/my', '2');
INSERT INTO `menu` VALUES ('7', '可报名课程', '/kbmkc', '2');

-- ----------------------------
-- Table structure for qicai
-- ----------------------------
DROP TABLE IF EXISTS `qicai`;
CREATE TABLE `qicai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `location` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of qicai
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `time` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `timelong` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `jiaolian` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `jiaolianid` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('3', '增肌', '2023-11-16', '56', '张供', '3');
INSERT INTO `subject` VALUES ('4', '塑形', '2023-11-22', '57', '张晚意', '5');
INSERT INTO `subject` VALUES ('5', '举重', '2023-11-17', '56', '檀建次', '4');
INSERT INTO `subject` VALUES ('7', '瑜伽', '2023-11-23', '67', '邓为1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `avator` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123321', 'http://demo-mp3.oss-cn-shenzhen.aliyuncs.com/egg-edu-demo/f4653d576bd10ed91393.jpg');

-- ----------------------------
-- Table structure for yuangong
-- ----------------------------
DROP TABLE IF EXISTS `yuangong`;
CREATE TABLE `yuangong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `year` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `ruzhitime` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `zhiwu` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of yuangong
-- ----------------------------
INSERT INTO `yuangong` VALUES ('1', '邓为1', '男', '33', '2023-11-16', '健身教练', '123333');
INSERT INTO `yuangong` VALUES ('3', '张供', '男', '23', '2023-11-24', '健身教练', '123');
INSERT INTO `yuangong` VALUES ('4', '檀建次', '男', '33', '2023-11-25', '健身教练', '12333');
INSERT INTO `yuangong` VALUES ('5', '张晚意', '男', '36', '2023-11-30', '健身教练', '132');
