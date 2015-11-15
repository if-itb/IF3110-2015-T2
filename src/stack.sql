-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 10 Nov 2015 pada 16.53
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
(1000, 1, 'Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1Untuk answer 1 pertanyaan 1', '2015-10-11 06:11:37', 0, 'tama', 'tamadamanik@gmail.com'),
(1001, 1, 'Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1Untuk answer 2 pertanyaan 1', '2015-10-11 06:12:01', 0, 'tata', 'tata@yahoo.com'),
(3000, 3, 'Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2Untuk answer 1 pertanyaan 2', '2015-10-11 06:12:25', 0, 'budi', 'budi@gmail.com'),
(4000, 4, 'Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3Untuk answer 1 pertanyaan 3', '2015-10-11 06:12:42', 0, 'tama', 'tamadamanik@yahoo.co.id'),
(4001, 4, 'Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3Untuk answer 2 pertanyaan 3', '2015-10-11 06:12:59', 0, 'tama-', 'tamadamanik@yahoo.co.id'),
(4002, 4, 'Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3Untuk answer 3 pertanyaan 3', '2015-10-11 06:13:13', 0, 'tata', 'tata@yahoo.com');

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
(1, 'First Ever Question', 'lorem ipsum lorem ipsum  lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange simple stack exchange ', 0, '2015-10-07 18:20:01', 'tama', 'tama.damanik@yahoo.co.id'),
(2, 'Fourth Question Test :D', 'Fourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth QuestionFourth Question', 0, '2015-10-11 06:18:28', 'tama', 'tama.damanik@yahoo.co.id'),
(3, 'Another Question', ' more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char more than 100 char', 0, '2015-10-10 13:47:19', 'tata', 'tatamadamanik@gmail.com'),
(4, 'Try from ask here', 'Try from ask here Try from ask here Try from ask here Try from ask here Try from ask here Try from ask here Try from ask here Try from ask here Try from ask here Try from ask here Try from ask here Try from ask here Try from ask here', 0, '2015-10-10 23:27:31', 'tama', 'tama.damanik@yahoo.co.id');

-- --------------------------------------------------------

--
-- Struktur dari tabel `registered`
--

CREATE TABLE IF NOT EXISTS `registered` (
`user_id` int(9) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `registered`
--

INSERT INTO `registered` (`user_id`, `username`, `email`, `password`) VALUES
(1, 'tama', 'tama.damanik@yahoo.co.id', 'tama'),
(2, 'tata', 'tatamadamanik@gmail.com', 'tata');

-- --------------------------------------------------------

--
-- Struktur dari tabel `voted`
--

CREATE TABLE IF NOT EXISTS `voted` (
  `id_v` int(9) NOT NULL,
  `id_u` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registered`
--
ALTER TABLE `registered`
MODIFY `user_id` int(9) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
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
