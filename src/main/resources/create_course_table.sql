delimiter $$

CREATE TABLE `course` (
  `course_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_code` varchar(10) NOT NULL,
  `begin_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `teacher_id` bigint(20) NOT NULL,
  PRIMARY KEY (`course_id`),
  Foreign Key (teacher_id) references teacher(teacher_id)
  UNIQUE(course_code)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1$$

