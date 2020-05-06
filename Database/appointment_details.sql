-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 05:05 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `newdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment_details`
--

CREATE TABLE `appointment_details` (
  `appointment_id` int(11) NOT NULL,
  `patient_nic` varchar(10) NOT NULL,
  `doc_speciality` varchar(45) NOT NULL,
  `doc_name` varchar(45) NOT NULL,
  `appointment_date` varchar(20) NOT NULL,
  `appointment_time` varchar(10) NOT NULL,
  `appointment_hospital` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment_details`
--

INSERT INTO `appointment_details` (`appointment_id`, `patient_nic`, `doc_speciality`, `doc_name`, `appointment_date`, `appointment_time`, `appointment_hospital`) VALUES
(35, '4565', 'Dermatologists', 'George', '2020-04-14', '09:20', 'General Hospital'),
(36, '66666', 'Surgery', 'Nimal', '2-2-2020', '3', 'Asisi'),
(37, '7777', 'Surgery', 'test', '2-2-2020', '3', 'Asiri'),
(49, '11111', 'Cardiologists', 'Vidula', '2020-04-15', '16:04', 'Lake Side Hospital'),
(253, '17', 'Cardiologists', 'vidula', '2020-05-06', '03:33', 'General Hospital'),
(254, '17', 'Cardiologists', 'vidula', '2020-05-06', '03:33', 'General Hospital');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment_details`
--
ALTER TABLE `appointment_details`
  ADD PRIMARY KEY (`appointment_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment_details`
--
ALTER TABLE `appointment_details`
  MODIFY `appointment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=255;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
