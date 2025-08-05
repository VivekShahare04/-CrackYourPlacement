# Write your MySQL query statement below
select actor_id,director_id from ActorDirector
group by actor_id,director_id having count(distinct timestamp)>=3;  # distinct time k hisab se count krna have very optimize one amazing!!!!!1