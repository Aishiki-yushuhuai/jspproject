/*
 Navicat Premium Data Transfer

 Source Server         : Shelly
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : back

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 31/03/2021 13:24:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for index
-- ----------------------------
DROP TABLE IF EXISTS `index`;
CREATE TABLE `index`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index
-- ----------------------------

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` int(11) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `menuId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (49, 'http://localhost:4413/upload/c85916167614848341.jpg', 'iphone11', '手机', 1, '2021-03-26 20:24:44', 2);
INSERT INTO `info` VALUES (50, 'http://localhost:4413/upload/71d316167614969933.jpg', '库克', 'CEO', 1, '2021-03-26 20:24:56', 3);
INSERT INTO `info` VALUES (51, 'http://localhost:4413/upload/4b3c16167615098720.jpg', '小天才', '培训', 1, '2021-03-26 20:25:09', 4);
INSERT INTO `info` VALUES (54, 'http://localhost:4413/upload/037916169167186864.jpg', '吉林大学', '高校', 1, '2021-03-28 15:31:58', 1);
INSERT INTO `info` VALUES (55, 'http://localhost:4413/upload/aa6216169167666181.jpg', '吉林大学生物与农业工程学院', '高校', 1, '2021-03-28 15:32:46', 1);
INSERT INTO `info` VALUES (56, 'http://localhost:4413/upload/905316169168156343.jpg', '材料科学与工程学院', '实验室', 1, '2021-03-28 15:33:35', 1);
INSERT INTO `info` VALUES (57, 'http://localhost:4413/upload/1d6516169168380130.jpg', '长春工业大学', '高校', 1, '2021-03-28 15:33:58', 1);
INSERT INTO `info` VALUES (58, 'http://localhost:4413/upload/806116169168820014.jpg', '长春理工大学', '高校', 1, '2021-03-28 15:34:42', 1);
INSERT INTO `info` VALUES (59, 'http://localhost:4413/upload/608616169169701594.jpg', '长春大学', '高校', 1, '2021-03-28 15:36:10', 1);
INSERT INTO `info` VALUES (60, 'http://localhost:4413/upload/dbbb16169169934410.jpg', '哈尔滨理工大学', '高校', 1, '2021-03-28 15:36:33', 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '企业资源', '1', '2021-03-24 11:39:11');
INSERT INTO `menu` VALUES (2, '设备资源', '1', '2021-03-24 11:39:30');
INSERT INTO `menu` VALUES (3, '专家资源', '1', '2021-03-24 11:39:30');
INSERT INTO `menu` VALUES (4, '培训资源', '1', '2021-03-24 11:39:30');
INSERT INTO `menu` VALUES (5, '评价资源', '1', '2021-03-24 11:39:30');
INSERT INTO `menu` VALUES (6, '联系我们', '1', '2021-03-24 11:39:30');
INSERT INTO `menu` VALUES (7, '设备资源', '1', '2021-03-24 11:39:30');
INSERT INTO `menu` VALUES (8, '平台动态', '1', '2021-03-24 11:39:30');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` int(11) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `menuId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES (9, 'http://localhost:4413/upload/2cd016169132390350.jpg', 1, '2021-03-28 14:33:59', 7);
INSERT INTO `picture` VALUES (10, 'http://localhost:4413/upload/dccd16169132492902.jpg', 1, '2021-03-28 14:34:09', 7);

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` int(11) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `menuId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (6, 'haohaohao', 13, '2021-03-31 10:59:15', 5);
INSERT INTO `review` VALUES (7, 'haohaohao', 13, '2021-03-31 11:00:18', 5);
INSERT INTO `review` VALUES (8, 'haohaohao', 13, '2021-03-31 11:00:42', 5);
INSERT INTO `review` VALUES (17, 'bucuo', 13, '2021-03-31 12:39:00', 5);
INSERT INTO `review` VALUES (18, 'haohaohao', 13, '2021-03-31 12:42:21', 5);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `menuId` int(11) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '1234567', '1', '2021-03-19 16:35:36', 1, 0, NULL);
INSERT INTO `user` VALUES (11, 'yonghu', '1234567', '1', '2021-03-28 16:48:13', 3, 0, '1234567');
INSERT INTO `user` VALUES (12, 'admin2', '1234567', '1', '2021-03-28 17:05:15', 2, 0, '1234567');
INSERT INTO `user` VALUES (13, 'yonghu2', '1234567', '1', '2021-03-30 15:47:59', 3, 0, '123456789');

-- ----------------------------
-- Table structure for we
-- ----------------------------
DROP TABLE IF EXISTS `we`;
CREATE TABLE `we`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telphone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `person` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menuId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of we
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
