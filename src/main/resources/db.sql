CREATE DATABASE sql_injection;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_email` (`email`),
  UNIQUE KEY `uni_username` (`username`),
  KEY `id` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `products_name` (`name`)
) ENGINE=InnoDB
