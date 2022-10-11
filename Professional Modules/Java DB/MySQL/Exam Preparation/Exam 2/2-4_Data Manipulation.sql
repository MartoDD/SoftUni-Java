USE online_store;

-- 2 Insert

INSERT INTO `reviews`(`content`,`picture_url`,`published_at`,`rating`)
SELECT
SUBSTRING(p.`description`,1,15),
REVERSE(p.`name`),
"2010-10-10",
p.`price`/8
FROM `products` AS p
WHERE p.`id`>=5;

-- 3 Update

UPDATE `products`
SET `quantity_in_stock` = `quantity_in_stock`-5
WHERE `quantity_in_stock`BETWEEN 60 AND 70;

-- 4 Delete

DELETE c FROM `customers` AS c
LEFT JOIN `orders` AS o ON c.`id`=o.`customer_id`
WHERE o.`id` IS NULL; 