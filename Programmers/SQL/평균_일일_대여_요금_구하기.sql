-- 반올림: round(값, 자리수) , 자리수는 소수점 아래 0부터시작
SELECT round(avg(DAILY_FEE),0) as AVERAGE_FEE FROM CAR_RENTAL_COMPANY_CAR
where car_type = "SUV"
