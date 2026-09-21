-- Last updated: 9/21/2026, 5:32:35 PM
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