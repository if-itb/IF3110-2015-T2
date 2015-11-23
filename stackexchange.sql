-- MySQL dump 10.13  Distrib 5.6.21, for Win32 (x86)
--
-- Host: localhost    Database: wbd
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `IDAns` int(11) NOT NULL AUTO_INCREMENT,
  `IDQ` int(11) NOT NULL,
  `IDUser` int(11) NOT NULL,
  `Answer` text NOT NULL,
  `Vote` int(11) NOT NULL,
  PRIMARY KEY (`IDAns`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (13,47,1,'ifeoeoefew',0),(14,47,1,'ipefpoiweiofwoeijfpq',0),(15,48,0,'',0),(16,48,0,'asdsadasda',0),(22,51,0,'Bacot',13),(23,51,0,'dasdasdasda',4),(24,51,0,'bacot',8),(25,0,0,'0',0),(26,51,0,'sndandoa',2),(27,51,0,'sndandoa',3);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `IDQ` int(11) NOT NULL AUTO_INCREMENT,
  `IDUser` int(11) NOT NULL,
  `QuestionTopic` varchar(30) NOT NULL,
  `Content` text NOT NULL,
  `Vote` int(6) NOT NULL,
  PRIMARY KEY (`IDQ`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (51,0,'ijoiwqfowqo','oifewoifowefew',13),(53,0,'ijoiwqfowqo','oifewoifowefew',2);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `IDUser` int(11) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(30) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`IDUser`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'','clif','jonathan','santoso','2015-11-23 05:49:51','0000-00-00 00:00:00'),(2,'','mochammad','ginanjar','busiri','2015-11-23 05:49:51','0000-00-00 00:00:00'),(3,'','muhammad','try','yulianto','2015-11-23 05:49:51','0000-00-00 00:00:00'),(4,'','mohammad','aodyra','khaidir','2015-11-23 05:49:51','0000-00-00 00:00:00'),(5,'','Bimo','Aryo','Tyasono','2015-11-23 05:49:51','0000-00-00 00:00:00'),(6,'','lie','albert','tri adrian','2015-11-23 05:49:51','0000-00-00 00:00:00'),(7,'','Chairuni','Aulia','Nusapati','2015-11-23 05:49:51','0000-00-00 00:00:00'),(8,'','Chairuni','Aulia','Nusapati','2015-11-23 05:49:51','0000-00-00 00:00:00'),(9,'','luminto','luhur','chandra','2015-11-23 05:49:51','0000-00-00 00:00:00'),(10,'','asdsada','jonatthan','asdasda','2015-11-23 05:49:51','0000-00-00 00:00:00'),(11,'','asdasggr','jonathan','uykmuju','2015-11-23 05:49:51','0000-00-00 00:00:00'),(12,'','qweqwe','jonathan','hregertr','2015-11-23 05:49:51','0000-00-00 00:00:00'),(13,'','asd','Jonathan','iejiweq','2015-11-23 05:49:51','0000-00-00 00:00:00'),(14,'','yujryjury','Aryo','nbbgfgh','2015-11-23 05:49:51','0000-00-00 00:00:00'),(15,'','dwqdqwijiodqwjoidj','ojoqwjodjewodjoi','ojoiewjfowejfoewf','2015-11-23 05:49:51','0000-00-00 00:00:00'),(16,'','sadasdsadsa','asdadasdasdsa','ChairuniAuliaNusapati','2015-11-23 05:49:51','0000-00-00 00:00:00'),(17,'','raymond','kusuma','kosasih','2015-11-23 05:49:51','0000-00-00 00:00:00'),(18,'','sdjiwdiwj','ieoidoieijewo','iejofiwejoifew','2015-11-23 05:49:51','0000-00-00 00:00:00'),(19,'','bimo','aryo','tyasono','2015-11-23 05:49:51','0000-00-00 00:00:00'),(20,'','owqkeopqwkpewqp','okkqpowrkqpkp','pkpoqkeprkqrer','2015-11-23 05:49:51','0000-00-00 00:00:00'),(21,'','wqdqwidji','iowiejfoiewjofio','jojfoiwefowefew','2015-11-23 05:49:51','0000-00-00 00:00:00'),(22,'','Chaer','chairuni.citata@gmail.com','Syalala','2015-11-23 05:49:51','0000-00-00 00:00:00'),(23,'','saioidsa','fdf','gfgf','2015-11-23 05:49:51','0000-00-00 00:00:00'),(24,'','sadajioda','fdf','dds','2015-11-23 05:49:51','0000-00-00 00:00:00'),(25,'','rioaefiooafo','ioroigierjgojo','irgoierigoirger','2015-11-23 05:49:51','0000-00-00 00:00:00'),(26,'jansdadasjodias','Luminto Luhur','lumintoluhur@hotmail.com','812378','2015-11-23 05:56:15','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_answer`
--

DROP TABLE IF EXISTS `vote_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote_answer` (
  `IDVoteAns` int(11) NOT NULL AUTO_INCREMENT,
  `IDUser` int(11) NOT NULL,
  `IDAns` int(11) NOT NULL,
  PRIMARY KEY (`IDVoteAns`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_answer`
--

LOCK TABLES `vote_answer` WRITE;
/*!40000 ALTER TABLE `vote_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_question`
--

DROP TABLE IF EXISTS `vote_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote_question` (
  `IDVoteQ` int(11) NOT NULL AUTO_INCREMENT,
  `IDUser` int(11) NOT NULL,
  `IDQ` int(11) NOT NULL,
  PRIMARY KEY (`IDVoteQ`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_question`
--

LOCK TABLES `vote_question` WRITE;
/*!40000 ALTER TABLE `vote_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-23 13:18:13
