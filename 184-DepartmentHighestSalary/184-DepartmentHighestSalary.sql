-- Last updated: 7/17/2026, 3:04:34 PM
SELECT 
    d.name AS Department, 
    e.name AS Employee, 
    e.salary AS Salary
FROM 
    Employee e
JOIN 
    Department d ON e.departmentId = d.id
WHERE 
    (e.departmentId, e.salary) IN (
        SELECT 
            departmentId, 
            MAX(salary)
        FROM 
            Employee
        GROUP BY 
            departmentId
    );