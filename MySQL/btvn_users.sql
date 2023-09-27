-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: btvn
-- ------------------------------------------------------
-- Server version	5.7.43-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `usID` int(11) NOT NULL,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `employeeID` varchar(10) DEFAULT NULL,
  `avatar` text,
  `departmentID` int(11) DEFAULT NULL,
  `gender` tinyint(10) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `create_At` datetime DEFAULT NULL,
  `update_At` datetime DEFAULT NULL,
  PRIMARY KEY (`usID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'tran','diep','a@gmail.com','0372667573','a','anh',1,1,21,'2019-02-09 00:00:00','2023-09-08 00:00:00'),(2,'le','vu','v@gmail.com','0908716543','b','file',1,0,23,'2008-09-08 00:00:00','2023-10-09 00:00:00'),(3,'nguyen','bang','b@gmail.com','0987654312','c','anh',1,0,30,'2009-08-07 00:00:00','2023-07-09 00:00:00'),(4,'vu','thuong','c@gmail.com','0908765423','d','anh',1,1,23,'2000-09-08 00:00:00','2023-06-07 00:00:00'),(5,'pham','phuong','d@gmail.com','0897654712','e','file',1,1,21,'2000-08-07 00:00:00','2023-01-02 00:00:00'),(6,'nguyen','van','e@gmail.com','0987654123','f','anh',2,0,34,'1999-09-08 00:00:00','2022-09-15 00:00:00'),(7,'tran','lan','f@gmail.com','0908567234','g','anh',2,1,25,'2000-09-08 00:00:00','2023-08-01 00:00:00'),(8,'nguyen','duy','g@gmail.com','0908556325','h','file',2,0,40,'1998-08-07 00:00:00','2023-09-07 00:00:00'),(9,'tran','mai','h@gmail.com','09374724276','i','anh',2,1,36,'1998-10-09 00:00:00','2023-09-18 00:00:00'),(10,'hoang','long','i@gmail.com','09347867754','k','anh',2,0,28,'1998-11-10 00:00:00','2023-12-01 00:00:00');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-27 16:31:49
