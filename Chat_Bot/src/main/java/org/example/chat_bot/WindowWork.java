package org.example.chat_bot;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static org.example.chat_bot.Bot.BotThink;

public class WindowWork {

    public WindowWork(String userName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WindowWork.class.getResource("Main_Work.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 430, 420);
        Stage stage = new Stage();
        WindowWorkController controllerEditBook = fxmlLoader.getController();
        stage.setTitle("Чат-бот с " + userName);
        stage.setScene(scene);
        stage.show();
        controllerEditBook.CountMessages = controllerEditBook.OpenDialogFromFile(controllerEditBook.ArrayMessages, controllerEditBook.CountMessages,userName);
        controllerEditBook.UserName = userName;
        stage.setOnCloseRequest(controllerEditBook.getCloseEventHandler());

        stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            ActionEvent actionEvent = null;
            try {
                controllerEditBook.onButtonSendMessage(actionEvent);
            }
            catch (IOException ex){

            }
        }});

    }

}
