/*
SQLyog Ultimate v8.32 
MySQL - 5.6.15 : Database - cgim
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cgim` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cgim`;

/*Table structure for table `fun_comment` */

DROP TABLE IF EXISTS `fun_comment`;

CREATE TABLE `fun_comment` (
  `ID` varchar(255) NOT NULL,
  `DYNAMICID` varchar(255) DEFAULT NULL,
  `USERID` int(11) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CONTENT` varchar(255) DEFAULT NULL,
  `REPLY_ID` int(11) DEFAULT NULL,
  `REPLY_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `fun_dynamic` */

DROP TABLE IF EXISTS `fun_dynamic`;

CREATE TABLE `fun_dynamic` (
  `ID` varchar(255) NOT NULL COMMENT '动态id',
  `CREATEUSERID` int(11) DEFAULT NULL COMMENT '创建人id',
  `CREATENAME` varchar(255) DEFAULT NULL COMMENT '创建人名字',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CONTENT` varchar(2000) DEFAULT NULL COMMENT '文本内容',
  `EXTRAS` varchar(255) DEFAULT NULL COMMENT '额外数据',
  `LIKE_USERIDS` varchar(2000) DEFAULT NULL COMMENT '点赞人id',
  `LIKE_NAMES` varchar(2000) DEFAULT NULL COMMENT '点赞人名字',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `fun_signinfo` */

DROP TABLE IF EXISTS `fun_signinfo`;

CREATE TABLE `fun_signinfo` (
  `SID` varchar(100) NOT NULL,
  `SNAME` varchar(255) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(255) DEFAULT NULL,
  `CREATEUSER` varchar(255) DEFAULT NULL,
  `SCONTENT` varchar(2000) DEFAULT NULL,
  `SADDRESS` varchar(255) DEFAULT NULL,
  `STARTTIME` datetime DEFAULT NULL,
  `ENDTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `fun_signlog` */

DROP TABLE IF EXISTS `fun_signlog`;

CREATE TABLE `fun_signlog` (
  `ID` varchar(100) NOT NULL,
  `SIGNID` varchar(100) DEFAULT NULL,
  `SIGNUSER` varchar(255) DEFAULT NULL,
  `SIGNUSERIMG` varchar(255) DEFAULT NULL,
  `SIGNUSERID` varchar(255) DEFAULT NULL,
  `SIGNTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `im_group` */

DROP TABLE IF EXISTS `im_group`;

CREATE TABLE `im_group` (
  `GID` int(11) NOT NULL AUTO_INCREMENT COMMENT '群组ID',
  `GIMG` varchar(255) DEFAULT NULL COMMENT '群组头像',
  `GNAME` varchar(255) DEFAULT NULL COMMENT '群组名称',
  `MEMBERS` varchar(2000) DEFAULT NULL COMMENT '群组用户',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATEUSERID` int(11) DEFAULT NULL COMMENT '创建用户ID',
  `DESCRIPTION` varchar(500) DEFAULT NULL COMMENT '群组简介',
  `CREATENAME` varchar(255) DEFAULT NULL COMMENT '创建人名称',
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8;

/*Table structure for table `im_message` */

DROP TABLE IF EXISTS `im_message`;

CREATE TABLE `im_message` (
  `MID` varchar(100) NOT NULL COMMENT '消息ID',
  `FROMID` int(11) DEFAULT NULL COMMENT '发送者ID',
  `FROMNAME` varchar(255) DEFAULT NULL COMMENT '发送者名字',
  `FROMTYPE` varchar(255) DEFAULT NULL COMMENT '发送者类型',
  `TARGETID` int(11) DEFAULT NULL COMMENT '目标ID',
  `TARGETNAME` varchar(255) DEFAULT NULL COMMENT '目标名字',
  `TARGETTYPE` varchar(255) DEFAULT NULL COMMENT '目标类型',
  `MSGTEXT` varchar(2000) DEFAULT NULL COMMENT '消息文本',
  `MSGEXTRAS` varchar(1000) DEFAULT NULL COMMENT '消息额外属性',
  `MSGTYPE` varchar(255) DEFAULT NULL COMMENT '消息类型',
  `MSGTIME` datetime DEFAULT NULL COMMENT '消息发送时间',
  PRIMARY KEY (`MID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `im_user` */

DROP TABLE IF EXISTS `im_user`;

CREATE TABLE `im_user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `UIMG` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `NAME` varchar(20) DEFAULT NULL COMMENT '名称',
  `REMARKNAME` varchar(20) DEFAULT NULL COMMENT '备注姓名',
  `PASSWORD` varchar(30) DEFAULT NULL COMMENT '密码',
  `CELLPHONE` varchar(15) DEFAULT NULL COMMENT '手机号',
  `BIRTHDAY` date DEFAULT NULL COMMENT '生日',
  `GENDER` varchar(5) DEFAULT NULL COMMENT '性别',
  `AGE` varchar(5) DEFAULT NULL COMMENT '年龄',
  `ADDRESS` varchar(200) DEFAULT NULL COMMENT '住址',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `HOBBY` varchar(255) DEFAULT NULL COMMENT '爱好',
  `SIGNATURE` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `OFFLINELOGS` text COMMENT '离线消息ids',
  `FRIENDS` varchar(2000) DEFAULT NULL COMMENT '我的好友',
  `GROUPS` varchar(2000) DEFAULT NULL COMMENT '我的群组',
  `TALKLIST` varchar(255) DEFAULT NULL COMMENT '会话列表',
  `ONLINETIME` datetime DEFAULT NULL COMMENT '上线时间',
  `OFFLINETIME` datetime DEFAULT NULL COMMENT '下线时间',
  `SCRAP` varchar(5) DEFAULT NULL COMMENT '该用户是否废弃Y/N',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100010 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
