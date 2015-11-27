-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 27 Nov 2015 pada 16.01
-- Versi Server: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simplestackexchange_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `activeuser`
--

CREATE TABLE IF NOT EXISTS `activeuser` (
  `token` varchar(32) NOT NULL,
  `uid` int(11) NOT NULL,
  `createdtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `activeuser`
--

INSERT INTO `activeuser` (`token`, `uid`, `createdtime`) VALUES
('6adffa25fa38487f8afe27637c0474a9', 16, '2015-11-27 14:04:46'),
('90a08fa481ea4d2aae01e5e75da521d9', 16, '2015-11-27 14:42:31');

-- --------------------------------------------------------

--
-- Struktur dari tabel `answer`
--

CREATE TABLE IF NOT EXISTS `answer` (
  `aid` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `content` text NOT NULL,
  `countvotes` int(11) NOT NULL DEFAULT '0',
  `createdtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `answer`
--

INSERT INTO `answer` (`aid`, `qid`, `uid`, `content`, `countvotes`, `createdtime`) VALUES
(13, 28, 16, 'jadi jawab', -1, '2015-11-27 13:41:08');

-- --------------------------------------------------------

--
-- Struktur dari tabel `answervoter`
--

CREATE TABLE IF NOT EXISTS `answervoter` (
  `id` int(11) NOT NULL,
  `aid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `value` enum('1','-1') NOT NULL,
  `createdtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `answervoter`
--

INSERT INTO `answervoter` (`id`, `aid`, `uid`, `value`, `createdtime`) VALUES
(14, 13, 16, '-1', '2015-11-27 14:05:19');

-- --------------------------------------------------------

--
-- Struktur dari tabel `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `qid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `topic` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `createdtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `countanswers` int(11) NOT NULL DEFAULT '0',
  `countvotes` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `question`
--

INSERT INTO `question` (`qid`, `uid`, `topic`, `content`, `createdtime`, `countanswers`, `countvotes`) VALUES
(28, 11, 'Aku mau tanya', 'tanya apa ya?\r\n', '2015-11-27 13:28:20', 1, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `questionvoter`
--

CREATE TABLE IF NOT EXISTS `questionvoter` (
  `id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `value` set('1','-1') NOT NULL,
  `createdtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `questionvoter`
--

INSERT INTO `questionvoter` (`id`, `qid`, `uid`, `value`, `createdtime`) VALUES
(35, 28, 16, '1', '2015-11-27 14:04:59');

-- --------------------------------------------------------

--
-- Struktur dari tabel `registereduser`
--

CREATE TABLE IF NOT EXISTS `registereduser` (
  `uid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `createdtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `registereduser`
--

INSERT INTO `registereduser` (`uid`, `name`, `email`, `password`, `createdtime`) VALUES
(11, 'Baru', 'baru@gmail.com', 'baru', '2015-11-27 13:27:54'),
(16, 'jadi', 'jadi@gmail.com', 'jadi', '2015-11-27 13:40:27');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activeuser`
--
ALTER TABLE `activeuser`
  ADD PRIMARY KEY (`token`);

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `answervoter`
--
ALTER TABLE `answervoter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`qid`);

--
-- Indexes for table `questionvoter`
--
ALTER TABLE `questionvoter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registereduser`
--
ALTER TABLE `registereduser`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `answervoter`
--
ALTER TABLE `answervoter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `qid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `questionvoter`
--
ALTER TABLE `questionvoter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `registereduser`
--
ALTER TABLE `registereduser`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
