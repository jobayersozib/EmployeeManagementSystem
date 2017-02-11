-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 11, 2017 at 03:06 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `employee_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee_attendance`
--

CREATE TABLE IF NOT EXISTS `employee_attendance` (
  `key` varchar(35) NOT NULL,
  `id` varchar(25) NOT NULL,
  `attendance_status` varchar(11) NOT NULL,
  `date` varchar(35) NOT NULL,
  `month` varchar(11) NOT NULL,
  `day` varchar(11) NOT NULL,
  `attendance_given` varchar(25) NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_attendance`
--

INSERT INTO `employee_attendance` (`key`, `id`, `attendance_status`, `date`, `month`, `day`, `attendance_given`) VALUES
('1202035_Feb 11, 2017', '1202035', 'Present', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202036_Feb 11, 2017', '1202036', 'Absent', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202037_Feb 11, 2017', '1202037', 'Present', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202038_Feb 11, 2017', '1202038', 'Present', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202039_Feb 11, 2017', '1202039', 'Present', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202040_Feb 11, 2017', '1202040', 'Absent', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202041_Feb 11, 2017', '1202041', 'Absent', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202043_Feb 11, 2017', '1202043', 'Present', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202044_Feb 11, 2017', '1202044', 'Present', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202045_Feb 11, 2017', '1202045', 'Absent', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('1202047_Feb 11, 2017', '1202047', 'Absent', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('c#_1202035_Feb 11, 2017', 'c#_1202035', 'Present', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('java_1202035_Feb 11, 2017', 'java_1202035', 'Present', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035'),
('php_1202035_Feb 11, 2017', 'php_1202035', 'Present', 'Feb 11, 2017', 'February', 'Saturday', 'java_1202035');

-- --------------------------------------------------------

--
-- Table structure for table `employee_details`
--

CREATE TABLE IF NOT EXISTS `employee_details` (
  `id` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(55) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `joining` varchar(10) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `address` varchar(55) DEFAULT NULL,
  `salary` varchar(20) NOT NULL,
  `daily_allowence` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_details`
--

INSERT INTO `employee_details` (`id`, `name`, `phone`, `email`, `joining`, `sex`, `address`, `salary`, `daily_allowence`) VALUES
('1202035', 'jobayer mahamud', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202036', 'jobayer mahamud', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202037', 'jobayer mahamud', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202038', 'jobayer mahamud kamal', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202039', 'mahamud hossain', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202040', 'mahamud hossain', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202041', 'mahamud hossain', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202043', 'mahamud hossain', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202044', 'jobayer sozib', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202045', 'jobayer sozib', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('1202047', 'jobayer sozib', '01717979764', 'jobayerkamal007@yahoo.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '210'),
('c#_1202035', 'jobayer mahamud', '01717979764', 'jobayermahamudkamalcse@gmail.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '350'),
('java_1202035', 'jobayer mahamud', '01717979764', 'jobayermahamudkamalcse@gmail.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '350'),
('php_1202035', 'jobayer mahamud', '01717979764', 'jobayermahamudkamalcse@gmail.com', '11/02/2017', 'Male', 'Bogra:5800', '31000', '350');

-- --------------------------------------------------------

--
-- Table structure for table `employee_login`
--

CREATE TABLE IF NOT EXISTS `employee_login` (
  `uid` varchar(35) NOT NULL,
  `pass` varchar(35) NOT NULL,
  `post` varchar(35) NOT NULL,
  `access` varchar(35) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_login`
--

INSERT INTO `employee_login` (`uid`, `pass`, `post`, `access`) VALUES
('1202035', 'jobayer', 'programmer', 'Super'),
('1202036', 'jobayer', 'programmer', 'Super'),
('1202037', 'jobayer', 'programmer', 'Super'),
('1202038', 'jobayer', 'programmer', 'Super'),
('1202039', 'jobayer', 'programmer', 'Super'),
('1202040', 'jobayer', 'programmer', 'Super'),
('1202041', 'jobayer', 'programmer', 'Super'),
('1202043', 'jobayer', 'programmer', 'Super'),
('1202044', 'jobayer', 'programmer', 'Super'),
('1202045', 'jobayer', 'programmer', 'General'),
('1202047', 'jobayer', 'programmer', 'Admin'),
('c#_1202035', 'jobayer', 'c#_developer', 'Admin'),
('java_1202035', 'jobayer', 'java_developer', 'Super'),
('php_1202035', 'jobayer', 'php_developer', 'General');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
