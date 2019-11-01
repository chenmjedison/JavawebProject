/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.0.96-community-nt : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `publicdemoprac`;

/*Table structure for table `dtree` */

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

insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (0,-1,'我的电脑','','','_self','base.gif',NULL);
insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (1,0,'本地文件夹','','','_self','folder.gif','folderopen.gif');
insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (2,0,'我的图片','','','_self','folder.gif','imgfolder.gif');
insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (3,0,'我的音乐','','','_self','folder.gif','musicfolder.gif');
insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (4,1,'我的文档','','','_self','page.gif',NULL);
insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (5,2,'我的旅游','','','_self','folder.gif','folderopen.gif');
insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (6,3,'音乐1','','','_self','page.gif',NULL);
insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (7,5,'图片1','','','_self','page.gif',NULL);
insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (8,5,'图片2','','','_self','page.gif',NULL);
insert  into `dtree`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`iconopen`) values (9,5,'图片3','','','_self','page.gif',NULL);

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  `age` int(3) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`age`) values (1,'小明','666666',28);
insert  into `user`(`id`,`name`,`password`,`age`) values (2,'name0','66660',20);
insert  into `user`(`id`,`name`,`password`,`age`) values (3,'name1','66661',21);
insert  into `user`(`id`,`name`,`password`,`age`) values (4,'name2','66662',22);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
