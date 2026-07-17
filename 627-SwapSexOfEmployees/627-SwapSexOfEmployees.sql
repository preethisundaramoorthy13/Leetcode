-- Last updated: 7/17/2026, 3:03:03 PM
# Write your MySQL query statement below
UPDATE Salary
SET sex = CASE 
    WHEN sex = 'm' THEN 'f' 
    ELSE 'm' 
END;