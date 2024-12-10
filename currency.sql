CREAcurrencyTE DATABASE  IF NOT EXISTS `currency_directory`;
USE `currency_directory`;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;

CREATE TABLE `currency` (
  `id` int NOT NULL AUTO_INCREMENT,
  `to` varchar(5) DEFAULT NULL,
  `from` varchar(5) DEFAULT NULL ,
  `rate` DOUBLE(10,2) DEFAULT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--


INSERT INTO `currency` VALUES
	(1,'SGD','INR',65.0),
	(2,'SGD','AUD', 1.1 ),
	(3,'SGD','USD' , 1.9),
	(4,'SGD','PWD' ,2.1),
	(5,'INR','SGD',0.03 ),
	(6,'INR','AUD',0.05 );
