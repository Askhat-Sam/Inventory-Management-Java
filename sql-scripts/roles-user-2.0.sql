USE `tool_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `user`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `user` (
   `id`int NOT NULL AUTO_INCREMENT,
  `user_id`varchar(50)  DEFAULT NULL,
  `first_name`varchar(50)  DEFAULT NULL,
  `last_name`varchar(50)  DEFAULT NULL,
  `email`varchar(50)  DEFAULT NULL,
  `password` char(78)  DEFAULT NULL,
  `active` tinyint  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `join_id` int DEFAULT NULL,
  `user_role` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_INSTRUCTOR_idx` (`join_id`),
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`join_id`) 
  REFERENCES `user` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `user`
VALUES
('1','john.s','john', 'smith', 'john.s@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('2','mary.s','mary', 'smith', 'mary.s@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('3','susan.s','susan', 'smith', 'susan.s@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);

INSERT INTO `roles`
VALUES
('1','john.s','1', 'ROLE_EMPLOYEE'),
('2','mary.s','2','ROLE_EMPLOYEE'),
('3','mary.s','2','ROLE_MANAGER'),
('4','susan.s','3','ROLE_EMPLOYEE'),
('5','susan.s','3','ROLE_MANAGER'),
('6','susan.s','3','ROLE_ADMIN');