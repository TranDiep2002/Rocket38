<<<<<<< HEAD
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
-- Table structure for table `project_modules`
--

DROP TABLE IF EXISTS `project_modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_modules` (
  `Pro_MdID` int NOT NULL AUTO_INCREMENT,
  `proID` int DEFAULT NULL,
  `employID` int DEFAULT NULL,
  `pro_mdDate` date DEFAULT NULL,
  `pro_mdComplete` date DEFAULT NULL,
  `pro_mdDescription` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Pro_MdID`),
  KEY `proID` (`proID`),
  KEY `employID` (`employID`),
  CONSTRAINT `project_modules_ibfk_1` FOREIGN KEY (`proID`) REFERENCES `projects` (`proID`) ON DELETE CASCADE,
  CONSTRAINT `project_modules_ibfk_2` FOREIGN KEY (`employID`) REFERENCES `employee` (`employID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_modules`
--

LOCK TABLES `project_modules` WRITE;
/*!40000 ALTER TABLE `project_modules` DISABLE KEYS */;
INSERT INTO `project_modules` VALUES (1,1,1,'2023-11-01','2023-11-30','Module 1 Description'),(2,1,2,'2023-10-15','2023-11-01','Module 2 Description'),(3,2,3,'2023-09-20','2023-09-30','Module 3 Description'),(4,2,4,'2023-10-10','2023-11-03','Module 4 Description'),(5,3,5,'2023-09-05','2023-11-01','Module 5 Description'),(6,3,1,'2023-09-12','2023-10-09','Module 6 Description'),(7,4,2,'2023-08-18','2023-09-01','Module 7 Description'),(8,4,3,'2023-07-25','2023-09-12','Module 8 Description'),(9,5,4,'2023-06-10','2023-07-20','Module 9 Description'),(10,5,5,'2023-07-08','2023-09-01','Module 10 Description');
/*!40000 ALTER TABLE `project_modules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-04  0:52:29
=======
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
-- Table structure for table `project_modules`
--

DROP TABLE IF EXISTS `project_modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_modules` (
  `Pro_MdID` int NOT NULL AUTO_INCREMENT,
  `proID` int DEFAULT NULL,
  `employID` int DEFAULT NULL,
  `pro_mdDate` date DEFAULT NULL,
  `pro_mdComplete` date DEFAULT NULL,
  `pro_mdDescription` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Pro_MdID`),
  KEY `proID` (`proID`),
  KEY `employID` (`employID`),
  CONSTRAINT `project_modules_ibfk_1` FOREIGN KEY (`proID`) REFERENCES `projects` (`proID`) ON DELETE CASCADE,
  CONSTRAINT `project_modules_ibfk_2` FOREIGN KEY (`employID`) REFERENCES `employee` (`employID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_modules`
--

LOCK TABLES `project_modules` WRITE;
/*!40000 ALTER TABLE `project_modules` DISABLE KEYS */;
INSERT INTO `project_modules` VALUES (1,1,1,'2023-11-01','2023-11-30','Module 1 Description'),(2,1,2,'2023-10-15','2023-11-01','Module 2 Description'),(3,2,3,'2023-09-20','2023-09-30','Module 3 Description'),(4,2,4,'2023-10-10','2023-11-03','Module 4 Description'),(5,3,5,'2023-09-05','2023-11-01','Module 5 Description'),(6,3,1,'2023-09-12','2023-10-09','Module 6 Description'),(7,4,2,'2023-08-18','2023-09-01','Module 7 Description'),(8,4,3,'2023-07-25','2023-09-12','Module 8 Description'),(9,5,4,'2023-06-10','2023-07-20','Module 9 Description'),(10,5,5,'2023-07-08','2023-09-01','Module 10 Description');
/*!40000 ALTER TABLE `project_modules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-04  0:52:29
>>>>>>> bc9758d11b8d846e8c67eb2ebe2df2ba5ba21009
