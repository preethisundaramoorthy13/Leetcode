-- Last updated: 7/18/2026, 12:19:32 PM
# Write your MySQL query statement below
SELECT 
    tweet_id
FROM 
    Tweets
WHERE 
    CHAR_LENGTH(content) > 15;