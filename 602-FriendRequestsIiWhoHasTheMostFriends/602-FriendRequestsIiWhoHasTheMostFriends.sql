-- Last updated: 7/31/2026, 9:36:51 AM
WITH AllFriends AS (
    SELECT requester_id AS id FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id FROM RequestAccepted
)
SELECT 
    id, 
    COUNT(*) AS num
FROM 
    AllFriends
GROUP BY 
    id
ORDER BY 
    num DESC
LIMIT 1;