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
('4','4','K098098', 'F324534', 'Torque wrench', 'Outside', 'A35-1', 'Calibration', '11.02.2024'),
('5','2','T324324', '34543535', 'Rotor', 'Callibration', 'A35-1', 'Calibration', '11.02.2024'),
('6','4','G3434', '987987K', 'Screwdriver', 'Hangar', 'A35-1', 'Calibration', '11.02.2024'),
('7','2','B333432', '987987K5564', 'Hammer', 'Outside', 'A35-1', 'Calibration', '11.02.2024'),
('8','2','X234234', 'F3243455', 'Torque wrench', 'Callibration', 'A35-1', 'Calibration', '11.02.2024'),
('9','2','BV33434', '3455464', 'Screwdriver', 'Hangar', 'A35-1', 'Calibration', '11.02.2024'),
('10','4','G445345', '785457', 'Hammer', 'Calibration', 'A35-1', 'Calibration', '11.02.2024'),
('11','2','B3454VV', '05443', 'Torque wrench', 'Hangar', 'A35-1', 'Calibration', '11.02.2024'),
('12','5','343579', '3679678', 'Screwdriver', 'Calibration', 'A35-1', 'Calibration', '09.02.2024'),
('13','5','D34534', '652323', 'Hammer', 'Tool Stor', 'A35-1', 'Calibration', '11.02.2024'),
('14','5','C34545', '45679', 'Torque wrench', 'Hangar', 'A35-1', 'Calibration', '11.02.2024'),
('15','5','I898', 'FF45', 'Screwdriver', 'Tool Stor', 'A35-1', 'Calibration', '13.02.2024'),
('16','2','UU8768', '008989', 'Torque wrench', 'Hangar', 'A35-1', 'Calibration', '21.02.2024'),
('17','2','L43543534', '345232', 'Hammer', 'Tool Stor', 'A35-1', 'Calibration', '11.02.2026'),
('18','2','J657565', '12334235', 'Screwdriver', 'Calibration', 'A35-1', 'Calibration', '23.02.2024'),
('19','2','F3245478', '768780', 'Torque wrench', 'Tool Stor', 'A35-1', 'Calibration', '11.02.2024'),
('20','2','G445345', '6545645', 'Hammer', 'Hangar', 'A35-1', 'Calibration', '11.02.2024'),
('21','2','HH8768', '32458568', 'Torque wrench', 'Tool Stor', 'A35-1', 'Calibration', '11.09.2026'),
('22','2','P509', '65867979686', 'Screwdriver', 'Calibration', 'A35-1', 'Calibration', '11.04.2024'),
('23','2','T4354', '65756', 'Screwdriver', 'Tool Store', 'A35-1', 'Calibration', '17.05.2024'),
('24','2','GG4543F', '345345', 'Screwdriver', 'Hangar', 'A35-1', 'Calibration', '12.09.2024');

SET FOREIGN_KEY_CHECKS = 1;
