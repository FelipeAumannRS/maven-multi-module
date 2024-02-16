package org.example;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StageBListener implements ApplicationListener<BInitializer.ShowStageB> {

    private final FxWeaver fxWeaver;

    @Override
    public void onApplicationEvent(BInitializer.ShowStageB event) {
        Stage stage = event.getStage();

        Scene scene = new Scene((Parent) fxWeaver.load(BController.class).getView().get());

        stage.setScene(scene);
        stage.setTitle("B View");
        stage.show();
    }
}