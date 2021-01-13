-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2021 at 10:12 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ibu_hamil`
--

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `ID_DOKTER` varchar(8) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `ALAMAT` varchar(100) NOT NULL,
  `NO_TELP` varchar(12) NOT NULL,
  `NIK` varchar(16) NOT NULL,
  `KOTA` varchar(20) NOT NULL,
  `INSTANSI_ASAL` varchar(20) NOT NULL,
  `EMAIL` varchar(30) NOT NULL,
  `PASSWORD` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `evaluasi`
--

CREATE TABLE `evaluasi` (
  `ID_EVALUASI` int(11) NOT NULL,
  `ID_PEMERIKSAAN` int(11) NOT NULL,
  `ID_DOKTER` varchar(8) NOT NULL,
  `TGL_EVALUASI` datetime NOT NULL,
  `RESPON_MEDIS` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `ID_PASIEN` varchar(8) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `ALAMAT` varchar(100) NOT NULL,
  `NO_TELP` varchar(12) NOT NULL,
  `TGL_LAHIR` date NOT NULL,
  `KOTA` varchar(20) NOT NULL,
  `HISTORI_KESEHATAN` varchar(300) NOT NULL,
  `NIK` varchar(16) NOT NULL,
  `NO_KK` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pemeriksaan`
--

CREATE TABLE `pemeriksaan` (
  `ID_PEMERIKSAAN` int(11) NOT NULL,
  `ID_PASIEN` varchar(8) NOT NULL,
  `ID_RELAWAN` varchar(8) NOT NULL,
  `TGL_PEMERIKSAAN` datetime NOT NULL,
  `KEHAMILAN_KE` int(11) NOT NULL,
  `KELUHAN` varchar(1000) NOT NULL,
  `TEKANAN_DARAH_SISTOL` float NOT NULL,
  `TEKANAN_DARAH_DIASTOL` float NOT NULL,
  `BERAT_BADAN` float NOT NULL,
  `TINGGI_BADAN` float NOT NULL,
  `UMUR_KEHAMILAN` int(11) NOT NULL,
  `FOTO` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `relawan`
--

CREATE TABLE `relawan` (
  `ID_RELAWAN` varchar(8) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `ALAMAT` varchar(100) NOT NULL,
  `NO_TELP` varchar(12) NOT NULL,
  `NIK` varchar(16) NOT NULL,
  `STATUS` tinyint(1) NOT NULL,
  `EMAIL` varchar(30) NOT NULL,
  `PASSWORD` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `relawan`
--

INSERT INTO `relawan` (`ID_RELAWAN`, `NAMA`, `ALAMAT`, `NO_TELP`, `NIK`, `STATUS`, `EMAIL`, `PASSWORD`) VALUES
('RELW0001', 'Rista', 'Kedurus III Pilang Asri No 16', '085815314881', '3578015404990002', 1, 'rista@gmail.com', 'rista123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`ID_DOKTER`);

--
-- Indexes for table `evaluasi`
--
ALTER TABLE `evaluasi`
  ADD PRIMARY KEY (`ID_EVALUASI`),
  ADD KEY `MELAKUKAN1_FK` (`ID_DOKTER`),
  ADD KEY `MEMILIKI_FK` (`ID_PEMERIKSAAN`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`ID_PASIEN`);

--
-- Indexes for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD PRIMARY KEY (`ID_PEMERIKSAAN`),
  ADD KEY `MENJALANI_FK` (`ID_PASIEN`),
  ADD KEY `MELAKUKAN_FK` (`ID_RELAWAN`);

--
-- Indexes for table `relawan`
--
ALTER TABLE `relawan`
  ADD PRIMARY KEY (`ID_RELAWAN`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `evaluasi`
--
ALTER TABLE `evaluasi`
  ADD CONSTRAINT `FK_MELAKUKAN1` FOREIGN KEY (`ID_DOKTER`) REFERENCES `dokter` (`ID_DOKTER`),
  ADD CONSTRAINT `FK_MEMILIKI` FOREIGN KEY (`ID_PEMERIKSAAN`) REFERENCES `pemeriksaan` (`ID_PEMERIKSAAN`);

--
-- Constraints for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD CONSTRAINT `FK_MELAKUKAN` FOREIGN KEY (`ID_RELAWAN`) REFERENCES `relawan` (`ID_RELAWAN`),
  ADD CONSTRAINT `FK_MENJALANI` FOREIGN KEY (`ID_PASIEN`) REFERENCES `pasien` (`ID_PASIEN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
