-- Last updated: 7/31/2026, 9:36:14 AM
# Write your MySQL query statement below
SELECT 
    a.visited_on, 
    SUM(b.day_sum) AS amount, 
    ROUND(AVG(b.day_sum), 2) AS average_amount
FROM 
    (SELECT visited_on, SUM(amount) AS day_sum FROM Customer GROUP BY visited_on) a
JOIN 
    (SELECT visited_on, SUM(amount) AS day_sum FROM Customer GROUP BY visited_on) b
ON 
    DATEDIFF(a.visited_on, b.visited_on) BETWEEN 0 AND 6
WHERE 
    a.visited_on >= (SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY) FROM Customer)
GROUP BY 
    a.visited_on
ORDER BY 
    a.visited_on;