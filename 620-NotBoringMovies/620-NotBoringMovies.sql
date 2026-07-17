-- Last updated: 7/17/2026, 3:03:04 PM
# Write your MySQL query statement below
SELECT id, movie, description, rating
FROM Cinema
WHERE id % 2 != 0 AND description != 'boring'
ORDER BY rating DESC;