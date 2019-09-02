/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : qm_bbs

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-09-02 19:02:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member_type
-- ----------------------------
DROP TABLE IF EXISTS `member_type`;
CREATE TABLE `member_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grade` tinyint(4) NOT NULL DEFAULT '1' COMMENT '等级',
  `grade_name` varchar(255) NOT NULL DEFAULT '' COMMENT '等级名称',
  `grade_alias` varchar(255) DEFAULT NULL COMMENT '等级别名',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否被删除0否1是',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最新修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员等级表';

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` longtext COMMENT '内容',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `comment_count` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `collect_count` int(11) NOT NULL DEFAULT '0' COMMENT '被收藏次数',
  `view_count` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `top` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否置顶0否 1是',
  `good` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为热帖0否 1是',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `wechat` varchar(255) DEFAULT NULL COMMENT '微信号',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq号码',
  `upload_img_ids` varchar(255) DEFAULT '' COMMENT '图片地址列表id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最新修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否被删除0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户帖';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  `avatar` varchar(1000) DEFAULT NULL COMMENT '头像地址',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
  `mobile` varchar(255) DEFAULT NULL COMMENT '电话',
  `website` varchar(255) DEFAULT NULL COMMENT '来源站点',
  `bio` varchar(1000) DEFAULT NULL COMMENT 'bio',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  `in_time` datetime NOT NULL COMMENT '注册时间',
  `token` varchar(255) NOT NULL DEFAULT '' COMMENT 'token',
  `telegram_name` varchar(255) DEFAULT NULL COMMENT '发送邮件名称',
  `email_notification` bit(1) NOT NULL DEFAULT b'0' COMMENT '邮箱提醒',
  `active` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否激活用户',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否被删除0：未删除 1：删除',
  `is_member` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为会员0：否 1：是',
  `member_type_id` tinyint(4) NOT NULL DEFAULT '0' COMMENT '会员等级',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';
