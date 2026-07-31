-- Last updated: 7/31/2026, 9:36:52 AM
# Write your MySQL query statement below
WITH Filtered AS (
    SELECT 
        id, 
        visit_date, 
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
)
SELECT 
    id, 
    visit_date, 
    people
FROM Filtered
WHERE grp IN (
    SELECT grp 
    FROM Filtered 
    GROUP BY grp 
    HAVING COUNT(*) >= 3
)
ORDER BY visit_date ASC;