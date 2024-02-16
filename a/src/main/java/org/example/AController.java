package com.multi_spring_configurable_context.a;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;


import static com.multi_spring_configurable_context.utils.LoadViewBUtils.loadViewB;

@Controller
@FxmlView("/AView.fxml")
public class AController {

    @FXML
    private void loadViewBOnButtonClicked(MouseEvent event) {
        loadViewB();
    }
}
