USE softuni_imdb;

-- 5 Countries

SELECT `id`,`name`,`continent`,`currency` FROM `countries`
ORDER BY `currency` DESC, `id`;

-- 6 Old Movies

SELECT ma.`id`,m.`title` AS "title",ma.`runtime`,ma.`budget`,ma.`release_date` FROM `movies_additional_info` AS ma
JOIN `movies` AS m ON m.movie_info_id=ma.id
WHERE YEAR(`release_date`) BETWEEN 1996 AND 1999
ORDER BY ma.`runtime`,ma.`id`
LIMIT 20;

-- 7 Movie Casting

SELECT CONCAT_WS(" ",a.`first_name`,a.`last_name`) AS "full_name", 
CONCAT(REVERSE(a.`last_name`),
LENGTH(a.`last_name`),"@cast.com") AS "email",
2022-YEAR(a.`birthdate`) AS "age",
 a.`height`
FROM `actors` AS a
LEFT JOIN `movies_actors` AS ma
ON ma.`actor_id`=a.`id`
WHERE ma.`movie_id` IS NULL
ORDER BY a.`height`;

-- 8 International Festival

SELECT c.`name`, COUNT(m.`id`) AS "movies_count" FROM `countries` AS c
JOIN `movies` AS m ON m.`country_id`=c.`id`
GROUP BY c.`id`
HAVING `movies_count`>=7
ORDER BY c.`name` DESC;

-- 9 Rating System

SELECT m.`title`,
CASE
WHEN `rating` <=4 THEN "poor"
WHEN `rating` <=7 THEN "good"
ELSE "excellent"
END
AS "rating",
CASE
WHEN `has_subtitles` = TRUE THEN "english"
ELSE "-"
END
AS "subtitles",
`budget` 
FROM `movies_additional_info` AS ma
JOIN `movies` AS m ON m.movie_info_id=ma.`id`
ORDER BY `budget` DESC;