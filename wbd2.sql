-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2015 at 03:28 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `wbd2`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `userID` int(11) NOT NULL,
  `userName` varchar(40) DEFAULT NULL,
  `password` varchar(12) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL,
  `tokenexpired` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`userID`, `userName`, `password`, `email`, `token`, `tokenexpired`) VALUES
(1, 'aaa', '', 'aaa@gmail.com', 'ssss', '2015-11-18 18:14:37'),
(2, 'bbb', '', 'bbb@gmail.com', 'aaa', '2015-11-18 18:19:06'),
(3, 'aaa', '1234', 'aaa@gmail.com', 'abc123', '2015-11-23 22:49:57'),
(4, 'ccc', '123456', 'ccc@gmail.com', 'abababab', '2015-11-24 00:38:01'),
(5, 'ddd', '12abc', 'ddd@gmail.com', NULL, NULL),
(13, 'eee', '123', 'eee@gmail.com', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE IF NOT EXISTS `answers` (
  `answer_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `vote` int(11) NOT NULL DEFAULT '0',
  `date` datetime NOT NULL,
  `userID` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`answer_id`, `question_id`, `content`, `vote`, `date`, `userID`) VALUES
(1, 1, 'yes we can', 7, '2012-01-01 00:00:00', NULL),
(2, 1, 'nope', 6, '2014-01-01 00:00:00', NULL),
(4, 12, 'well, it means nothing about value proposition', 3, '2015-10-11 00:21:27', NULL),
(5, 12, 'A value proposition is a promise of value to be delivered and acknowledged and a belief from the customer that value will be delivered and experienced. A value proposition can apply to an entire organization, or parts thereof, or customer accounts, or products or services.', 2, '2015-10-14 19:35:45', NULL),
(6, 12, 'As an entrepreneur turned venture capitalist, I enjoy collaborating with innovators on their planned ventures and helping them explore their value propositions. However, many entrepreneurs lose out, due to never truly articulating a compelling value proposition. Establishing a substantive value proposition is critical if you want to start the journey from your â€œideaâ€ to building a successful company.', 0, '2015-10-14 19:43:43', NULL),
(7, 12, 'In its simplest terms, a value proposition is a positioning statement that explains what benefit you provide for who and how you do it uniquely well. It describes your target buyer, the problem you solve, and why youâ€™re distinctly better than the alternatives', 0, '2015-10-14 19:44:55', NULL),
(8, 12, 'A fellow inventor, Charles Kettering, once said, a problem well stated is a problem half solved and many entrepreneurs make the mistake of diving headlong into the solution before really understanding the problem theyâ€™re looking to solve.', 0, '2015-10-14 19:46:31', NULL),
(9, 1, 'A significant part of defining a value proposition involves what I like to call the 4Us. If you find yourself answering a definitive yes to the majority of these questions, then you are on the right path toward a compelling value proposition. If not, consider re-evaluating and revising your new venture.', 0, '2015-10-14 19:49:16', NULL),
(11, 22, ' Does your solution fix a broken business process where there are real, measureable consequences to inaction? Will someone get fired if the issue is not addressed? *If the answer is yes â€“ then that person will likely be your internal champion.', 2, '2015-10-14 20:13:49', NULL),
(12, 22, 'pintar sekali nak. rajin2 bimbingan', 2, '2015-10-29 15:20:45', NULL),
(16, 1, 'hello', 1, '2015-11-18 18:15:55', 1),
(18, 1, 'hello', 0, '2015-11-18 18:23:18', 1),
(19, 1, 'hello', 0, '2015-11-18 19:04:37', 1),
(20, 27, 'hello hello ', -1, '2015-11-24 16:15:34', 3);

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE IF NOT EXISTS `questions` (
  `questionId` int(11) NOT NULL,
  `title` varchar(300) NOT NULL,
  `content` text NOT NULL,
  `vote` int(11) NOT NULL DEFAULT '0',
  `date` datetime NOT NULL,
  `userID` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`questionId`, `title`, `content`, `vote`, `date`, `userID`) VALUES
(1, 'Memilih Macbook', 'Mungkin sih ya beberapa calon pembeli Mac acapkali bingung ketika hendak memilih MacBook. Apakah memilih MacBook klasik, MacBook Air, atau MacBook Pro. Walaupun MacBook klasik sudah dihentikan, tetap saja banyak yang masih bimbang memilih antara MacBook Air dan MacBook Pro. Apalagi saat ini ditambah lagi dengan pilihan MacBook Pro dengan Retina.\r\n\r\nUntuk yang butuh ukuran yang kecil dan ringan, tentunya MacBook Air 11â€œ akan jadi satu-satunya pilihan. Begitu juga dengan yang membutuhkan ukuran besar: 15â€ dan 17"; tentunya akan langsung menuju ke MacBook Pro. Jika tidak membutuhkan SuperDrive dan anggaran memadai, MacBook Pro dengan Retina. Nah, bagaimana dengan pilihan yang di tengah-tengah, yakni 13 inci? Mari kita telaah satu per satu.', 2, '2015-10-14 19:34:35', NULL),
(12, 'Whatâ€™s my value proposition?', 'This article will began by identifying its audience and what they stood to gain from reading it. Thatâ€™s what business-school types call a â€œvalue propositionâ€â€”fancy wording for â€œwhy the hell you should spend money and time on my product or service.â€ Every company, project and employee should have a value propâ€”preferably a clear and measurable oneâ€”though plenty are wanting. Chew on yours a bit. In question No. 5 Iâ€™ll show you why the answer may not be what you think it is.', 3, '2015-10-16 11:32:37', NULL),
(22, 'How Can I Tell if an Email Is Spam?', 'Some spam is obvious (â€œI lost 30 pounds and made $24356 in five hours by taking this special pill!â€), but other messages are more subtle. A lot of spam relies oh â€œphishing,â€ in which a spammer will try to make their email look like itâ€™s coming from a legitimate source in order to get your information. They may tell you to click a link that looks like itâ€™s going to paypal.com, but if you hover over it, youâ€™ll see that itâ€™s really going somewhere elseâ€”likely a PayPal-disguised site where you willingly type in your information. Luckily, you can usually avoid those tricks by checking the URL and typing it in yourself instead. Be careful, tooâ€”sometimes those links will cause you to unknowingly spam one of your friends, which only spreads the scam.', 2, '2015-10-14 20:14:00', NULL),
(24, 'akapakdkfsdfsdf dfsdf d dsfsdf sdfs', 'safdsfasdf sdf sdf sdfsd sdfsdfs sdfs fsdfsd f fsdfsdf  s dsfasdf asdf sdf asd fsd fsdfsdfsd sf sdfsd fsdfsdf safdsfasdf sdf sdf sdfsd sdfsdfs sdfs fsdfsd f fsdfsdf  s dsfasdf asdf sdf asd fsd fsdfsdfsd sf sdfsd fsdfsdf safdsfasdf sdf sdf sdfsd sdfsdfs sdfs fsdfsd f fsdfsdf  s dsfasdf asdf sdf asd fsd fsdfsdfsd sf sdfsd fsdfsdf safdsfasdf sdf sdf sdfsd sdfsdfs sdfs fsdfsd f fsdfsdf  s dsfasdf asdf sdf asd fsd fsdfsdfsd sf sdfsd fsdfsdf safdsfasdf sdf sdf sdfsd sdfsdfs sdfs fsdfsd f fsdfsdf  s dsfasdf asdf sdf asd fsd fsdfsdfsd sf sdfsd fsdfsdf', 0, '2015-10-29 15:20:12', NULL),
(25, 'topik 1', 'hello world', 5, '2015-11-23 22:51:10', 3),
(27, 'topik 2', 'hello world 2', 0, '2015-11-24 00:38:17', 4);

-- --------------------------------------------------------

--
-- Table structure for table `voteanswer`
--

CREATE TABLE IF NOT EXISTS `voteanswer` (
  `voteanswerID` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `answerID` int(11) DEFAULT NULL,
  `questionID` int(11) NOT NULL,
  `value` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voteanswer`
--

INSERT INTO `voteanswer` (`voteanswerID`, `userID`, `answerID`, `questionID`, `value`) VALUES
(1, 3, 20, 27, -1);

-- --------------------------------------------------------

--
-- Table structure for table `votequestion`
--

CREATE TABLE IF NOT EXISTS `votequestion` (
  `voteID` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `questionID` int(11) DEFAULT NULL,
  `value` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `votequestion`
--

INSERT INTO `votequestion` (`voteID`, `userID`, `questionID`, `value`) VALUES
(25, 3, 25, -1),
(26, 4, 27, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`answer_id`), ADD KEY `question_id` (`question_id`), ADD KEY `userID` (`userID`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`questionId`), ADD KEY `userID` (`userID`);

--
-- Indexes for table `voteanswer`
--
ALTER TABLE `voteanswer`
  ADD PRIMARY KEY (`voteanswerID`);

--
-- Indexes for table `votequestion`
--
ALTER TABLE `votequestion`
  ADD PRIMARY KEY (`voteID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
  MODIFY `answer_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `questionId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `voteanswer`
--
ALTER TABLE `voteanswer`
  MODIFY `voteanswerID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `votequestion`
--
ALTER TABLE `votequestion`
  MODIFY `voteID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers`
--
ALTER TABLE `answers`
ADD CONSTRAINT `answers_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `questions` (`questionId`) ON DELETE CASCADE,
ADD CONSTRAINT `answers_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `account` (`userID`) ON DELETE CASCADE;

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `account` (`userID`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
