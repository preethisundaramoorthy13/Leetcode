-- Last updated: 7/17/2026, 3:02:37 PM
SELECT 
    ROUND(
        COUNT(DISTINCT a.player_id) / COUNT(DISTINCT f.player_id), 
        2
    ) AS fraction
FROM (
    SELECT player_id, MIN(event_date) as event_date
    FROM Activity
    GROUP BY player_id
) AS f
LEFT JOIN Activity AS a
ON f.player_id = a.player_id AND a.event_date = DATE_ADD(f.event_date, INTERVAL 1 DAY)