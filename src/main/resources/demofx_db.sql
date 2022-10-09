-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.6.45 - MySQL Community Server (GPL)
-- Server OS:                    Linux
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
CREATE USER 'test'@'localhost' IDENTIFIED BY 'test_pass';
GRANT ALL PRIVILEGES ON *.* TO 'test'@'localhost' WITH GRANT OPTION;
CREATE USER 'root'@'%' IDENTIFIED BY 'asd123';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
CREATE USER 'root'@'localhost' IDENTIFIED BY 'asd123';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

-- Dumping database structure for demofx_db
drop database IF EXISTS `demofx_db`;
create DATABASE IF NOT EXISTS `demofx_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `demofx_db`;

-- Dumping structure for table demofx_db.book_entity
drop table IF EXISTS `book_entity`;
create TABLE IF NOT EXISTS `book_entity` (
  `id` bigint(20) NOT NULL,
  `added_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isbn` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table demofx_db.book_entity: ~0 rows (approximately)
/*!40000 ALTER TABLE `book_entity` DISABLE KEYS */;
REPLACE INTO `book_entity` (`id`, `added_on`, `isbn`, `title`) VALUES
	(1, '2019-10-08 06:58:39', 'sadsad', 'asdsda'),
	(2, '2019-10-08 06:59:20', 'sdsd', 'dsd');
/*!40000 ALTER TABLE `book_entity` ENABLE KEYS */;

-- Dumping structure for table demofx_db.hibernate_sequence
drop table IF EXISTS `hibernate_sequence`;
create TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table demofx_db.hibernate_sequence: ~1 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
REPLACE INTO `hibernate_sequence` (`next_val`) VALUES
	(3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
