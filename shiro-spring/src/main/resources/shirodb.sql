

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS shirodb CHARACTER SET = utf8;
-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `pid` char(4) NOT NULL COMMENT '权限ID',
  `perms_type` varchar(32) NOT NULL COMMENT '权限类型',
  `perms_name` varchar(32) NOT NULL COMMENT '权限名称',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态 1:启用 0:禁用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_permission` (`pid`, `perms_type`, `perms_name`, `status`, `create_time`, `update_time`) VALUES ('3000', '*', '超级权限', '1', '2023-03-11 22:16:54', '2023-03-11 22:16:57');
INSERT INTO `t_permission` (`pid`, `perms_type`, `perms_name`, `status`, `create_time`, `update_time`) VALUES ('3001', 'user:query', '用户查询权限', '1', '2023-03-11 22:18:06', '2023-03-11 22:18:45');
INSERT INTO `t_permission` (`pid`, `perms_type`, `perms_name`, `status`, `create_time`, `update_time`) VALUES ('3002', 'user:insert', '用户插入权限', '1', '2023-03-11 22:19:07', '2023-03-11 22:19:10');
INSERT INTO `t_permission` (`pid`, `perms_type`, `perms_name`, `status`, `create_time`, `update_time`) VALUES ('3003', 'user:update', '用户更新权限', '1', '2023-03-11 22:19:40', '2023-03-11 22:19:43');
INSERT INTO `t_permission` (`pid`, `perms_type`, `perms_name`, `status`, `create_time`, `update_time`) VALUES ('3004', 'user:delete', '用户删除权限', '1', '2023-03-11 22:20:03', '2023-03-11 22:20:05');
COMMIT;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `rid` char(4) NOT NULL COMMENT '角色ID',
  `role_type` varchar(32) NOT NULL COMMENT '角色类型',
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态 1:启用 0:禁用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` (`rid`, `role_type`, `role_name`, `status`, `create_time`, `update_time`) VALUES ('2000', 'admin', '超级管理员', '1', '2023-03-11 22:12:25', '2023-03-11 22:12:28');
INSERT INTO `t_role` (`rid`, `role_type`, `role_name`, `status`, `create_time`, `update_time`) VALUES ('2001', 'manager', '经理', '1', '2023-03-11 22:15:19', '2023-03-11 22:15:21');
COMMIT;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` char(4) NOT NULL COMMENT '角色ID',
  `pid` char(4) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_role_permission` (`id`, `rid`, `pid`) VALUES (1, '2000', '3000');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `login_name` varchar(32) NOT NULL COMMENT '登录名',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '用户密码',
  `salt` varchar(100) NOT NULL COMMENT '加密盐值',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态 1:启用 0:禁用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` (`uid`, `login_name`, `username`, `password`, `salt`, `status`, `create_time`, `update_time`) VALUES (1000, 'admin', '超级管理员', 'VkbQvv0zBAEU5a6R2XlxAQ==', 'dbb9a7bd-3cad-4b18-8158-863bb2b3d760', '1', '2023-03-11 22:21:15', '2023-03-11 22:21:17');
INSERT INTO `t_user` (`uid`, `login_name`, `username`, `password`, `salt`, `status`, `create_time`, `update_time`) VALUES (1001, 'jack', '杰克', 'VkbQvv0zBAEU5a6R2XlxAQ==', 'dbb9a7bd-3cad-4b18-8158-863bb2b3d760', '1', '2023-03-12 21:48:40', '2023-03-12 21:48:40');
COMMIT;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(4) NOT NULL COMMENT '用户ID',
  `rid` char(4) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` (`id`, `uid`, `rid`) VALUES (1, '1000', '2000');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
