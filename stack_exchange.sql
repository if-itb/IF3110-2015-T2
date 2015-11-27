-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2015 at 08:28 AM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stack_exchange`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `id` int(255) NOT NULL,
  `questionId` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `vote` int(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `answervote`
--

CREATE TABLE `answervote` (
  `userId` int(255) NOT NULL,
  `answerId` int(255) NOT NULL,
  `type` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `topic` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `vote` int(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `userId`, `topic`, `content`, `vote`) VALUES
(22, 3, 'gerry', 'gerry', 1);

-- --------------------------------------------------------

--
-- Table structure for table `questionvote`
--

CREATE TABLE `questionvote` (
  `userId` int(255) NOT NULL,
  `questionId` int(255) NOT NULL,
  `type` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questionvote`
--

INSERT INTO `questionvote` (`userId`, `questionId`, `type`) VALUES
(3, 22, 1),
(8, 22, 1),
(9, 22, -1);

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE `token` (
  `id` int(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `lifetime` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `token`
--

INSERT INTO `token` (`id`, `value`, `user_id`, `lifetime`) VALUES
(1, '4d0aef29-6e59-4901-8329-60b3b8a67a63', 5, '20151127142156'),
(2, '7d0836b9-1bbd-46b3-9792-c5cf606ad724', 7, '20151127140644'),
(3, 'be7a2d74-cdd3-4aa9-8835-5410a73a9c2f', 1, '20151127140405'),
(4, '199f3add-6891-45f2-9df2-0710116cc402', 3, '20151127142359'),
(5, '04e324fb-f477-43c5-8090-6415c9cf301b', 8, '20151127142501'),
(6, '643e5196-81c5-4305-af7a-853b89925df0', 9, '20151127142756');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`) VALUES
(1, 'Calvin Aditya Jonathan', 'calvin.aditya95@gmail.com', 'Deus0123'),
(2, 'Joben', 'joben@joben.joben', 'thebest'),
(3, 'Gerry', 'gerry@gerry.com', 'gerry'),
(4, 'Benedict', 'top kek@gmail.com', 'kkkkkkk'),
(5, 'a', 'a', 'a'),
(6, 'CAJ', 'deus.caj@gmail.com', 'Deus0123'),
(7, 'b', 'b', 'b'),
(8, 'jonathan', 'jonathan@gmail.com', 'jonathan'),
(9, 'g', 'g@g', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `questionId` (`questionId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `answervote`
--
ALTER TABLE `answervote`
  ADD KEY `userId` (`userId`),
  ADD KEY `answerId` (`answerId`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `questionvote`
--
ALTER TABLE `questionvote`
  ADD PRIMARY KEY (`userId`,`questionId`,`type`),
  ADD KEY `userId` (`userId`),
  ADD KEY `questionId` (`questionId`);

--
-- Indexes for table `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `token`
--
ALTER TABLE `token`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `question_constraint` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_constraint` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `answervote`
--
ALTER TABLE `answervote`
  ADD CONSTRAINT `vote_constrain3` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vote_constrain4` FOREIGN KEY (`answerId`) REFERENCES `answer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `user_constraint2` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `questionvote`
--
ALTER TABLE `questionvote`
  ADD CONSTRAINT `vote_constraint1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vote_constraint2` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
