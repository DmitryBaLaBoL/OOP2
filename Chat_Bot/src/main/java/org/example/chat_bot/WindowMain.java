package org.example.chat_bot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class WindowMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WindowMain.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 260, 240);
        stage.setTitle("Вход пользователя");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /*try {
            URL url = new URL("https://www.cbr-xml-daily.ru/daily_json.js");



        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }*/
        //HttpURLConnection
        launch();
    }
}