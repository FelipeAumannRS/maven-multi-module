package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.AbstractApplicationContext;

public class BInitializer extends Application {

    private AbstractApplicationContext springBootApplicationContext() {
        return (AbstractApplicationContext) new SpringApplicationBuilder()
                .sources(MainB.class)
                .run(getParameters().getRaw().toArray(String[]::new));
    }

    @Override
    public void init() {
        MainB.contextB = springBootApplicationContext();
    }

    @Override
    public void start(Stage stage) {
        MainB.contextB.publishEvent(new ShowStageB(stage));
    }

    @Override
    public void stop() {
        MainB.contextB.close();
    }

    public static class ShowStageB extends ApplicationEvent {
        public Stage getStage() {
            return (Stage) getSource();
        }

        public ShowStageB(Stage stage) {
            super(stage);
        }
    }
}