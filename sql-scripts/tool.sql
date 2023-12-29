CREATE DATABASE  IF NOT EXISTS `tool_directory`;
USE `tool_directory`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tool`;

CREATE TABLE `tool` (
   `barcode_id` int NOT NULL AUTO_INCREMENT,
  `parent_barcode_id` varchar(45) DEFAULT NULL,
  `part_number` varchar(68) DEFAULT NULL,
  `serial_number` varchar(45) DEFAULT NULL,
   `description` varchar(45) DEFAULT NULL,
	`location` varchar(45) DEFAULT NULL,
	`shelf` varchar(45) DEFAULT NULL,
	`verification_type` varchar(45) DEFAULT NULL,
	`next_due_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`barcode_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `tool`
VALUES
('1','2','D34343D1', '34543456535', 'Torque wrench', 'Hangar', 'A35-1', 'Calibration', '11.02.2024'),
('2','2','Q2334453', '32432432', 'Hammer', 'Outside', 'A35-1', 'Calibration', '11.02.2024'),
('3','2','G9869', '3454354535', 'Screwdriver', 'Callibration', 'A35-1', 'Calibration', '11.02.2024'),
('4','2','K098098', 'F324534', 'Torque wrench', 'Outside', 'A35-1', 'Calibration', '11.02.2024'),
('5','2','T324324', '34543535', 'Rotor', 'Callibration', 'A35-1', 'Calibration', '11.02.2024'),
('6','2','G3434', '987987K', 'Screwdriver', 'Hangar', 'A35-1', 'Calibration', '11.02.2024'),
('7','2','B333432', '987987K5564', 'Hammer', 'Outside', 'A35-1', 'Calibration', '11.02.2024'),
('8','2','G435345', 'F3243455', 'Torque wrench', 'Callibration', 'A35-1', 'Calibration', '11.02.2024'),
('9','2','G445345', 'FF45', 'Screwdriver', 'Hangar', 'A35-1', 'Calibration', '11.02.2024');


SET FOREIGN_KEY_CHECKS = 1;
