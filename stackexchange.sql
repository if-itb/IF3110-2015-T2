-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2015 at 02:37 AM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `stackexchange`
--

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE IF NOT EXISTS `answers` (
`AnswerID` int(11) NOT NULL,
  `QuestionID` int(11) NOT NULL,
  `Votes` int(11) NOT NULL,
  `Answer` varchar(9999) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Datetime` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`AnswerID`, `QuestionID`, `Votes`, `Answer`, `Name`, `Email`, `Datetime`) VALUES
(6, 38, 0, 'you cant', 'Cliff', 'cliffsantoso@gmail.com', '2015-10-10 17:11:48'),
(7, 38, 0, 'get a boyfriend instead', 'Ben', 'benlemuel@gmail.com', '2015-10-10 17:15:21'),
(9, 38, 0, 'bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben bacot ben ', 'Cliff J', 'cliffsantoso@gmail.com', '2015-10-10 17:25:09'),
(10, 38, 0, 'aadfafaf', 'fsfsdfs', 'fdfsfsf', '2015-10-10 19:00:18'),
(11, 39, 7, '', 'sgsdgsdg', '', '2015-10-10 19:03:31'),
(12, 38, 0, '', 'asd', '', '2015-10-10 19:06:28'),
(13, 39, 3, 'fsfs', 'dsaad', 'sfsdfds@sggsg.asdfdf', '2015-10-10 21:09:42'),
(14, 37, 2, 'fsfsfsfsfsf', 'Cliff', 'fasdfasfasf@gkajf.sjfds', '2015-10-10 21:26:04'),
(15, 42, 5, 'YOU''RE FUCKING GAY', 'Cliff', '', '2015-10-15 15:22:29');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE IF NOT EXISTS `questions` (
`QuestionID` int(11) NOT NULL,
  `Votes` int(11) NOT NULL,
  `Answers` int(11) NOT NULL,
  `Topic` varchar(25) NOT NULL,
  `Question` varchar(9999) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Datetime` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`QuestionID`, `Votes`, `Answers`, `Topic`, `Question`, `Name`, `Email`, `Datetime`) VALUES
(37, 2, 1, 'asdf', 'fsfsfsfsf', 'fsdfsfsf', 'afasfaf@asdf.cg', '2015-10-10 17:19:54'),
(38, 5, 6, 'How to get a gf?', 'im such a loser', 'fdsa', 'cliffsantoso@gmail.com', '2015-10-10 17:08:03'),
(39, 3, 2, 'asdasd', 'asdsdsd', 'adadasdsad', 'sfsfsf@sgsgsgs.sdf', '2015-10-10 19:03:24'),
(42, -2, 1, 'ben???''', 'is ben gay?" i''m not!@#%^*()`~', 'Cliff', 'cliffsantoso@gmail.com', '2015-10-15 15:25:49');

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE IF NOT EXISTS `sessions` (
  `SessionID` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `AccessToken` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`UserID` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `Name`, `Email`, `Password`) VALUES
(1, 'Yoga', 'yoga@gmail.com', 'yoga'),
(2, 'Cliff', 'cliffsantoso@gmail.com', 'cliff'),
(3, 'asdf', 'asdfasdf', 'asdfasfd'),
(4, 'Memek', 'Kontol', 'memek');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
 ADD PRIMARY KEY (`AnswerID`), ADD UNIQUE KEY `AnswerID` (`AnswerID`), ADD KEY `QuestionID` (`QuestionID`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
 ADD PRIMARY KEY (`QuestionID`), ADD UNIQUE KEY `QuestionID` (`QuestionID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`UserID`), ADD UNIQUE KEY `UserID` (`UserID`), ADD KEY `UserID_2` (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
MODIFY `AnswerID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
MODIFY `QuestionID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers`
--
ALTER TABLE `answers`
ADD CONSTRAINT `answers_ibfk_1` FOREIGN KEY (`QuestionID`) REFERENCES `questions` (`QuestionID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
