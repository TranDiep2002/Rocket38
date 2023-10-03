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
-- Table structure for table `salary_detail_type`
--

DROP TABLE IF EXISTS `salary_detail_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_detail_type` (
  `satpID` int(11) NOT NULL,
  `satpName` varchar(20) DEFAULT NULL,
  `cre` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`satpID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_detail_type`
--

LOCK TABLES `salary_detail_type` WRITE;
/*!40000 ALTER TABLE `salary_detail_type` DISABLE KEYS */;
INSERT INTO `salary_detail_type` VALUES (1,'luong chinh','2023-09-27 08:00:00','2023-09-27 08:30:00'),(2,'phu cap','2023-09-27 09:00:00','2023-09-27 09:30:00'),(3,'luong phu','2023-09-27 10:00:00','2023-09-27 10:30:00'),(4,'Type D','2023-09-27 11:00:00','2023-09-27 11:30:00'),(5,'Type E','2023-09-27 12:00:00','2023-09-27 12:30:00'),(6,'Type F','2023-09-27 13:00:00','2023-09-27 13:30:00'),(7,'Type G','2023-09-27 14:00:00','2023-09-27 14:30:00'),(8,'Type H','2023-09-27 15:00:00','2023-09-27 15:30:00'),(9,'Type I','2023-09-27 16:00:00','2023-09-27 16:30:00'),(10,'Type J','2023-09-27 17:00:00','2023-09-27 17:30:00');
/*!40000 ALTER TABLE `salary_detail_type` ENABLE KEYS */;
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