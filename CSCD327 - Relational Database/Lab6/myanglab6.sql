-- Lab 6

-- 1)
update instructor
set salary = salary * 1.1
where dept_name = 'Comp. Sci.';

-- 2)
delete from course
where course_id not in
	  (select course_id from section);
      
-- 3)
create temporary table temp_instructor
select *
from instructor;

insert into temp_instructor
select id, name, dept_name, 10000
from student
where tot_cred > 100;

select * from temp_instructor;

-- 4)
create temporary table temp_course
select * from course;
create temporary table temp_section
select * from section;
create temporary table temp_takes
select * from takes;

insert into temp_course
values ('CS-001', 'Computer Basics', 'Comp. Sci.', 2);
insert into temp_section
values ('CS-001', 1, 'Winter', 2018, ' ', ' ', ' ');
insert into temp_takes
select ID, 'CS-001', 1, 'Winter', 2018, null
from student
where student.dept_name = 'Comp. Sci.';


select * from temp_section;
select * from temp_takes;

-- 5)
drop table temp_takes1;
create temporary table temp_takes1
select * from temp_takes;

delete from temp_takes1
where course_id = 'CS-001' and 
	  sec_id = 1 and
	  semester = 'Winter' and
      year = 2018 and 
      ID = (select ID
			from student
			where name = 'Zhang');

select * from temp_takes1;

-- 6)
delete from temp_takes1
where course_id = (select course_id
				   from course
				   where lower(title) like '%database%');

select * from temp_takes1;

-- 7)
create temporary table temp_student
select * from student;

update temp_student
set tot_cred = (select sum(temp_course.credits)
				from temp_takes1 join temp_course using(course_id)
                where temp_takes1.ID = temp_student.ID and
				(temp_takes1.grade != 'f' or temp_takes1.grade is not null));

select * from temp_student;

create database w19yang_Constraints;