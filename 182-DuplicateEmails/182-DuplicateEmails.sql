-- Last updated: 7/17/2026, 3:04:37 PM
# Write your MySQL query statement below
SELECT email AS Email 
FROM Person
GROUP BY email
HAVING COUNT(email)>1;