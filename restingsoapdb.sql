-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2015 at 08:36 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `restingsoapdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE IF NOT EXISTS `answer` (
  `A_ID` int(3) NOT NULL AUTO_INCREMENT,
  `Q_ID` int(3) NOT NULL,
  `Content` varchar(12000) NOT NULL,
  `Vote` int(3) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `User_ID` int(20) NOT NULL,
  PRIMARY KEY (`A_ID`),
  KEY `Q_ID` (`Q_ID`),
  KEY `User_ID` (`User_ID`),
  KEY `User_ID_2` (`User_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `Q_ID` int(3) NOT NULL AUTO_INCREMENT,
  `Vote` int(3) NOT NULL,
  `Answer_Count` int(11) NOT NULL DEFAULT '0',
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Title` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Content` varchar(12000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `User_ID` int(20) NOT NULL,
  PRIMARY KEY (`Q_ID`),
  UNIQUE KEY `Q_ID` (`Q_ID`),
  KEY `User_ID` (`User_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`Q_ID`, `Vote`, `Answer_Count`, `Time`, `Title`, `Content`, `User_ID`) VALUES
(3, 0, 0, '2015-11-26 05:06:11', 'Test 2 Edited', 'Reintegration test 2 edited', 1),
(4, 0, 0, '2015-11-26 06:31:24', 'Baru', 'Dari frontend pasca reintegrasi', 1);

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE IF NOT EXISTS `token` (
  `Token_ID` int(100) NOT NULL AUTO_INCREMENT,
  `value` varchar(2000) NOT NULL,
  `user_Email` varchar(3000) NOT NULL,
  PRIMARY KEY (`Token_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `token`
--

INSERT INTO `token` (`Token_ID`, `value`, `user_Email`) VALUES
(1, '5d100823-9364-4018-95a4-6495538e4e9d', 'benbong@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `User_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(15000) NOT NULL,
  `Email` varchar(2000) NOT NULL,
  `Password` varchar(3000) NOT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_ID`, `Name`, `Email`, `Password`) VALUES
(1, 'Benjamin Bong', 'benbong@gmail.com', 'bongtillwedrop'),
(2, 'Hans Christian Gunawan', 'hcguyz@gmail.com', '250895'),
(3, 'Juan Anton', 'juan_anton@gmail.com', 'juananton');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`Q_ID`) REFERENCES `question` (`Q_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
