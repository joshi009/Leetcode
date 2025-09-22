# Write your MySQL query statement below
SELECT pc.product_id,
IFNULL(ROUND(SUM(pc.price*us.units)/SUM(us.units),2),0) as average_price
FROM Prices pc
LEFT JOIN UnitsSold us
ON pc.product_id = us.product_id
AND us.purchase_date >= pc.start_date
AND us.purchase_date <= pc.end_date
GROUP BY pc.product_id;