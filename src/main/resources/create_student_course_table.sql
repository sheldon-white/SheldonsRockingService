delimiter $$

CREATE TABLE `student_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  Foreign Key (course_id) references course(course_id),
  Foreign Key (student_id) references student(student_id)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1$$

CREATE INDEX idx_course_code ON student_course(course_id);
CREATE INDEX idx_student_code ON student_course(student_id)
alter table student_course add unique index(course_id, student_id);