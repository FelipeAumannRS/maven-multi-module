package org.example;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StageAListener implements ApplicationListener<AInitializer.ShowStageA> {

    private final FxWeaver fxWeaver;

    public static Stage stage;

    @Override
    public void onApplicationEvent(AInitializer.ShowStageA event) {
        stage = event.getStage();
        stage.setOnCloseRequest(e -> {
            log.info("A stopped.");
            MainA.contextA.close();
            System.exit(0);
            Platform.exit();
        });

        Scene scene = new Scene((Parent) fxWeaver.load(AController.class).getView().get());

        stage.setScene(scene);
        stage.setTitle("A View");
        stage.show();
    }
}
