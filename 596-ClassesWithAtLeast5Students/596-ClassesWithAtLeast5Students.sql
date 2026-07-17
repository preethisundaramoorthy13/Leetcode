-- Last updated: 7/17/2026, 3:03:10 PM
# Write your MySQL query statement below
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5;