-- Last updated: 9/21/2026, 5:32:12 PM
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