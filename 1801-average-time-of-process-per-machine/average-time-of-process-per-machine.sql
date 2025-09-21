# Write your MySQL query statement below
SELECT 
    a.machine_id,
    ROUND(AVG(e.timestamp - s.timestamp), 3) AS processing_time
FROM 
    Activity a
JOIN 
    Activity s ON a.machine_id = s.machine_id 
               AND a.process_id = s.process_id
               AND s.activity_type = 'start'
JOIN 
    Activity e ON a.machine_id = e.machine_id 
               AND a.process_id = e.process_id
               AND e.activity_type = 'end'
GROUP BY 
    a.machine_id;
