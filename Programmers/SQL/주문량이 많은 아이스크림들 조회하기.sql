-- flavor로 join
SELECT f.flavor from first_half f join july j using(flavor)
group by j.flavor
order by sum(j.total_order)+f.total_order desc limit 3
