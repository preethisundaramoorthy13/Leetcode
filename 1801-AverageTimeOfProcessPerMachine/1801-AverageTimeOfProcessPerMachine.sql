-- Last updated: 7/18/2026, 12:19:37 PM
SELECT 
    machine_id,
    ROUND(
        SUM(CASE WHEN activity_type = 'end' THEN timestamp ELSE -timestamp END) 
        / COUNT(DISTINCT process_id), 
        3
    ) AS processing_time
FROM 
    Activity
GROUP BY 
    machine_id;