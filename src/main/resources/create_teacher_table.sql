delimiter $$

CREATE TABLE `teacher` (
  `teacher_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_code` VARCHAR(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`teacher_id`),
  UNIQUE(teacher_code)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1$$