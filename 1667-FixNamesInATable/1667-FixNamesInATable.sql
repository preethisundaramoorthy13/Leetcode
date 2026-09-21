-- Last updated: 9/21/2026, 5:32:26 PM
# Write your MySQL query statement below
SELECT 
    user_id, 
    CONCAT(UPPER(SUBSTR(name, 1, 1)), LOWER(SUBSTR(name, 2))) AS name
FROM 
    Users
ORDER BY 
    user_id;