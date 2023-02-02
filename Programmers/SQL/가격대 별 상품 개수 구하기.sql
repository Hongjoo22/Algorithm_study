-- round(반올림), truncate(버림)
SELECT TRUNCATE(price/10000,0)*10000 PRICE_GROUP, count(*) PRODUCTS
from product
group by PRICE_GROUP
order by 1
