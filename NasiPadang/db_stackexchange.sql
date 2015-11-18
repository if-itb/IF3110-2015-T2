-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2015 at 06:03 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_stackexchange`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE IF NOT EXISTS `answer` (
  `id` int(11) NOT NULL,
`id_answer` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `votes` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`id`, `id_answer`, `name`, `content`, `timestamp`, `votes`) VALUES
(19, 99, 'sa', 'as', '2015-10-10 12:56:55', 0),
(20, 102, 'dHJKD', 'DAS', '2015-10-17 00:32:19', 0),
(22, 103, 'das', 'fsf', '2015-10-17 01:40:53', 0),
(23, 104, 'sdf', 'fsafsf', '2015-10-25 22:53:18', 0),
(21, 105, 'h', 'Dengan demikian, jika disesuaikan dengan jumlah populasi penduduk Indonesia yang menurut data Badan Pusat Statistik (BPS) mencapai 252,5 juta jiwa, maka pengguna internet di Indonesia mengalami pertumbuhan 16,2 juta jiwa dari total 71,9 juta pengguna di tahun 2013 lalu.', '2015-10-25 22:54:24', 0);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `topic` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `votes` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `name`, `topic`, `content`, `timestamp`, `votes`) VALUES
(21, 'Jun', 'hakjda', 'cdaskjdhd', '2015-10-17 01:15:41', 0),
(23, 'Jun', 'asdasddfd', 'All HTML elements can be considered as boxes. In CSS, the term "box model" is used when talking about design and layout.\r\n\r\nThe CSS box model is essentially a box that wraps around HTML elements, and it consists of: margins, borders, padding, and the actual content.\r\n\r\nThe box model allows us to add a border around elements, and to define space between elements.\r\n\r\nThe image below illustrates the box model:', '2015-10-17 02:18:30', 0),
(24, 'da', 'fsafsdf', 'Dengan demikian, jika disesuaikan dengan jumlah populasi penduduk Indonesia yang menurut data Badan Pusat Statistik (BPS) mencapai 252,5 juta jiwa, maka pengguna internet di Indonesia mengalami pertumbuhan 16,2 juta jiwa dari total 71,9 juta pengguna di tahun 2013 lalu.', '2015-10-25 22:54:43', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
 ADD PRIMARY KEY (`id_answer`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
MODIFY `id_answer` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=106;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
