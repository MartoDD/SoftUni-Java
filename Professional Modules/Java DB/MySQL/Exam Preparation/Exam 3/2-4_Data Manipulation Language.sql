USE sgd;

-- 2 Insert

INSERT INTO `games` (`name`,`rating`,`budget`,`team_id`)
SELECT 
REVERSE(SUBSTRING(LOWER(t.`name`),2)),
t.`id`,
t.`leader_id`*1000,
t.`id`
FROM `teams` AS t
WHERE t.`id` BETWEEN 1 AND 9;

-- 3 Update

UPDATE `employees` AS e
LEFT JOIN `teams` AS t ON t.`leader_id`=e.`id`
SET `salary`=`salary` + 1000
WHERE t.`leader_id` IS NOT NULL AND
`age`<40 AND e.`salary`<5000;

-- 4 Delete

DELETE g FROM `games` AS g
LEFT JOIN `games_categories` AS gc ON gc.`game_id`=g.`id`
WHERE g.`release_date` IS NULL AND gc.`category_id` IS NULL;



