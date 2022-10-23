USE restaurant_db;

-- 10 Extract bill

DELIMITER $$

CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN

DECLARE total_price DECIMAL(10,2);

SET total_price=
(
SELECT SUM(p.`price`) FROM `products` AS p
JOIN `orders_products` AS op ON op.`product_id`=p.`id`
JOIN `orders` AS o ON o.`id`=op.`order_id`
JOIN `orders_clients` AS oc ON oc.`order_id`=o.`id`
JOIN `clients` AS c ON c.`id`=oc.`client_id`
WHERE CONCAT_WS(" ",c.`first_name`,c.`last_name`) =full_name
);

RETURN total_price;

END$$

SELECT c.first_name,c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';

-- 11 Happy hour

DELIMITER $$

CREATE PROCEDURE udp_happy_hour(type VARCHAR(50))
BEGIN

UPDATE `products`
SET `price`=`price`*0.8
WHERE `price`>=10 AND `type`=type;

END$$

CALL udp_happy_hour ('Cognac');