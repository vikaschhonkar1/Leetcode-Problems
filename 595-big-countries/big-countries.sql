# Write your MySQL query statement below
SELECT w.name AS name, w.population AS population, w.area AS area
FROM world w
WHERE w.area >= 3000000 OR w.population >= 25000000;