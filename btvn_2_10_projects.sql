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
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `proID` int NOT NULL AUTO_INCREMENT,
  `employID` int DEFAULT NULL,
  `proName` varchar(30) DEFAULT NULL,
  `proStartDate` date DEFAULT NULL,
  `proDescription` varchar(30) DEFAULT NULL,
  `proDetail` varchar(30) DEFAULT NULL,
  `proConplete` date DEFAULT NULL,
  PRIMARY KEY (`proID`),
  KEY `employID` (`employID`),
  CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`employID`) REFERENCES `employee` (`employID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,1,'Project 1','2023-10-01','Description 1','Details 1','2024-01-06'),(2,2,'Project 2','2023-09-15','Description 2','Details 2','2023-12-04'),(3,3,'Project 3','2023-08-20','Description 3','Details 3','2024-10-11'),(4,4,'Project 4','2023-07-10','Description 4','Details 4','2023-10-10'),(5,5,'Project 5','2023-06-05','Description 5','Details 5','2023-10-09'),(6,1,'Project 6','2023-05-12','Description 6','Details 6','2023-08-18'),(7,2,'Project 7','2023-04-18','Description 7','Details 7','2023-12-19'),(8,3,'Project 8','2023-03-25','Description 8','Details 8','2024-01-19'),(9,4,'Project 9','2023-02-10','Description 9','Details 9','2024-10-12'),(10,5,'Project 10','2023-01-08','Description 10','Details 10','2023-10-20');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
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
