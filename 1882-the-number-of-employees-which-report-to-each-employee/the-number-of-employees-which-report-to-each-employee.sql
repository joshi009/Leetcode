# Write your MySQL query statement below
SELECT E2.reports_to as employee_id, E1.name as name, COUNT(*) as reports_count, ROUND(AVG(E2.age)) as average_age
FROM employees E1
JOIN employees E2 ON E1.employee_id = E2.reports_to
GROUP BY E2.reports_to, E1.name
ORDER BY employee_id;