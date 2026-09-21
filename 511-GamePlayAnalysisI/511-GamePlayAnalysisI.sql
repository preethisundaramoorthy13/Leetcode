-- Last updated: 9/21/2026, 5:35:20 PM
# Write your MySQL query statement below
SELECT 
    player_id,
    MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;