-- Last updated: 7/17/2026, 3:04:43 PM
SELECT  
   score, 
   DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
FROM Scores 
ORDER BY score DESC;
   