USE `tool_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id`int NOT NULL ,
  `user_id`varchar(50) NOT NULL,
  `first_name`varchar(50) NOT NULL,
  `last_name`varchar(50) NOT NULL,
  `email`varchar(50) NOT NULL,
  `password` char(78) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `roles` (
  `id` int DEFAULT NULL,
  `user_id` varchar(50) NOT NULL,
  `user_role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `roles`
ADD CONSTRAINT FK_role_user
foreign key (`id`)
references `user`(`id`);

INSERT INTO `user`
VALUES
('1','john.s','john', 'smith', 'john.s@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('2','mary.s','mary', 'smith', 'mary.s@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('3','susan.s','susan', 'smith', 'susan.s@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);

INSERT INTO `roles`
VALUES
('1','john.s','ROLE_ADMIN'),
('2','mary.s','ROLE_EMPLOYEE'),
('2','mary.s','ROLE_MANAGER'),
('3','susan.s','ROLE_EMPLOYEE'),
('3','susan.s','ROLE_MANAGER'),
('3','susan.s','ROLE_ADMIN');
