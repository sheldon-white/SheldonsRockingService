delimiter $$

CREATE TABLE `student` (
  `student_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_code` VARCHAR(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE(student_code)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1$$