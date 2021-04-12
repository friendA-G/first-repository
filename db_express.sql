/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : db_express

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2021-04-13 00:02:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(50) DEFAULT NULL,
  `passWord` varchar(10) DEFAULT NULL,
  `loginIp` varchar(50) DEFAULT NULL,
  `loginTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456', '0:0:0:0:0:0:0:1', '2021-04-03 19:42:17');

-- ----------------------------
-- Table structure for courier
-- ----------------------------
DROP TABLE IF EXISTS `courier`;
CREATE TABLE `courier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courierName` varchar(32) DEFAULT NULL,
  `passWord` varchar(32) DEFAULT NULL,
  `courierPhone` varchar(32) DEFAULT NULL,
  `idNumber` varchar(32) DEFAULT NULL,
  `expressNumber` varchar(32) DEFAULT NULL,
  `logonTime` timestamp NULL DEFAULT NULL,
  `loginTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `courierPhone` (`courierPhone`) USING BTREE,
  UNIQUE KEY `idNumber` (`idNumber`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of courier
-- ----------------------------
INSERT INTO `courier` VALUES ('5', '黄飞鸿', '125546', '12554663254', '154489654231202145', '10040', '2021-02-27 22:18:46', '2021-04-04 21:48:22');
INSERT INTO `courier` VALUES ('6', '李四3', '12533', '12236542103', '123365421325645803', '60', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('7', '李四4', '12534', '12236542104', '123365421325645804', '80', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('8', '李四5', '12535', '12236542105', '123365421325645805', '100', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('9', '李四6', '12536', '12236542106', '123365421325645806', '120', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('10', '李四7', '12537', '12236542107', '123365421325645807', '140', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('11', '李四8', '12538', '12236542108', '123365421325645808', '160', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('12', '李四9', '12539', '12236542109', '123365421325645809', '180', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('13', '李四10', '125310', '12236542110', '123365421325645810', '200', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('14', '李四11', '125311', '12236542111', '123365421325645811', '220', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('15', '李四12', '125312', '12236542112', '123365421325645812', '240', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('16', '李四13', '125313', '12236542113', '123365421325645813', '260', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('17', '李四14', '125314', '12236542114', '123365421325645814', '280', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('18', '李四15', '125315', '12236542115', '123365421325645815', '300', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('19', '李四16', '125316', '12236542116', '123365421325645816', '320', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('20', '李四17', '125317', '12236542117', '123365421325645817', '340', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('21', '李四18', '125318', '12236542118', '123365421325645818', '360', '2021-02-27 22:18:46', null);
INSERT INTO `courier` VALUES ('23', '钟八', '12345', '12355421635', '125546521325485632', '1542', '2021-02-28 15:21:09', null);
INSERT INTO `courier` VALUES ('27', '龚焱兴', '123456', '14715046330', '44140219980914071X', '82', '2021-03-01 18:28:23', '2021-04-06 20:20:52');
INSERT INTO `courier` VALUES ('32', '沈萍', '14452', '12236542149', '123365421325645848', '0', '2021-04-03 15:21:19', null);

-- ----------------------------
-- Table structure for express
-- ----------------------------
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(64) DEFAULT NULL,
  `userName` varchar(32) DEFAULT NULL,
  `userPhone` varchar(32) DEFAULT NULL,
  `company` varchar(32) DEFAULT NULL,
  `code` varchar(32) DEFAULT NULL,
  `inTime` timestamp NULL DEFAULT NULL,
  `outTime` timestamp NULL DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sysPhone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of express
-- ----------------------------
INSERT INTO `express` VALUES ('2', '1544', '张三', '15554623546', '圆通快递', null, '2021-02-01 17:34:51', '2021-03-31 17:29:03', '1', '14715046330');
INSERT INTO `express` VALUES ('3', '1665', '李四', '15554256548', '圆通快递', null, '2021-03-06 15:11:30', '2021-03-31 15:31:04', '1', '14715046330');
INSERT INTO `express` VALUES ('5', '1578', '李四', '15554256548', '京东快递', null, '2021-02-25 16:47:44', '2021-03-02 22:04:11', '1', '15554233654');
INSERT INTO `express` VALUES ('10', '15773', '李四', '15554256548', '京东快递', null, '2021-02-26 00:22:13', '2021-03-02 22:04:32', '1', '15554233654');
INSERT INTO `express` VALUES ('11', '15774', '王五', '14456587451', '圆通快递', null, '2021-02-26 00:22:13', '2021-03-31 17:51:41', '1', '15554233654');
INSERT INTO `express` VALUES ('12', '15775', '王五', '14456587451', '京东快递', null, '2021-02-26 00:22:13', '2021-03-31 18:04:13', '1', '15554233654');
INSERT INTO `express` VALUES ('13', '15776', '王五', '14456587451', '京东快递', null, '2021-02-26 00:22:13', '2021-04-06 19:18:33', '1', '15554233654');
INSERT INTO `express` VALUES ('14', '15777', '王五', '14456587451', '京东快递', '145507', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('15', '15778', '王五', '14456587451', '京东快递', '145508', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('16', '15779', '王五', '14456587451', '京东快递', '145509', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('17', '157710', '王五', '14456587451', '京东快递', '145510', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('18', '157711', '王五', '14456587451', '京东快递', null, '2021-02-26 00:22:13', '2021-04-06 19:21:21', '1', '15554233654');
INSERT INTO `express` VALUES ('19', '157712', '王五', '14456587451', '京东快递', '145512', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('20', '157713', '王五', '14456587451', '京东快递', '145513', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('21', '157714', '王五', '14456587451', '京东快递', '145514', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('22', '157715', '王五', '14456587451', '京东快递', '145515', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('23', '157716', '王五', '14456587451', '京东快递', '145516', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('24', '157717', '王五', '14456587451', '京东快递', '145517', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('25', '157718', '王五', '14456587451', '京东快递', '145518', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('26', '157719', '王五', '14456587451', '京东快递', '145519', '2021-02-26 00:22:13', null, '0', '15554233654');
INSERT INTO `express` VALUES ('27', '155542', '陈二', '14458866593', '安能物流', '549764', '2021-02-26 14:24:16', null, '0', '15447896532');
INSERT INTO `express` VALUES ('30', '15748', '陈二', '14455684532', '顺丰速运', '111388', '2021-02-26 14:34:09', null, '0', '15447896532');
INSERT INTO `express` VALUES ('34', '15772', '王五', '14445234654', '顺丰速递', '308456', '2021-02-26 21:36:43', null, '0', '15554233654');
INSERT INTO `express` VALUES ('35', '15423', '王五', '12354621321', '顺丰速运', '864167', '2021-02-28 14:44:04', null, '0', '15447896532');
INSERT INTO `express` VALUES ('36', '154475', '黄一', '15542666544', '顺丰速运', '243468', '2021-02-28 15:26:03', null, '0', '15447896532');
INSERT INTO `express` VALUES ('38', '15763', '李四', '15554256548', '顺丰速运', null, '2021-03-04 15:30:57', '2021-03-05 09:20:55', '1', '14715046330');
INSERT INTO `express` VALUES ('39', '158843', '李四', '15554256548', '顺丰速运', null, '2021-03-04 17:07:33', '2021-03-05 09:24:53', '1', '14715046330');
INSERT INTO `express` VALUES ('40', '42256', '李四', '15554256548', '顺丰速运', null, '2021-03-05 09:24:04', '2021-03-05 11:32:02', '1', '14715046330');
INSERT INTO `express` VALUES ('41', '52668', '李四', '15554256548', '瑞士邮政', null, '2021-03-05 09:26:00', '2021-03-05 09:26:32', '1', '14715046330');
INSERT INTO `express` VALUES ('42', '422658', '李四', '15554256548', '苏宁快递', null, '2021-03-05 11:35:48', '2021-03-05 11:45:35', '1', '14715046330');
INSERT INTO `express` VALUES ('43', '158875', '李四', '15554256548', '顺丰速运', null, '2021-03-05 12:11:27', '2021-03-05 12:12:42', '1', '14715046330');
INSERT INTO `express` VALUES ('44', '16684', '李四', '15554256548', '顺丰速运', null, '2021-03-05 12:15:05', '2021-03-05 12:16:13', '1', '14715046330');
INSERT INTO `express` VALUES ('45', '11543', '刘崇水', '18670106673', '瑞士邮政', null, '2021-03-06 12:47:12', '2021-03-06 12:48:03', '1', '14715046330');
INSERT INTO `express` VALUES ('46', '1555756', '黄飞鸿', '15669875324', '顺丰速运', '146231', '2021-03-30 14:27:28', null, '0', '14715046330');
INSERT INTO `express` VALUES ('52', '78896', '李四', '15554256549', '顺丰速运', '510693', '2021-04-05 00:36:16', null, '0', '14715046330');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) DEFAULT NULL,
  `userPhone` varchar(32) DEFAULT NULL,
  `passWord` varchar(32) DEFAULT NULL,
  `idNumber` varchar(32) DEFAULT NULL,
  `loginTime` timestamp NULL DEFAULT NULL,
  `logonTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userPhone` (`userPhone`),
  UNIQUE KEY `idNumber` (`idNumber`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '王五', '11455416511', '15485', '154478894756235467', null, '2021-02-27 15:03:58');
INSERT INTO `user` VALUES ('14', '刘六', '14475634454', '15447', '154478894756235468', null, '2021-02-27 17:11:03');
INSERT INTO `user` VALUES ('15', '李四一', '15554256549', '159357', '123467891154669532', '2021-04-05 01:06:43', '2021-02-27 19:11:53');
INSERT INTO `user` VALUES ('16', '陈二', '45678954698', '125967', '154669325669875463', null, '2021-02-27 19:14:42');
INSERT INTO `user` VALUES ('17', '陈二', '14445569800', '15485', '154478896554235400', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('18', '陈二', '14445569801', '15485', '154478896554235401', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('19', '陈二', '14445569802', '15485', '154478896554235402', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('20', '陈二', '14445569803', '15485', '154478896554235403', '2021-04-04 21:44:53', '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('21', '陈二', '14445569804', '15485', '154478896554235404', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('22', '陈二', '14445569805', '15485', '154478896554235405', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('23', '陈二', '14445569806', '15485', '154478896554235406', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('24', '陈二', '14445569807', '15485', '154478896554235407', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('25', '陈二', '14445569808', '15485', '154478896554235408', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('26', '陈二', '14445569809', '15485', '154478896554235409', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('27', '陈二', '14445569810', '15485', '154478896554235410', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('28', '陈二', '14445569811', '15485', '154478896554235411', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('29', '陈二', '14445569812', '15485', '154478896554235412', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('30', '陈二', '14445569813', '15485', '154478896554235413', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('31', '陈二', '14445569814', '15485', '154478896554235414', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('32', '陈二', '14445569815', '15485', '154478896554235415', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('33', '陈二', '14445569816', '15485', '154478896554235416', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('34', '陈二', '14445569817', '15485', '154478896554235417', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('35', '陈二', '14445569818', '15485', '154478896554235418', '2021-04-05 01:39:59', '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('36', '陈二', '14445569819', '15485', '154478896554235419', null, '2021-02-27 20:36:53');
INSERT INTO `user` VALUES ('37', '钟八', '14475463224', '123456', '14457532146542184X', null, '2021-02-28 14:46:52');
INSERT INTO `user` VALUES ('42', '龚焱兴', '19170213787', '45852', '44140219980914071X', '2021-03-01 19:01:44', '2021-03-01 18:48:37');
INSERT INTO `user` VALUES ('43', '李四', '15554256548', '66666', '44140219990914071X', '2021-04-04 19:00:02', '2021-03-01 21:48:44');
INSERT INTO `user` VALUES ('44', '蘅伊', '19170213789', '775546', '447556998548576321', '2021-03-02 14:23:55', '2021-03-02 14:16:20');
INSERT INTO `user` VALUES ('45', '沈怡', '19178213789', '4475ssa', '144556585452321542', '2021-03-02 14:29:39', '2021-03-02 14:29:39');
INSERT INTO `user` VALUES ('47', '王明', '18670106673', '14475', '144475996685421357', null, '2021-04-01 14:04:09');
INSERT INTO `user` VALUES ('52', '王五', '11455416512', '12554', '154478894756235461', null, '2021-04-02 20:58:14');
INSERT INTO `user` VALUES ('53', null, '14475633215', null, null, '2021-04-04 14:49:02', '2021-04-04 14:22:27');
INSERT INTO `user` VALUES ('54', null, '18857632451', null, null, '2021-04-04 21:16:02', '2021-04-04 14:49:45');
INSERT INTO `user` VALUES ('55', '王五', '14456587451', '788520', '444756632145242246', '2021-04-06 20:37:27', '2021-04-04 17:59:30');
