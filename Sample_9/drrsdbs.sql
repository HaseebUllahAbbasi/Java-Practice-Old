-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2021 at 06:56 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `drrsdbs`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookId` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `isbn` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookId`, `title`, `isbn`, `author`) VALUES
(1, 'Anna Karenina', '0451528611', 'Leo Tolstoy'),
(2, 'Madame Bovary', '979-8649042031', 'Gustave Flaubert'),
(3, 'Hamlet', '1980625026', 'William Shakespeare'),
(4, 'The Hobbit', '9780007458424', 'J R R Tolkien'),
(5, 'Great Expectations', '1521853592', 'Charles Dickens'),
(6, 'Pride and Prejudice ', '979-8653642272', 'Jane Austen'),
(7, 'Wuthering Heights ', 's 3961300224', 'Emily Brontë');

-- --------------------------------------------------------

--
-- Table structure for table `lendandreturn`
--

CREATE TABLE `lendandreturn` (
  `lendId` int(11) NOT NULL,
  `memberId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `lendDate` datetime NOT NULL,
  `returnDate` datetime DEFAULT NULL,
  `fineAmount` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lendandreturn`
--

INSERT INTO `lendandreturn` (`lendId`, `memberId`, `bookId`, `lendDate`, `returnDate`, `fineAmount`) VALUES
(7, 3, 1, '2021-03-12 22:45:00', NULL, '0');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `memberId` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `gender` char(1) NOT NULL,
  `age` int(11) NOT NULL,
  `identity` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`memberId`, `firstName`, `lastName`, `gender`, `age`, `identity`, `phone`, `address`) VALUES
(1, 'Tony', 'Shade', 'M', 31, 'S8900678A', '83722773', '13 Jurong East, Ave 3'),
(2, 'Dewi', 'Tan', 'F', 35, 'S8581028X', '94602711', '15 Computing Dr'),
(3, 'bakhtiar', 'hussain', 'M', 22, 'sss', '333333333', 'noman');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffId` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffId`, `firstName`, `lastName`, `userName`, `password`) VALUES
(1, 'Eric', 'Some', 'eric', 'password'),
(2, 'Sarah', 'Brightman', 'sarah', 'password');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookId`);

--
-- Indexes for table `lendandreturn`
--
ALTER TABLE `lendandreturn`
  ADD PRIMARY KEY (`lendId`),
  ADD KEY `check_1` (`bookId`),
  ADD KEY `check_2` (`memberId`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`memberId`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `bookId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `lendandreturn`
--
ALTER TABLE `lendandreturn`
  MODIFY `lendId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `memberId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `staffId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `lendandreturn`
--
ALTER TABLE `lendandreturn`
  ADD CONSTRAINT `check_1` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `check_2` FOREIGN KEY (`memberId`) REFERENCES `member` (`memberId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
