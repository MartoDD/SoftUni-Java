USE online_store;

-- 5 Categories

SELECT `id`,`name` FROM `categories`
ORDER BY `name` DESC;

-- 6 Quantity

SELECT p.`id`,b.`id` AS "brand_id",p.`name`,p.`quantity_in_stock` FROM `products` AS p
JOIN `brands` AS b ON b.`id`=p.`brand_id`
WHERE p.`price`>1000 AND p.`quantity_in_stock`<30
ORDER BY `quantity_in_stock`;

-- 7 Review

SELECT `id`,`content`,`rating`,`picture_url`,`published_at` FROM `reviews`
WHERE `content` LIKE "My%" AND LENGTH(`content`)>61
ORDER BY `rating` DESC;

-- 8 First Customers

SELECT CONCAT_WS(" ",c.`first_name`,c.`last_name`) AS "full_name",c.`address`,o.`order_datetime` AS "order_date" FROM `customers` AS c
JOIN `orders` AS o ON o.`customer_id`=c.`id`
WHERE YEAR(o.`order_datetime`)<=2018
ORDER BY `full_name` DESC;

-- 9 Best Categories

SELECT COUNT(p.`id`) AS "items_count",c.`name`,SUM(p.`quantity_in_stock`) AS "total_quantity" FROM `categories` AS c
JOIN `products` AS p ON p.`category_id`=c.`id`
GROUP BY c.`name`
ORDER BY `items_count` DESC, `total_quantity`
LIMIT 5;