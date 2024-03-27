package org.example.chat_bot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class WindowMainController {
    public VBox Start;
    public Label LabelError;
    public TextField TextFieldUserName;

    public void onConnectButtonClick(ActionEvent actionEvent) {
        try {
            new WindowWork(TextFieldUserName.getText());
            Start.getScene().getWindow().hide();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}