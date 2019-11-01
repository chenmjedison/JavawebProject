/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.0.96-community-nt : Database - entertaiment
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`entertaiment` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `entertaiment`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(255) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`password`) values (1,'1','1');

/*Table structure for table `admin_backup` */

DROP TABLE IF EXISTS `admin_backup`;

CREATE TABLE `admin_backup` (
  `id` int(255) NOT NULL default '0',
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_backup` */

insert  into `admin_backup`(`id`,`username`,`password`) values (1,'1','1');

/*Table structure for table `admin_backup_table_strutcture` */

DROP TABLE IF EXISTS `admin_backup_table_strutcture`;

CREATE TABLE `admin_backup_table_strutcture` (
  `id` int(255) NOT NULL default '0',
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_backup_table_strutcture` */

/*Table structure for table `files` */

DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `id` int(255) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `lastModified` varchar(255) default NULL,
  `size` int(255) default NULL,
  `hits` int(255) default NULL,
  `type` char(1) default NULL,
  `description` mediumtext,
  `filePath` varchar(255) default NULL,
  `fileName` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `files` */

insert  into `files`(`id`,`name`,`lastModified`,`size`,`hits`,`type`,`description`,`filePath`,`fileName`) values (14,'测试6','2018-09-30 18:02:12',7007,0,'5','测试6','/software/1538301732372.html','activity-add.html'),(17,'绽放的花','2019-06-18 12:21:12',97280,4,'5','廖永清','/software/1560831672761.doc','廖咏晴—Java开发工程师.doc'),(18,'简历1111','2019-06-18 14:47:19',31744,1,'5','简历1111111','/software/1560840439511.doc','汪丽华的简历 (1).doc'),(19,'廖永清','2019-06-18 14:48:52',97280,3,'5','廖永清的简历','/software/1560840532634.doc','廖咏晴—Java开发工程师.doc'),(20,'陈明剑的简历','2019-06-18 14:50:02',170883,2,'1','陈明剑的简历11111','/software/1560840602207.docx','陈明剑-JavaWeb开发工程师190618.docx'),(21,'项目bug笔记','2019-06-18 14:51:43',13824,2,'1','项目bug笔记，记录bug','/software/1560840703638.docx','项目bug笔记.docx'),(22,'111','2019-06-18 17:27:11',142937,1,'1','11111','/software/1560850031066.jpg','cbd.jpg'),(23,'22222','2019-06-18 17:28:02',2440594,1,'4','222222','/software/1560850082433.mp4','面试视频.mp4'),(24,'33333','2019-06-18 17:28:59',11187715,1,'3','3333333','/software/1560850139333.mp3','朴树 - 平凡之路(电影版).mp3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
