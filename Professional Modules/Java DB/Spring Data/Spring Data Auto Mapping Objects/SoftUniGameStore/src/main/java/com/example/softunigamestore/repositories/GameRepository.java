package com.example.softunigamestore.repositories;

import com.example.softunigamestore.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByTitle(String title);
    Optional<Game> findById(Long id);
    @Transactional
    void deleteGameById(Long id);

}
