USE sgd;

-- 10 Find all basic information for a game

DELIMITER $$

CREATE FUNCTION udf_game_info_by_name(game_name VARCHAR(20))
RETURNS TEXT
DETERMINISTIC
BEGIN

DECLARE basic_information TEXT;

SET basic_information= CONCAT_WS(" ","The",game_name,"is developed by a",
(SELECT t.`name` FROM `teams` as t
JOIN `games` AS g ON g.`team_id`=t.`id`
WHERE g.`name`=game_name),
"in an office with an address",
(SELECT a.`name` FROM `addresses` AS a
JOIN `offices` AS o ON o.`address_id`=a.`id`
JOIN `teams` AS t ON t.`office_id`=o.`id`
JOIN `games` AS g ON g.`team_id`=t.`id`
WHERE g.`name`=game_name));

RETURN basic_information;

END$$

SELECT udf_game_info_by_name('Bitwolf') AS info;

-- 11 Update budget of the games 

DELIMITER $$

CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)
BEGIN

UPDATE `games` AS g
LEFT JOIN `games_categories` AS gc ON gc.`game_id`=g.`id`
SET g.`budget`=g.`budget` + 100000,
g.`release_date`= DATE_ADD(g.`release_date`, INTERVAL 1 YEAR)
WHERE g.`rating`> min_game_rating AND gc.`category_id` IS NULL AND g.`release_date` IS NOT NULL;

END$$