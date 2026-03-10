# Write your MySQL query statement below

(select name as results
from users u
join movierating r on u.user_id = r.user_id
group by u.user_id
order by count(*) desc, name
limit 1)
union all
(select title as results
from movies m
join movierating r on m.movie_id = r.movie_id
where month(r.created_at)=2 and year(r.created_at)=2020
group by m.movie_id
order by avg(r.rating) desc, title
limit 1);