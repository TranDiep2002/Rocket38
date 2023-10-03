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
-- Table structure for table `work_done`
--

DROP TABLE IF EXISTS `work_done`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_done` (
  `workID` int NOT NULL AUTO_INCREMENT,
  `employID` int DEFAULT NULL,
  `pro_mdID` int DEFAULT NULL,
  `workdate` date DEFAULT NULL,
  `workdescription` varchar(30) DEFAULT NULL,
  `workstatus` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`workID`),
  KEY `employID` (`employID`),
  KEY `pro_mdID` (`pro_mdID`),
  CONSTRAINT `work_done_ibfk_1` FOREIGN KEY (`employID`) REFERENCES `employee` (`employID`),
  CONSTRAINT `work_done_ibfk_2` FOREIGN KEY (`pro_mdID`) REFERENCES `project_modules` (`Pro_MdID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_done`
--

LOCK TABLES `work_done` WRITE;
/*!40000 ALTER TABLE `work_done` DISABLE KEYS */;
INSERT INTO `work_done` VALUES (1,1,1,'2023-12-01','Work 1 Description','Completed'),(2,2,2,'2023-10-25','Work 2 Description','In Progress'),(3,3,3,'2023-10-20','Work 3 Description','Not Started'),(4,4,4,'2023-10-20','Work 4 Description','Completed'),(5,5,5,'2023-10-05','Work 5 Description','In Progress'),(6,1,6,'2023-09-29','Work 6 Description','Not Started'),(7,2,7,'2023-08-29','Work 7 Description','Completed'),(8,3,8,'2023-08-25','Work 8 Description','In Progress'),(9,4,9,'2023-07-10','Work 9 Description','Not Started'),(10,5,10,'2023-08-08','Work 10 Description','Completed'),(11,6,10,'2023-12-01','Work 11 Description','Completed'),(12,7,7,'2023-10-25','Work 12 Description','In Progress'),(13,9,5,'2023-10-20','Work 13 Description','Not Started'),(14,8,8,'2023-10-20','Work 14 Description','Completed'),(15,10,9,'2023-10-05','Work 15 Description','In Progress'),(16,1,6,'2023-09-29','Work 16 Description','Not Started'),(17,2,7,'2023-08-29','Work 17 Description','Completed'),(18,3,8,'2023-08-25','Work 18 Description','In Progress'),(19,4,9,'2023-07-10','Work 19 Description','Not Started'),(20,5,10,'2023-08-08','Work 20 Description','Completed');
/*!40000 ALTER TABLE `work_done` ENABLE KEYS */;
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
