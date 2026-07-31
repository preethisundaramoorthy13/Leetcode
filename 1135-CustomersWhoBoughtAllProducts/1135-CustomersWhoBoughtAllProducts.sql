-- Last updated: 7/31/2026, 9:36:34 AM
# Write your MySQL query statement below
SELECT 
    customer_id
FROM 
    Customer
GROUP BY 
    customer_id
HAVING 
    COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product);