# Write your MySQL query statement below
# Write your MySQL query statement below
WITH highestSalary AS(
    select d.name as Department,e.name as Employee,e.salary as Salary
    from employee e
    join department d on e.departmentId = d.id
    where e.salary = (select max(salary) from employee where departmentId = e.departmentId)
)
select Department,Employee,Salary
from highestSalary;