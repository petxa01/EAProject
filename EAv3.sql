CREATE DATABASE  IF NOT EXISTS `ea` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ea`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ea
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Category` varchar(45) NOT NULL,
  `IdCard` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Game','Enterprise',''),(2,'MediaMarkt','Enterprise',''),(3,'Juan','Customer',''),(4,'James','Customer','');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `developers`
--

DROP TABLE IF EXISTS `developers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `developers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdCard` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Surname` varchar(45) NOT NULL,
  `Salary` float NOT NULL,
  `Job` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IdCard_UNIQUE` (`IdCard`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developers`
--

LOCK TABLES `developers` WRITE;
/*!40000 ALTER TABLE `developers` DISABLE KEYS */;
INSERT INTO `developers` VALUES (1,'12345678A','Mario','Garcia',2000,' Junior developer','Spain'),(2,'12345678B','Josu','lazpita',2500,'Menu Manager','Spain'),(3,'11111111','Peter','Parker',3000,'Graphic Asistant','USA'),(4,'22222222','Clark','Kent',2000,'Junior developer','USA');
/*!40000 ALTER TABLE `developers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `develops`
--

DROP TABLE IF EXISTS `develops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `develops` (
  `DeveloperId` int(11) NOT NULL,
  `GameId` int(11) NOT NULL,
  `Finished` tinyint(4) NOT NULL,
  PRIMARY KEY (`DeveloperId`,`GameId`),
  KEY `Games_idx` (`GameId`),
  CONSTRAINT `Developers-develops` FOREIGN KEY (`DeveloperId`) REFERENCES `developers` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Games-develops` FOREIGN KEY (`GameId`) REFERENCES `games` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `develops`
--

LOCK TABLES `develops` WRITE;
/*!40000 ALTER TABLE `develops` DISABLE KEYS */;
INSERT INTO `develops` VALUES (1,1,1),(1,2,1),(1,3,1),(2,1,1),(2,2,1),(2,3,1),(3,6,1),(3,7,1),(3,8,0),(4,15,1),(4,16,0);
/*!40000 ALTER TABLE `develops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `divisions`
--

DROP TABLE IF EXISTS `divisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `divisions` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `divisions`
--

LOCK TABLES `divisions` WRITE;
/*!40000 ALTER TABLE `divisions` DISABLE KEYS */;
INSERT INTO `divisions` VALUES (3,'EA Maxis'),(4,'EA Play'),(2,'EA Sports'),(1,'EA Worldwide Stdios');
/*!40000 ALTER TABLE `divisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `franchises`
--

DROP TABLE IF EXISTS `franchises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `franchises` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `StudioId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name_UNIQUE` (`Name`),
  KEY `Studios_idx` (`StudioId`),
  CONSTRAINT `Studios` FOREIGN KEY (`StudioId`) REFERENCES `studios` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `franchises`
--

LOCK TABLES `franchises` WRITE;
/*!40000 ALTER TABLE `franchises` DISABLE KEYS */;
INSERT INTO `franchises` VALUES (11,'Burnout',1),(12,'Need For Speed',1),(13,'Battlefield',2),(14,'Medal Of Honor',2),(15,'NBA',3),(16,'Madden NFL',3),(17,'FIFA',4),(18,'Sims',5),(19,'Flight Control',6),(20,'Need For Speed Mobile',6);
/*!40000 ALTER TABLE `franchises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Genre` varchar(45) NOT NULL,
  `Price` float NOT NULL,
  `FranchiseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Franchises_idx` (`FranchiseId`),
  CONSTRAINT `Franchises` FOREIGN KEY (`FranchiseId`) REFERENCES `franchises` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,'Burnout','Racing',15,11),(2,'Burnout 2: Point of Impact','Racing',20,11),(3,'Burnout 3: Takedown','Racing',24.99,11),(4,'Need For Speed: Most Wanted','Racing',5,12),(5,'Need For Speed: Underground','Racing',5,12),(6,'Battlefield 3','Shooter',19.95,13),(7,'Battlefield 4','Shooter',4.98,13),(8,'Battlefield 1','Shooter',19.97,13),(9,'Medal Of Honor','Shooter',9.95,14),(10,'Medal Of Honor Airbone','Shooter',4.95,14),(11,'2K18','Sports',39.95,15),(12,'2K17','Sports',19.95,15),(13,'Madden NFL 18','Sports',69.95,16),(14,'Madden NFL 17','Sports',39.95,16),(15,'FIFA 18','Sports',54.95,17),(16,'FIFA 17','Sports',24.95,17),(17,'The SIMS 4','Simulation',39.95,18),(18,'The SIMS 4: Cats & Dogs ','Simulation',39.95,18),(19,'Flight Control','Time management',0.99,19),(20,'Need For Speed No Limits','Racing',0,20);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Quantity` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `GameId` int(11) DEFAULT NULL,
  `ClientId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Games_idx` (`GameId`),
  KEY `Clients_idx` (`ClientId`),
  CONSTRAINT `Clients` FOREIGN KEY (`ClientId`) REFERENCES `clients` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Games` FOREIGN KEY (`GameId`) REFERENCES `games` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,300,'2016-11-22',7,1),(2,300,'2016-11-22',7,2),(3,1,'2017-06-04',7,3),(4,1,'2015-01-06',1,4);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studios`
--

DROP TABLE IF EXISTS `studios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studios` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  `DivisionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name_UNIQUE` (`Name`),
  KEY `Division_idx` (`DivisionId`),
  CONSTRAINT `Division` FOREIGN KEY (`DivisionId`) REFERENCES `divisions` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studios`
--

LOCK TABLES `studios` WRITE;
/*!40000 ALTER TABLE `studios` DISABLE KEYS */;
INSERT INTO `studios` VALUES (1,'Criterion Games','UK',1),(2,'DICE','USA',1),(3,'EA Tiburon','USA',2),(4,'EA Canada','Canada',2),(5,'The Sims Studio','USA',3),(6,'Firemonkeys Studios','Australia',3),(7,'EA Mobile','USA',4);
/*!40000 ALTER TABLE `studios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ea'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-08 13:47:27
