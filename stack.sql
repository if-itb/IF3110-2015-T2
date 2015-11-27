-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 27 Nov 2015 pada 15.05
-- Versi Server: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `stack`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `answer`
--

CREATE TABLE IF NOT EXISTS `answer` (
  `id_a` int(9) NOT NULL,
  `q_id` int(9) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL,
  `vote` int(9) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `answer`
--

INSERT INTO `answer` (`id_a`, `q_id`, `content`, `date`, `vote`, `username`, `email`) VALUES
(1001, 1, 'Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 Answer Q 1 ', '2015-11-18 00:24:16', 1, 'tata', ''),
(3001, 3, 'Test answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answerTest answer', '2015-11-26 22:44:21', 0, 'tama', ''),
(4001, 4, 'Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 Answer Q 2 ', '2015-11-18 00:25:02', 0, 'tama', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id_q` int(9) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `vote` int(9) NOT NULL,
  `date` datetime NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `question`
--

INSERT INTO `question` (`id_q`, `title`, `content`, `vote`, `date`, `username`, `email`) VALUES
(1, 'Question by tama', 'test by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by testtest by test\r\n\r\n\r\n\r\n', 2, '2015-11-18 00:05:33', 'tama', ''),
(3, 'Question by tata', 'Test by tataTest by tataTest by tataTest by tataTest by tataTest by tataTest by tataTest by tataTest by tataTest by tataTest by tataTest by tata\r\n', 2, '2015-11-18 00:21:11', 'tata', ''),
(4, 'Test by tata2', 'Test by tata2Test by tata2Test by tata2Test by tata2Test by tata2Test by tata2Test by tata2Test by tata2', 0, '2015-11-18 00:23:41', 'tata', ''),
(6, 'Test by tama 3 (edited)', '(edited)Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3Test by tama 3\r\n', 0, '2015-11-18 00:42:52', 'tama', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `registered`
--

CREATE TABLE IF NOT EXISTS `registered` (
`user_id` int(9) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `registered`
--

INSERT INTO `registered` (`user_id`, `username`, `email`, `password`) VALUES
(1, 'tama', 'tama.damanik@yahoo.co.id', 'tama'),
(2, 'tata', 'tatamadamanik@gmail.com', 'tata'),
(8, 'tama126', 'tama126@gmail.com', 'tatama');

-- --------------------------------------------------------

--
-- Struktur dari tabel `token`
--

CREATE TABLE IF NOT EXISTS `token` (
  `token` varchar(100) NOT NULL,
  `expire` varchar(100) NOT NULL,
  `id_user` int(5) NOT NULL,
  `username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `token`
--

INSERT INTO `token` (`token`, `expire`, `id_user`, `username`) VALUES
('itjahmc', '1447785951', 1, 'tama'),
('otgastsaewq', '1047784904', 2, 'tata'),
('st4ajmva', '1448557484', 1, 'tama'),
('ttpaqmfa', '1448278220', 1, 'tama'),
('ut8ammja', '1448557454', 1, 'tama'),
('wtja6mh', '1447787595', 1, 'tama');

-- --------------------------------------------------------

--
-- Struktur dari tabel `voted`
--

CREATE TABLE IF NOT EXISTS `voted` (
  `Kode` varchar(10) NOT NULL,
  `id_v` int(9) NOT NULL,
  `id_u` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `voted`
--

INSERT INTO `voted` (`Kode`, `id_v`, `id_u`) VALUES
('1-1', 1, 1),
('1-2', 1, 2),
('1001-1', 1001, 1),
('3-1', 3, 1),
('3-2', 3, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
 ADD PRIMARY KEY (`id_a`), ADD KEY `q_id` (`q_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
 ADD PRIMARY KEY (`id_q`);

--
-- Indexes for table `registered`
--
ALTER TABLE `registered`
 ADD PRIMARY KEY (`user_id`), ADD FULLTEXT KEY `password` (`password`);

--
-- Indexes for table `token`
--
ALTER TABLE `token`
 ADD UNIQUE KEY `token` (`token`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registered`
--
ALTER TABLE `registered`
MODIFY `user_id` int(9) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `answer`
--
ALTER TABLE `answer`
ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`q_id`) REFERENCES `question` (`id_q`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
