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
-- Table structure for table `salary_detail`
--

DROP TABLE IF EXISTS `salary_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_detail` (
  `sadtID` int(11) NOT NULL,
  `amount` double(12,2) DEFAULT NULL,
  `saID` int(11) DEFAULT NULL,
  `satpID` int(11) DEFAULT NULL,
  `operation` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`sadtID`),
  KEY `saID` (`saID`),
  KEY `satpID` (`satpID`),
  CONSTRAINT `salary_detail_ibfk_1` FOREIGN KEY (`saID`) REFERENCES `salary` (`saID`),
  CONSTRAINT `salary_detail_ibfk_2` FOREIGN KEY (`satpID`) REFERENCES `salary_detail_type` (`satpID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_detail`
--

LOCK TABLES `salary_detail` WRITE;
/*!40000 ALTER TABLE `salary_detail` DISABLE KEYS */;
INSERT INTO `salary_detail` VALUES (1,1000.00,1,1,1),(2,1500.50,1,2,2),(3,800.00,2,1,1),(4,1200.75,2,3,2),(5,950.25,3,2,1),(6,2000.00,3,3,2);
/*!40000 ALTER TABLE `salary_detail` ENABLE KEYS */;
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
