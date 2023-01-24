-- date_format의 Y는 4글자 y는 2글자, M은 영어로 m은 숫자로, D는 th로 d는 숫자로
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(date_of_birth,"%Y-%m-%d") as DATE_OF_BIRTH  from member_profile
where date_of_birth like "%-03-%" and tlno is not null and gender = "W" order by member_id;
