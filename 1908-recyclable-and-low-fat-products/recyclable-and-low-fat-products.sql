# Write your MySQL query statement below
SELECT p.product_id 
FROM Products p
WHERE p.low_fats = 'Y' AND p.recyclable = 'Y';