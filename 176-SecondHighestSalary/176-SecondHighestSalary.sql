-- Last updated: 7/17/2026, 3:04:45 PM
# Write your MySQL query statement below
SELECT (SELECT DISTINCT salary
                    FROM Employee
                            ORDER BY salary DESC
                                    LIMIT 1 OFFSET 1
                                        ) AS SecondHighestSalary;