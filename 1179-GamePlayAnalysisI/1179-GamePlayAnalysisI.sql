-- Last updated: 7/17/2026, 3:02:39 PM
# Write your MySQL query statement below
SELECT 
    player_id,
    MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;