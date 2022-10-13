USE stc;

-- 10 Find all courses by client’s phone number

DELIMITER $$

CREATE FUNCTION udf_courses_by_client(phone_num VARCHAR(20))
RETURNS INT
DETERMINISTIC 
BEGIN

DECLARE number_of_courses INT;

SET number_of_courses = 
(SELECT COUNT(co.`id`) FROM `courses` AS co
JOIN `clients` AS cl ON cl.`id`=co.`client_id`
WHERE cl.`phone_number`=phone_num);

RETURN number_of_courses;

END$$

-- 11 Full info for address

DELIMITER $$

CREATE PROCEDURE udp_courses_by_address (address_name VARCHAR(100))
BEGIN

SELECT a.`name`,cl.`full_name`,
CASE
WHEN co.`bill` <=20 THEN "Low"
WHEN co.`bill` <=30 THEN "Medium"
ELSE "High"
END
AS "level_of_bill",ca.`make`,ca.`condition`,cat.`name` AS "cat_name" FROM `addresses` AS a
JOIN `courses` AS co ON co.`from_address_id`=a.`id`
JOIN `clients` AS cl ON cl.`id`=co.`client_id`
JOIN `cars` AS ca ON ca.`id`=co.`car_id`
JOIN `categories` AS cat ON cat.`id`=ca.`category_id`
WHERE a.`name`=address_name
ORDER BY ca.`make`,cl.`full_name`;

END$$

