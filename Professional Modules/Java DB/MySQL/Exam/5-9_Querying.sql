USE restaurant_db;

-- 5 Clients

SELECT `id`,`first_name`,`last_name`,`birthdate`,`card`,`review` FROM `clients`
ORDER BY `birthdate` DESC, `id` DESC;

-- 6 Birthdate

SELECT `first_name`,`last_name`,`birthdate`,`review` FROM `clients`
WHERE `card` IS NULL AND YEAR(`birthdate`) BETWEEN 1978 AND 1993
ORDER BY `last_name` DESC, `id` DESC
LIMIT 5; 

-- 7 Accounts

SELECT 
CONCAT(w.`last_name`,w.`first_name`,LENGTH(w.`first_name`),"Restaurant") AS "username",
REVERSE(SUBSTRING(w.`email`,2,12)) AS "password" FROM `waiters` AS w
WHERE `salary` IS NOT NULL
ORDER BY `password` DESC;

-- 8 Top from menu

SELECT p.`id`,p.`name`,COUNT(`order_id`) AS "count" FROM `products` AS p
JOIN `orders_products` AS op ON op.`product_id`=p.`id`
GROUP BY p.`id`
HAVING `count`>= 5
ORDER BY `count` DESC, p.`name`;

-- 9 Availability

SELECT t.`id` AS "table_id",t.`capacity`,
COUNT(oc.`client_id`) AS "count_clients",
CASE
WHEN t.`capacity`>COUNT(oc.`client_id`) THEN "Free seats"
WHEN t.`capacity`=COUNT(oc.`client_id`) THEN "Full"
ELSE "Extra seats"
END
AS "availability" FROM `tables` AS t
JOIN `orders` AS o ON o.`table_id`=t.`id`
JOIN `orders_clients` AS oc ON oc.`order_id`=o.`id`
WHERE t.`floor`=1
GROUP BY `table_id`
ORDER BY `table_id` DESC;
