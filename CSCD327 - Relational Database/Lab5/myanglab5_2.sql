-- Lab5 (continued 2)

-- 12)
select id, name, salary
from instructor
where salary = (select max(salary)
				from instructor);
                
-- 13)
select id, name, salary
from instructor
where salary = (select max(salary)
				from instructor
                where salary < (select max(salary)
								from instructor));
                                
-- 14)
select id, name, count(distinct course_id) as cnt
from instructor join teaches using(id)
group by id
having
	count(distinct course_id) =  
		(select max(a.num)
			from (select count(distinct course_id) as num
                  from teaches
				  group by id) as a);

-- This returns the # of all the distinct courses taught by each instructor
select id, name, count(distinct course_id) as cnt
from instructor i
join teaches using(id)
group by i.id;