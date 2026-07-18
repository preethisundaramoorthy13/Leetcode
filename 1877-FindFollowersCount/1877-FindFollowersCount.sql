-- Last updated: 7/18/2026, 12:19:30 PM
# Write your MySQL query statement below
SELECT 
    user_id, 
    COUNT(follower_id) AS followers_count
FROM 
    Followers
GROUP BY 
    user_id
ORDER BY 
    user_id ASC;