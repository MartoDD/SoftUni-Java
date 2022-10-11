USE softuni_imdb;

-- 10 History Movies

DELIMITER $$

CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN

DECLARE hystory_movies_number INT;

SET hystory_movies_number = 
(SELECT COUNT(ma.movie_id) FROM `movies_actors` AS ma
JOIN `actors` AS a ON ma.actor_id=a.id
JOIN `genres_movies` as gm ON gm.movie_id=ma.movie_id
JOIN `genres` as g ON gm.genre_id=g.id
WHERE CONCAT_WS(" ",a.first_name,a.last_name) = full_name AND g.name="History"
GROUP BY a.`id`);

RETURN hystory_movies_number;

END$$

SELECT udf_actor_history_movies_count('Stephan Lundberg')  AS 'history_movies';

-- 11 Movie Awards

DELIMITER $$

CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))
BEGIN

UPDATE `actors` AS a
JOIN `movies_actors` as ma ON a.id=ma.actor_id
JOIN `movies` AS m ON ma.movie_id=m.id
SET a.`awards`=a.`awards`+1
WHERE m.title=movie_title;

END$$

