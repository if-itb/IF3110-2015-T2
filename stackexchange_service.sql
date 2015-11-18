-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: localhost    Database: stackexchange_service
-- ------------------------------------------------------
-- Server version	5.6.24

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
  `a_id` int(7) NOT NULL AUTO_INCREMENT,
  `u_id` int(7) NOT NULL,
  `content` text NOT NULL,
  `vote` int(10) NOT NULL DEFAULT '0',
  `date_created` datetime NOT NULL,
  `q_id` int(10) NOT NULL,
  PRIMARY KEY (`a_id`),
  KEY `u_id` (`u_id`),
  KEY `q_id` (`q_id`),
  CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE,
  CONSTRAINT `answer_ibfk_2` FOREIGN KEY (`q_id`) REFERENCES `question` (`q_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` (`a_id`, `u_id`, `content`, `vote`, `date_created`, `q_id`) VALUES
(1, 1, 'Tralala', 1, '2015-11-17 17:15:35', 2),
(2, 1, 'syubidam', -1, '2015-11-17 17:16:55', 2),
(7, 1, 'Coba lagi', 2, '2015-11-17 19:20:40', 2),
(9, 1, 'Huff', 3, '2015-11-17 19:41:04', 2),
(11, 1, '1', 0, '2015-11-17 20:18:18', 2),
(12, 1, 'HAIIII', 0, '2015-11-17 20:18:36', 2),
(14, 1, 'Syubidam syalala kita tidak kobam', 0, '2015-11-17 22:46:49', 10),
(16, 1, 'My mama dont like you she likes everyone', 1, '2015-11-17 22:48:51', 11),
(17, 1, 'Test plis bisa', 0, '2015-11-17 23:02:04', 11),
(18, 1, 'Syubidam', 0, '2015-11-18 03:32:21', 2),
(19, 1, 'I left you here', 1, '2015-11-18 03:46:21', 11);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `q_id` int(7) NOT NULL AUTO_INCREMENT,
  `u_id` int(7) NOT NULL,
  `topic` varchar(250) NOT NULL,
  `content` text NOT NULL,
  `vote` int(10) NOT NULL DEFAULT '0',
  `date_created` datetime NOT NULL,
  `date_edited` datetime DEFAULT NULL,
  PRIMARY KEY (`q_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`q_id`, `u_id`, `topic`, `content`, `vote`, `date_created`, `date_edited`) VALUES
(2, 1, 'Siapa Snowball?', 'Snowball adalah salah satu kucing kesayangan', 5, '2015-11-16 22:04:40', NULL),
(10, 1, '2', '2', 0, '2015-11-17 20:04:04', NULL),
(11, 1, '2', '2', 0, '2015-11-17 20:04:08', NULL);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `u_id` int(7) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tifaniwarnita','kucing','Tifani Warnita','tiffayumuyuka@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_answer`
--

DROP TABLE IF EXISTS `vote_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote_answer` (
  `a_id` int(7) NOT NULL,
  `u_id` int(7) NOT NULL,
  `vote` int(1) NOT NULL,
  KEY `a_id` (`a_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `vote_answer_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE,
  CONSTRAINT `vote_answer_ibfk_2` FOREIGN KEY (`a_id`) REFERENCES `answer` (`a_id`) ON DELETE CASCADE
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
  `q_id` int(7) NOT NULL,
  `u_id` int(7) NOT NULL,
  `vote` int(1) NOT NULL,
  KEY `u_id` (`u_id`),
  KEY `q_id` (`q_id`),
  CONSTRAINT `vote_question_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE,
  CONSTRAINT `vote_question_ibfk_2` FOREIGN KEY (`q_id`) REFERENCES `question` (`q_id`) ON DELETE CASCADE
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

-- Dump completed on 2015-11-18 16:26:11
