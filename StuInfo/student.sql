/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.0.96-community-nt : Database - student
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`student` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `student`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `cid` varchar(255) collate utf8_bin NOT NULL,
  `coursename` varchar(255) collate utf8_bin default NULL,
  `coursehours` varchar(255) collate utf8_bin default NULL,
  `credit` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `course` */

insert  into `course`(`cid`,`coursename`,`coursehours`,`credit`) values ('1000','中文','32','16'),('1001','数学','32','16'),('1002','英语','32','16'),('1003','计算机科学','32','16'),('1004','java程序设计','32','16'),('1005','C#程序设计','32','16'),('1006','c语言程序设计','32','16'),('1007','C++语言程序设计','32','16');

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `sid` varchar(255) collate utf8_bin NOT NULL,
  `cid` varchar(255) collate utf8_bin NOT NULL,
  `score` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`sid`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `score` */

insert  into `score`(`sid`,`cid`,`score`) values ('1000','1000','70'),('1000','1001','55'),('1000','1002','72'),('1000','1003','59'),('1000','1004','68'),('1000','1005','67'),('1000','1006','73'),('1000','1007','70'),('1001','1000','70'),('1001','1001','71'),('1001','1002','72'),('1001','1003','73'),('1001','1004','69'),('1001','1005','68'),('1001','1006','67'),('1002','1000','70'),('1002','1001','69'),('1002','1002','68'),('1002','1003','67'),('1002','1004','71'),('1002','1005','72'),('1002','1006','73');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` varchar(255) collate utf8_bin NOT NULL,
  `name` varchar(255) collate utf8_bin default NULL,
  `sex` varchar(255) collate utf8_bin default NULL,
  `age` varchar(255) collate utf8_bin default NULL,
  `entrancetime` date default NULL,
  `major` varchar(255) collate utf8_bin default NULL,
  `class` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `student` */

insert  into `student`(`sid`,`name`,`sex`,`age`,`entrancetime`,`major`,`class`) values ('1000','张三','男','19','2019-04-12','软件工程','一年级'),('1001','张三1','男','20','2019-04-12','软件工程','一年级'),('1002','张三2','男','15','2019-04-12','软件工程','一年级'),('1003','张三3','男','16','2019-04-12','软件工程','一年级'),('1004','张三4','男','17','2019-04-12','软件工程','一年级'),('1005','张三5','男','18','2019-04-12','软件工程','一年级'),('1006','张三6','女','14','2019-04-12','软件工程','一年级'),('1007','张三7','女','17','2019-04-12','物联网','一年级'),('1008','张三','女','17','2019-04-12','电子信息','一年级');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
