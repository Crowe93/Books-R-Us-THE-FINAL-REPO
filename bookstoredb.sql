-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstoredb
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) DEFAULT NULL COMMENT 'Holds name of books author',
  `publisher` varchar(100) DEFAULT NULL COMMENT 'Holds name of book publisher',
  `genre` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL COMMENT 'Holds year book written',
  `price` double DEFAULT NULL COMMENT 'Holds book price',
  `stock` int(11) DEFAULT NULL COMMENT 'Holds current amount in inventory',
  `sold` int(11) DEFAULT NULL COMMENT 'Holds number sold',
  `imgURL` varchar(100) DEFAULT NULL,
  `minimum` int(11) DEFAULT '2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'test','test','test','test',1999,10,5,0,'https://cdn.vox-cdn.com/uploads/chorus_asset/file/8552631/leather_book_preview.png',3),(2,'The Kite Runner','Khaled Hosseini','Riverhead Books','Drama',2003,15,5,0,'https://upload.wikimedia.org/wikipedia/en/6/62/Kite_runner.jpg',3),(3,'Hitchhiker\'s Guide To The Galaxy','Douglas Adams','Pan Books','Science Fiction',1979,15,5,0,'https://images-na.ssl-images-amazon.com/images/I/A1HGWCA36hL.jpg',3),(4,'Lord of the Rings: The Fellowship of the Ring','J. R. R. Tolkien','Allen & Unwin','Fantasy',1954,15,5,0,'https://images-na.ssl-images-amazon.com/images/I/41kUPvqlguL.jpg',3),(6,'Lord of the Rings: The Two Towers','J. R. R. Tolkien','Allen & Unwin','Fantasy',1954,15,5,0,'https://images-na.ssl-images-amazon.com/images/I/41cnYEiew3L._SX304_BO1,204,203,200_.jpg',3),(7,'Lord of the Rings: The Return of the King','J. R. R. Tolkien','Allen & Unwin','Fantasy',1955,15,5,0,'https://i.stack.imgur.com/071TF.jpg',3),(8,'A Tale of Two Cities','Charles Dickens','Signet Classics','History',1859,12,5,0,'http://images.gr-assets.com/books/1410762334l/135625.jpg',2),(9,'The Adventures of Sherlock Holmes','Arthur Conan Doyle','George Newnes','Mystery',1892,12,5,0,'http://t2.gstatic.com/images?q=tbn:ANd9GcStWjErePCa5zwizPuciyRBDXWQY8fHKcyvrzegbxAdcA8ZN5ms',2),(10,'The Hunt for Red October','Tom Clancy','Naval Institute Press','Action',1984,12,5,0,'http://t2.gstatic.com/images?q=tbn:ANd9GcR0r7EouCdLxXfyIUU1QCGGKrGrh7v35ACAqXLz0hoTjaEtQ5gI',2),(11,'The Handmaid\'s Tale','Margaret Atwood','McClelland and Stewart','Science Fiction',1985,15,5,0,'https://images-na.ssl-images-amazon.com/images/I/41aPpkv7ZjL._SY346_.jpg',2),(12,'A Dirty Job','Christopher Moore','Harper Collins','Comedy',2006,12,5,0,'http://ecx.images-amazon.com/images/I/51Afkc1pDEL._SX329_BO1,204,203,200_.jpg',2);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booksales`
--

DROP TABLE IF EXISTS `booksales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booksales` (
  `book_id` int(11) NOT NULL COMMENT 'Foreign Key, Reference book(id)',
  `numSold` int(11) DEFAULT NULL COMMENT 'Number of specified book sold',
  `validDate` date DEFAULT NULL COMMENT 'Date on which sales took place',
  KEY `book_id_idx` (`book_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booksales`
--

LOCK TABLES `booksales` WRITE;
/*!40000 ALTER TABLE `booksales` DISABLE KEYS */;
/*!40000 ALTER TABLE `booksales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_id_uses_user.id_idx` (`user_id`),
  CONSTRAINT `FK_user_id_uses_user.id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dayreport`
--

DROP TABLE IF EXISTS `dayreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dayreport` (
  `validDate` date DEFAULT NULL COMMENT 'Day these transactions took place',
  `netTotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dayreport`
--

LOCK TABLES `dayreport` WRITE;
/*!40000 ALTER TABLE `dayreport` DISABLE KEYS */;
/*!40000 ALTER TABLE `dayreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `book_id` int(11) NOT NULL,
  `genre` varchar(45) DEFAULT NULL,
  KEY `book_id_idx` (`book_id`),
  CONSTRAINT `genre_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `cart_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `qty` varchar(45) DEFAULT NULL,
  KEY `book_FK_01_idx` (`book_id`),
  KEY `cart_FK_01_idx` (`cart_id`),
  CONSTRAINT `cart_FK_01` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pastorder`
--

DROP TABLE IF EXISTS `pastorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pastorder` (
  `orderNum` varchar(100) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pastorder`
--

LOCK TABLES `pastorder` WRITE;
/*!40000 ALTER TABLE `pastorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `pastorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `user_id` int(11) NOT NULL,
  `cardNum` varchar(16) NOT NULL,
  `expDate` varchar(7) DEFAULT NULL,
  `csc` varchar(3) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `billingAddr` varchar(100) DEFAULT NULL,
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `id` int(11) NOT NULL,
  `discount` float NOT NULL,
  `expiration` date NOT NULL,
  `code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publishersales`
--

DROP TABLE IF EXISTS `publishersales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publishersales` (
  `publisher_id` int(11) NOT NULL,
  `numSold` int(11) DEFAULT NULL,
  `netTotal` double DEFAULT NULL,
  `validDate` date NOT NULL,
  KEY `publisher_id_idx` (`publisher_id`),
  CONSTRAINT `publisher_id` FOREIGN KEY (`publisher_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishersales`
--

LOCK TABLES `publishersales` WRITE;
/*!40000 ALTER TABLE `publishersales` DISABLE KEYS */;
/*!40000 ALTER TABLE `publishersales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shippinginfo`
--

DROP TABLE IF EXISTS `shippinginfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shippinginfo` (
  `user_id` int(11) NOT NULL,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shippinginfo`
--

LOCK TABLES `shippinginfo` WRITE;
/*!40000 ALTER TABLE `shippinginfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `shippinginfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Chris','Rowe','ccr','pass','ccr@uga.edu',0),(4,'Michael','Tostenson','mat','pass','mat@uga.edu',0),(8,'Justin','Chiu','jmc','pass','jmc@uga.edu',0),(9,'Eric','Holbrook','ebh','pass','ebh@uga.edu',0),(10,'Chanice','Campbell','cmc','pass','cmc@uga.edu',0),(11,'BookStore','Owner','admin','admin','admin@bookstore.com',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bookstoredb'
--

--
-- Dumping routines for database 'bookstoredb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-25 21:16:31
