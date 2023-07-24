/*
 Navicat Premium Data Transfer

 Source Server         : vm
 Source Server Type    : MySQL
 Source Server Version : 80024 (8.0.24)
 Source Host           : 10.0.0.2:3306
 Source Schema         : parkingmanage

 Target Server Type    : MySQL
 Target Server Version : 80024 (8.0.24)
 File Encoding         : 65001

 Date: 05/07/2023 15:26:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_card
-- ----------------------------
DROP TABLE IF EXISTS `t_card`;
CREATE TABLE `t_card`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `car_num` int NULL DEFAULT NULL,
  `open_date` datetime NULL DEFAULT NULL,
  `start_date` datetime NULL DEFAULT NULL,
  `card_day` int NULL DEFAULT 0 COMMENT '0 启用 1 禁用',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `park_id` int NULL DEFAULT NULL,
  `other` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `left_day` int NULL DEFAULT NULL COMMENT '剩余时间',
  `status` int NULL DEFAULT NULL COMMENT '0 正常 1 不正常',
  `deleted` int NULL DEFAULT 0 COMMENT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_card
-- ----------------------------
INSERT INTO `t_card` VALUES (10, 12312, '2023-07-05 06:14:48', '2023-07-04 06:13:02', 180, '2023-07-05 06:14:48', '2023-07-05 06:17:21', NULL, '车票号12312的半年卡', 179, 0, 0);
INSERT INTO `t_card` VALUES (11, 99999, '2023-07-05 06:20:54', '2023-07-04 06:20:26', 60, '2023-07-05 06:20:54', '2023-07-05 06:40:08', NULL, '2月卡', 59, 0, 0);
INSERT INTO `t_card` VALUES (12, 55555, '2023-07-05 06:29:42', '2022-06-30 16:00:00', 128, '2023-07-05 06:29:42', '2023-07-05 06:40:32', NULL, '过期卡', -241, 1, 0);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `car_num` int NULL DEFAULT NULL,
  `card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `park_time` float NULL DEFAULT NULL,
  `payment` int NULL DEFAULT NULL,
  `pay_way` int NULL DEFAULT NULL,
  `car_statu` int NULL DEFAULT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `park_id` int NULL DEFAULT NULL,
  `verification_code` int NULL DEFAULT NULL,
  `deleted` int NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (7, 67676, '0', 67, 40, 2, 0, 'shouyin', 1, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (8, 12312, '10', 30, 2, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (9, 23347, '0', 171, 22, 1, 1, 'shouyin', 1, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (10, 30123, '0', 140, 60, 1, 2, 'shouyin', 3, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (11, 56124, '0', 58, 58, 1, 2, 'shouyin', 3, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (12, 57101, '0', 33, 86, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (13, 99999, '0', 90, 21, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (14, 72843, '0', 172, 36, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (15, 12312, '10', 144, 88, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (16, 72843, '0', 140, 61, 2, 2, 'shouyin', 3, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (17, 12312, '10', 109, 72, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (18, 12312, '10', 43, 99, 0, 0, 'shouyin', 1, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (19, 99999, '0', 134, 73, 0, 1, 'shouyin', 3, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (20, 12312, '10', 95, 65, 2, 0, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (21, 12312, '10', 169, 45, 1, 0, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (22, 76094, '0', 30, 49, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (23, 12312, '10', 145, 66, 0, 1, 'shouyin', 1, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (24, 18077, '0', 71, 29, 0, 2, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (25, 72843, '0', 71, 30, 0, 0, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (26, 12312, '10', 168, 79, 0, 2, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (27, 43560, '0', 106, 50, 2, 2, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (28, 99999, '0', 118, 67, 2, 1, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (29, 71432, '0', 176, 8, 1, 0, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (30, 23347, '0', 48, 42, 2, 0, 'shouyin', 4, NULL, 0, '2023-07-01 14:59:37', '2023-07-01 14:59:37');
INSERT INTO `t_order` VALUES (31, 55861, '0', 169, 16, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (32, 30123, '0', 74, 99, 1, 1, 'shouyin', 1, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (33, 57101, '0', 177, 8, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (34, 12312, '10', 87, 39, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (35, 12312, '10', 52, 85, 1, 2, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (36, 12312, '10', 121, 59, 1, 0, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (37, 79698, '0', 72, 66, 2, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (38, 66290, '0', 107, 35, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (39, 12312, '10', 23, 29, 1, 2, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (40, 23347, '0', 89, 45, 0, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (41, 66290, '0', 83, 39, 2, 2, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (42, 44321, '0', 67, 73, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (43, 99999, '0', 169, 58, 2, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (44, 66290, '0', 144, 64, 0, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (45, 55861, '0', 48, 81, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (46, 55861, '0', 74, 64, 1, 0, 'shouyin', 1, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (47, 99999, '0', 42, 88, 0, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (48, 55861, '0', 98, 23, 0, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (49, 30123, '0', 162, 87, 2, 0, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (50, 71432, '0', 33, 35, 1, 2, 'shouyin', 1, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (51, 12312, '10', 178, 99, 0, 0, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (52, 79698, '0', 34, 98, 1, 0, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (53, 18077, '0', 159, 56, 1, 2, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (54, 12312, '10', 94, 35, 2, 0, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (55, 79698, '0', 110, 8, 2, 2, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (56, 12312, '10', 115, 73, 0, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (57, 55861, '0', 77, 63, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (58, 12312, '10', 19, 61, 2, 0, 'shouyin', 1, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (59, 76094, '0', 69, 51, 0, 0, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (60, 99999, '0', 26, 35, 2, 0, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (61, 99999, '0', 121, 78, 0, 0, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (62, 99999, '0', 47, 100, 0, 1, 'shouyin', 1, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (63, 55861, '0', 39, 78, 2, 1, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (64, 12312, '10', 141, 26, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (65, 18077, '0', 116, 42, 1, 2, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (66, 72843, '0', 176, 65, 0, 2, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (67, 44321, '0', 31, 40, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (68, 76094, '0', 175, 37, 0, 0, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (69, 18077, '0', 26, 34, 2, 1, 'shouyin', 4, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (70, 80797, '0', 17, 22, 0, 0, 'shouyin', 3, NULL, 0, '2023-07-02 14:59:37', '2023-07-02 14:59:37');
INSERT INTO `t_order` VALUES (71, 43560, '0', 120, 78, 1, 2, 'shouyin', 3, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (72, 12312, '10', 164, 36, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (73, 12312, '10', 136, 40, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (74, 99999, '0', 172, 0, 0, 0, 'shouyin', 3, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (75, 43560, '0', 112, 1, 0, 0, 'shouyin', 4, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (76, 12312, '10', 85, 59, 1, 1, 'shouyin', 1, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (77, 12312, '10', 84, 83, 1, 0, 'shouyin', 4, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (78, 71432, '0', 146, 34, 0, 1, 'shouyin', 3, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (79, 72843, '0', 64, 12, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (80, 72843, '0', 165, 91, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (81, 12312, '10', 18, 81, 2, 1, 'shouyin', 1, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (82, 44321, '0', 124, 54, 2, 1, 'shouyin', 3, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (83, 18077, '0', 128, 26, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (84, 99999, '0', 160, 72, 2, 1, 'shouyin', 1, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (85, 12312, '10', 171, 28, 2, 2, 'shouyin', 3, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (86, 56124, '0', 42, 29, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (87, 99999, '0', 101, 28, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (88, 56124, '0', 151, 73, 1, 1, 'shouyin', 1, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (89, 43560, '0', 64, 42, 2, 2, 'shouyin', 4, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (90, 99999, '0', 119, 32, 1, 2, 'shouyin', 3, NULL, 0, '2023-07-03 14:59:37', '2023-07-03 14:59:37');
INSERT INTO `t_order` VALUES (91, 12312, '10', 146, 63, 2, 0, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (92, 23347, '0', 56, 85, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (93, 56124, '0', 51, 59, 1, 2, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (94, 66290, '0', 168, 84, 2, 1, 'shouyin', 3, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (95, 79698, '0', 69, 59, 0, 2, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (96, 99999, '0', 20, 85, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (97, 99999, '0', 19, 40, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (98, 18077, '0', 19, 45, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (99, 66290, '0', 21, 70, 2, 1, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (100, 12312, '10', 168, 26, 2, 2, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (101, 12312, '10', 147, 6, 0, 0, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (102, 55861, '0', 72, 34, 1, 2, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (103, 79698, '0', 127, 92, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (104, 56124, '0', 55, 13, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (105, 44321, '0', 108, 41, 1, 2, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (106, 57101, '0', 44, 27, 0, 0, 'shouyin', 1, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (107, 72843, '0', 146, 86, 2, 1, 'shouyin', 3, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (108, 44321, '0', 167, 19, 2, 0, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (109, 76094, '0', 70, 69, 2, 1, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (110, 72843, '0', 104, 38, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (111, 18077, '0', 140, 22, 1, 2, 'shouyin', 3, NULL, 0, '2023-07-04 14:59:37', '2023-07-04 14:59:37');
INSERT INTO `t_order` VALUES (112, 12312, '10', 180, 64, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (113, 66290, '0', 25, 80, 1, 0, 'shouyin', 3, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (114, 12312, '10', 132, 59, 2, 2, 'shouyin', 3, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (115, 12312, '10', 120, 22, 0, 1, 'shouyin', 3, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (116, 56124, '0', 100, 75, 0, 1, 'shouyin', 4, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (117, 12312, '10', 166, 32, 1, 0, 'shouyin', 4, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (118, 12312, '10', 40, 15, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (119, 76094, '0', 32, 33, 1, 0, 'shouyin', 1, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (120, 12312, '10', 28, 21, 2, 1, 'shouyin', 3, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (121, 12312, '10', 145, 15, 1, 0, 'shouyin', 3, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (122, 30123, '0', 86, 49, 1, 1, 'shouyin', 3, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (123, 18077, '0', 145, 10, 2, 2, 'shouyin', 4, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (124, 12312, '10', 32, 67, 1, 0, 'shouyin', 4, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (125, 99999, '0', 35, 12, 2, 2, 'shouyin', 1, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (126, 12312, '10', 18, 22, 2, 1, 'shouyin', 4, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');
INSERT INTO `t_order` VALUES (127, 80797, '0', 31, 47, 1, 1, 'shouyin', 4, NULL, 0, '2023-07-05 14:59:37', '2023-07-05 14:59:37');

-- ----------------------------
-- Table structure for t_park
-- ----------------------------
DROP TABLE IF EXISTS `t_park`;
CREATE TABLE `t_park`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `park_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `park_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `park_status` int NULL DEFAULT NULL COMMENT '状态 0 正常 1 停止',
  `park_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `free_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '首免时间',
  `class_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '阶级时间',
  `max_money` double NULL DEFAULT NULL COMMENT '封顶金额',
  `class_money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '阶级时间',
  `play_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  `park_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `people_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `park_other` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deleted` int NULL DEFAULT 0 COMMENT '0 未删除 1 删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_park
-- ----------------------------
INSERT INTO `t_park` VALUES (1, '金融港A1', '金融港A1负一层', 0, '0', '30', '20', 99, '20', '0', '联系人甲', '15541245781', 'beizhu', 0, '2023-07-03 07:19:19', '2023-07-03 07:19:19');
INSERT INTO `t_park` VALUES (2, '金融港A2', '金融港A2负一层', 1, '0', '30', '15', 200, '20', '0', '联系人乙', '15541245781', '备注', 0, '2023-07-03 07:19:19', '2023-07-03 07:19:19');
INSERT INTO `t_park` VALUES (3, '金融港A4', '金融港A4负一层', 0, '2', '10', '20', 20, '10', '0', '联系人3', '15541245781', '测试测试', 0, '2023-07-03 07:19:19', '2023-07-03 07:19:19');
INSERT INTO `t_park` VALUES (4, '金融港B27', '金融港B27负一层', 0, '0', '15', '15', 49, '15', '0', '联系人4', '15541245781', '欢迎光临', 0, '2023-07-03 07:19:19', '2023-07-03 07:19:19');
INSERT INTO `t_park` VALUES (6, '测试', '金融港x路', 0, '1', '60', '30', 100, '10', '1', 'ceshi-man', '13200000000', '一个备注', 0, '2023-07-05 06:12:14', '2023-07-05 06:12:14');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `deleted` int NULL DEFAULT 0 COMMENT '默认  0 未删除 1删除',
  `status` int NULL DEFAULT 0 COMMENT '0 启用 1 禁用',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'shouyin', '$2a$10$t9txVRBURgeEb72OaDu7G.jE07GwYVuYeBRuD5Ra85udlEt5bhNyK', 0, 0, '2023-07-03 21:03:41', '2023-07-03 21:03:41', '15011111111');
INSERT INTO `t_user` VALUES (2, 'admin', '$2a$10$t9txVRBURgeEb72OaDu7G.jE07GwYVuYeBRuD5Ra85udlEt5bhNyK', 0, 0, '2023-07-03 21:06:22', '2023-07-03 21:06:22', '15022222222');

SET FOREIGN_KEY_CHECKS = 1;
