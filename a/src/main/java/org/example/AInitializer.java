package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.AbstractApplicationContext;

@Slf4j
public class AInitializer extends Application {

    private AbstractApplicationContext springBootApplicationContext() {
        return (AbstractApplicationContext) new SpringApplicationBuilder()
                .sources(MainA.class)
                .run(getParameters().getRaw().toArray(String[]::new));
    }

    @Override
    public void init() {
        log.info("*** A INITIALIZED ***");
        MainA.contextA = springBootApplicationContext();
    }

    @Override
    public void start(Stage stage) {
        MainA.contextA.publishEvent(new ShowStageA(stage));
    }

    @Override
    public void stop() {
        log.info("A stopped.");
    }

    public static class ShowStageA extends ApplicationEvent {
        public Stage getStage() {
            return (Stage) getSource();
        }

        public ShowStageA(Stage stage) {
            super(stage);
        }
    }
}