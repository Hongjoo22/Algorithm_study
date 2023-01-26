-- 혹은 select count(distinct name) as count from animal_ins
select count(*) as count from (SELECT distinct name from animal_ins where name is not null) as t1
