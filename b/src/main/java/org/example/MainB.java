package org.example;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class MainB {

    public static AbstractApplicationContext contextB;

    public static void main(String[] args) {
        Application.launch(BInitializer.class, args);
    }
}