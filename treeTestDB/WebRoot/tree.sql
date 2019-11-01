/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.0.96-community-nt : Database - tree
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tree` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `tree`;

/*Table structure for table `dtree` */

DROP TABLE IF EXISTS `dtree`;

CREATE TABLE `dtree` (
  `id` int(11) NOT NULL default '0',
  `pid` int(11) NOT NULL default '-1',
  `name` varchar(50) NOT NULL,
  `url` varchar(50) default '',
  `title` varchar(50) default '',
  `target` varchar(50) default '_self',
  `icon` varchar(50) default NULL,
  `iconopen` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dtree` */

insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (0,-1,'我的电脑','','','_self','base.gif',NULL),(1,0,'本地文件夹','','','_self','folder.gif','folderopen.gif'),(2,0,'我的图片','','','_self','folder.gif','imgfolder.gif'),(3,0,'我的音乐','','','_self','folder.gif','musicfolder.gif'),(4,1,'我的文档','','','_self','page.gif',NULL),(5,2,'我的旅游','','','_self','folder.gif','folderopen.gif'),(6,3,'音乐1','','','_self','page.gif',NULL),(7,5,'图片1','','','_self','page.gif',NULL),(8,5,'图片2','','','_self','page.gif',NULL),(9,5,'图片3','','','_self','page.gif',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
