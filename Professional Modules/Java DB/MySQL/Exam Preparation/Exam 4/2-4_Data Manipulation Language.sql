USE stc;

-- 2 Insert

INSERT INTO `clients` (`full_name`,`phone_number`)
SELECT 
CONCAT_WS(" ",d.`first_name`,d.`last_name`),
CONCAT("(088) 9999",d.`id`*2)
FROM `drivers` AS d
WHERE d.`id` BETWEEN 10 AND 20;

-- 3 Update

UPDATE `cars`
SET `condition`="C"
WHERE `mileage`>800000 OR (`mileage` IS NULL AND `year`<2010) AND `make`NOT LIKE "Mercedes-Benz";

-- 4 Delete

DELETE c FROM `clients` AS c
LEFT JOIN `courses` AS co ON co.`client_id`=c.`id`
WHERE co.`id` IS NULL AND LENGTH(c.`full_name`)>3;