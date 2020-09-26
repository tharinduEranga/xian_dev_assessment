/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : xian_dev

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 26/09/2020 16:52:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carton
-- ----------------------------
DROP TABLE IF EXISTS `carton`;
CREATE TABLE `carton`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT 0.00,
  `units` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carton
-- ----------------------------
INSERT INTO `carton` VALUES (1, 'Hurricane', 100.00, 12);
INSERT INTO `carton` VALUES (2, 'Horseshoe', 100.00, 12);
INSERT INTO `carton` VALUES (3, 'Galaxy', 100.00, 12);
INSERT INTO `carton` VALUES (4, 'Fitme', 100.00, 12);
INSERT INTO `carton` VALUES (5, 'Navbar', 100.00, 12);
INSERT INTO `carton` VALUES (6, 'Sidebar', 100.00, 12);
INSERT INTO `carton` VALUES (7, 'Branded', 100.00, 12);
INSERT INTO `carton` VALUES (8, 'Black', 100.00, 12);
INSERT INTO `carton` VALUES (9, 'Vegit', 100.00, 12);
INSERT INTO `carton` VALUES (10, 'Legimate', 100.00, 12);
INSERT INTO `carton` VALUES (11, 'Vodka', 100.00, 12);
INSERT INTO `carton` VALUES (12, 'Ranger', 100.00, 12);
INSERT INTO `carton` VALUES (13, 'Cosmo', 100.00, 12);

-- ----------------------------
-- Table structure for price_structure
-- ----------------------------
DROP TABLE IF EXISTS `price_structure`;
CREATE TABLE `price_structure`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `carton_discount` decimal(10, 2) NULL DEFAULT 0.00,
  `count_for_carton_discount` int(11) NOT NULL,
  `single_unit_price_increase` decimal(10, 2) NULL DEFAULT 0.00,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of price_structure
-- ----------------------------
INSERT INTO `price_structure` VALUES (1, 0.10, 3, 1.30);

SET FOREIGN_KEY_CHECKS = 1;
