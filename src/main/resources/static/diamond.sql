-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: diamond
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clarity_master`
--

DROP TABLE IF EXISTS `clarity_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clarity_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `clarity` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clarity_master`
--

LOCK TABLES `clarity_master` WRITE;
/*!40000 ALTER TABLE `clarity_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `clarity_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color_master`
--

DROP TABLE IF EXISTS `color_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `color` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_master`
--

LOCK TABLES `color_master` WRITE;
/*!40000 ALTER TABLE `color_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `color_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cut_master`
--

DROP TABLE IF EXISTS `cut_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cut_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cut` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cut_master`
--

LOCK TABLES `cut_master` WRITE;
/*!40000 ALTER TABLE `cut_master` DISABLE KEYS */;
INSERT INTO `cut_master` VALUES (1,'EX'),(2,'VG'),(3,'G');
/*!40000 ALTER TABLE `cut_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fluorescence_master`
--

DROP TABLE IF EXISTS `fluorescence_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fluorescence_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fluorescence` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fluorescence_master`
--

LOCK TABLES `fluorescence_master` WRITE;
/*!40000 ALTER TABLE `fluorescence_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `fluorescence_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_master`
--

DROP TABLE IF EXISTS `lab_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `lab_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_master`
--

LOCK TABLES `lab_master` WRITE;
/*!40000 ALTER TABLE `lab_master` DISABLE KEYS */;
INSERT INTO `lab_master` VALUES (1,'IGI'),(2,'GIA'),(3,'HRD');
/*!40000 ALTER TABLE `lab_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_master`
--

DROP TABLE IF EXISTS `location_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `location` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_master`
--

LOCK TABLES `location_master` WRITE;
/*!40000 ALTER TABLE `location_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_status_master`
--

DROP TABLE IF EXISTS `payment_status_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_status_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_status_master`
--

LOCK TABLES `payment_status_master` WRITE;
/*!40000 ALTER TABLE `payment_status_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_status_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `polish_master`
--

DROP TABLE IF EXISTS `polish_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `polish_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `polish` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polish_master`
--

LOCK TABLES `polish_master` WRITE;
/*!40000 ALTER TABLE `polish_master` DISABLE KEYS */;
INSERT INTO `polish_master` VALUES (1,'EX'),(2,'VG'),(3,'G');
/*!40000 ALTER TABLE `polish_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shape_master`
--

DROP TABLE IF EXISTS `shape_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shape_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `shape_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shape_master`
--

LOCK TABLES `shape_master` WRITE;
/*!40000 ALTER TABLE `shape_master` DISABLE KEYS */;
INSERT INTO `shape_master` VALUES (1,'Round'),(2,'Oval'),(3,'Pear'),(4,'Princess'),(5,'Emerald');
/*!40000 ALTER TABLE `shape_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stones`
--

DROP TABLE IF EXISTS `stones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stones` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `kapan` varchar(50) DEFAULT NULL,
  `lot_no` varchar(50) DEFAULT NULL,
  `shape_id` bigint DEFAULT NULL,
  `weight_ct` decimal(10,2) DEFAULT NULL,
  `color_id` bigint DEFAULT NULL,
  `clarity_id` bigint DEFAULT NULL,
  `cut_id` bigint DEFAULT NULL,
  `polish_id` bigint DEFAULT NULL,
  `symmetry_id` bigint DEFAULT NULL,
  `fluorescence_id` bigint DEFAULT NULL,
  `lab_id` bigint DEFAULT NULL,
  `cert_no` varchar(100) DEFAULT NULL,
  `per_carat` decimal(12,2) DEFAULT NULL,
  `total_carat` decimal(12,2) DEFAULT NULL,
  `rate` decimal(12,2) DEFAULT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  `brokerage` decimal(12,2) DEFAULT NULL,
  `final_amount` decimal(12,2) DEFAULT NULL,
  `payment_status_id` bigint DEFAULT NULL,
  `sell_date` date DEFAULT NULL,
  `payment_done_date` date DEFAULT NULL,
  `location_id` bigint DEFAULT NULL,
  `terms_id` bigint DEFAULT NULL,
  `party_name` varchar(100) DEFAULT NULL,
  `broker_name` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `cut_id` (`cut_id`),
  KEY `polish_id` (`polish_id`),
  KEY `symmetry_id` (`symmetry_id`),
  KEY `fluorescence_id` (`fluorescence_id`),
  KEY `location_id` (`location_id`),
  KEY `terms_id` (`terms_id`),
  KEY `idx_shape` (`shape_id`),
  KEY `idx_color` (`color_id`),
  KEY `idx_clarity` (`clarity_id`),
  KEY `idx_lab` (`lab_id`),
  KEY `idx_payment` (`payment_status_id`),
  CONSTRAINT `stones_ibfk_1` FOREIGN KEY (`shape_id`) REFERENCES `shape_master` (`id`),
  CONSTRAINT `stones_ibfk_10` FOREIGN KEY (`location_id`) REFERENCES `location_master` (`id`),
  CONSTRAINT `stones_ibfk_11` FOREIGN KEY (`terms_id`) REFERENCES `terms_master` (`id`),
  CONSTRAINT `stones_ibfk_2` FOREIGN KEY (`color_id`) REFERENCES `color_master` (`id`),
  CONSTRAINT `stones_ibfk_3` FOREIGN KEY (`clarity_id`) REFERENCES `clarity_master` (`id`),
  CONSTRAINT `stones_ibfk_4` FOREIGN KEY (`cut_id`) REFERENCES `cut_master` (`id`),
  CONSTRAINT `stones_ibfk_5` FOREIGN KEY (`polish_id`) REFERENCES `polish_master` (`id`),
  CONSTRAINT `stones_ibfk_6` FOREIGN KEY (`symmetry_id`) REFERENCES `symmetry_master` (`id`),
  CONSTRAINT `stones_ibfk_7` FOREIGN KEY (`fluorescence_id`) REFERENCES `fluorescence_master` (`id`),
  CONSTRAINT `stones_ibfk_8` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`),
  CONSTRAINT `stones_ibfk_9` FOREIGN KEY (`payment_status_id`) REFERENCES `payment_status_master` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stones`
--

LOCK TABLES `stones` WRITE;
/*!40000 ALTER TABLE `stones` DISABLE KEYS */;
/*!40000 ALTER TABLE `stones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `symmetry_master`
--

DROP TABLE IF EXISTS `symmetry_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `symmetry_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `symmetry` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symmetry_master`
--

LOCK TABLES `symmetry_master` WRITE;
/*!40000 ALTER TABLE `symmetry_master` DISABLE KEYS */;
INSERT INTO `symmetry_master` VALUES (1,'EX'),(2,'VG'),(3,'G');
/*!40000 ALTER TABLE `symmetry_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terms_master`
--

DROP TABLE IF EXISTS `terms_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `terms_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `terms_name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terms_master`
--

LOCK TABLES `terms_master` WRITE;
/*!40000 ALTER TABLE `terms_master` DISABLE KEYS */;
INSERT INTO `terms_master` VALUES (1,'Cash',NULL),(2,'7 Days',NULL),(3,'15 Days',NULL),(4,'30 Days',NULL);
/*!40000 ALTER TABLE `terms_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-30 19:17:57
