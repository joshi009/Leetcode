# Write your MySQL query statement below
select name,Bonus
from Bonus Right join Employee
on Employee.empId = Bonus.empId
where bonus < 1000  or bonus is null