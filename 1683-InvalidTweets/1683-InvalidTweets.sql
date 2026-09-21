-- Last updated: 9/21/2026, 5:32:24 PM
# Write your MySQL query statement below
SELECT 
    tweet_id
FROM 
    Tweets
WHERE 
    CHAR_LENGTH(content) > 15;