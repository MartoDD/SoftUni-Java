USE softuni_imdb;

-- 2 Insert

INSERT INTO `actors`(`first_name`,`last_name`,`birthdate`,`height`,`awards`,`country_id`)
SELECT
REVERSE(`first_name`),
REVERSE(`last_name`),
DATE_SUB(`birthdate`, INTERVAL 2 DAY),
`height` + 10,
`country_id`,
(SELECT `id` FROM `countries` WHERE `name` = "Armenia")
FROM `actors` WHERE `id`<=10;

-- 3 Update

UPDATE `movies_additional_info` 
SET runtime=
IF (runtime-10<0,0,runtime-10)
WHERE  `id`>=15 AND `id`<=25;

-- 4 Delete

DELETE c FROM `countries` AS c
LEFT JOIN `movies` AS m
ON m.`country_id`=c.`id`
WHERE m.`movie_info_id` IS NULL;