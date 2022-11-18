package com.example.softunigamestore;

import com.example.softunigamestore.constants.Messages;
import com.example.softunigamestore.services.game.GameService;
import com.example.softunigamestore.services.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ServiceProvider {

    private final UserService userService;
    private final GameService gameService;

    Scanner scanner = new Scanner(System.in);

    public String execute() throws Exception {
        String[] info = scanner.nextLine().split("\\|");


        return switch (info[0]) {
            case "RegisterUser" -> registerUser(info);
            case "LoginUser" -> loginUser(info);
            case "Logout" -> logoutUser();
            case "AddGame" -> addGame(info);
            case "EditGame"->editGame(info);
            case "DeleteGame" -> deleteGame(Long.parseLong(info[1]));
            case "End" -> "End";
            default -> Messages.UNKNOWN_COMMAND;
        };
    }

    public ServiceProvider(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    public String registerUser(String... args) throws IllegalAccessException {
        return userService.registerUser(args);
    }

    public String loginUser(String... args) {
        return userService.loginUser(args);
    }

    public String logoutUser() {
        return this.userService.logoutUser();
    }

    public String addGame(String... args) {
        return gameService.addGame(args);
    }

    public String deleteGame(Long id) {
        return gameService.deleteGame(id);
    }
    public String editGame(String...args){
        return gameService.editGame(args);
    }

}
