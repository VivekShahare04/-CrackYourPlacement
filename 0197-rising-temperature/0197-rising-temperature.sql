# Write your MySQL query statement below
select w1.id 
from Weather w1 
join Weather w2
on DATE(w1.recordDate)=DATE(w2.recordDate) + INTERVAL 1 day
where w1.temperature > w2.temperature 