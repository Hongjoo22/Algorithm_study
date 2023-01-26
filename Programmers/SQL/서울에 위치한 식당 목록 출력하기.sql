-- %는 뒤에만(도로명이 서울일 수 있음)
SELECT r.rest_id, rest_name, food_type, favorites, address, round(avg(review_score),2) score
from rest_review r join rest_info i using(rest_id)
where address like "서울%"
group by rest_id
order by 6 desc, 4 desc
