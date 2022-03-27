/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : spbootvue09811csglxt

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2021-12-22 17:10:21
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '帐号',
  `pwd` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `gongyingshang`
-- ----------------------------
DROP TABLE IF EXISTS `gongyingshang`;
CREATE TABLE `gongyingshang` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `gongyingshangbianhao` varchar(50) NOT NULL COMMENT '供应商编号',
  `gongyingshangmingcheng` varchar(255) NOT NULL COMMENT '供应商名称',
  `gongyingshangdianhua` varchar(50) NOT NULL COMMENT '供应商电话',
  `gongyingshangdizhi` varchar(255) NOT NULL COMMENT '供应商地址',
  `gongyingshangxiangqing` text NOT NULL COMMENT '供应商详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='供应商';

-- ----------------------------
-- Records of gongyingshang
-- ----------------------------
INSERT INTO `gongyingshang` VALUES ('1', '122213361755', '供应商AAAA', '12345678901', 'XXX', 'XXXX');
INSERT INTO `gongyingshang` VALUES ('2', '122213361755', '供应商BBB', '12345678902', 'XXXXX', 'XXXX');

-- ----------------------------
-- Table structure for `jinhuo`
-- ----------------------------
DROP TABLE IF EXISTS `jinhuo`;
CREATE TABLE `jinhuo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shangpinxinxiid` int(10) unsigned NOT NULL COMMENT '商品信息id',
  `shangpinbianhao` varchar(50) NOT NULL COMMENT '商品编号',
  `shangpinmingcheng` varchar(255) NOT NULL COMMENT '商品名称',
  `fenlei` int(10) unsigned NOT NULL COMMENT '分类',
  `gongyingshang` int(10) unsigned NOT NULL COMMENT '供应商ID',
  `gongyingshangbianhao` varchar(50) NOT NULL COMMENT '供应商编号',
  `gongyingshangmingcheng` varchar(255) NOT NULL COMMENT '供应商名称',
  `gongyingshangdianhua` varchar(50) NOT NULL COMMENT '供应商电话',
  `jinhuojiage` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '进货价格',
  `jinhuoshuliang` int(11) NOT NULL DEFAULT '0' COMMENT '进货数量',
  `jinhuoxiaoji` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '进货小计',
  `jinhuobeizhu` text NOT NULL COMMENT '进货备注',
  `caozuoren` varchar(50) NOT NULL COMMENT '操作人',
  PRIMARY KEY (`id`),
  KEY `jinhuo_shangpinxinxiid_index` (`shangpinxinxiid`),
  KEY `jinhuo_fenlei_index` (`fenlei`),
  KEY `jinhuo_gongyingshang_index` (`gongyingshang`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='进货';

-- ----------------------------
-- Records of jinhuo
-- ----------------------------
INSERT INTO `jinhuo` VALUES ('1', '18', '122216477809', '测试', '3', '2', '122213361755', '供应商BBB', '12345678902', '20.00', '500', '10000.00', 'X', 'admin');
INSERT INTO `jinhuo` VALUES ('2', '11', '2102242136002', '日本出口AAA级抑菌技术纯棉加厚毛巾', '2', '2', '122213361755', '供应商BBB', '12345678902', '12.00', '30', '360.00', 'X', 'admin');
INSERT INTO `jinhuo` VALUES ('3', '6', '2102242129222', '蒜香味青豆', '1', '2', '122213361755', '供应商BBB', '12345678902', '6.00', '50', '300.00', 'X', 'admin');
INSERT INTO `jinhuo` VALUES ('4', '3', '2102242125451', '上好佳（Oishi）鲜虾片 膨化零食大礼包 6g*20袋', '1', '2', '122213361755', '供应商BBB', '12345678902', '16.00', '50', '800.00', 'X', 'admin');
INSERT INTO `jinhuo` VALUES ('5', '1', '2102242122340', '趣多多 大块巧克力味曲奇饼干', '1', '1', '122213361755', '供应商AAAA', '12345678901', '26.00', '50', '1300.00', 'X', 'admin');
INSERT INTO `jinhuo` VALUES ('6', '18', '122216477809', '测试', '3', '2', '122213361755', '供应商BBB', '12345678902', '20.00', '20', '400.00', 'X', 'admin');

-- ----------------------------
-- Table structure for `shangpinfenlei`
-- ----------------------------
DROP TABLE IF EXISTS `shangpinfenlei`;
CREATE TABLE `shangpinfenlei` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fenlei` varchar(50) NOT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品分类';

-- ----------------------------
-- Records of shangpinfenlei
-- ----------------------------
INSERT INTO `shangpinfenlei` VALUES ('1', '零食');
INSERT INTO `shangpinfenlei` VALUES ('2', '日用品');
INSERT INTO `shangpinfenlei` VALUES ('3', '饮料');

-- ----------------------------
-- Table structure for `shangpinxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `shangpinxinxi`;
CREATE TABLE `shangpinxinxi` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shangpinbianhao` varchar(50) NOT NULL COMMENT '商品编号',
  `shangpinmingcheng` varchar(255) NOT NULL COMMENT '商品名称',
  `fenlei` int(10) unsigned NOT NULL COMMENT '分类',
  `shangpintupian` text NOT NULL COMMENT '商品图片',
  `shangpinjiage` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
  `shangpinkucun` int(11) NOT NULL DEFAULT '0' COMMENT '商品库存',
  `shangpinxiangqing` longtext NOT NULL COMMENT '商品详情',
  `jinhuojiage` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shangpinxinxi_fenlei_index` (`fenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Records of shangpinxinxi
-- ----------------------------
INSERT INTO `shangpinxinxi` VALUES ('1', '2102242122340', '趣多多 大块巧克力味曲奇饼干', '1', '/upload/20211222/c7ae4978-8518-47fe-9dda-d6c6157ab652.png', '28.60', '97', '<p><img src=\"http://localhost:8088/upload/20211222/f18617d0-f586-4fdd-bc11-5a0c230d054b.png\" /></p>', '26');
INSERT INTO `shangpinxinxi` VALUES ('2', '2102242124353', '好丽友 休闲零食 薯片', '1', '/upload/20211222/29de9629-c476-4d1f-8671-13f1a411d241.png', '8.80', '550', '<p><img src=\"http://localhost:8088/upload/20211222/54666e69-1b6a-46ac-8ac6-a7ccbb960fdd.png\" /></p>', '8');
INSERT INTO `shangpinxinxi` VALUES ('3', '2102242125451', '上好佳（Oishi）鲜虾片 膨化零食大礼包 6g*20袋', '1', '/upload/20211222/288728ee-e9e1-4b23-a60f-19dc8c63a90d.png', '17.60', '100', '<p><img src=\"http://localhost:8088/upload/20211222/8756a8d9-85ff-4cab-a915-8c1d77a405a9.png\" /></p>', '16');
INSERT INTO `shangpinxinxi` VALUES ('4', '2102242126370', '印尼进口纳宝帝Nabati丽芝士', '1', '/upload/20211222/824995c9-8e8f-4d9c-9926-ef46737607b0.png', '16.50', '550', '<p><img src=\"http://img12.360buyimg.com/cms/jfs/t1/55622/8/89/228521/5cd24fd1E4dff330a/fae0c268bcd6dd0e.jpg\" /></p>', '15');
INSERT INTO `shangpinxinxi` VALUES ('5', '2102242127374', '老板仔（Tao Kae Noi）海苔卷原味', '1', '/upload/20211222/41a539cd-47b7-465e-b7b5-7ed746c54c89.png', '13.20', '540', '<p><img src=\"http://localhost:8088/upload/20211222/41055ff4-8480-4657-bfa6-65f4418901a0.png\" /></p>', '12');
INSERT INTO `shangpinxinxi` VALUES ('6', '2102242129222', '蒜香味青豆', '1', '/upload/20211222/c97e2e30-6dc2-4978-9a63-8c383e7629f4.png', '6.60', '100', '<p><img src=\"http://localhost:8088/upload/20211222/9bf2aff0-2222-48da-85bb-830818050c78.png\" /></p>', '6');
INSERT INTO `shangpinxinxi` VALUES ('8', '2102242131400', '英国DR.WLEN迪王 情侣款牙刷', '2', '/upload/20211222/4d89361c-b49c-40e6-bd79-f2de79faddab.png', '36.30', '247', '<p><img src=\"http://localhost:8088/upload/20211222/651938fb-ac55-43e0-9c66-877d8c2afa82.png\" /></p>', '33');
INSERT INTO `shangpinxinxi` VALUES ('9', '2102242133062', '云南白药 牙膏 180g （留兰香型）', '2', '/upload/20211222/cefdf20d-e179-4321-84bb-694c2fc4e3a7.png', '28.60', '50', '<ul class=\"parameter2 p-parameter-list\">\n<li title=\"牙龈护理，牙周护理，清新口气，多效护理\">功效：牙龈护理，牙周护理，清新口气，多效护理</li>\n<li title=\"成人\">适用人群：成人</li>\n<li title=\"留兰香型\">香型：留兰香型</li>\n<li title=\"141-200g\">净含量：141-200g</li>\n<li title=\"不含氟\">是否含氟：不含氟</li>\n<li title=\"国产\">国产/进口：国产<img src=\"upload/5ca269ba6cdcd1223eae1d2ece055fa1.png\" /></li>\n</ul>', '26');
INSERT INTO `shangpinxinxi` VALUES ('10', '2102242134211', '得宝(Tempo) 抽纸 4层90抽*18包', '2', '/upload/20211222/03887ed8-26b2-45d3-b6e5-3bd2c10ac8fe.png', '57.20', '50', '<p><img src=\"http://localhost:8088/upload/20211222/d0dbcb61-9056-45e3-9faa-1957c28b522a.png\" /></p>', '52');
INSERT INTO `shangpinxinxi` VALUES ('11', '2102242136002', '日本出口AAA级抑菌技术纯棉加厚毛巾', '2', '/upload/20211222/77e5417f-d506-4558-9390-f3aa649fef0f.png', '13.20', '80', '<p><img src=\"http://localhost:8088/upload/20211222/8b475cf6-15c0-442f-8fba-c0e35a49c8ec.png\" /></p>', '12');
INSERT INTO `shangpinxinxi` VALUES ('14', '2102242139333', '荔枝味汽水 碳酸饮料 330ml*24听', '3', '/upload/20211222/02b70123-377b-4cda-83eb-4873ad39a6ed.png', '42.90', '44', '<p><img src=\"http://localhost:8088/upload/20211222/ea01e5ac-6a94-4511-9277-5881483af3b6.png\" /></p>', '39');
INSERT INTO `shangpinxinxi` VALUES ('15', '2102242141233', '可口可乐 Coca-Cola 汽水 碳酸饮料 300ml*24瓶', '3', '/upload/20211222/fe81ea1b-1ade-4655-8eb4-e0156e8f0b5f.png', '46.20', '549', '<p><img src=\"http://img20.360buyimg.com/vc/jfs/t1/77329/5/7770/534247/5d5b6219E5545ca8a/2f9b4f04935c8cb2.jpg\" /></p>', '42');
INSERT INTO `shangpinxinxi` VALUES ('16', '2102242142111', '农夫山泉 NFC果汁饮料 100%NFC橙汁300ml*10瓶', '3', '/upload/20211222/04eeca4c-d849-4731-b494-4efeb85484e4.png', '49.50', '50', '<p><img src=\"http://localhost:8088/upload/20211222/7af5f1fe-c298-40e1-b3c4-d501c25a9165.png\" /></p>', '45');
INSERT INTO `shangpinxinxi` VALUES ('17', '2102242143260', '椰汁正宗椰树牌椰子汁饮料 六连包 245ml*6盒/组', '3', '/upload/20211222/eec3729b-9700-4dcf-8649-59c444162ee2.png', '39.60', '547', '<p><img src=\"http://localhost:8088/upload/20211222/83a6310f-74f4-4771-89e8-adb6a3a5b410.png\" /></p>', '36');
INSERT INTO `shangpinxinxi` VALUES ('18', '122216477809', '测试', '3', '/upload/20211222/0a03c424-2441-4d56-9385-ad4ca8a8da0e.png', '22.00', '5', '<p>XX</p>', '20');

-- ----------------------------
-- Table structure for `xiaoshou`
-- ----------------------------
DROP TABLE IF EXISTS `xiaoshou`;
CREATE TABLE `xiaoshou` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shangpinxinxiid` int(10) unsigned NOT NULL COMMENT '商品信息id',
  `shangpinbianhao` varchar(50) NOT NULL COMMENT '商品编号',
  `shangpinmingcheng` varchar(255) NOT NULL COMMENT '商品名称',
  `fenlei` int(10) unsigned NOT NULL COMMENT '分类',
  `shangpinjiage` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
  `xiaoshoushuliang` int(11) NOT NULL DEFAULT '0' COMMENT '销售数量',
  `xiaoji` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '小计',
  `xiaoshoubeizhu` text NOT NULL COMMENT '销售备注',
  `caozuoren` varchar(50) NOT NULL COMMENT '操作人',
  `addtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`),
  KEY `xiaoshou_shangpinxinxiid_index` (`shangpinxinxiid`),
  KEY `xiaoshou_fenlei_index` (`fenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='销售';

-- ----------------------------
-- Records of xiaoshou
-- ----------------------------
INSERT INTO `xiaoshou` VALUES ('1', '17', '2102242143260', '椰汁正宗椰树牌椰子汁饮料 六连包 245ml*6盒/组', '3', '21.00', '3', '63.00', 'X', 'admin', '2021-12-22 14:41:50');
INSERT INTO `xiaoshou` VALUES ('2', '15', '2102242141233', '可口可乐 Coca-Cola 汽水 碳酸饮料 300ml*24瓶', '3', '38.00', '1', '38.00', 'X', 'admin', '2021-12-22 14:41:52');
INSERT INTO `xiaoshou` VALUES ('3', '8', '2102242131400', '英国DR.WLEN迪王 情侣款牙刷', '2', '15.00', '3', '45.00', 'X', 'admin', '2021-12-22 14:41:55');
INSERT INTO `xiaoshou` VALUES ('4', '5', '2102242127374', '老板仔（Tao Kae Noi）海苔卷原味', '1', '14.00', '10', '140.00', 'X', 'admin', '2021-12-22 14:41:58');
INSERT INTO `xiaoshou` VALUES ('5', '1', '2102242122340', '趣多多 大块巧克力味曲奇饼干', '1', '22.00', '3', '66.00', 'X', 'admin', '2021-12-22 14:45:37');
INSERT INTO `xiaoshou` VALUES ('6', '14', '2102242139333', '荔枝味汽水 碳酸饮料 330ml*24听', '3', '45.00', '6', '270.00', 'X', 'admin', '2021-12-22 14:45:44');
