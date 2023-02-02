-- 문제 이해를 잘못함. 2022/04/13일 기준 취소 안된 흉부외과 진료 예약 내역
SELECT apnt_no, pt_name, a.pt_no, d.mcdp_cd, dr_name, apnt_YMD
from  appointment a join  patient p using(pt_no)
join doctor d on d.dr_id = a.mddr_id
where apnt_YMD like "2022-04-13%"
and APNT_CNCL_YN = "N"
and d.mcdp_cd = "CS"
order by 6

-- 또다른 3중 조인 방법
-- from appointment a, doctor d, patient p
-- where d.dr_id = a.mddr_id and p.pt_no = a.pt_no
