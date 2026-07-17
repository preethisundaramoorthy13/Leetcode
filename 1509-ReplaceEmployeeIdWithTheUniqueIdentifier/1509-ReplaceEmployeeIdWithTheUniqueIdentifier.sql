-- Last updated: 7/17/2026, 3:02:20 PM
# Write your MySQL query statement below
SELECT 
    eu.unique_id, 
    e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu ON e.id = eu.id;