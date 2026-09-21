-- Last updated: 9/21/2026, 5:33:30 PM
# Write your MySQL query statement below
SELECT 
    eu.unique_id, 
    e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu ON e.id = eu.id;