 CREATE TABLE `auctions` (
  `name` varchar(30) DEFAULT NULL,
  `start_bid` int DEFAULT NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `min_bid_inc` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `index1` (`start_time`),
  KEY `index2` (`end_time`));

   CREATE TABLE `users` (
  `name` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `phone` char(10) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`));

   CREATE TABLE `auction_items` (
  `id` int NOT NULL,
  `item_id` int NOT NULL,
  `auction_id` int NOT NULL,
  `last_bid_user` varchar(40) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `auction_id` (`auction_id`),
  KEY `last_bid_user` (`last_bid_user`),
  CONSTRAINT `auction_items_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`),
  CONSTRAINT `auction_items_ibfk_2` FOREIGN KEY (`auction_id`) REFERENCES `auctions` (`id`),
  CONSTRAINT `auction_items_ibfk_3` FOREIGN KEY (`last_bid_user`) REFERENCES `users` (`username`));

 CREATE TABLE `items` (
  `id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `owner` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `owner` (`owner`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `users` (`username`));