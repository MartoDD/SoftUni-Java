package com.example.softunigamestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {


    private final ServiceProvider serviceProvider;

    @Autowired
    public ConsoleRunner(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }


    @Override
    public void run(String... args) throws Exception {
        while (true) {
            String result;
            try {
                result=serviceProvider.execute();
                if (result.equals("End")){
                    break;
                }
            } catch (IllegalArgumentException e) {
                result=e.getMessage();
            }
            System.out.println(result);
        }
    }


}
