/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.0.96-community-nt : Database - mycollege
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mycollege` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `mycollege`;

/*Table structure for table `tb_dc` */

CREATE TABLE `tb_dc` (
  `plId` int(255) NOT NULL,
  `userName` varchar(255) collate utf8_bin default NULL,
  `wjId` varchar(255) collate utf8_bin default NULL,
  `plInner` varchar(255) collate utf8_bin default NULL,
  `plTime` date default NULL,
  PRIMARY KEY  (`plId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_dc` */

/*Table structure for table `tb_manage` */

CREATE TABLE `tb_manage` (
  `manageId` int(255) NOT NULL,
  `manageName` varchar(255) collate utf8_bin default NULL,
  `managePassword` varchar(255) collate utf8_bin default NULL,
  `manageQuanXian` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`manageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_manage` */

/*Table structure for table `tb_t` */

CREATE TABLE `tb_t` (
  `tId` int(255) NOT NULL,
  `wjId` varchar(255) collate utf8_bin default NULL,
  `xxId` int(255) NOT NULL,
  `wjType` varchar(255) collate utf8_bin default NULL,
  `tInner` varchar(255) collate utf8_bin default NULL,
  `tBeiZhu` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`tId`,`xxId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_t` */

/*Table structure for table `tb_user` */

CREATE TABLE `tb_user` (
  `userId` int(255) NOT NULL,
  `userName` varchar(255) collate utf8_bin default NULL,
  `userPassword` varchar(255) collate utf8_bin default NULL,
  `userSex` varchar(255) collate utf8_bin default NULL,
  `userPhone` varchar(255) collate utf8_bin default NULL,
  `userAddress` varchar(255) collate utf8_bin default NULL,
  `qx_name` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_user` */

/*Table structure for table `tb_wj` */

CREATE TABLE `tb_wj` (
  `wjId` int(255) NOT NULL,
  `wjName` varchar(255) collate utf8_bin default NULL,
  `wjNum` int(255) default NULL,
  `wjType` varchar(255) collate utf8_bin default NULL,
  `wjBeiZhu` varchar(255) collate utf8_bin default NULL,
  `wjAuthor` varchar(255) collate utf8_bin default NULL,
  `wjTime` date default NULL,
  PRIMARY KEY  (`wjId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_wj` */

/*Table structure for table `tb_xx` */

CREATE TABLE `tb_xx` (
  `xxId` int(255) NOT NULL,
  `tId` int(255) NOT NULL,
  `xxName` varchar(255) collate utf8_bin default NULL,
  `count` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`xxId`,`tId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_xx` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
