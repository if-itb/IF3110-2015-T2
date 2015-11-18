-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2015 at 07:07 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `stack_exchange`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE IF NOT EXISTS `answer` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `answerer_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `answerer_email` varchar(100) NOT NULL,
  `answer_content` text NOT NULL,
  `answer_vote` int(11) NOT NULL DEFAULT '0',
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `question_id_index` (`question_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`answer_id`, `answerer_name`, `answerer_email`, `answer_content`, `answer_vote`, `question_id`) VALUES
(13, 'admin', 'admin@live.com', 'Website ini untuk nanya-nanya tentang berbagai macam hal mas, kalo mau nanya monggo ya, siapa tau yang laen bisa bantuin mas.. hehe', 2, 9),
(14, 'Roni', 'roni@yahool.com', 'Untuk nanya-nanya doang kok', 3, 9),
(16, 'Rachel', 'rachel@live.com', 'That would be an alleged affair but no not why he stepped down. ', 0, 11),
(17, 'alex', 'alex@yahoo.com', 'From his own answer on Quora; \r\n"When I said that my leadership style is based on listening, I meant it. You may have trouble believing this – I truly didn’t seek public office to be someone, but to do something for our country. \r\n\r\nI know people are angry at Congress. I know people are frustrated by Washington’s seeming inability to do the work that you send people there to do. I know people are skeptical of anything an elected official has to say. To be completely candid, I understand why you feel that way, because I feel the same way. \r\n\r\nI truly believe that we are here as public servants; our job is to work for you – period. Your public servants should not be here to gain power or positions; we should be here to do what’s best for our country. \r\n\r\nHouse Republicans need a new leader that can unite them, and after many days of talking with my colleagues, it became clear that I would not be that person. The selection of a new Speaker can never be about a single person, it must be about doing what s right for the country. \r\n\r\nWe need a new start – a fresh face who can bring Congress together. I hope that my choice will help heal the wounds that are keeping well-meaning people from finding common cause for our country. \r\n"', 0, 11),
(19, 'William', 'william@live.com', 'Halo salam kenal', 0, 9);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `asker_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `asker_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `question_topic` varchar(400) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `question_content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `question_vote` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`question_id`, `asker_name`, `asker_email`, `question_topic`, `question_content`, `question_vote`, `user_id`) VALUES
(9, 'Will', 'William@live.com', 'Apa sih ini ?', 'hahahahhahahahahah', 9, 0),
(11, 'Billy', 'billy@gmail.com', 'Do we now know why McCarthy suddenly dropped out of the vote for House Speaker?', 'Is it because he was was carrying on a long running affair with a Congresswoman? \n\nMultiple sources within Bakersfield, North Carolina, & on Capitol Hill tell Gotnews.com that Majority Leader Kevin McCarthy (R-CA) and Renee Ellmers (R-NC) have been carrying on a long-running affair since 2011. ', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `email` varchar(200) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`email`, `nama`, `password`) VALUES
('acel@gmail.com', 'marcel', 'acelacel'),
('william@gmail.com', 'william', 'william');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
