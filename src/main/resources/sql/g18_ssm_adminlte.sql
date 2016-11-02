/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : g18_ssm_adminlte

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-11-02 18:39:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL DEFAULT '123456',
  `role` int(11) NOT NULL DEFAULT '0',
  `realname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`user_id`),
  UNIQUE KEY `username_2` (`user_id`),
  UNIQUE KEY `username_3` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '00001', '1234', '10', '小明', 'wangquanjava@163.com', '2016-11-03');
INSERT INTO `user` VALUES ('20', '00010', '123456', '0', '王1', null, '2012-09-01');
INSERT INTO `user` VALUES ('21', '00011', '123456', '0', '王2', null, '2012-09-02');
INSERT INTO `user` VALUES ('22', '00012', '123456', '0', '王3', null, '2012-09-03');
INSERT INTO `user` VALUES ('23', '00013', '123456', '0', '王4', null, '2012-09-04');
INSERT INTO `user` VALUES ('24', '00014', '123456', '0', '王5', null, '2012-09-05');
INSERT INTO `user` VALUES ('25', '00015', '123456', '0', '王6', null, '2012-09-06');
INSERT INTO `user` VALUES ('26', '00016', '123456', '0', '王7', null, '2012-09-07');
INSERT INTO `user` VALUES ('27', '00017', '123456', '0', '王8', null, '2012-09-08');
INSERT INTO `user` VALUES ('28', '00018', '123456', '0', '王9', null, '2012-09-09');
INSERT INTO `user` VALUES ('29', '00019', '123456', '0', '王10', null, '2012-09-10');
INSERT INTO `user` VALUES ('30', '00020', '123456', '0', '王11', null, '2012-09-11');
INSERT INTO `user` VALUES ('31', '00021', '123456', '0', '王12', null, '2012-09-12');
INSERT INTO `user` VALUES ('32', '00022', '123456', '0', '王13', null, '2012-09-13');
INSERT INTO `user` VALUES ('33', '00023', '123456', '0', '王14', null, '2012-09-14');
