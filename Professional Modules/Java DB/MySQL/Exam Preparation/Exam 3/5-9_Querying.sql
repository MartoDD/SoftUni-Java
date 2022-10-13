USE sgd;

-- 5 Employees

SELECT `first_name`,`last_name`,`age`,`salary`,`happiness_level` FROM `employees`
ORDER BY `salary`,`id`;

-- 6 Addresses of the teams

SELECT t.`name` AS "team_name",a.`name` AS "address_name", LENGTH(a.`name`)AS "count_of_characters" FROM `teams` AS t
JOIN `offices` AS o ON o.`id`=t.`office_id`
JOIN `addresses` AS a ON a.`id`=o.`address_id`
WHERE o.`website` IS NOT NULL
ORDER BY `team_name`,`address_name`;

-- 7 Categories Info

SELECT c.`name`,COUNT(gc.`game_id`) AS "games_count",ROUND(AVG(g.`budget`),2) AS "avg_budget",MAX(g.`rating`) AS "max_rating" FROM `categories` AS c
JOIN `games_categories` AS gc ON gc.`category_id`=c.`id`
JOIN `games` AS g ON g.`id`=gc.`game_id`
GROUP BY c.`name`
HAVING `max_rating`>=9.5
ORDER BY `games_count` DESC, `name`;

-- 8 Games of 2022

SELECT g.`name`,`release_date`,CONCAT(SUBSTRING(`description`,1,10),"...") AS "summary",
CASE
WHEN MONTH(`release_date`) BETWEEN 1 AND 3 THEN "Q1"
WHEN MONTH(`release_date`) BETWEEN 4 AND 6 THEN "Q2"
WHEN MONTH(`release_date`) BETWEEN 7 AND 9 THEN "Q3"
WHEN MONTH(`release_date`) BETWEEN 10 AND 12 THEN "Q4"
END
AS "quarter",t.`name` AS "team_name" FROM `games` AS g
JOIN `teams` AS t ON t.`id`=g.`team_id`
WHERE YEAR(`release_date`) = 2022 AND g.`name` LIKE "%2" AND MONTH(`release_date`) %2 =0
ORDER BY `quarter`;

-- 9 Full info for games

SELECT g.`name`,
CASE
WHEN `budget` <50000 THEN "Normal budget"
ELSE "Insufficient budget"
END AS "budget_level",
t.`name` AS "team_name",
a.`name` AS "address_name" FROM `games` AS g
JOIN `teams` AS t ON t.`id`=g.`team_id`
JOIN `offices` AS o ON o.`id`=t.`office_id`
JOIN `addresses` AS a ON a.`id`=o.`address_id`
LEFT JOIN `games_categories` as gc ON gc.`game_id`=g.`id`
WHERE g.`release_date` IS NULL AND gc.`category_id` IS NULL
ORDER BY g.`name`;