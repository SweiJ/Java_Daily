/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : secsys

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 03/06/2022 16:02:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客户姓名',
  `customer_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客户电话',
  `price` decimal(10, 2) NOT NULL COMMENT '订单价格',
  `create_time` datetime(0) NOT NULL COMMENT '订单创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES (2, '张三', '12345678910', 50.56, '2020-11-02 14:02:40');
INSERT INTO `data` VALUES (3, '张三', '12345678910', 50.56, '2020-11-02 14:02:40');
INSERT INTO `data` VALUES (4, '李四', '12345678910', 80.73, '2020-11-02 14:04:29');
INSERT INTO `data` VALUES (5, '李四', '12345678910', 80.73, '2020-11-02 14:04:37');
INSERT INTO `data` VALUES (6, '李四', '12345678910', 80.73, '2020-11-02 14:04:38');
INSERT INTO `data` VALUES (7, '王五', '12345678910', 66.55, '2020-11-02 14:06:26');
INSERT INTO `data` VALUES (8, '王五', '12345678910', 66.55, '2020-11-02 14:06:14');
INSERT INTO `data` VALUES (9, '王五', '12345678910', 66.55, '2020-11-02 14:06:31');
INSERT INTO `data` VALUES (10, '赵六', '12345678910', 95.00, '2020-11-02 14:07:16');
INSERT INTO `data` VALUES (11, '赵六', '12345678910', 95.00, '2020-11-02 14:07:17');
INSERT INTO `data` VALUES (12, '赵六', '12345678910', 95.00, '2020-11-02 14:07:17');
INSERT INTO `data` VALUES (13, '孙七', '12345678910', 100.00, '2020-11-02 14:08:46');
INSERT INTO `data` VALUES (14, '孙七', '12345678910', 100.00, '2020-11-02 14:08:46');
INSERT INTO `data` VALUES (15, '孙七', '12345678910', 100.00, '2020-11-02 14:08:47');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '路径',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `type` tinyint(255) UNSIGNED NOT NULL COMMENT '类型。0为菜单，1为接口',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, '/user/account', '账户管理', 0);
INSERT INTO `resource` VALUES (2, '/user/role', '角色管理', 0);
INSERT INTO `resource` VALUES (3, '/data', '数据管理', 0);
INSERT INTO `resource` VALUES (1001, 'POST:/sec/user', '新增用户', 1);
INSERT INTO `resource` VALUES (1002, 'DELETE:/sec/user', '删除用户', 1);
INSERT INTO `resource` VALUES (1003, 'PUT:/sec/user', '编辑用户', 1);
INSERT INTO `resource` VALUES (1004, 'GET:/sec/user/test/{id}', '用于演示路径参数', 1);
INSERT INTO `resource` VALUES (1005, 'GET:/sec/test', '用于测试', 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (2, '数据管理员');
INSERT INTO `role` VALUES (1, '超级管理员');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `resource_id` bigint(20) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`role_id`, `resource_id`) USING BTREE,
  INDEX `resource_id`(`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-权限关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES (1, 1);
INSERT INTO `role_resource` VALUES (2, 1);
INSERT INTO `role_resource` VALUES (1, 2);
INSERT INTO `role_resource` VALUES (1, 3);
INSERT INTO `role_resource` VALUES (2, 3);
INSERT INTO `role_resource` VALUES (1, 1001);
INSERT INTO `role_resource` VALUES (1, 1002);
INSERT INTO `role_resource` VALUES (1, 1003);
INSERT INTO `role_resource` VALUES (2, 1003);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$NCGG/cowi3kUWOqCSqSR1.BM4V1SbsyUxduCNyFqKdOVHEsKK03VS');
INSERT INTO `user` VALUES (2, 'user1', '$2a$10$z07BJCu67TKadCXuC8jjUOZpsJgpCDotnMnvll0NDdwitW5C/enqq');
INSERT INTO `user` VALUES (3, 'user2', '$2a$10$3PLj2SAGSQ/iy6M8xk8QHOFVMmnvUVMp3/E55ochQKGYV.E6y9ULm');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
