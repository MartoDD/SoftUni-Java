package com.example.softunigamestore.services.game;

import com.example.softunigamestore.constants.Messages;
import com.example.softunigamestore.dtos.GameDto;
import com.example.softunigamestore.entities.Game;
import com.example.softunigamestore.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    ModelMapper modelMapper = new ModelMapper();
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public String addGame(String[] args) {

        String title = args[1];
        BigDecimal price = new BigDecimal(args[2]);
        float size = Float.parseFloat(args[3]);
        String trailer = args[4];
        String imageUrl = args[5];
        String description = args[6];
        LocalDate releaseDate = LocalDate.parse(args[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Game checkIfGamePresent = gameRepository.findByTitle(title);
        if (checkIfGamePresent != null) {
            throw new IllegalArgumentException(Messages.GAME_ALREADY_ADDED);
        }

        GameDto addGameDto = new GameDto(title, price, size, trailer, imageUrl, description, releaseDate);
        Game game = modelMapper.map(addGameDto, Game.class);
        gameRepository.save(game);
        return String.format(Messages.GAME_ADDED, title);
    }

    @Override
    public String deleteGame(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isEmpty()) {
            throw new IllegalArgumentException(Messages.GAME_DOES_NOT_EXIST);
        }
        String title = gameRepository.findById(id).get().getTitle();
        gameRepository.deleteGameById(id);
        return String.format(Messages.GAME_DELETED, title);
    }

    @Override
    public String editGame(String[] args) {
        long id = Long.parseLong(args[1]);

        Optional<Game> game =gameRepository.findById(id);
        if (game.isEmpty()){
            throw new IllegalArgumentException(Messages.GAME_DOES_NOT_EXIST);
        }
        GameDto gameDto =modelMapper.map(game.get(),GameDto.class);

        for (int i = 2; i < args.length; i++) {
            String current = args[i];
            String key = current.split("=")[0];
            String value = current.split("=")[1];

            switch (key){
                case "price":
                    gameDto.setPrice(new BigDecimal(value));
                    break;
                case "size":
                    gameDto.setSize(Float.parseFloat(value));
                    break;
                case "trailer":
                    gameDto.setTrailer(value);
                    break;
                case "thumbnail":
                    gameDto.setImageUrl(value);
                    break;
                case "description":
                    gameDto.setDescription(value);
                    break;
                case "releaseDate":
                    gameDto.setReleaseDate(LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    break;
                default:
                    System.out.println(Messages.NO_SUCH_VALUE);
            }


        }
        gameRepository.deleteGameById(id);
        Game game1=modelMapper.map(gameDto,Game.class);
        gameRepository.save(game1);

        return String.format(Messages.GAME_EDITED,gameDto.getTitle());
    }
}
