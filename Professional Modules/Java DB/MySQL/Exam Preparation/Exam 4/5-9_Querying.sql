USE stc;

-- 5 Cars

SELECT `make`,`model`,`condition` FROM `cars`
ORDER BY `id`;

-- 6 Drivers and Cars

SELECT d.`first_name`,d.`last_name`,c.`make`,c.`model`,c.`mileage` FROM `drivers` AS d
JOIN `cars_drivers` AS cd ON cd.`driver_id`=d.`id`
JOIN `cars` AS c ON c.`id`=cd.`car_id`
WHERE c.`mileage` IS NOT NULL
ORDER BY c.`mileage` DESC, d.`first_name`;

-- 7 Number of courses for each car

SELECT c.`id` AS "car_id",c.`make`,c.`mileage`,COUNT(co.`id`) AS "count_of_courses",ROUND(AVG(co.`bill`),2) AS "avg_bill" FROM `cars` AS c
LEFT JOIN `courses` AS co ON co.`car_id`=c.`id`
GROUP BY c.`id`
HAVING `count_of_courses`!=2
ORDER BY `count_of_courses` DESC, c.`id`;

-- 8 Regular clients

SELECT c.`full_name`,COUNT(ca.`id`) AS "count_of_cars",SUM(co.`bill`) AS "total_sum" FROM `clients` AS c
JOIN `courses` AS co ON co.`client_id`=c.`id`
JOIN `cars` AS ca ON ca.`id`=co.`car_id`
GROUP BY c.`full_name`
HAVING SUBSTRING(c.`full_name`,2) LIKE "a%" AND `count_of_cars`>1
ORDER BY `full_name`;

-- 9 Full info for courses

SELECT 
a.`name`,
CASE
WHEN HOUR(co.`start`) BETWEEN 6 AND 20 THEN "Day"
ELSE "Night"
END
AS "day_time",
co.`bill`,
cl.`full_name`,
c.`make`,
c.`model`,
cat.`name` AS "category_name" FROM `addresses` AS a
JOIN `courses` AS co ON co.`from_address_id`=a.`id`
JOIN `clients` AS cl ON cl.`id`=co.`client_id`
JOIN `cars` AS c ON c.`id`=co.`car_id`
JOIN `categories` AS cat ON cat.`id`=c.`category_id`
ORDER BY co.`id`;
