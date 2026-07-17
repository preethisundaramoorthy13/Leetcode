-- Last updated: 7/17/2026, 3:04:35 PM
# Write your MySQL query statement below
SELECT name AS Customers FROM Customers c
LEFT JOIN Orders o
ON c.id = o.customerId
WHERE customerId IS NULL;