-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: fogcarport
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `bill_of_materials`
--

DROP TABLE IF EXISTS `bill_of_materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_of_materials` (
                                     `bom_id` int NOT NULL AUTO_INCREMENT,
                                     `material_amount` int NOT NULL,
                                     `material_id` int NOT NULL,
                                     PRIMARY KEY (`bom_id`),
                                     KEY `fk_bill_of_materials_materials1_idx` (`material_id`),
                                     CONSTRAINT `fk_bill_of_materials_materials1` FOREIGN KEY (`material_id`) REFERENCES `materials` (`material_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_of_materials`
--

LOCK TABLES `bill_of_materials` WRITE;
/*!40000 ALTER TABLE `bill_of_materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_of_materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport`
--

DROP TABLE IF EXISTS `carport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport` (
                           `carport_id` int NOT NULL AUTO_INCREMENT,
                           `width_id` int NOT NULL,
                           `length_id` int NOT NULL,
                           `rooftype_id` int NOT NULL,
                           `toolshed_id` int DEFAULT NULL,
                           `order_id` int NOT NULL,
                           PRIMARY KEY (`carport_id`),
                           KEY `fk_carport_carport_width1_idx` (`width_id`),
                           KEY `fk_carport_carport_length1_idx` (`length_id`),
                           KEY `fk_carport_rooftype1_idx` (`rooftype_id`),
                           KEY `fk_carport_toolshed1_idx` (`toolshed_id`),
                           KEY `fk_carport_order1_idx` (`order_id`),
                           CONSTRAINT `fk_carport_carport_length1` FOREIGN KEY (`length_id`) REFERENCES `carport_length` (`carport_length_id`),
                           CONSTRAINT `fk_carport_carport_width1` FOREIGN KEY (`width_id`) REFERENCES `carport_width` (`carport_width_id`),
                           CONSTRAINT `fk_carport_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
                           CONSTRAINT `fk_carport_rooftype1` FOREIGN KEY (`rooftype_id`) REFERENCES `rooftype` (`rooftype_id`),
                           CONSTRAINT `fk_carport_toolshed1` FOREIGN KEY (`toolshed_id`) REFERENCES `toolshed` (`toolshed_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport`
--

LOCK TABLES `carport` WRITE;
/*!40000 ALTER TABLE `carport` DISABLE KEYS */;
/*!40000 ALTER TABLE `carport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport_length`
--

DROP TABLE IF EXISTS `carport_length`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_length` (
                                  `carport_length_id` int NOT NULL,
                                  `carport_length_cm` int NOT NULL,
                                  PRIMARY KEY (`carport_length_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_length`
--

LOCK TABLES `carport_length` WRITE;
/*!40000 ALTER TABLE `carport_length` DISABLE KEYS */;
INSERT INTO `carport_length` VALUES (1,240),(2,270),(3,300),(4,330),(5,360),(6,390),(7,420),(8,450),(9,480),(10,510),(11,540),(12,570),(13,600);
/*!40000 ALTER TABLE `carport_length` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport_width`
--

DROP TABLE IF EXISTS `carport_width`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_width` (
                                 `carport_width_id` int NOT NULL AUTO_INCREMENT,
                                 `carport_width_cm` int NOT NULL,
                                 PRIMARY KEY (`carport_width_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_width`
--

LOCK TABLES `carport_width` WRITE;
/*!40000 ALTER TABLE `carport_width` DISABLE KEYS */;
INSERT INTO `carport_width` VALUES (1,240),(2,270),(3,300),(4,330),(5,360),(6,390),(7,420),(8,450),(9,480),(10,510),(11,540),(12,570),(13,600),(14,630),(15,660),(16,690),(17,720),(18,750),(19,780);
/*!40000 ALTER TABLE `carport_width` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
                             `material_id` int NOT NULL,
                             `material_description` varchar(45) NOT NULL,
                             `material_guidance` varchar(45) NOT NULL,
                             `material_category` varchar(45) NOT NULL,
                             `material_unit` varchar(45) NOT NULL,
                             `material_length` int NOT NULL,
                             `material_price` int NOT NULL,
                             PRIMARY KEY (`material_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
                         `order_id` int NOT NULL AUTO_INCREMENT,
                         `user_id` int NOT NULL,
                         `order_date` datetime NOT NULL,
                         `order_price` int NOT NULL,
                         `order_status` tinyint NOT NULL,
                         `bom_id` int NOT NULL,
                         PRIMARY KEY (`order_id`),
                         KEY `fk_order_user_idx` (`user_id`),
                         KEY `fk_order_bill_of_materials1_idx` (`bom_id`),
                         CONSTRAINT `fk_order_bill_of_materials1` FOREIGN KEY (`bom_id`) REFERENCES `bill_of_materials` (`bom_id`),
                         CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooftype`
--

DROP TABLE IF EXISTS `rooftype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooftype` (
                            `rooftype_id` int NOT NULL AUTO_INCREMENT,
                            `roof_name` varchar(45) NOT NULL,
                            PRIMARY KEY (`rooftype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooftype`
--

LOCK TABLES `rooftype` WRITE;
/*!40000 ALTER TABLE `rooftype` DISABLE KEYS */;
INSERT INTO `rooftype` VALUES (1,'Plasttrapezplader');
/*!40000 ALTER TABLE `rooftype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toolshed`
--

DROP TABLE IF EXISTS `toolshed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toolshed` (
                            `toolshed_id` int NOT NULL AUTO_INCREMENT,
                            `toolshed_width_id` int NOT NULL,
                            `toolshed_length_id` int NOT NULL,
                            PRIMARY KEY (`toolshed_id`),
                            KEY `fk_toolshed_toolshed_length1_idx` (`toolshed_length_id`),
                            KEY `fk_toolshed_toolshed_width1_idx` (`toolshed_width_id`),
                            CONSTRAINT `fk_toolshed_toolshed_length1` FOREIGN KEY (`toolshed_length_id`) REFERENCES `toolshed_length` (`toolshed_length_id`),
                            CONSTRAINT `fk_toolshed_toolshed_width1` FOREIGN KEY (`toolshed_width_id`) REFERENCES `toolshed_width` (`toolshed_width_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toolshed`
--

LOCK TABLES `toolshed` WRITE;
/*!40000 ALTER TABLE `toolshed` DISABLE KEYS */;
/*!40000 ALTER TABLE `toolshed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toolshed_length`
--

DROP TABLE IF EXISTS `toolshed_length`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toolshed_length` (
                                   `toolshed_length_id` int NOT NULL AUTO_INCREMENT,
                                   `toolshed_length_cm` int NOT NULL,
                                   PRIMARY KEY (`toolshed_length_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toolshed_length`
--

LOCK TABLES `toolshed_length` WRITE;
/*!40000 ALTER TABLE `toolshed_length` DISABLE KEYS */;
INSERT INTO `toolshed_length` VALUES (1,150),(2,180),(3,210),(4,240),(5,270),(6,300),(7,330),(8,360),(9,390),(10,420),(11,450),(12,480),(13,510),(14,540),(15,570),(16,600),(17,630),(18,660),(19,690);
/*!40000 ALTER TABLE `toolshed_length` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toolshed_width`
--

DROP TABLE IF EXISTS `toolshed_width`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toolshed_width` (
                                  `toolshed_width_id` int NOT NULL,
                                  `toolshed_width_cm` int NOT NULL,
                                  PRIMARY KEY (`toolshed_width_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toolshed_width`
--

LOCK TABLES `toolshed_width` WRITE;
/*!40000 ALTER TABLE `toolshed_width` DISABLE KEYS */;
INSERT INTO `toolshed_width` VALUES (1,210),(2,240),(3,270),(4,300),(5,330),(6,360),(7,390),(8,420),(9,450),(10,480),(11,510),(12,540),(13,570),(14,600),(15,630),(16,660),(17,690),(18,720);
/*!40000 ALTER TABLE `toolshed_width` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `user_id` int NOT NULL AUTO_INCREMENT,
                        `email` varchar(45) NOT NULL,
                        `password` varchar(45) NOT NULL,
                        `name` varchar(45) NOT NULL,
                        `address` varchar(45) NOT NULL,
                        `city` varchar(45) NOT NULL,
                        `zipcode` int NOT NULL,
                        `phone_number` int NOT NULL,
                        `balance` int NOT NULL DEFAULT '50000',
                        `role` varchar(45) NOT NULL DEFAULT 'customer',
                        PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-05 10:55:03
