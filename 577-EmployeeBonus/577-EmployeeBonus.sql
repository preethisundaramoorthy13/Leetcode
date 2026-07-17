-- Last updated: 7/17/2026, 3:03:18 PM
# Write your MySQL query statement below

SELECT Employee.name,Bonus.bonus FROM Employee 
LEFT JOIN Bonus ON Employee.empID = Bonus.empID
WHERE bonus < 1000 OR Bonus IS NULL ;