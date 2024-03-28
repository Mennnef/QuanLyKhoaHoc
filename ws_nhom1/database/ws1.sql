-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for ws_nhom1
DROP DATABASE IF EXISTS `ws_nhom1`;
CREATE DATABASE IF NOT EXISTS `ws_nhom1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ws_nhom1`;

-- Dumping structure for table ws_nhom1.cahoc
DROP TABLE IF EXISTS `cahoc`;
CREATE TABLE IF NOT EXISTS `cahoc` (
  `maCa` varchar(50) NOT NULL DEFAULT '',
  `thoiGianBatDau` varchar(50) NOT NULL DEFAULT '',
  `thoiGianKetThuc` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`maCa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.cahoc: ~5 rows (approximately)
REPLACE INTO `cahoc` (`maCa`, `thoiGianBatDau`, `thoiGianKetThuc`) VALUES
	('Ca 1', '07:30:00', '09:30:00'),
	('Ca 2', '09:45:00', '11:45:00'),
	('Ca 3', '13:00:00', '15:00:00'),
	('Ca 4', '15:15:00', '17:15:00'),
	('Ca 5', '18:00:00', '20:00:00');

-- Dumping structure for table ws_nhom1.dangky
DROP TABLE IF EXISTS `dangky`;
CREATE TABLE IF NOT EXISTS `dangky` (
  `maDK` varchar(50) NOT NULL DEFAULT '',
  `emailUser` varchar(50) NOT NULL DEFAULT '',
  `maMHCT` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`maDK`) USING BTREE,
  KEY `FK_dangky_user` (`emailUser`),
  KEY `FK_dangky_monhocchitiet` (`maMHCT`) USING BTREE,
  CONSTRAINT `FK_dangky_monhocchitiet` FOREIGN KEY (`maMHCT`) REFERENCES `monhocchitiet` (`maMHCT`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_dangky_user` FOREIGN KEY (`emailUser`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.dangky: ~4 rows (approximately)
REPLACE INTO `dangky` (`maDK`, `emailUser`, `maMHCT`) VALUES
	('DK0', 'admin', 'MHCT0'),
	('DK1', 'daoducdung2000@gmail.com', 'MHCT0'),
	('DK2', 'admin', 'MHCT5'),
	('DK3', 'admin', 'MHCT10');

-- Dumping structure for table ws_nhom1.danhgia
DROP TABLE IF EXISTS `danhgia`;
CREATE TABLE IF NOT EXISTS `danhgia` (
  `maDG` varchar(50) NOT NULL DEFAULT '',
  `emailUser` varchar(50) NOT NULL DEFAULT '',
  `maMH` varchar(50) NOT NULL DEFAULT '',
  `noiDung` varchar(500) NOT NULL DEFAULT '',
  PRIMARY KEY (`maDG`),
  KEY `FK_danhgia_user` (`emailUser`),
  KEY `FK_danhgia_monhocchitiet` (`maMH`),
  CONSTRAINT `FK_danhgia_monhocchitiet` FOREIGN KEY (`maMH`) REFERENCES `monhocchitiet` (`maMH`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_danhgia_user` FOREIGN KEY (`emailUser`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.danhgia: ~0 rows (approximately)

-- Dumping structure for table ws_nhom1.diemchitiet
DROP TABLE IF EXISTS `diemchitiet`;
CREATE TABLE IF NOT EXISTS `diemchitiet` (
  `email` varchar(50) NOT NULL DEFAULT '',
  `maMHCT` varchar(50) NOT NULL DEFAULT '',
  `maDauDiem` varchar(50) NOT NULL DEFAULT '',
  `diem` float NOT NULL DEFAULT 0,
  `ghiChu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`email`,`maMHCT`,`maDauDiem`) USING BTREE,
  KEY `FK_diemchitiet_diemso` (`maDauDiem`),
  KEY `FK_diemchitiet_monhocchitiet` (`maMHCT`),
  CONSTRAINT `FK_diemchitiet_diemso` FOREIGN KEY (`maDauDiem`) REFERENCES `diemso` (`maDauDiem`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_diemchitiet_monhocchitiet` FOREIGN KEY (`maMHCT`) REFERENCES `monhocchitiet` (`maMHCT`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.diemchitiet: ~14 rows (approximately)
REPLACE INTO `diemchitiet` (`email`, `maMHCT`, `maDauDiem`, `diem`, `ghiChu`) VALUES
	('admin', 'MHCT0', 'DD0', -1, ''),
	('admin', 'MHCT0', 'DD1', -1, ''),
	('admin', 'MHCT0', 'DD2', -1, ''),
	('admin', 'MHCT10', 'DD0', -1, 'null'),
	('admin', 'MHCT10', 'DD1', -1, 'null'),
	('admin', 'MHCT10', 'DD2', -1, 'null'),
	('admin', 'MHCT5', 'DD0', -1, NULL),
	('admin', 'MHCT5', 'DD1', -1, NULL),
	('admin', 'MHCT5', 'DD2', -1, NULL),
	('daoducdung2000@gmail.com', 'MHCT0', 'DD0', 10, 'Gioi'),
	('daoducdung2000@gmail.com', 'MHCT0', 'DD1', 10, 'Xuat sac'),
	('daoducdung2000@gmail.com', 'MHCT0', 'DD2', 10, 'VipPro');

-- Dumping structure for table ws_nhom1.diemso
DROP TABLE IF EXISTS `diemso`;
CREATE TABLE IF NOT EXISTS `diemso` (
  `maDauDiem` varchar(50) NOT NULL DEFAULT '',
  `tenDauDiem` varchar(50) NOT NULL DEFAULT '',
  `trongSo` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`maDauDiem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.diemso: ~3 rows (approximately)
REPLACE INTO `diemso` (`maDauDiem`, `tenDauDiem`, `trongSo`) VALUES
	('DD0', 'Lab 1', 1),
	('DD1', 'Lab 2', 1),
	('DD2', 'Assignment', 3);

-- Dumping structure for table ws_nhom1.giangvien
DROP TABLE IF EXISTS `giangvien`;
CREATE TABLE IF NOT EXISTS `giangvien` (
  `email` varchar(50) NOT NULL DEFAULT '',
  `kinhNghiem` int(11) DEFAULT 0,
  `chuyenMon` varchar(50) DEFAULT '0',
  `cv` varchar(50) DEFAULT '0',
  PRIMARY KEY (`email`),
  CONSTRAINT `FK_giangvien_user` FOREIGN KEY (`email`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.giangvien: ~3 rows (approximately)
REPLACE INTO `giangvien` (`email`, `kinhNghiem`, `chuyenMon`, `cv`) VALUES
	('cogiao@gmail.com', 12, '0', '0'),
	('thaygiao@gmail.com', 20, '0', '0');

-- Dumping structure for table ws_nhom1.khoahoc
DROP TABLE IF EXISTS `khoahoc`;
CREATE TABLE IF NOT EXISTS `khoahoc` (
  `maKH` varchar(255) NOT NULL,
  `tenKH` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.khoahoc: ~3 rows (approximately)
REPLACE INTO `khoahoc` (`maKH`, `tenKH`) VALUES
	('kh01', 'Web Designer'),
	('kh02', 'Lập Trình Di Động'),
	('kh03', 'Lập trình cơ bản');

-- Dumping structure for table ws_nhom1.khuvuc
DROP TABLE IF EXISTS `khuvuc`;
CREATE TABLE IF NOT EXISTS `khuvuc` (
  `maKhu` varchar(50) NOT NULL DEFAULT '',
  `tenKhu` varchar(50) DEFAULT NULL,
  `diaChi` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`maKhu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.khuvuc: ~3 rows (approximately)
REPLACE INTO `khuvuc` (`maKhu`, `tenKhu`, `diaChi`) VALUES
	('Khu 1', 'Công viên phần mền quang trung', 'Ở đâu còn lâu mới nói'),
	('Khu 2', 'Tòa nhà bỏ hoang', 'Ở đấu trường công lý'),
	('Khu 3', 'Vương quốc tử vong', 'Ở lãnh địa sương đen');

-- Dumping structure for table ws_nhom1.lophoc
DROP TABLE IF EXISTS `lophoc`;
CREATE TABLE IF NOT EXISTS `lophoc` (
  `maLop` varchar(50) NOT NULL DEFAULT '',
  `maKhu` varchar(50) DEFAULT NULL,
  `moTa` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`maLop`),
  KEY `FK_lophoc_khuvuc` (`maKhu`),
  CONSTRAINT `FK_lophoc_khuvuc` FOREIGN KEY (`maKhu`) REFERENCES `khuvuc` (`maKhu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.lophoc: ~18 rows (approximately)
REPLACE INTO `lophoc` (`maLop`, `maKhu`, `moTa`) VALUES
	('F101', 'Khu 2', 'Lầu 1'),
	('F203', 'Khu 2', 'Lầu 2'),
	('F402', 'Khu 2', 'Lầu 3'),
	('F403', 'Khu 2', 'Lầu 3'),
	('F404', 'Khu 2', 'Lầu 3'),
	('F408', 'Khu 3', 'Lầu 3'),
	('P333', 'Khu 3', 'Lầu 3'),
	('P444', 'Khu 2', 'Lầu 4'),
	('P555', 'Khu 2', 'Lầu 5'),
	('P666', 'Khu 3', 'Lầu 6'),
	('P888', 'Khu 2', 'Lầu 8'),
	('P999', 'Khu 3', 'Lầu 9'),
	('T1007', 'Khu 1', 'Lầu 10'),
	('T1106', 'Khu 1', 'Lầu 11'),
	('T1110', 'Khu 1', 'Lầu 11'),
	('T1111', 'Khu 1', 'Lầu 11'),
	('T1112', 'Khu 1', 'Lầu 11'),
	('T1113', 'Khu 1', 'Lầu 11');

-- Dumping structure for table ws_nhom1.monhoc
DROP TABLE IF EXISTS `monhoc`;
CREATE TABLE IF NOT EXISTS `monhoc` (
  `maMH` varchar(255) NOT NULL,
  `maKH` varchar(255) DEFAULT NULL,
  `tenMH` varchar(255) NOT NULL,
  `hinhMH` varchar(255) DEFAULT NULL,
  `soGioHoc` float NOT NULL,
  `taiLieuMon` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`maMH`),
  KEY `FK_monhoc_khoahoc` (`maKH`),
  CONSTRAINT `FK_monhoc_khoahoc` FOREIGN KEY (`maKH`) REFERENCES `khoahoc` (`maKH`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.monhoc: ~9 rows (approximately)
REPLACE INTO `monhoc` (`maMH`, `maKH`, `tenMH`, `hinhMH`, `soGioHoc`, `taiLieuMon`) VALUES
	('MH0', 'kh01', 'Khóa học html/css', 'htmlcss.jpg', 60, NULL),
	('MH1', 'kh01', 'Khóa học JavaScrip', 'JavaScript.jpg', 25, NULL),
	('MH2', 'kh01', 'Khóa học PHP', 'PHP.jpg', 0, NULL),
	('MH3', 'kh02', 'Khóa học Flutter & Dart', 'FlutterNDart.png', 0, NULL),
	('MH4', 'kh02', 'Khóa học IOS', 'ios.jpg', 0, NULL),
	('MH5', 'kh02', 'Khóa học Android', 'android.jpg', 0, NULL),
	('MH6', 'kh03', 'Khóa học Kotlin', 'kotlin.png', 0, NULL),
	('MH7', 'kh03', 'Khóa học Python', 'python.png', 0, NULL),
	('MH8', 'kh03', ' Khóa học Java ', 'java.jpg', 45, NULL);

-- Dumping structure for table ws_nhom1.monhocchitiet
DROP TABLE IF EXISTS `monhocchitiet`;
CREATE TABLE IF NOT EXISTS `monhocchitiet` (
  `maMHCT` varchar(50) NOT NULL DEFAULT '',
  `maMH` varchar(50) NOT NULL DEFAULT '',
  `maLop` varchar(50) NOT NULL DEFAULT '',
  `maCa` varchar(50) NOT NULL DEFAULT '',
  `maGiangVien` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`maMHCT`) USING BTREE,
  KEY `FK_monhocchitiet_lophoc` (`maLop`),
  KEY `FK_monhocchitiet_cahoc` (`maCa`),
  KEY `FK_monhocchitiet_giangvien` (`maGiangVien`),
  KEY `maMH` (`maMH`),
  CONSTRAINT `FK_monhocchitiet_cahoc` FOREIGN KEY (`maCa`) REFERENCES `cahoc` (`maCa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_monhocchitiet_giangvien` FOREIGN KEY (`maGiangVien`) REFERENCES `giangvien` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_monhocchitiet_lophoc` FOREIGN KEY (`maLop`) REFERENCES `lophoc` (`maLop`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_monhocchitiet_monhoc` FOREIGN KEY (`maMH`) REFERENCES `monhoc` (`maMH`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.monhocchitiet: ~90 rows (approximately)
REPLACE INTO `monhocchitiet` (`maMHCT`, `maMH`, `maLop`, `maCa`, `maGiangVien`) VALUES
	('MHCT0', 'MH0', 'T1007', 'Ca 1', 'cogiao@gmail.com'),
	('MHCT1', 'MH0', 'T1007', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT10', 'MH2', 'F101', 'Ca 1', 'thaygiao@gmail.com'),
	('MHCT11', 'MH2', 'F101', 'Ca 2', 'cogiao@gmail.com'),
	('MHCT12', 'MH2', 'F101', 'Ca 3', 'thaygiao@gmail.com'),
	('MHCT13', 'MH2', 'F101', 'Ca 4', 'cogiao@gmail.com'),
	('MHCT14', 'MH2', 'F101', 'Ca 5', 'thaygiao@gmail.com'),
	('MHCT15', 'MH3', 'F403', 'Ca 1', 'cogiao@gmail.com'),
	('MHCT16', 'MH3', 'F403', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT17', 'MH3', 'F403', 'Ca 3', 'cogiao@gmail.com'),
	('MHCT18', 'MH3', 'F403', 'Ca 4', 'thaygiao@gmail.com'),
	('MHCT19', 'MH3', 'F403', 'Ca 5', 'cogiao@gmail.com'),
	('MHCT2', 'MH0', 'T1007', 'Ca 3', 'thaygiao@gmail.com'),
	('MHCT20', 'MH4', 'P666', 'Ca 1', 'thaygiao@gmail.com'),
	('MHCT21', 'MH4', 'P666', 'Ca 2', 'cogiao@gmail.com'),
	('MHCT22', 'MH4', 'P666', 'Ca 3', 'thaygiao@gmail.com'),
	('MHCT23', 'MH4', 'P666', 'Ca 4', 'cogiao@gmail.com'),
	('MHCT24', 'MH4', 'P666', 'Ca 5', 'thaygiao@gmail.com'),
	('MHCT25', 'MH5', 'T1110', 'Ca 1', 'thaygiao@gmail.com'),
	('MHCT26', 'MH5', 'T1110', 'Ca 2', 'cogiao@gmail.com'),
	('MHCT27', 'MH5', 'T1110', 'Ca 3', 'thaygiao@gmail.com'),
	('MHCT28', 'MH5', 'T1110', 'Ca 4', 'cogiao@gmail.com'),
	('MHCT29', 'MH5', 'T1110', 'Ca 5', 'thaygiao@gmail.com'),
	('MHCT3', 'MH0', 'T1007', 'Ca 4', 'cogiao@gmail.com'),
	('MHCT30', 'MH6', 'P333', 'Ca 1', 'cogiao@gmail.com'),
	('MHCT31', 'MH6', 'P333', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT32', 'MH6', 'P333', 'Ca 3', 'cogiao@gmail.com'),
	('MHCT33', 'MH6', 'P333', 'Ca 4', 'thaygiao@gmail.com'),
	('MHCT34', 'MH6', 'P333', 'Ca 5', 'cogiao@gmail.com'),
	('MHCT35', 'MH7', 'F203', 'Ca 1', 'thaygiao@gmail.com'),
	('MHCT36', 'MH7', 'F203', 'Ca 2', 'cogiao@gmail.com'),
	('MHCT37', 'MH7', 'F203', 'Ca 3', 'thaygiao@gmail.com'),
	('MHCT38', 'MH7', 'F203', 'Ca 4', 'cogiao@gmail.com'),
	('MHCT39', 'MH7', 'F203', 'Ca 5', 'thaygiao@gmail.com'),
	('MHCT4', 'MH0', 'T1110', 'Ca 5', 'cogiao@gmail.com'),
	('MHCT40', 'MH8', 'F402', 'Ca 1', 'cogiao@gmail.com'),
	('MHCT41', 'MH8', 'F402', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT42', 'MH8', 'F402', 'Ca 3', 'cogiao@gmail.com'),
	('MHCT43', 'MH8', 'F402', 'Ca 4', 'thaygiao@gmail.com'),
	('MHCT44', 'MH8', 'F402', 'Ca 5', 'cogiao@gmail.com'),
	('MHCT45', 'MH0', 'T1112', 'Ca 1', 'thaygiao@gmail.com'),
	('MHCT46', 'MH0', 'T1112', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT47', 'MH0', 'T1112', 'Ca 3', 'cogiao@gmail.com'),
	('MHCT48', 'MH0', 'T1112', 'Ca 4', 'thaygiao@gmail.com'),
	('MHCT49', 'MH0', 'T1112', 'Ca 5', 'cogiao@gmail.com'),
	('MHCT5', 'MH1', 'T1106', 'Ca 1', 'cogiao@gmail.com'),
	('MHCT50', 'MH1', 'T1111', 'Ca 1', 'thaygiao@gmail.com'),
	('MHCT51', 'MH1', 'T1111', 'Ca 2', 'cogiao@gmail.com'),
	('MHCT52', 'MH1', 'T1111', 'Ca 3', 'thaygiao@gmail.com'),
	('MHCT53', 'MH1', 'T1111', 'Ca 4', 'cogiao@gmail.com'),
	('MHCT54', 'MH1', 'T1111', 'Ca 5', 'thaygiao@gmail.com'),
	('MHCT55', 'MH2', 'F404', 'Ca 1', 'cogiao@gmail.com'),
	('MHCT56', 'MH2', 'F404', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT57', 'MH2', 'F404', 'Ca 3', 'cogiao@gmail.com'),
	('MHCT58', 'MH2', 'F404', 'Ca 4', 'thaygiao@gmail.com'),
	('MHCT59', 'MH2', 'F404', 'Ca 5', 'cogiao@gmail.com'),
	('MHCT6', 'MH1', 'T1106', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT60', 'MH3', 'P999', 'Ca 1', 'thaygiao@gmail.com'),
	('MHCT61', 'MH3', 'P999', 'Ca 2', 'cogiao@gmail.com'),
	('MHCT62', 'MH3', 'P999', 'Ca 3', 'thaygiao@gmail.com'),
	('MHCT63', 'MH3', 'P999', 'Ca 4', 'cogiao@gmail.com'),
	('MHCT64', 'MH3', 'P999', 'Ca 5', 'thaygiao@gmail.com'),
	('MHCT65', 'MH4', 'P444', 'Ca 1', 'cogiao@gmail.com'),
	('MHCT66', 'MH4', 'P444', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT67', 'MH4', 'P444', 'Ca 3', 'cogiao@gmail.com'),
	('MHCT68', 'MH4', 'P444', 'Ca 4', 'thaygiao@gmail.com'),
	('MHCT69', 'MH4', 'P444', 'Ca 5', 'cogiao@gmail.com'),
	('MHCT7', 'MH1', 'T1106', 'Ca 3', 'cogiao@gmail.com'),
	('MHCT70', 'MH5', 'P555', 'Ca 1', 'thaygiao@gmail.com'),
	('MHCT71', 'MH5', 'P555', 'Ca 2', 'cogiao@gmail.com'),
	('MHCT72', 'MH5', 'P555', 'Ca 3', 'thaygiao@gmail.com'),
	('MHCT73', 'MH5', 'P555', 'Ca 4', 'cogiao@gmail.com'),
	('MHCT74', 'MH5', 'P555', 'Ca 5', 'thaygiao@gmail.com'),
	('MHCT75', 'MH6', 'T1113', 'Ca 1', 'cogiao@gmail.com'),
	('MHCT76', 'MH6', 'T1106', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT77', 'MH6', 'T1106', 'Ca 3', 'cogiao@gmail.com'),
	('MHCT78', 'MH6', 'T1106', 'Ca 4', 'thaygiao@gmail.com'),
	('MHCT79', 'MH6', 'T1106', 'Ca 5', 'cogiao@gmail.com'),
	('MHCT8', 'MH1', 'T1106', 'Ca 4', 'thaygiao@gmail.com'),
	('MHCT80', 'MH7', 'P888', 'Ca 1', 'thaygiao@gmail.com'),
	('MHCT81', 'MH7', 'P888', 'Ca 2', 'cogiao@gmail.com'),
	('MHCT82', 'MH7', 'P888', 'Ca 3', 'thaygiao@gmail.com'),
	('MHCT83', 'MH7', 'P888', 'Ca 4', 'cogiao@gmail.com'),
	('MHCT84', 'MH7', 'P888', 'Ca 5', 'thaygiao@gmail.com'),
	('MHCT85', 'MH8', 'F408', 'Ca 1', 'cogiao@gmail.com'),
	('MHCT86', 'MH8', 'F408', 'Ca 2', 'thaygiao@gmail.com'),
	('MHCT87', 'MH8', 'F408', 'Ca 3', 'cogiao@gmail.com'),
	('MHCT88', 'MH8', 'F408', 'Ca 4', 'thaygiao@gmail.com'),
	('MHCT89', 'MH8', 'F408', 'Ca 5', 'cogiao@gmail.com'),
	('MHCT9', 'MH1', 'T1106', 'Ca 5', 'cogiao@gmail.com');

-- Dumping structure for table ws_nhom1.thongtincn
DROP TABLE IF EXISTS `thongtincn`;
CREATE TABLE IF NOT EXISTS `thongtincn` (
  `maThongTin` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  `phone` varchar(50) DEFAULT '',
  `avatar` varchar(50) DEFAULT '',
  PRIMARY KEY (`maThongTin`),
  KEY `FK__user` (`email`),
  CONSTRAINT `FK__user` FOREIGN KEY (`email`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.thongtincn: ~5 rows (approximately)
REPLACE INTO `thongtincn` (`maThongTin`, `email`, `name`, `phone`, `avatar`) VALUES
	('TT0', 'admin', 'admin', '0907890653', 'idea.png'),
	('TT1', 'cogiao@gmail.com', 'Cô Giáo', '020202020', ''),
	('TT2', 'myhanh@gmail.com', 'Mỹ Hạnh', '0798937490', ''),
	('TT3', 'daoducdung2000@gmail.com', 'Dao Duc Dung', '0906789064', NULL),
	('TT4', 'thaygiao@gmail.com', 'Thầy Giáo', '020202020', '');

-- Dumping structure for table ws_nhom1.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(255) NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.user: ~6 rows (approximately)
REPLACE INTO `user` (`username`, `answer`, `password`, `role`) VALUES
	('admin', '', 'admin', 'admin'),
	('cogiao@gmail.com', 'What\'s your father name?: ...', '123', 'gv'),
	('daoducdung2000@gmail.com', 'What\'s your father name?: 123', '123', 'hv'),
	('myhanh@gmail.com', '', '', 'hv'),
	('thaygiao@gmail.com', 'What\'s your father name?: ...', '123', 'gv');

-- Dumping structure for table ws_nhom1.waitaccept
DROP TABLE IF EXISTS `waitaccept`;
CREATE TABLE IF NOT EXISTS `waitaccept` (
  `Email` varchar(50) NOT NULL,
  `kinhNghiem` int(11) DEFAULT NULL,
  `chuyenMon` varchar(50) DEFAULT NULL,
  `cv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Email`),
  CONSTRAINT `FK_waitaccept_user` FOREIGN KEY (`Email`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table ws_nhom1.waitaccept: ~0 rows (approximately)
REPLACE INTO `waitaccept` (`Email`, `kinhNghiem`, `chuyenMon`, `cv`) VALUES
	('myhanh@gmail.com', 23, '12', 'work-process.png');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
