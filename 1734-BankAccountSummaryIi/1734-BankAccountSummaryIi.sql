-- Last updated: 7/17/2026, 3:18:49 PM
# Write your MySQL query statement below
SELECT 
    u.name, 
    SUM(t.amount) AS balance
FROM 
    Users u
JOIN 
    Transactions t ON u.account = t.account
GROUP BY 
    u.account, u.name
HAVING 
    SUM(t.amount) > 10000;