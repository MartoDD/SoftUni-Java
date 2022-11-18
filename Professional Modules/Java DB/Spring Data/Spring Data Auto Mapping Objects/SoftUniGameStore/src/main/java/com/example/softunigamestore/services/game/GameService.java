package com.example.softunigamestore.services.game;

import javax.transaction.Transactional;

public interface GameService {

    String addGame(String[] args);
    String deleteGame(Long id);

    String editGame(String[] args);
}
