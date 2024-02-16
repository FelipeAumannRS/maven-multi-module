package org.example;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

import static org.example.LoadViewBUtils.loadViewB;

@Controller
@FxmlView("/AView.fxml")
public class AController {

    @FXML
    private void loadViewBOnButtonClicked(MouseEvent event) {
        loadViewB();
    }
}
