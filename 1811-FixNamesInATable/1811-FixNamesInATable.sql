-- Last updated: 7/18/2026, 12:19:35 PM
# Write your MySQL query statement below
SELECT 
    user_id, 
    CONCAT(UPPER(SUBSTR(name, 1, 1)), LOWER(SUBSTR(name, 2))) AS name
FROM 
    Users
ORDER BY 
    user_id;