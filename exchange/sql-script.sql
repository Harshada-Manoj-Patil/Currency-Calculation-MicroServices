CREATE DATABASE  IF NOT EXISTS `currency_directory`;
USE `currency_directory`;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;

CREATE TABLE `currency` (
  `id` int NOT NULL AUTO_INCREMENT,
  `from` varchar(45) DEFAULT NULL,
  `to` varchar(45) DEFAULT NULL ,
  `rate` DOUBLE(10, 2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `currency`
--

INSERT INTO `currency` VALUES
	(1,'SGD','INR', 60.0 ),
	(2,'SGD','AUD', 1.1 ),
	(3,'AUD','INR', 55.0 ),
	(4,'AUD','SGD', 0.99),
	(5,'USD','SGD',1.5 );
