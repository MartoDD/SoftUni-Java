USE online_store;

-- 10 Extract client cards count

DELIMITER $$

CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN

DECLARE products_ordered INT;

SET products_ordered = 
(SELECT COUNT(op.`product_id`) FROM `orders_products` AS op
JOIN `orders` AS o ON o.`id`=op.`order_id`
JOIN `customers` AS c ON c.`id`=o.`customer_id`
WHERE c.`first_name` = name);

RETURN products_ordered;
END$$

-- 11 Reduce price

DELIMITER $$

CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN

UPDATE `products` AS p
JOIN `reviews` AS r ON r.`id`=p.`review_id`
JOIN `categories` AS c ON c.`id`=p.`category_id`
SET p.`price`=p.`price` * 0.70
WHERE r.`rating`<4 AND c.`name`=category_name;

END$$

