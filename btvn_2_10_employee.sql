-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: btvn_2_10
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employID` int NOT NULL AUTO_INCREMENT,
  `employLastName` varchar(30) DEFAULT NULL,
  `employFirstName` varchar(30) DEFAULT NULL,
  `employHireDate` date DEFAULT NULL,
  `emploStatus` varchar(30) DEFAULT NULL,
  `supervisorID` int DEFAULT NULL,
  `socialNumber` int DEFAULT NULL,
  PRIMARY KEY (`employID`),
  KEY `pk_manager` (`supervisorID`),
  CONSTRAINT `pk_manager` FOREIGN KEY (`supervisorID`) REFERENCES `employee` (`employID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Nguyen','Hoa','2021-01-15','Active',NULL,123456789),(2,'Tran','Nam','2020-05-20','Active',NULL,987654321),(3,'Le','An','2022-03-10','Active',1,456789123),(4,'Pham','Van','2019-11-08','Active',2,789123456),(5,'Vo','Mai','2020-09-25','Active',1,321654987),(6,'Do','Duc','2021-07-17','Active',3,654789321),(7,'Ho','Thao','2020-02-12','Active',2,987321654),(8,'Nguyen','Tuan','2022-06-30','Active',1,789654321),(9,'Tran','Lan','2019-04-03','Active',4,456987123),(10,'Le','Phat','2021-08-21','Active',3,123987456);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-04  0:52:30
