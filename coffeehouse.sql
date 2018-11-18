-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2018 at 06:51 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffeehouse`
--

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `DoUongID` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `TenDoUong` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`DoUongID`, `TenDoUong`, `DonGia`) VALUES
('CAF', 'Nước Cam', 25000),
('CAP', 'Capucino', 30000),
('CFA', 'Cà Phê Dừa', 30000),
('CFD', 'Cà Phê Đen', 20000),
('CFR', 'Trà Lipton', 20000),
('CFS', 'Cà Phê Sữa', 25000),
('HG', 'Tra Xanh', 15000),
('HK', 'Sua Chua Mit', 25000),
('SN', 'Sữa Nóng', 20000),
('ST', 'String', 15000),
('TEA03', 'Tra Sua Dua Gang', 35000),
('TEMI', 'Tra Xoai Pudding', 40000),
('TMK', 'Tra sua kiwi', 40000),
('TRG', 'Trà Gừng', 20000),
('WT', 'Nước Táo', 25000);

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

CREATE TABLE `order_detail` (
  `GoiID` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `BanID` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `DoUongID` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `order_detail`
--

INSERT INTO `order_detail` (`GoiID`, `BanID`, `DoUongID`, `SoLuong`) VALUES
('11', 'B1', 'CAF', 2),
('12', 'B2', 'CAP', 6),
('13', 'B3', 'CFA', 3),
('21', 'B6', 'CFD', 2),
('23', 'B5', 'CFS', 1),
('22', 'B4', 'CFR', 3),
('1', 'B1', 'CFD', 1),
('2', 'B3', 'CFR', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tableitem`
--

CREATE TABLE `tableitem` (
  `BanID` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `TenBan` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `GhiChu` varchar(500) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `tableitem`
--

INSERT INTO `tableitem` (`BanID`, `TenBan`, `GhiChu`) VALUES
('11', 'Ban11', 'Gan Quay'),
('B1', 'Ban1', 'Gần cửa ra vào'),
('B10', 'Ban10', 'cuoi cung'),
('B12', 'Ban12', 'Canh cua so'),
('B2', 'Ban2', ''),
('B3', 'Ban3', ''),
('B4', 'Ban4', ''),
('B5', 'Ban5', ''),
('B6', 'Ban6', ''),
('B9', 'Ban9', 'Gan cua so');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` int(11) NOT NULL,
  `UserName` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `Password` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `Email` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `FullName` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `UserName`, `Password`, `Email`, `DiaChi`, `FullName`) VALUES
(1, 'phamthanhhue', '123456', 'hue@gmail.com', 'Tp Ho Chi Minh', 'Pham Thanh Hue'),
(2, 'tranthanhtruc', '123456', 'thanhtruc@code.com', '67 Le Duan, Ha Noi', 'Tran Thanh Truc'),
(3, 'admin', 'admin', 'admin@hus.edu.vn', 'Tp Ho Chi Minh', 'Pham Van Thanh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`DoUongID`);

--
-- Indexes for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD KEY `BanID` (`BanID`),
  ADD KEY `DoUongID` (`DoUongID`);

--
-- Indexes for table `tableitem`
--
ALTER TABLE `tableitem`
  ADD PRIMARY KEY (`BanID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`BanID`) REFERENCES `tableitem` (`BanID`),
  ADD CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`DoUongID`) REFERENCES `menu` (`DoUongID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
