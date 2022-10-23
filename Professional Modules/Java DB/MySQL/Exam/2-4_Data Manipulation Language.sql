USE restaurant_db;

-- 2 Insert

INSERT INTO `products`(`name`,`type`,`price`)
SELECT 
CONCAT_WS(" ",w.`last_name`,"specialty"),
"Cocktail",
CEIL(w.`salary`*0.01)
FROM `waiters` AS w
WHERE w.`id`>6;

-- 3 Update

UPDATE `orders`
SET `table_id`=`table_id`-1
WHERE `id` BETWEEN 12 AND 23;

-- 4 Delete

DELETE w FROM `waiters` AS w
LEFT JOIN `orders` AS o ON o.`waiter_id`=w.`id`
WHERE o.`id` IS NULL;